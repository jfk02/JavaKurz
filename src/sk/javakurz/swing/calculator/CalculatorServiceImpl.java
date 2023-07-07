package sk.javakurz.swing.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class CalculatorServiceImpl implements CalculatorService {

    public CalculatorServiceImpl() {
    }

    private String displayText = "";
    private final LinkedList<BigDecimal> operandsQueue = new LinkedList<>();
    private BigDecimal constantOperand = null;
    private String constantOperator = "";
    private String mathOperator = "";
    private boolean hasResult = false;
    private final BigDecimal hundredPercent = new BigDecimal("100");
    private final MathContext mathContext = new MathContext(10);
    private final HashMap<String, Callable<BigDecimal>> mathEvaluators = new HashMap<>() {
        {
            put("+", () -> operandsQueue.removeFirst().add(operandsQueue.removeFirst(), mathContext));
            put("-", () -> operandsQueue.removeFirst().subtract(operandsQueue.removeFirst(), mathContext));
            put("x", () -> operandsQueue.removeFirst().multiply(operandsQueue.removeFirst(), mathContext));
            put("÷", () -> operandsQueue.removeFirst().divide(operandsQueue.removeFirst(), mathContext));
            put("+%", () -> {
                var firstOperand = operandsQueue.removeFirst();
                var secondOperand = operandsQueue.removeFirst().divide(hundredPercent, mathContext)
                        .multiply(firstOperand);
                return firstOperand.add(secondOperand, mathContext);
            });
            put("-%", () -> {
                var firstOperand = operandsQueue.removeFirst();
                var secondOperand = operandsQueue.removeFirst().divide(hundredPercent, mathContext)
                        .multiply(firstOperand);
                return firstOperand.subtract(secondOperand, mathContext);
            });
            put("x%", () -> operandsQueue.removeFirst()
                    .multiply(operandsQueue.removeFirst(), mathContext)
                    .divide(hundredPercent, mathContext));
            put("÷%", () -> operandsQueue.removeFirst()
                    .divide(operandsQueue.removeFirst(), mathContext)
                    .multiply(hundredPercent, mathContext));
        }
    };

    @Override
    public String doNumbersAction(String pressedNumber) {
        clearAfterResult();
        displayText += displayText.length() < 15 ? pressedNumber : "";
        displayText = removeLeadingZero(displayText);
        return displayText;
    }

    @Override
    public String doOperatorsAction(String operator) {
        String resultText = "";

        if (!displayText.isEmpty() && !hasResult) {
            operandsQueue.add(stringToBigDecimal(displayText));
            displayText = "";
        }

        if (operandsQueue.size() == 2) {
            resultText = calculate();
        }

        mathOperator = operator;
        return resultText;
    }

    @Override
    public void allClear() {
        operandsQueue.clear();
        hasResult = false;
        constantOperand = null;
        displayText = "";
    }

    @Override
    public String addPeriod() {
        if (!hasResult) {
            displayText += !displayText.contains(".") ? "." : "";
        }
        return displayText;
    }

    @Override
    public String performCalculation(String pressedButton) {
        String resultText = displayText;

        if (!displayText.isEmpty()) {
            var secondOperand = stringToBigDecimal(displayText);
            if (!mathOperator.isEmpty()) {
                mathOperator += addPercentageOperator(pressedButton);
                operandsQueue.add(secondOperand);
                constantOperand = secondOperand;
                constantOperator = mathOperator;
                resultText = calculate();
            } else if (constantOperand != null) {
                operandsQueue.add(constantOperand);
                mathOperator = constantOperator;
                resultText = calculate();
            }
        }
        mathOperator = "";
        return resultText;
    }

    @Override
    public String addMinusSign() {
        if (!displayText.isEmpty()) {
            displayText = displayText.startsWith("-") ? displayText.substring(1) : "-" + displayText;
            if (hasResult) {
                operandsQueue.removeLast();
                operandsQueue.add(stringToBigDecimal(displayText));
            }
        }
        return displayText;
    }

    @Override
    public String doBackspace() {
        if (!displayText.isEmpty() && !hasResult) {
            displayText = displayText.substring(0, displayText.length() - 1);
        }
        return displayText;
    }

    private String calculate() {
        hasResult = false;
        String resultText = "";
        try {
            BigDecimal result = mathEvaluators.get(mathOperator).call();
            displayText = result.toString();
            operandsQueue.add(stringToBigDecimal(displayText));
            resultText = displayText;
            hasResult = true;
        } catch (Exception e) {
            displayText = "";
            resultText = "Error";
        }
        return resultText;
    }

    private void clearAfterResult() {
        if (hasResult) {
            hasResult = false;
            constantOperand = null;
            displayText = "";
            if (mathOperator.isEmpty()) operandsQueue.clear();
        }
    }

    private String addPercentageOperator(String button) {
        return button.equals("%") && mathOperator.length() == 1 ? "%" : "";
    }

    private String removeLeadingZero(String number) {

        if (number.length() > 1)
            if (number.startsWith("0") && !number.startsWith("0.")) {
                number = number.substring(1);
            }
        return number;
    }

    private BigDecimal stringToBigDecimal(String number) {
        number = number == null ? "0" : number;
        return new BigDecimal(number);
    }
}

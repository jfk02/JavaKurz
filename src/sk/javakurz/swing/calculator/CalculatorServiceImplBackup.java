package sk.javakurz.swing.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;

public class CalculatorServiceImplBackup {

    public CalculatorServiceImplBackup() {
    }

    private String displayText = "";
    private final LinkedList<BigDecimal> calculationQueue = new LinkedList<>();
    private BigDecimal constantOperand = null;
    private String constantOperator = "";
    private String mathOperator = "";
    private boolean hasResult = false;
    private final MathContext mathContext = new MathContext(10);
    private final HashMap<String, Callable<BigDecimal>> mathEvaluators = new HashMap<>() {
        {
            put("+", () -> calculationQueue.removeFirst().add(calculationQueue.removeLast(), mathContext));
            put("-", () -> calculationQueue.removeFirst().subtract(calculationQueue.removeLast(), mathContext));
            put("x", () -> calculationQueue.removeFirst().multiply(calculationQueue.removeLast(), mathContext));
            put("÷", () -> calculationQueue.removeFirst().divide(calculationQueue.removeLast(), mathContext));
        }
    };

 //   @Override
    public String doNumbersAction(String pressedNumber) {
        if (hasResult) {
            hasResult = false;
            constantOperand = null;

            if (!mathOperator.isEmpty()) {
                calculationQueue.add(new BigDecimal(Objects.requireNonNull(displayText)));
            }

            displayText = "";
        }

        displayText += displayText.length() < 15 ? pressedNumber : "";
        displayText = removeLeadingZero(displayText);
        return displayText;
    }

 //   @Override
    public String doOperatorsAction(String operator) {
        hasResult = false;
        String resultText = "";

        if (!displayText.isEmpty()) {
            calculationQueue.add(new BigDecimal(Objects.requireNonNull(displayText)));
            displayText = "";
        }

        if (calculationQueue.size() == 2) {
            resultText = calculate();
        }

        mathOperator = operator;

        return resultText;
    }

 //   @Override
    public void allClear() {
        calculationQueue.clear();
        hasResult = false;
        constantOperand = null;
        displayText = "";
    }

 //   @Override
    public String addPeriod() {
        if(!hasResult) {
            displayText += !displayText.contains(".") ? "." : "";
        }
        return displayText;
    }

 //   @Override
    public String performCalculation() {
        String resultText = displayText;
        if (!displayText.isEmpty()) {
            var displayedOperand = new BigDecimal(Objects.requireNonNull(displayText));
            if (calculationQueue.size() == 1 && !mathOperator.isEmpty()) {
                calculationQueue.add(displayedOperand);
                constantOperand = displayedOperand;
                constantOperator = mathOperator;
                resultText = calculate();
            } else if (calculationQueue.isEmpty() && constantOperand != null) {
                calculationQueue.add(displayedOperand);
                calculationQueue.add(constantOperand);
                mathOperator = constantOperator;
                resultText = calculate();
            }
        }
        mathOperator = "";
        return resultText;
    }

 //   @Override
    public String addMinusSign() {
        if (!displayText.isEmpty()) {
            displayText = displayText.startsWith("-") ? displayText.substring(1) : "-" + displayText;
        }
        return displayText;
    }

 //   @Override
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
            resultText = displayText;
            hasResult = true;
        } catch (Exception e) {
            displayText = "";
            resultText = "Error";
        }
        return resultText;
    }

    private String removeLeadingZero(String number) {

        if (number.length() > 1 && number.startsWith("0") && !number.startsWith("0.")) {
            number = number.substring(1);
        }
        return number;
    }
}

package sk.javakurz.swing.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class CalculatorService2Impl implements CalculatorService {
    private String displayText = "";
    private BigDecimal currentOperand = BigDecimal.ZERO;
    private BigDecimal constantOperand = BigDecimal.ZERO;
    private BigDecimal result = BigDecimal.ZERO;
    private String mathOperator = "";
    private boolean hasResult = false;
    private final MathContext mathContext = new MathContext(10);

    public String doNumbersAction(String pressedNumber) {
        if (hasResult) {
            hasResult = false;
            displayText = "";
        }

        displayText += displayText.length() < 15 ? pressedNumber : "";
        displayText = removeLeadingZero(displayText);
        return displayText;
    }

    public String doOperatorsAction(String operator) {
        hasResult = false;

        if (!displayText.isEmpty()) {
            performCalculation();
        }

        mathOperator = operator;
        return displayText;
    }

    public void allClear() {
        displayText = "";
        currentOperand = BigDecimal.ZERO;
        constantOperand = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        mathOperator = "";
        hasResult = false;
    }

    public String addPeriod() {
        if (!hasResult) {
            displayText += !displayText.contains(".") ? "." : "";
        }
        return displayText;
    }

    public String performCalculation() {
        if (!displayText.isEmpty()) {
            BigDecimal displayedOperand = new BigDecimal(Objects.requireNonNull(displayText));

            if (mathOperator.isEmpty()) {
                result = displayedOperand;
            } else {
                calculate(displayedOperand);
                if (result == null) {
                    displayText = "Error: Division by zero";
                    return displayText;
                }
                result = currentOperand;
            }

            currentOperand = result;
            constantOperand = result;
            displayText = result.stripTrailingZeros().toPlainString();
            hasResult = true;
        }

        mathOperator = "";
        return displayText;
    }

    public String addMinusSign() {
        if (!displayText.isEmpty()) {
            displayText = displayText.startsWith("-") ? displayText.substring(1) : "-" + displayText;
        }
        return displayText;
    }

    public String doBackspace() {
        if (!displayText.isEmpty() && !hasResult) {
            displayText = displayText.substring(0, displayText.length() - 1);
        }
        return displayText;
    }

    private void calculate(BigDecimal secondOperand) {
        switch (mathOperator) {
            case "+":
                currentOperand = currentOperand.add(secondOperand, mathContext);
                break;
            case "-":
                currentOperand = currentOperand.subtract(secondOperand, mathContext);
                break;
            case "x":
                currentOperand = currentOperand.multiply(secondOperand, mathContext);
                break;
            case "÷":
                if (secondOperand.compareTo(BigDecimal.ZERO) != 0) {
                    currentOperand = currentOperand.divide(secondOperand, mathContext);
                } else {
                    result = null; // Division by zero
                }
                break;
        }
    }

    private String removeLeadingZero(String number) {
        if (number.length() > 1 && number.startsWith("0") && !number.startsWith("0.")) {
            number = number.substring(1);
        }
        return number;
    }
}

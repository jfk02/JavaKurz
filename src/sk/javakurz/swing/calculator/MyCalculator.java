package sk.javakurz.swing.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;

public class MyCalculator {

    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    private JTextField display;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a1Button;
    private JButton periodButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a9Button;
    private JButton plusButton;
    private JButton a6Button;
    private JButton minusButton;
    private JButton a3Button;
    private JButton multiplicationButton;
    private JButton equalButton;
    private JButton divideButton;
    private JButton cButton;
    private JButton backspaceButton;
    private JButton plusMinusButton;

    CalculatorService calculatorService;

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
            put("/", () -> calculationQueue.removeFirst().divide(calculationQueue.removeLast(), mathContext));
        }
    };

    private ActionListener createNumbersListener() {
        return e -> {

//            if (hasResult) {
//                hasResult = false;
//                constantOperand = null;
//
//                if (!mathOperator.isEmpty()) {
//                    calculationQueue.add(new BigDecimal(Objects.requireNonNull(displayText)));
//                }
//
//                displayText = "";
//            }
//
//            displayText += displayText.length() < 15 ? e.getActionCommand() : "";
//            displayText = removeHeadingZero(displayText);
            display.setText(calculatorService.doNumbersAction(e.getActionCommand()));
        };
    }

    private ActionListener createOperatorsListener() {
        return e -> {
            display.setText(calculatorService.doOperatorsAction(e.getActionCommand()));

//            hasResult = false;
//
//            if (!displayText.isEmpty()) {
//                calculationQueue.add(new BigDecimal(Objects.requireNonNull(displayText)));
//                clearDisplay();
//            }
//
//            if (calculationQueue.size() == 2) {
//                calculate();
//            }
//
//            mathOperator = e.getActionCommand();
        };
    }

    private ActionListener createClearButtonListener() {
        return e -> {
            display.setText("");
            calculatorService.allClear();
//            calculationQueue.clear();
//            hasResult = false;
//            constantOperand = null;
//            clearDisplay();
        };
    }

    private ActionListener createPeriodButtonListener() {
//        return e -> displayText += !displayText.contains(".") ? "." : "";
        return e-> display.setText(calculatorService.addPeriod());
    }

    private ActionListener createEqualButtonListener() {
        return e -> {
            display.setText(calculatorService.performCalculation());
//            if (!displayText.isEmpty()) {
//                var displayedOperand = new BigDecimal(Objects.requireNonNull(displayText));
//                if (calculationQueue.size() == 1 && !mathOperator.isEmpty()) {
//                    calculationQueue.add(displayedOperand);
//                    constantOperand = displayedOperand;
//                    constantOperator = mathOperator;
//                    calculate();
//                } else if (calculationQueue.isEmpty() && constantOperand != null) {
//                    calculationQueue.add(displayedOperand);
//                    calculationQueue.add(constantOperand);
//                    mathOperator = constantOperator;
//                    calculate();
//                }
//            }
//            mathOperator = "";
        };
    }

    private ActionListener createPlusMinusListener() {
        return e -> {
            display.setText(calculatorService.addMinusSign());
//            if (!displayText.isEmpty()) {
//                displayText = displayText.startsWith("-") ? displayText.substring(1) : "-" + displayText;
//                display.setText(displayText);
//            }
        };
    }

    private ActionListener createBackspaceListener() {
        return e -> {
            display.setText(calculatorService.doBackspace());
//            if (!displayText.isEmpty() && !hasResult) {
//                displayText = displayText.substring(0, displayText.length() - 1);
//                display.setText(displayText);
//            }
        };
    }

    private void calculate() {
        hasResult = false;
        try {
            BigDecimal result = mathEvaluators.get(mathOperator).call();
            displayText = result.toString();
            display.setText(displayText);
            hasResult = true;
        } catch (Exception e) {
            showError();
        }
    }

    private void clearDisplay() {
        displayText = "";
        display.setText(displayText);
    }

    private void showError() {
        displayText = "";
        display.setText("Error");
    }

    private String removeHeadingZero(String number) {

        if (number.length() > 1 && number.startsWith("0") && !number.startsWith("0.")) {
            number = number.substring(1);
        }
        return number;
    }


    public MyCalculator() {

        calculatorService = new CalculatorService();

        var numbersListener = createNumbersListener();
        a0Button.addActionListener(numbersListener);
        a1Button.addActionListener(numbersListener);
        a2Button.addActionListener(numbersListener);
        a3Button.addActionListener(numbersListener);
        a4Button.addActionListener(numbersListener);
        a5Button.addActionListener(numbersListener);
        a6Button.addActionListener(numbersListener);
        a7Button.addActionListener(numbersListener);
        a8Button.addActionListener(numbersListener);
        a9Button.addActionListener(numbersListener);

        var operatorsListener = createOperatorsListener();
        plusButton.addActionListener(operatorsListener);
        minusButton.addActionListener(operatorsListener);
        multiplicationButton.addActionListener(operatorsListener);
        divideButton.addActionListener(operatorsListener);

        equalButton.addActionListener(createEqualButtonListener());

        periodButton.addActionListener(createPeriodButtonListener());

        cButton.addActionListener(createClearButtonListener());

        plusMinusButton.addActionListener(createPlusMinusListener());

        backspaceButton.addActionListener(createBackspaceListener());
    }
}

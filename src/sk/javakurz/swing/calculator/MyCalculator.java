package sk.javakurz.swing.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Function;

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

    private String displayText = "";

    private final LinkedList<String> calculationQueue = new LinkedList<>();

    private String mathOperator = "";

    private boolean hasResult = false;

    private final MathContext mathContext = new MathContext(10);

    private final HashMap<String, Function<BigDecimal[], BigDecimal>> mathEvaluators = new HashMap<>() {
                {
                    put("+", (BigDecimal[] operands) -> operands[0].add(operands[1],mathContext));
                    put("-", (BigDecimal[] operands) -> operands[0].subtract(operands[1], mathContext));
                    put("x", (BigDecimal[] operands) -> operands[0].multiply(operands[1], mathContext));
                    put("/", (BigDecimal[] operands) -> operands[0].divide(operands[1],  mathContext));
                }
            };

    private void addNumbersListener() {
        var numbersListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasResult) {
                    hasResult = false;
                    displayText = "";
                }

                displayText += displayText.length() < 15 ? e.getActionCommand() : "";
                display.setText(displayText);
            }
        };
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
    }

    private void addOperatorsListener() {
        var operatorsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasResult = false;

                if (!displayText.isEmpty()) {
                    calculationQueue.add(displayText);
                    clearDisplay();
                }

                if (calculationQueue.size() == 1) {
                    clearDisplay();
                } else if (calculationQueue.size() == 2) {
                    calculate();
                }

                mathOperator = e.getActionCommand();
            }
        };
        plusButton.addActionListener(operatorsListener);
        minusButton.addActionListener(operatorsListener);
        multiplicationButton.addActionListener(operatorsListener);
        divideButton.addActionListener(operatorsListener);
        cButton.addActionListener(operatorsListener);
    }

    private void addSpecialButtonsListener() {
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculationQueue.clear();
                clearDisplay();
            }
        });

        periodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText += !displayText.contains(".") ? "." : "";
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculationQueue.size() == 1 && !mathOperator.isEmpty()) {
                    calculationQueue.add(displayText);
                    calculate();
                }
            }
        });
    }

    private void calculate() {
        if (!mathOperator.isEmpty() && calculationQueue.size() == 2) {
            try {
                BigDecimal[] operands = new BigDecimal[]{
                        new BigDecimal(Objects.requireNonNull(calculationQueue.poll())),
                        new BigDecimal(Objects.requireNonNull(calculationQueue.poll()))
                };
                BigDecimal result = mathEvaluators.get(mathOperator).apply(operands);
                displayText = result.toString();
                display.setText(displayText);
                hasResult = true;
            } catch (ArithmeticException e) {
                showError();
            }
            mathOperator = "";
        }
    }

    private void clearDisplay() {
        displayText = "";
        display.setText("0");
    }

    private void showError() {
        displayText = "";
        display.setText("Error");
    }

    public MyCalculator() {
        addNumbersListener();
        addOperatorsListener();
        addSpecialButtonsListener();
    }
}

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.*;
// import java.awt.color.*;

public class Calculator {

  int borderWidth = 540;
  int borderHeight = 720;

  Color customLightGray = new Color(212, 212, 210);
  Color customDarkGray = new Color(80, 80, 89);
  Color customBlack = new Color(28,28,28);
  Color customOrange = new Color(255,149,0);

  String[] buttonValues = {
    "AC", "+/-", "%", "x²",
    "cos", "sin", "tan", "÷",
    "7", "8", "9", "*",
    "6", "5", "4", "-",
    "3", "2", "1", "+",
    "0", ".", "√", "="
  };
  String[] rightSymbols = {"÷", "*", "-", "+", "="};
  String[] topSymbols = {"AC", "+/-", "%", "x²", "cos", "sin", "tan"};

  JFrame frame = new JFrame("Calculator");
  JLabel displayLabel = new JLabel();
  JPanel displayPanel = new JPanel();
  JPanel buttonPanel  = new JPanel();

  String A = "0";
  String operator = null;
  String B = null;

  Calculator(){
    // frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setSize(borderWidth,borderHeight);

    displayLabel.setBackground(Color.BLACK);
    displayLabel.setForeground(Color.WHITE);
    displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
    displayLabel.setHorizontalAlignment(JLabel.RIGHT);
    displayLabel.setText("0");
    displayLabel.setOpaque(true);

    displayPanel.setLayout(new BorderLayout());
    displayPanel.add(displayLabel);
    frame.add(displayPanel, BorderLayout.NORTH);

    buttonPanel.setLayout(new GridLayout(6,4));
    buttonPanel.setBackground(customBlack);
    frame.add(buttonPanel);

    for (int i = 0; i < buttonValues.length; i ++) {
      JButton button = new JButton();
      String buttonValue = buttonValues[i];
      button.setFont(new Font("Arial", Font.PLAIN, 30));
      button.setText(buttonValue);
      button.setFocusable(false);
      button.setBorder(new LineBorder(customBlack));

      if (Arrays.asList(topSymbols).contains(buttonValue)) {
        button.setBackground(customLightGray);
        button.setForeground(Color.BLACK);
      } 
      else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
        button.setBackground(customOrange);
        button.setForeground(Color.WHITE);
      }
      else {
        button.setBackground(customDarkGray);
        button.setForeground(Color.WHITE);
      }

      buttonPanel.add(button);

      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton button = (JButton) e.getSource();
          String buttonValue = button.getText();
          if (Arrays.asList(rightSymbols).contains(buttonValue)) {
            if (buttonValue == "="){
              if (A != null) {
                  B = displayLabel.getText();
                  double numA = Double.parseDouble(A);
                  double numB = Double.parseDouble(B);

                  if (operator == "÷") {
                    displayLabel.setText(removeZeroDecimal(numA/numB));
                  }
                  else if (operator == "-") {
                    displayLabel.setText(removeZeroDecimal(numA-numB));
                  }else if (operator == "*") {
                    displayLabel.setText(removeZeroDecimal(numA*numB));
                  }
                  else if (operator == "+") {
                    displayLabel.setText(removeZeroDecimal(numA+numB));
                  }
                  clearAll();
              }
            }
            else if ("÷-*+".contains(buttonValue)) {
              if (operator == null){
                A = displayLabel.getText();
                displayLabel.setText("0");
                B = "0";
              }
              operator = buttonValue;
            }
          }
          else if (Arrays.asList(topSymbols).contains(buttonValue)) {
            if (buttonValue == "AC") {
              clearAll();
              displayLabel.setText("0");
            }
            else if (buttonValue == "+/-") {
              double numDisplay = Double.parseDouble(displayLabel.getText());
              numDisplay *= -1;
              displayLabel.setText(removeZeroDecimal(numDisplay));
            }
            else if (buttonValue == "%"){
              double numDisplay = Double.parseDouble(displayLabel.getText());
              numDisplay /= 100;
              displayLabel.setText(removeZeroDecimal(numDisplay));
            }
            else if (buttonValue.equals("cos")) {
              double numDisplay = Double.parseDouble(displayLabel.getText());
              double result = Math.cos(Math.toRadians(numDisplay));
              displayLabel.setText(removeZeroDecimal(result));
            }
             else if (buttonValue.equals("sin")) {
              double numDisplay = Double.parseDouble(displayLabel.getText());
              double result = Math.sin(Math.toRadians(numDisplay));
              displayLabel.setText(removeZeroDecimal(result));
            }
             else if (buttonValue.equals("tan")) {
              double numDisplay = Double.parseDouble(displayLabel.getText());
              double result = Math.tan(Math.toRadians(numDisplay));
              displayLabel.setText(removeZeroDecimal(result));
            }
            else if (buttonValue.equals("x²")) {
              double numDisplay = Double.parseDouble(displayLabel.getText());
              numDisplay = numDisplay * numDisplay;
              displayLabel.setText(removeZeroDecimal(numDisplay));
            }
          }
           else if (buttonValue == "√") {
            double numDisplay = Double.parseDouble(displayLabel.getText());
            double result = numDisplay = Math.sqrt(numDisplay);
            displayLabel.setText(removeZeroDecimal(result));
        }
            if (buttonValue == ".") {
              if (!displayLabel.getText().contains(buttonValue)) {
                displayLabel.setText(displayLabel.getText() + buttonValue);
              }
            }
            else if ("0123456789".contains(buttonValue)) {
              if (displayLabel.getText() =="0") {
                  displayLabel.setText(buttonValue);
              }
              else {
                displayLabel.setText(displayLabel.getText() + buttonValue);
              }
            }
          }
          
        }
      );
      frame.setVisible(true);
    }
  }

  void clearAll() {
    A = "0";
    operator = null;
    B = null;
  }

  String removeZeroDecimal(double numDisplay){
    if (numDisplay % 1 == 0){
      return Integer.toString((int) numDisplay);
    }
    return Double.toString(numDisplay);
  }
    public static void main(String[] args) {
    new Calculator();
  }
}
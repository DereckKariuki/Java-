import javax.swing.*;
import java.awt.event.*;
public class TextFieldExample2 implements ActionListener{
  JTextField tf1, tf2, tf3;
  JButton b1, b2, b3, b4, b5, b6, b7, b8;

  TextFieldExample2(){
    JFrame f = new JFrame();

    tf1 = new JTextField();
    tf1.setBounds(50,50,150,20);

    tf2 = new JTextField();
    tf2.setBounds(50,100,150,20);

    tf3 = new JTextField();
    tf3.setBounds(50,150,150,20);

    tf3.setEditable(false);

    b1 = new JButton("+");
    b1.setBounds(50,200,50,50);

    b2 = new JButton("-");
    b2.setBounds(120,200,50,50);

    b3 = new JButton("*");
    b3.setBounds(190,200,50,50);

    b4 = new JButton("%");
    b4.setBounds(260,200,50,50);

    b5 = new JButton("/");
    b5.setBounds(50,300,50,50);

    b6 = new JButton(">");
    b6.setBounds(120,300,50,50);

    b7 = new JButton("<");
    b7.setBounds(190,300,50,50);

    b8 = new JButton("==");
    b8.setBounds(260,300,50,50);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);

    f.add(tf1);
    f.add(tf2);
    f.add(tf3);
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);
    f.add(b5);
    f.add(b6);
    f.add(b7);
    f.add(b8);

    f.setSize(600,600);
    f.setLayout(null);
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String s1 = tf1.getText();
    String s2 = tf2.getText();

    int a = Integer.parseInt(s1);
    int b = Integer.parseInt(s2);

    int c = 0;
    

    if (e.getSource() == b1) {
      c = a + b;
    } else if (e.getSource() == b2) {
      c = a - b;
    } else if (e.getSource()== b3){
      c = a * b;
    } else if (e.getSource()== b4){
      c = a % b;
    } else if (e.getSource()== b5){
      c = a / b;
    } else if (e.getSource()== b6){
      if (a > b) {
        tf3.setText("true");
      } else {
        tf3.setText("false");
      }
    }
    String result = String.valueOf(c);

    tf3.setText(result);
  }
  public static void main(String[] args) {
    new TextFieldExample2();
  }
} 

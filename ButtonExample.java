import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;

public class ButtonExample {
  public static void main(String[]args){
    JFrame f = new JFrame("Button Example");
    final JTextField tf = new JTextField();
    tf.setBounds(50,50,150,20);

    JButton resetButton = new JButton("Reset Me");
    resetButton.setBounds(100,50,95,30);
    resetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        tf.setText("");
    }
    });
    JButton b = new JButton("Click Here");
    b.setBounds(50,100,150,20);
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        tf.setText("Welcome to Javapoint.");
      }
    });
      
    f.add(b);
    f.add(tf);
    f.add(resetButton);f.add(tf);
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);
  }
}

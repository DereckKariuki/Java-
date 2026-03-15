import javax.swing.*;
public class Hello {

  JFrame f;
  void Simple(){
    f = new JFrame();
    JButton b = new JButton("Click");
    JButton b1 = new JButton("Click");
    JButton b2 = new JButton("Click");
    b.setBounds(130,100,100,40);
    b1.setBounds(250,50,100,40);
    b2.setBounds(10,50,100,40);
    f.add(b);
    f.add(b1);
    f.add(b2);
    f.setSize(400,500);
    f.setLayout(null);
    f.setVisible(true);
  }

  public static void main(String[]args) {
    Hello hello = new Hello();
    hello.Simple();
  }
}
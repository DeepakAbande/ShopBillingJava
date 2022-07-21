package project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class showbills implements ActionListener {
  JFrame frame = new JFrame();
  JLabel label = new JLabel("Show Bills section");
  JButton button1 = new JButton("previous");

  showbills() {
    button1.setBounds(0, 0, 100, 50);
    button1.addActionListener(this);
    label.setBounds(200, 100, 100, 50);
    frame.setSize(1600, 1000);
    frame.setTitle("Show Bills");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setIconImage(image.getImage());
    // frame.getContentPane().setBackground(new Color(204, 255,253));
    frame.setVisible(true);
    frame.setLayout(null);
    frame.add(label);
    frame.add(button1);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      frame.dispose();
      LaunchPage launchPage = new LaunchPage();
    }
  }
}
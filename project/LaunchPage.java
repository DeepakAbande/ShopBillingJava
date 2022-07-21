package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener {

  JLabel label = new JLabel();
  JLabel label1 = new JLabel();
  JButton bill = new JButton("Create Bill");
  JButton showbill = new JButton("Show Bills");
  JButton sproduct = new JButton("Show Products");
  JButton product = new JButton("Add Products");
  JButton exit = new JButton("EXIT");
  JPanel panel = new JPanel();
  ImageIcon image = new ImageIcon("label.png");

  LaunchPage() {

    panel.setBackground(Color.WHITE);
    panel.setBounds(450, 0, 650, 300);

    label1.setIcon(image);
    label1.setBounds(650, 0, 300, 200);

    label.setText("Deeepak Mashinary stores");
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setForeground(new Color(255, 130, 0));
    label.setFont(new Font("Noto Sans", Font.BOLD, 40));
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
    ;
    label.setBounds(500, 200, 550, 50);

    bill.setBounds(250, 350, 600, 50);
    bill.setFont(new Font("Arial", Font.PLAIN, 25));
    bill.setFocusable(false);
    bill.addActionListener(this);

    showbill.setBounds(250, 430, 600, 50);
    showbill.setFont(new Font("Arial", Font.PLAIN, 25));
    showbill.setFocusable(false);
    showbill.addActionListener(this);

    product.setBounds(250, 500, 600, 50);
    product.setFont(new Font("Arial", Font.PLAIN, 25));
    product.setFocusable(false);
    product.addActionListener(this);

    sproduct.setBounds(250, 580, 600, 50);
    sproduct.setFont(new Font("Arial", Font.PLAIN, 25));
    sproduct.setFocusable(false);
    sproduct.addActionListener(this);

    exit.setBounds(250, 660, 600, 50);
    exit.setFont(new Font("Arial", Font.PLAIN, 25));
    exit.setFocusable(false);
    exit.addActionListener(this);

    this.setSize(1600, 1000);
    this.setTitle("Deepak mashinary stores");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.setVisible(true);
    this.add(label);
    this.add(bill);
    this.add(showbill);
    this.add(product);
    this.add(sproduct);
    this.add(exit);
    this.add(label1);
    this.add(panel);
    this.setLayout(new BorderLayout(10, 10));

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bill) {
      this.dispose();
      createbill newbill = new createbill();
    } else if (e.getSource() == showbill) {
      this.dispose();
      showbills bill = new showbills();
    }

    else if (e.getSource() == product) {
      this.dispose();
      addproduct newproduct = new addproduct();
    } else if (e.getSource() == sproduct) {
      this.dispose();
      showproducts products = new showproducts();
    } else if (e.getSource() == exit) {
      this.dispose();
    }

  }

}
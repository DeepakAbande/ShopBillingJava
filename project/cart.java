package project;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cart extends JFrame implements ActionListener {
  JLabel label = new JLabel("Welcome to add cart section");
  JLabel lpname = new JLabel("Product Name :");
  JLabel lqty = new JLabel("Quantity   :");
  JLabel lprice = new JLabel("Product Price:");
  JLabel ltotal = new JLabel("Total Price:");
  JLabel icon = new JLabel();
  JButton previous = new JButton("previous");
  JButton add = new JButton("add product");
  JTextField pname = new JTextField();
  JTextField qty = new JTextField();
  JTextField price = new JTextField();
  JTextField total = new JTextField();
  ImageIcon image = new ImageIcon("label.png");
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JOptionPane message = new JOptionPane();
  JButton btnNewButton = new JButton();
  ResultSet rs;
  String data = new String();
  int n;

  public void gettotal() {

  }

  cart() {

    panel.setBounds(50, 350, 600, 250);
    panel.setBackground(Color.WHITE);

    panel1.setBackground(Color.WHITE);
    panel1.setBounds(400, 0, 700, 300);

    previous.setBounds(0, 0, 100, 50);
    previous.setFont(new Font("Arial", Font.PLAIN, 15));
    previous.setFocusable(false);
    previous.addActionListener(this);

    add.setBounds(200, 600, 200, 40);
    add.setFont(new Font("Arial", Font.PLAIN, 15));
    add.setFocusable(false);
    add.addActionListener(this);

    icon.setIcon(image);
    icon.setBounds(650, 0, 300, 200);

    label.setBounds(450, 200, 1000, 50);
    label.setFont(new Font("Noto Sans", Font.BOLD, 40));
    label.setForeground(new Color(255, 130, 0));

    lpname.setBounds(100, 400, 300, 30);
    lpname.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lpname.setForeground(new Color(255, 130, 0));

    lprice.setBounds(100, 450, 300, 30);
    lprice.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lprice.setForeground(new Color(255, 130, 0));

    lqty.setBounds(100, 500, 300, 30);
    lqty.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lqty.setForeground(new Color(255, 130, 0));

    ltotal.setBounds(100, 550, 300, 30);
    ltotal.setFont(new Font("Noto Sans", Font.BOLD, 25));
    ltotal.setForeground(new Color(255, 130, 0));

    pname.setBounds(300, 400, 200, 30);
    pname.setFont(new Font("Arial", Font.PLAIN, 15));
    pname.setBackground(Color.BLACK);
    pname.setForeground(new Color(255, 0, 0));
    pname.setCaretColor(Color.WHITE);
    // pname.setText();

    price.setBounds(300, 450, 200, 30);
    price.setFont(new Font("Arial", Font.PLAIN, 15));
    price.setBackground(Color.BLACK);
    price.setForeground(new Color(255, 0, 0));
    price.setCaretColor(Color.WHITE);

    qty.setBounds(300, 500, 200, 30);
    qty.setFont(new Font("Arial", Font.PLAIN, 15));
    qty.setBackground(Color.BLACK);
    qty.setForeground(new Color(255, 0, 0));
    qty.setCaretColor(Color.WHITE);

    total.setBounds(300, 550, 200, 30);
    total.setFont(new Font("Arial", Font.PLAIN, 15));
    total.setBackground(Color.BLACK);
    total.setForeground(new Color(255, 0, 0));
    total.setCaretColor(Color.WHITE);
    // String tee90= new String();
    pname.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String prname = pname.getText();
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

          String query = "select price from product where pname = '" + prname + "'";

          Statement sta = connection.createStatement();
          rs = sta.executeQuery(query);
          while (rs.next()) {
            data = rs.getString(1);
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
        price.setText(data);

      }
    });
    qty.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String q = qty.getText();
        String p = price.getText();
        int a = Integer.parseInt(q);
        int b = Integer.parseInt(p);
        int c = a * b;
        String t = String.valueOf(c);
        total.setText(t);
      }
    });

    this.setSize(1600, 1000);
    this.setTitle("Adding Products to cart");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.setVisible(true);
    this.setLayout(null);
    this.add(label);
    this.add(previous);
    this.add(pname);
    this.add(qty);
    this.add(price);
    this.add(total);
    this.add(add);
    this.add(lpname);
    this.add(lqty);
    this.add(lprice);
    this.add(ltotal);
    this.add(icon);
    this.add(panel);
    this.add(panel1);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      // this.dispose();
      // createbill newbill = new createbill();
    } else if (e.getSource() == add) {

      String prname = pname.getText();
      String prqty = qty.getText();
      String Price = price.getText();
      String Total = total.getText();
      try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        String query = "INSERT INTO cart(pname,price,qty,total) values('" + prname + "'," + Price + "," + prqty + ","
            + Total + ")";

        Statement sta = connection.createStatement();
        int x = sta.executeUpdate(query);
        if (x == 0) {
        } else {
          JOptionPane.showMessageDialog(btnNewButton, "Welcome, Your product is sucessfully added to cart");
        }
        connection.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }

      btnNewButton.setFont(new Font("Noto Sans", Font.BOLD, 25));
      btnNewButton.setBounds(399, 447, 259, 74);
      this.add(btnNewButton);
    }
    this.dispose();
    createbill newbill = new createbill();
  }

}
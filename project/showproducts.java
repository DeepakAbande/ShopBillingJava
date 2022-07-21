package project;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showproducts extends JFrame implements ActionListener {
  JLabel label = new JLabel("Show Products section");
  JButton previous = new JButton("previous");
  ImageIcon image = new ImageIcon("label.png");
  JLabel icon = new JLabel();
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  ResultSet rs;
  JLabel lpname = new JLabel("Product Name");
  JLabel lpid = new JLabel("  Product ID  ");
  JLabel lprice = new JLabel("Product Price");
  JTable prtable;
  JScrollPane sp = new JScrollPane();
  int n = 0;
  //JTable ctable;

  showproducts() {

    previous.setBounds(0, 0, 100, 50);
    previous.setFont(new Font("Arial", Font.PLAIN, 15));
    previous.setFocusable(false);
    previous.addActionListener(this);

    panel.setBackground(Color.WHITE);
    panel.setBounds(400, 0, 700, 300);

    panel1.setBackground(Color.WHITE);
    panel1.setBounds(300, 400, 400, 300);

    icon.setIcon(image);
    icon.setBounds(650, 0, 300, 200);

    label.setBounds(550, 200, 1000, 50);
    label.setFont(new Font("Noto Sans", Font.BOLD, 40));
    label.setForeground(new Color(255, 130, 0));

    lpname.setBounds(300, 370, 150, 30);
    lpname.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lpname.setForeground(new Color(255, 130, 0));

    lpid.setBounds(450, 370, 150, 30);
    lpid.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lpid.setForeground(new Color(255, 130, 0));

    lprice.setBounds(600, 370, 150, 30);
    lprice.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lprice.setForeground(new Color(255, 130, 0));

    /*String[][] data = new String[100][3];

    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

      String query = "select * from product";

      Statement sta = connection.createStatement();
      rs = sta.executeQuery(query);
      while (rs.next()) {
        for (int i = 1; i < 4; i++) {
          data[n][i - 1] = rs.getString(i);

        }
        n++;
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    } /*
       * for(int n=0;n<9;n++){ for(int i=0;i<3;i++){ System.out.print(data[n][i] +
       * "   "); } }
       

    String[] column = { "product names", "product ID", "product Price" };
    JTable prtable = new JTable(data, column);
    prtable.setBounds(300, 400, 450, 300);
    prtable.setFont(new Font("Arial", Font.PLAIN, 15));
    prtable.setVisible(true);
    sp.add(prtable);
    sp.setBounds(300, 400, 450, 300);*/
    

    this.setSize(1600, 1000);
    this.setTitle("Show Products");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.setVisible(true);
    this.setLayout(null);
    //this.add(prtable);
    this.add(sp);
    this.add(label);
    this.add(previous);
    this.add(icon);
    this.add(panel);
    //this.add(panel1);
    this.add(lpname);
    this.add(lpid);
    this.add(lprice);
    this.showproduct();

  }

  public void showproduct() {
    String[][] data = new String[100][4];
    try {
      // String c = cartno.getText();
      // int lastcartno = Integer.parseInt(c);
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

      String query = "select * from product";

      Statement sta = connection.createStatement();
      rs = sta.executeQuery(query);
      while (rs.next()) {
        for (int i = 1; i < 4; i++) {
          data[n][i - 1] = rs.getString(i);

        }
        n++;
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    };
    String[] column = { "product name ", "ID", "product Price" };
    JTable prtable = new JTable(data, column);
    prtable.setBounds(600, 450, 400, 300);
    prtable.setFont(new Font("Arial", Font.PLAIN, 15));
    sp.add(prtable);
    sp.setBounds(300, 400, 450, 300);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      this.dispose();
      LaunchPage launchPage = new LaunchPage();
    }

  }
}
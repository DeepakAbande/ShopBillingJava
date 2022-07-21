package project;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createbill extends JFrame implements ActionListener {

  JLabel label = new JLabel("create bill section");
  JButton previous = new JButton("previous");
  ImageIcon image = new ImageIcon("label.png");
  JLabel icon = new JLabel();
  JPanel panel = new JPanel();
  JPanel puser = new JPanel();
  JPanel pcart = new JPanel();
  JPanel pbill = new JPanel();
  JTextField name = new JTextField();
  JTextField date = new JTextField();
  JTextField cono = new JTextField();
  JTextField city = new JTextField();
  JTextField grandtotal = new JTextField();
  JTextField cartno = new JTextField();
  JLabel lname = new JLabel("Customer name :");
  JLabel ldate = new JLabel("Enter Date    :");
  JLabel lcono = new JLabel("contact no.   :");
  JLabel lcity = new JLabel("Enter village :");
  JLabel luser = new JLabel("USER");
  JLabel lcart = new JLabel("CART");
  JLabel lcid = new JLabel("ID");
  JLabel lpname = new JLabel("Product");
  JLabel lprice = new JLabel("Price");
  JLabel lpqty = new JLabel("Quantity");
  JLabel ltotal = new JLabel("Total");
  JLabel lscart = new JLabel("cart");
  JLabel lbill = new JLabel("BILL");
  JLabel btotal = new JLabel("Grand Total:");
  JLabel tcarts = new JLabel("last Cart no:");
  JButton addcart = new JButton("add cart");
  JButton savebill = new JButton("SAVE BILL");
  ResultSet rs;
  JTable ctable;
  int n = 0;
  ScrollPane p = new ScrollPane();
  JButton btnNewButton = new JButton();
  int prevcartno = 0;

  createbill() {

    previous.setBounds(0, 0, 100, 50);
    previous.setFont(new Font("Arial", Font.PLAIN, 15));
    previous.setFocusable(false);
    previous.addActionListener(this);

    icon.setIcon(image);
    icon.setBounds(650, 0, 300, 200);

    panel.setBackground(Color.WHITE);
    panel.setBounds(500, 0, 500, 300);

    puser.setBackground(Color.WHITE);
    puser.setBounds(30, 350, 440, 300);

    pcart.setBackground(Color.WHITE);
    pcart.setBounds(500, 350, 400, 300);

    pbill.setBackground(Color.WHITE);
    pbill.setBounds(950, 350, 400, 300);

    label.setBounds(550, 200, 1000, 50);
    label.setFont(new Font("Noto Sans", Font.BOLD, 40));
    label.setForeground(new Color(255, 130, 0));

    luser.setBounds(200, 375, 100, 40);
    luser.setFont(new Font("Noto Sans", Font.BOLD, 30));
    luser.setForeground(new Color(255, 130, 0));

    lcart.setBounds(550, 375, 100, 40);
    lcart.setFont(new Font("Noto Sans", Font.BOLD, 30));
    lcart.setForeground(new Color(255, 130, 0));

    lbill.setBounds(1100, 375, 100, 40);
    lbill.setFont(new Font("Noto Sans", Font.BOLD, 30));
    lbill.setForeground(new Color(255, 130, 0));

    lscart.setBounds(700, 450, 100, 40);
    lscart.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lscart.setForeground(new Color(255, 130, 0));

    lname.setBounds(50, 450, 300, 30);
    lname.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lname.setForeground(new Color(255, 130, 0));

    lcono.setBounds(50, 500, 300, 30);
    lcono.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lcono.setForeground(new Color(255, 130, 0));

    lcity.setBounds(50, 550, 300, 30);
    lcity.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lcity.setForeground(new Color(255, 130, 0));

    lpname.setBounds(580, 420, 80, 30);
    lpname.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lpname.setForeground(new Color(255, 130, 0));

    lcid.setBounds(500, 420, 80, 30);
    lcid.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lcid.setForeground(new Color(255, 130, 0));

    lprice.setBounds(660, 420, 80, 30);
    lprice.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lprice.setForeground(new Color(255, 130, 0));

    lpqty.setBounds(720, 420, 80, 30);
    lpqty.setFont(new Font("Noto Sans", Font.BOLD, 20));
    lpqty.setForeground(new Color(255, 130, 0));

    ltotal.setBounds(800, 420, 80, 30);
    ltotal.setFont(new Font("Noto Sans", Font.BOLD, 20));
    ltotal.setForeground(new Color(255, 130, 0));

    ldate.setBounds(50, 600, 300, 30);
    ldate.setFont(new Font("Noto Sans", Font.BOLD, 25));
    ldate.setForeground(new Color(255, 130, 0));

    btotal.setBounds(1000, 500, 300, 30);
    btotal.setFont(new Font("Noto Sans", Font.BOLD, 25));
    btotal.setForeground(new Color(255, 130, 0));

    tcarts.setBounds(1000, 450, 300, 30);
    tcarts.setFont(new Font("Noto Sans", Font.BOLD, 25));
    tcarts.setForeground(new Color(255, 130, 0));

    name.setBounds(250, 450, 200, 30);
    name.setFont(new Font("Arial", Font.PLAIN, 15));
    name.setBackground(Color.BLACK);
    name.setForeground(new Color(255, 0, 0));
    name.setCaretColor(Color.WHITE);

    cono.setBounds(250, 500, 200, 30);
    cono.setFont(new Font("Arial", Font.PLAIN, 15));
    cono.setBackground(Color.BLACK);
    cono.setForeground(new Color(255, 0, 0));
    cono.setCaretColor(Color.WHITE);

    city.setBounds(250, 550, 200, 30);
    city.setFont(new Font("Arial", Font.PLAIN, 15));
    city.setBackground(Color.BLACK);
    city.setForeground(new Color(255, 0, 0));
    city.setCaretColor(Color.WHITE);

    date.setBounds(250, 600, 200, 30);
    date.setFont(new Font("Arial", Font.PLAIN, 15));
    date.setBackground(Color.BLACK);
    date.setForeground(new Color(255, 0, 0));
    date.setCaretColor(Color.WHITE);

   
    grandtotal.setBounds(1150, 500, 150, 30);
    grandtotal.setFont(new Font("Arial", Font.PLAIN, 15));
    grandtotal.setBackground(Color.BLACK);
    grandtotal.setForeground(new Color(255, 0, 0));
    grandtotal.setCaretColor(Color.WHITE);

    cartno.setBounds(1150, 450, 150, 30);
    cartno.setFont(new Font("Arial", Font.PLAIN, 15));
    cartno.setBackground(Color.BLACK);
    cartno.setForeground(new Color(255, 0, 0));
    cartno.setCaretColor(Color.WHITE);

    String[][] data = new String[100][5];
        try {
         // String c = cartno.getText();
          //int lastcartno = Integer.parseInt(c);
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

          String query = "select * from cart";

          Statement sta = connection.createStatement();
          rs = sta.executeQuery(query);
          while (rs.next()) {
            for (int i = 1; i < 6; i++) {
              data[n][i - 1] = rs.getString(i);

            }
            n++;
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        };
    String[] column = { "Cart id", "product name ", "product Price", "Quantity", "Total" };
    JTable ctable = new JTable(data, column);
    ctable.setBounds(500, 450, 400, 300);
    ctable.setFont(new Font("Arial", Font.PLAIN, 15));
    p.add(ctable);
    p.setBounds(500, 450, 400, 200);

    grandtotal.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        int data = 0;
        try {
          // String prname = pname.getText();
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

          String query = "select total from cart";

          Statement sta = connection.createStatement();
          rs = sta.executeQuery(query);
          while (rs.next()) {
            data = data + Integer.parseInt(rs.getString(1));
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
        String g = String.valueOf(data);
        grandtotal.setText(g);

      }
    });

    addcart.setBounds(650, 375, 200, 40);
    addcart.setFont(new Font("Arial", Font.PLAIN, 25));
    addcart.setFocusable(false);
    addcart.addActionListener(this);

    savebill.setBounds(1000, 550, 300, 50);
    savebill.setFont(new Font("Arial", Font.PLAIN, 35));
    savebill.setBackground(Color.GREEN);
    savebill.setFocusable(false);
    savebill.addActionListener(this);

    this.setSize(1600, 1000);
    this.setTitle("Create Bill");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.setVisible(true);
    this.setLayout(null);
    this.add(label);
    this.add(previous);
    this.add(icon);
    this.add(panel);
    this.add(luser);
    this.add(lcart);
    this.add(lbill);
    this.add(lcid);
    this.add(lpname);
    this.add(lprice);
    this.add(lpqty);
    this.add(ltotal);
    this.add(btotal);
    this.add(tcarts);
    this.add(name);
    this.add(date);
    this.add(ldate);
    this.add(cartno);
    this.add(grandtotal);
    this.add(cono);
    this.add(city);
    this.add(lname);
    this.add(ldate);
    this.add(lcity);
    this.add(lcono);
    this.add(p);
    this.add(addcart);
    this.add(savebill);
    this.add(puser);
    this.add(pcart);
    this.add(pbill);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      this.dispose();
      LaunchPage launchPage = new LaunchPage();
    } else if (e.getSource() == addcart) {
      this.dispose();
      cart cart = new cart();

    } else if (e.getSource() == savebill) {

      String cname = name.getText();
      String contact = cono.getText();
      String address = city.getText();
      String bdate = date.getText();
      String gtotal = grandtotal.getText();
      String lastcart = cartno.getText();
      try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        String query = "INSERT INTO bill(cname,contact,address,date,grandtotal,cartno) values('" + cname + "',"
            + contact + ",'" + address + "','" + bdate + "'," + gtotal + "," + lastcart + ")";

        Statement sta = connection.createStatement();
        int x = sta.executeUpdate(query);
        if (x == 0) {
          // JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
        } else {
          JOptionPane.showMessageDialog(btnNewButton, "Welcome, Your bill is successfully saved");
        }
        connection.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }

      btnNewButton.setFont(new Font("Noto Sans", Font.BOLD, 25));
      btnNewButton.setBounds(399, 447, 259, 74);
      this.add(btnNewButton);
      this.dispose();
      LaunchPage launchPage = new LaunchPage();
    }
  }

}

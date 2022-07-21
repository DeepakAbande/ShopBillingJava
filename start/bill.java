package start;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bill extends JFrame implements ActionListener {

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
  JTextField price = new JTextField();
  JLabel lname = new JLabel("Customer name :");
  JLabel ldate = new JLabel("Enter Date    :");
  JLabel lcono = new JLabel("contact no.   :");
  JLabel lcity = new JLabel("Enter village :");
  JLabel luser = new JLabel("USER");
  JLabel lproduct = new JLabel("Product:");
  JLabel lbill = new JLabel("BILL");
  JLabel lqty = new JLabel("Quantity");
  JLabel lprice = new JLabel("Price:");
  JLabel ltotal = new JLabel("Total:");
  JTextField qty = new JTextField();
  JTextField total = new JTextField();
  JLabel btotal = new JLabel("Grand Total:");
  JButton addtobill = new JButton("Add to bill");
  JButton savebill = new JButton("SAVE BILL");
  ResultSet rs;
  JTable ctable;
  int n = 0;
  ScrollPane p = new ScrollPane();
  JButton btnNewButton = new JButton();
  JComboBox pname;
  String[] data = new String[100];

  bill() {

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

    pbill.setBackground(Color.WHITE);
    pbill.setBounds(1150, 350, 400, 300);

    label.setBounds(550, 200, 1000, 50);
    label.setFont(new Font("Noto Sans", Font.BOLD, 40));
    label.setForeground(new Color(255, 130, 0));

    luser.setBounds(200, 375, 100, 40);
    luser.setFont(new Font("Noto Sans", Font.BOLD, 30));
    luser.setForeground(new Color(255, 130, 0));

    lbill.setBounds(1300, 375, 100, 40);
    lbill.setFont(new Font("Noto Sans", Font.BOLD, 30));
    lbill.setForeground(new Color(255, 130, 0));

    lname.setBounds(50, 450, 300, 30);
    lname.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lname.setForeground(new Color(255, 130, 0));

    lcono.setBounds(50, 500, 300, 30);
    lcono.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lcono.setForeground(new Color(255, 130, 0));

    lcity.setBounds(50, 550, 300, 30);
    lcity.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lcity.setForeground(new Color(255, 130, 0));

    ldate.setBounds(50, 600, 300, 30);
    ldate.setFont(new Font("Noto Sans", Font.BOLD, 25));
    ldate.setForeground(new Color(255, 130, 0));

    btotal.setBounds(1200, 500, 300, 30);
    btotal.setFont(new Font("Noto Sans", Font.BOLD, 25));
    btotal.setForeground(new Color(255, 130, 0));
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

    grandtotal.setBounds(1450, 500, 150, 30);
    grandtotal.setFont(new Font("Arial", Font.PLAIN, 15));
    grandtotal.setBackground(Color.BLACK);
    grandtotal.setForeground(new Color(255, 0, 0));
    grandtotal.setCaretColor(Color.WHITE);

    savebill.setBounds(1200, 750, 300, 50);
    savebill.setFont(new Font("Arial", Font.PLAIN, 35));
    savebill.setBackground(Color.GREEN);
    savebill.setFocusable(false);
    savebill.addActionListener(this);

    this.setSize(1600, 1000);
    this.setTitle("Create Bill");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.setLayout(null);
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.addtoBill();
    this.savebill();
    this.setVisible(true);
    this.add(label);
    this.add(previous);
    this.add(icon);
    this.add(panel);
    this.add(luser);
    this.add(lproduct);
    // this.add(lbill);
    // this.add(btotal);
    this.add(name);
    this.add(date);
    this.add(ldate);
    // this.add(grandtotal);
    this.add(cono);
    this.add(city);
    this.add(lname);
    this.add(ldate);
    this.add(lcity);
    this.add(lcono);
    this.add(p);
    this.add(addtobill);
    this.add(savebill);
    this.add(puser);
    this.add(pcart);
    // this.add(pbill);

  }

  public void addtoBill() {

    pcart.setBackground(Color.WHITE);
    pcart.setBounds(500, 350, 400, 300);

    lproduct.setBounds(510, 375, 100, 40);
    lproduct.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lproduct.setForeground(new Color(255, 130, 0));

    lprice.setBounds(720, 375, 100, 30);
    lprice.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lprice.setForeground(new Color(255, 130, 0));

    lqty.setBounds(510, 425, 100, 30);
    lqty.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lqty.setForeground(new Color(255, 130, 0));

    ltotal.setBounds(720, 425, 100, 30);
    ltotal.setFont(new Font("Noto Sans", Font.BOLD, 25));
    ltotal.setForeground(new Color(255, 130, 0));

    addtobill.setBounds(600, 750, 200, 30);
    addtobill.setFont(new Font("Arial", Font.PLAIN, 25));
    addtobill.setFocusable(false);
    addtobill.addActionListener(this);

    price.setBounds(790, 375, 100, 30);
    price.setFont(new Font("Arial", Font.PLAIN, 15));
    price.setBackground(Color.BLACK);
    price.setForeground(new Color(255, 0, 0));
    price.setCaretColor(Color.WHITE);

    qty.setBounds(610, 425, 100, 30);
    qty.setFont(new Font("Arial", Font.PLAIN, 15));
    qty.setBackground(Color.BLACK);
    qty.setForeground(new Color(255, 0, 0));
    qty.setCaretColor(Color.WHITE);

    total.setBounds(790, 425, 100, 30);
    total.setFont(new Font("Arial", Font.PLAIN, 15));
    total.setBackground(Color.BLACK);
    total.setForeground(new Color(255, 0, 0));
    total.setCaretColor(Color.WHITE);
    int i = 0;
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

      String query = "select pname from product";

      Statement sta = connection.createStatement();
      rs = sta.executeQuery(query);
      while (rs.next()) {

        data[i] = rs.getString(1);
        i++;
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    } // for (int j=0;j<25; j++){
      // System.out.print(data[j]);}
    pname = new JComboBox(data);
    pname.setBounds(610, 380, 100, 25);
    this.add(pname);
    pname.addActionListener(new ActionListener() {
      String d;

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Object prname = pname.getSelectedItem();
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

          String query = "select price from product where pname = '" + prname + "'";

          Statement sta = connection.createStatement();
          rs = sta.executeQuery(query);
          while (rs.next()) {
            d = rs.getString(1);
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
        price.setText(d);

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

    this.add(qty);
    this.add(price);
    this.add(total);
    this.add(lqty);
    this.add(lprice);
    this.add(ltotal);

  }

  public void savebill() {
    JTextArea billtxt = new JTextArea();
    billtxt.setBounds(950, 350, 500, 400);
    billtxt.setBackground(new Color(250, 240, 230));
    this.add(billtxt);
    addtobill.addActionListener(new ActionListener() {
      int n = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        if (name.getText().isEmpty() || cono.getText().isEmpty() || city.getText().isEmpty() || date.getText().isEmpty()
            || total.getText().isEmpty() || price.getText().isEmpty() || qty.getText().isEmpty()) {
          JOptionPane.showMessageDialog(btnNewButton, "Missing Information!!");
        } else {
          n++;
          if (n == 1) {
            billtxt.setText(billtxt.getText() + "\t\tDeepak mashinary Stores\n Costmer name:" + name.getText()
                + "\ncontact no:" + cono.getText() + "\nAddress:" + city.getText() + "Date:" + date.getText()
                + "NUM     prodname     price     Qty     Total\n" + n + "     " + pname.getSelectedItem() + "     "
                + price.getText() + "     " + qty.getText() + "     " + total.getText());
          } else {
            billtxt.setText(billtxt.getText() + n + "     " + pname.getSelectedItem() + "     " + price.getText()
                + "     " + qty.getText() + "     " + total.getText());
          }
        }

      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      this.dispose();
      // LaunchPage launchPage = new LaunchPage();
    } else if (e.getSource() == addtobill) {
      this.dispose();
      // cart cart = new cart();

    } else if (e.getSource() == savebill) {

      String cname = name.getText();
      String contact = cono.getText();
      String address = city.getText();
      String bdate = date.getText();
      String gtotal = grandtotal.getText();
      try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        String query = "INSERT INTO bill(cname,contact,address,date,grandtotal,cartno) values('" + cname + "',"
            + contact + ",'" + address + "','" + bdate + "'," + gtotal + "," + ")";

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
      // this.dispose();
      // LaunchPage launchPage = new LaunchPage();
    }
  }

}

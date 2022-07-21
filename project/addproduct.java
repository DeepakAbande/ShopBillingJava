package project;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addproduct extends JFrame implements ActionListener {
  JLabel label = new JLabel("Welcome to add product section");
  JLabel lpname = new JLabel("Product Name :");
  JLabel lpid = new JLabel("Product ID   :");
  JLabel lprice = new JLabel("Product Price:");
  JLabel spname = new JLabel("Product Name");
  JLabel spid = new JLabel("Product ID   ");
  JLabel sprice = new JLabel("Product Price");
  JLabel icon = new JLabel();
  JButton previous = new JButton("previous");
  JButton add = new JButton("add product");
  JTextField pname = new JTextField();
  JTextField pid = new JTextField();
  JTextField price = new JTextField();
  ImageIcon image = new ImageIcon("label.png");
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JOptionPane message = new JOptionPane();
  JButton btnNewButton = new JButton();
  int n = 0;
  ScrollPane p = new ScrollPane();
  ResultSet rs;
  JTable ctable;

  addproduct() {

    panel.setBounds(50, 350, 500, 250);
    panel.setBackground(Color.WHITE);

    panel1.setBackground(Color.WHITE);
    panel1.setBounds(400, 0, 700, 300);


    previous.setBounds(0, 0, 100, 50);
    previous.setFont(new Font("Arial", Font.PLAIN, 15));
    previous.setFocusable(false);
    previous.addActionListener(this);

    add.setBounds(200, 550, 200, 40);
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

    lpid.setBounds(100, 450, 300, 30);
    lpid.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lpid.setForeground(new Color(255, 130, 0));

    lprice.setBounds(100, 500, 300, 30);
    lprice.setFont(new Font("Noto Sans", Font.BOLD, 25));
    lprice.setForeground(new Color(255, 130, 0));

    pname.setBounds(300, 400, 200, 30);
    pname.setFont(new Font("Arial", Font.PLAIN, 15));
    pname.setBackground(Color.BLACK);
    pname.setForeground(new Color(255, 0, 0));
    pname.setCaretColor(Color.WHITE);

    pid.setBounds(300, 450, 200, 30);
    pid.setFont(new Font("Arial", Font.PLAIN, 15));
    pid.setBackground(Color.BLACK);
    pid.setForeground(new Color(255, 0, 0));
    pid.setCaretColor(Color.WHITE);

    price.setBounds(300, 500, 200, 30);
    price.setFont(new Font("Arial", Font.PLAIN, 15));
    price.setBackground(Color.BLACK);
    price.setForeground(new Color(255, 0, 0));
    price.setCaretColor(Color.WHITE);

    this.setSize(1600, 1000);
    this.setTitle("Adding Products");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(204, 255, 253));
    this.setVisible(true);
    this.setLayout(null);
    this.add(p);
    this.add(label);
    this.add(previous);
    this.add(pname);
    this.add(pid);
    this.add(price);
    this.add(add);
    this.add(lpname);
    this.add(lpid);
    this.add(lprice);
    this.add(icon);
    this.add(panel);
    this.add(panel1);
    this.showproduct();

  }

  public void showproduct() {

    spname.setBounds(600, 350, 200, 30);
    spname.setFont(new Font("Noto Sans", Font.BOLD, 20));
    spname.setForeground(new Color(255, 130, 0));

    spid.setBounds(800, 350, 200, 30);
    spid.setFont(new Font("Noto Sans", Font.BOLD, 20));
    spid.setForeground(new Color(255, 130, 0));

    sprice.setBounds(1000, 350, 200, 30);
    sprice.setFont(new Font("Noto Sans", Font.BOLD, 20));
    sprice.setForeground(new Color(255, 130, 0));

    panel2.setBounds(600, 350, 600, 250);
    panel2.setBackground(Color.WHITE);

    String[][] data = new String[100][4];
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
    }
    ;
    String[] column = { "product name ", "ID", "product Price" };
    JTable ctable = new JTable(data, column);
    ctable.setBounds(600, 400, 600, 300);
    ctable.setFont(new Font("Arial", Font.PLAIN, 15));
    p.add(ctable);
    p.setBounds(600, 400, 600, 200);
    this.add(spname);
    this.add(spid);
    this.add(sprice);
    this.add(panel2);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      this.dispose();
      LaunchPage launchPage = new LaunchPage();
    } else if (e.getSource() == add) {

      String prname = pname.getText();
      String prid = pid.getText();
      String Price = price.getText();
      if(prname.isEmpty() || prid.isEmpty() || Price.isEmpty()){
        JOptionPane.showMessageDialog(btnNewButton, "Missing Information!!");
      }
      else{
      try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        String query = "INSERT INTO product(pname,pid,price) values('" + prname + "'," + prid + "," + Price + ")";

        Statement sta = connection.createStatement();
        int x = sta.executeUpdate(query);
        if (x == 0) {
          JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
        } else {
          JOptionPane.showMessageDialog(btnNewButton, "Welcome, Your product is sucessfully added");
        }
        connection.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }

      btnNewButton.setFont(new Font("Noto Sans", Font.BOLD, 25));
      //btnNewButton.setBounds(399, 447, 259, 74);
      this.add(btnNewButton);
      showproduct();
      // this.dispose();
      // LaunchPage launchPage = new LaunchPage();
    }
    }

  }

}
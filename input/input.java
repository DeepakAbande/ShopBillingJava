package input;

//import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class input{
    public static void main(String[] args) {
      JFrame frame = new JFrame();
      JTextField text =new JTextField();

      text.setBounds(100, 100, 250, 50);
      
      frame.setSize(500,500);
      frame.setTitle("Deepak mashinary stores");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.setIconImage(image.getImage());
      //frame.getContentPane().setBackground(new Color(80, 130,200));
      frame.setLayout(null);
      frame.setVisible(true);
      frame.add(text);
        
    }
}
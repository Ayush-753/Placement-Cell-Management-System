/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcms;

/**
 *
 * @author Ayush
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login implements ActionListener
{
    JFrame frame;
    JLabel USNLabel=new JLabel("USERID");
    JLabel Title = new JLabel("LOGIN FORM");
    JTextField USNTextField=new JTextField();
    JLabel passwordLabel=new JLabel("PASSWORD");
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton = new JButton("Login");
    JLabel image = new JLabel();
    Icon p;
    String[] choice={"Student", "Faculty"};
    JComboBox choiceComboBox=new JComboBox (choice);
    Login()
    {   
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setBounds (300, 300, 800, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
    }
    public void setLocationAndSize()
    {
        Title.setBounds(320, 50, 400, 40);
        Title.setFont (new Font("Cambria", Font.CENTER_BASELINE, 25));
        Title.setBackground(Color.white); 
        Title.setForeground(Color.red);
        
        choiceComboBox.setBounds(300, 150, 200, 40);
        choiceComboBox.setFont (new Font("Cambria", Font.CENTER_BASELINE, 20));
        choiceComboBox.setBackground(Color.WHITE);
        
        USNLabel.setBounds (200, 200, 400,40);
        USNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        USNLabel.setBackground(Color.white);
        USNLabel.setForeground(Color.red);
        USNTextField.setBounds (200,250,400,40);
        USNTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
        USNTextField.setBackground(Color.WHITE);
        passwordLabel.setBounds (200,300,400,40);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        passwordLabel.setBackground(Color.white);
        passwordLabel.setForeground(Color.red);
        passwordField.setBounds (200,350,400,40);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
        passwordField.setBackground(Color.WHITE);
        
        p = new ImageIcon("C:\\Users\\DELL\\Downloads\\Placement.jpg");
        
        image.setBounds (10, 130, 800, 419);
        image.setIcon(p);
        loginButton.setBounds (200,450,400,40);
    }
    public void addComponentsToFrame()
    {
        frame.add(Title);
        frame.add(choiceComboBox);
        frame.add(USNLabel);
        frame.add(USNTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(image);
    }
    public void actionEvent()
    {
        loginButton.addActionListener(this);
    }
        @Override
    public void actionPerformed (ActionEvent e){
    if(e.getSource()==loginButton)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
            
            Statement stmt = conn1.createStatement();
            Statement stmtl = conn1.createStatement();
            String usn = USNTextField.getText();
            String pass = passwordField.getText();
        
        if(choiceComboBox.getSelectedItem().toString().equals("Student"))
        {
            String query = "SELECT * FROM student_details";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String UserId = rs.getString("USN");
                String Password = rs.getString("Password");
            if(UserId.equals(usn) && Password.equals(pass))
            {
                JOptionPane.showMessageDialog(null, "Logged In Successfully");
                Search s = new Search();
                frame.setVisible(false);
            }
           }
        }    
            if(choiceComboBox.getSelectedItem().toString().equals("Faculty"))
            {
                String queryl = "SELECT * FROM po_details";
                ResultSet rsl = stmtl.executeQuery(queryl);
                    while(rsl.next())
                {
                    String UserId1 = rsl.getString("UserId");
                    String Password1 = rsl.getString("Password");
                if (UserId1.equals(usn) && Password1.equals(pass))
                {
                    JOptionPane.showMessageDialog(null, "Logged In Successfully");
                    Search s = new Search();
                    frame.setVisible(false);
                }
              }
            }
                else
                JOptionPane.showMessageDialog(null, "Invalid Credentials!");
            } catch (SQLException el) {
                el.printStackTrace();
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}   
}

class Main1 {
    public static void main(String[] args){
        Login l = new Login();
    }
}

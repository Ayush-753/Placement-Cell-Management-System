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

public class PassChange implements ActionListener
{
    JFrame frame;
    JLabel usnLabel = new JLabel("UserId");
    JLabel passwordLabel = new JLabel("Password");
    JLabel changePassLabel = new JLabel("New Password");
    JLabel Title = new JLabel("Reset Your Fassword If You Don't Remember!");
    JLabel repassLabel = new JLabel("Re-Type New Password");
    JPasswordField passwordField = new JPasswordField();
    JPasswordField changePassField = new JPasswordField();
    JPasswordField rePasswordField = new JPasswordField();
    JTextField usnTextField = new JTextField();
    String[] choice={"Student", "Faculty"};
    JComboBox choiceComboBox=new JComboBox (choice);

    JButton ChangeButton = new JButton("Change");

    PassChange ()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Password Reset");
        frame.setBounds (300, 300, 900, 800);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        Title.setBounds (200, 5, 600, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        
        choiceComboBox.setBounds(200, 60, 200, 40);
        choiceComboBox.setBackground (Color.white);
        choiceComboBox.setFont(new Font("Campraa", Font.CENTER_BASELINE, 25));
        
        usnLabel.setBounds(200, 110, 400,40);
        usnLabel.setBackground(Color.white);
        usnLabel.setFont(new Font("Camoria", Font.CENTER_BASELINE, 18));
        
        usnTextField.setBounds(200, 160, 400,40);
        usnTextField.setBackground(Color.white);
        usnTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        passwordLabel.setBounds(200, 210, 400,40);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        passwordField.setBounds(200, 260, 400, 40);
        passwordField.setBackground(Color.white);
        passwordField.setFont(new Font("Campria", Font.CENTER_BASELINE, 18));
        
        changePassLabel.setBounds(200, 310, 120, 40);
        changePassLabel.setBackground(Color.white);
        changePassLabel.setFont(new Font("Camoria", Font.CENTER_BASELINE, 18));
        
        changePassField.setBounds(200, 360, 400, 40);
        changePassField.setBackground(Color.white);
        changePassField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        repassLabel.setBounds(200, 410, 400, 40);
        repassLabel.setBackground(Color.white);
        repassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        rePasswordField.setBounds(200,460,400,40);
        rePasswordField.setBackground(Color.white);
        rePasswordField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        ChangeButton.setBounds(300,530,200,40);
        ChangeButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        }
        public void addComponentsToFrame()
        {
            frame.add(usnLabel);
            frame.add(usnTextField);
            frame.add(Title);
            frame.add(passwordLabel);
            frame.add(passwordField);
            frame.add(changePassLabel);
            frame.add(changePassField); 
            frame.add(repassLabel);
            frame.add(rePasswordField);
            frame.add(ChangeButton);
            frame.add(choiceComboBox);
        }
        public void actionEvent()
        {
            ChangeButton.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==ChangeButton)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Creating Connection Object
                Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
                
                String usn = usnTextField.getText();
                String pass = passwordField.getText();
                String changePass = changePassField.getText();
                String re_pass = rePasswordField.getText();
                if(usn.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "UserId Is Missing");
                }
                else if(pass.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Password Is Missing");
                }                
                else if(changePass.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "New Password Is Missing");
                }                
                else if(!changePass.equals(re_pass))
                {
                    JOptionPane.showMessageDialog(null, "Password Doesn't Match");
                }
                
                if(choiceComboBox.getSelectedItem().toString()=="Student")
                {
                    Statement stmt = conn1.createStatement();
                    String query = "SELECT * FROM student_details";
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next())
                    {
                        String UserId = rs.getString("USN");
                        String Password = rs.getString("Password");
                    if (UserId.equals(usn))
                    {
                        JOptionPane.showMessageDialog(null, "User Already Exists");
                    PreparedStatement Pstatement = conn1.prepareStatement("update student_details set Password = ?, ConfirmPassword = ? where USN = ?");
                    Pstatement.setString(1,changePassField.getText());
                    Pstatement.setString(2,changePassField.getText());
                    Pstatement.setString(3,usnTextField.getText());
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                    }
                    }
                }
                if(choiceComboBox.getSelectedItem().toString()=="Faculty")
                {
                    Statement stmt = conn1.createStatement();
                    String query = "SELECT * FROM po_details";
                    ResultSet rs = stmt.executeQuery(query);
                    
                    while(rs.next())
                    {
                    String UserId = rs.getString("UserId");
                    String Password = rs.getString("Password");
                    if(UserId.equals(usn))
                    {
                     JOptionPane.showMessageDialog(null, "User Already Exists");
                    PreparedStatement Pstatement=conn1.prepareStatement("update po_details set Password = ?, ConfirmPassword = ? where UserId = ?");
                    Pstatement.setString(1,changePassField.getText());
                    Pstatement.setString(2,changePassField.getText());
                    Pstatement.setString(3,usnTextField.getText());
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                    }
        
                   }    
    
                }
                    frame.setVisible(false);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
               }
}

class Main8
{
    public static void main(String args[])
    {
        PassChange pc = new PassChange();
    }
}

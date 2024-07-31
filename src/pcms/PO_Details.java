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

public class PO_Details implements ActionListener
{
        JFrame frame;
        JLabel emailLabel=new JLabel("EMAIL");
        JLabel UserIdLabel = new JLabel("UserId");
        JLabel nameLabel = new JLabel("Name");
        JLabel branchLabel = new JLabel("Dept");
        JLabel collegenameLabel = new JLabel("CollegeName");
        JLabel passwordLabel = new JLabel("Password");
        JLabel confirmpassLabel = new JLabel("Confirm Password");
        JLabel Title = new JLabel("Enter PO Details");
        
        String[] branch= {"Placement Cell", "External"};
        
        JTextField emailTextField = new JTextField();
        JTextField UserIdTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JComboBox branchname = new JComboBox (branch);
        JTextField collegeTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmpassField = new JPasswordField();
        JButton homeButton = new JButton("Home");
        JButton saveButton = new JButton("Save");
        JButton compButton = new JButton("Company Details");
        JButton updateButton = new JButton("Update");

        PO_Details()
        {
            createWindow();
            setLocationAndSize();
            addComponentsToFrame();
            actionEvent();
        }    
        public void createWindow()
        {
            frame = new JFrame();
            frame.setTitle("PO Details Form");
            frame.setBounds (300, 300, 1000, 900);
            frame.getContentPane().setBackground(Color.white);
            frame.getContentPane().setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable (false);
        }    
        public void setLocationAndSize()
        {
            Title.setBounds(390, 2, 400, 40);
            Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
            Title.setBackground(Color.white);
            
            UserIdLabel.setBounds(300, 40, 400,40);
            UserIdLabel.setBackground(Color.white);
            UserIdLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            UserIdTextField.setBounds (300, 80, 400, 40);
            UserIdTextField.setBackground(Color.white);
            UserIdTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            nameLabel.setBounds(300, 120, 120, 40);
            nameLabel.setBackground(Color.white);
            nameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            nameTextField.setBounds (300,170,400,40);
            nameTextField.setBackground(Color.white);
            nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            emailLabel.setBounds (300,220,400,40);
            emailLabel.setBackground(Color.white);
            emailLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            emailTextField.setBounds (300,270,400,40);
            emailTextField.setBackground(Color.white);
            emailTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            branchLabel.setBounds (300,320,400,40);
            branchLabel.setBackground(Color.white);
            branchLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            branchname.setBounds (300,370,400,40);
            branchname.setBackground(Color.white);
            branchname.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            collegenameLabel.setBounds (300,420,400,40);
            collegenameLabel.setBackground(Color.white);
            collegenameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            collegeTextField.setBounds (300,470,400,40);
            collegeTextField.setBackground (Color.white);
            collegeTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            passwordLabel.setBounds (300, 520, 400, 40);
            passwordLabel.setBackground(Color.white);
            passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            passwordField.setBounds (300, 570, 400, 40);
            passwordField.setBackground(Color.white);
            passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            confirmpassLabel.setBounds (300, 610, 400, 40);
            confirmpassLabel.setBackground (Color.white);
            confirmpassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            confirmpassField.setBounds (300, 660, 400, 40);
            confirmpassField.setBackground(Color.white);
            confirmpassField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            homeButton.setBounds (90,710,180,40);
            homeButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            saveButton.setBounds (300,710,180,40);
            saveButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            compButton.setBounds(510,710,190,40);
            compButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
            
            updateButton.setBounds (720,710,180,40);
            updateButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        }
        
            public void addComponentsToFrame ()
        {
            frame.add(Title);
            frame.add(UserIdLabel);
            frame.add(UserIdTextField);
            frame.add(nameLabel);
            frame.add(nameTextField);
            frame.add(emailLabel);
            frame.add(emailTextField);
            frame.add(branchLabel);
            frame.add(branchname);
            frame.add(passwordField);
            frame.add(collegenameLabel);
            frame.add(collegeTextField);
            frame.add(passwordLabel);
            frame.add(passwordField);
            frame.add(confirmpassLabel); frame.add(confirmpassField);
            frame.add(homeButton); frame.add(saveButton);
            frame.add(compButton);
            frame.add(updateButton);
        }
            
            public void actionEvent ()
        {
            homeButton.addActionListener(this);
            saveButton.addActionListener(this);
            compButton.addActionListener(this);
            updateButton.addActionListener(this);
        }
            
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==saveButton)
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //Creating Connection Object
                    Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
                    //Preacated Statement
                    PreparedStatement Pstatement= conn1.prepareStatement("insert into po_details values(?, ?, ?, ?, ?, ?, ?)");
                    //Specifying the values of it's parameter
                    Pstatement.setString(1,UserIdTextField.getText());
                    Pstatement.setString(2,nameTextField.getText());
                    Pstatement.setString(3,emailTextField.getText());
                    Pstatement.setString(4,branchname.getSelectedItem().toString());
                    Pstatement.setString(5,collegeTextField.getText());
                    Pstatement.setString(6,passwordField.getText());
                    Pstatement.setString(7,confirmpassField.getText());
                    
                    //Checking for the Fassword matco
                    String usn = UserIdTextField.getText();
                    String pass = passwordField.getText();
                    String re_pass = confirmpassField.getText();
                    String email = emailTextField.getText();
            if(usn.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Userid Is Missing");
            }
            else if(pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Password Is Missing");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Email Is Missing");
            }
            else if(!pass.equals(re_pass))
            {
                JOptionPane.showMessageDialog(null, "Password Doesn't Mation");
            }
            
                    Statement stmt = conn1.createStatement();
                    
                    String query = "SELECT * FROM po_details";
                    ResultSet rs = stmt.executeQuery(query);
                    
                    while(rs.next())
                    {
                        String UserId = rs.getString("UserId");
                        String Password = rs.getString("Password");
                    if (UserId.equals(usn) && Password.equals(pass))
                    {
                        JOptionPane.showMessageDialog(null, "UserId Already Exists");
                    }
                    else
                    {
                        //Executing query
                        Pstatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "User Registered Successfully");
                    }
                   }
                    
                  if(!rs.next())
                  {
                     Pstatement.executeUpdate();
                     JOptionPane.showMessageDialog(null, "User Registered Successfully");
                  }
                        
                } catch (SQLException el) {
                        el.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PO_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(e.getSource()== updateButton)
            {
                try
                {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
                //Preapared Statement
                Statement stmt = conn1.createStatement();
                String query = "SELECT * FROM po_details";
                ResultSet rs = stmt.executeQuery(query);
                
                String usn = UserIdTextField.getText();
                String pass = passwordField.getText();
                String email = emailTextField.getText();
                
                while(rs.next())
                {
                    String UserId = rs.getString("UserId");
                    String Password = rs.getString("Password");
                    
                 if(UserId.equals(usn))
                 {    
                    JOptionPane.showMessageDialog(null, "UserId Already Exists");
                    
                PreparedStatement Pstatement = conn1.prepareStatement ("update po_details set UserName = ?, Email = ?, Dept = , collegeName = ?, Password = ?, ConfirmPassword = ? where UserId = ?");
                
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,emailTextField.getText());
                Pstatement.setString(3,branchname.getSelectedItem().toString());
                Pstatement.setString(4,collegeTextField.getText());
                Pstatement.setString(5,passwordField.getText());
                Pstatement.setString(6,confirmpassField.getText());
                Pstatement.setString(7,UserIdTextField.getText());
                
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                }
               }
                JOptionPane.showMessageDialog(null, "Enter Details Fields Are Empty!!");
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
             }
         }
            
        if(e.getSource()==homeButton)
        {
            //Clearing Fields
            Home h = new Home ();
            frame.setVisible(false);
        }
        if(e.getSource()==compButton)
        {
            Company_Details c = new Company_Details();
            frame.setVisible(false);
        }
    }    
}
class Main3 {
    public static void main(String[] args)
    {
        PO_Details t= new PO_Details();
    }
}
             


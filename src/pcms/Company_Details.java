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

public class Company_Details implements ActionListener{
    JFrame frame;
    JLabel emailLabel= new JLabel("EMAIL");
    JLabel CompanyIdLabel = new JLabel("CompanyId");
    JLabel companynameLabel = new JLabel("Company Name");
    JLabel branchLabel = new JLabel("Branch");
    JLabel Title = new JLabel("Enter Company Details");
    JLabel contactNoLabel = new JLabel("ContactNo");
    JLabel cuttoffLabel = new JLabel("Cuttoff");
    JLabel AddressLabel = new JLabel("Address");
    JLabel HRnameLabel = new JLabel("HR Name");
    JLabel skillLabel = new JLabel("Required Skills");
    JLabel Type = new JLabel("Branch Type");
    
    String[] type= {"Soft", "Hard"};
    String[] branch = {"AIDS", "CSE(AI&ML)", "CSE", "Electronics", "Mechanical", "Civil", "ISE", "CSE(DS)"};
    
    JCheckBox b1 = new JCheckBox("AIDS");
    JCheckBox b2 = new JCheckBox("CSE(AI&ML)");
    JCheckBox b3 = new JCheckBox("CSE");
    JCheckBox b4 = new JCheckBox("Electronics");
    JCheckBox b5 = new JCheckBox("Mechanical");
    JCheckBox b6 = new JCheckBox("Civil");
    JCheckBox b7 = new JCheckBox("ISE");
    JCheckBox b8 = new JCheckBox("CSE(DS)");
    JComboBox type1 = new JComboBox(type);
    
    JTextField emailTextField = new JTextField();
    JTextField companyIdTextField = new JTextField();
    JTextField companyNameTextField = new JTextField();
    JTextField contactNoTextField = new JTextField();
    JTextField cutoffTextField = new JTextField();
    JTextField addressTextField = new JTextField();
    JTextField HRnameTextField = new JTextField();
    JTextField skillTextField = new JTextField();
    JTextArea Skills = new JTextArea();
    JButton saveButton = new JButton("Save");
    JButton loginButton = new JButton("Login");
    JButton updateButton = new JButton("Update");
    
    Company_Details()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Company Detalls Form");
        frame.setBounds (300, 300, 1000, 1000);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize()
    {
        Title.setBounds (350, 2, 400, 40);
        Title.setBackground (Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        
        CompanyIdLabel.setBounds (100, 40, 400,40);
        CompanyIdLabel.setBackground(Color.white);
        CompanyIdLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        companyIdTextField.setBounds (100, 90, 400, 40);
        companyIdTextField.setBackground(Color.white);
        companyIdTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        companynameLabel.setBounds (100, 140, 400, 40);
        companynameLabel.setBackground (Color.white);
        companynameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        companyNameTextField.setBounds(100,190,400,40);
        companyNameTextField.setBackground(Color.white);
        companyNameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        emailLabel.setBounds (100,240,400,40);
        emailLabel.setBackground(Color.white);
        emailLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        emailTextField.setBounds (100,290,400,40);
        emailTextField.setBackground (Color.white);
        emailTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        contactNoLabel.setBounds (100,340,400,40);
        contactNoLabel.setBackground (Color.white);
        contactNoLabel.setFont (new Font("Cambrie", Font.CENTER_BASELINE, 18));
        
        contactNoTextField.setBounds (100,390, 400, 40);
        contactNoTextField.setBackground(Color.white);
        contactNoTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        AddressLabel.setBounds (100,440,400,40);
        AddressLabel.setBackground(Color.white);
        AddressLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        addressTextField.setBounds (100,490,400,40);
        addressTextField.setBackground (Color.white);
        addressTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        HRnameLabel.setBounds (100, 540, 400, 40);
        HRnameLabel.setBackground(Color.white);
        HRnameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        HRnameTextField.setBounds (100, 590, 400, 40);
        HRnameTextField.setBackground(Color.white);
        HRnameTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        cuttoffLabel.setBounds (100, 640, 400, 40);
        cuttoffLabel.setBackground (Color.white);
        cuttoffLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        cutoffTextField.setBounds (100, 690, 400, 40);
        cutoffTextField.setBackground(Color.white);
        cutoffTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        branchLabel.setBounds (550, 40, 400, 40);
        branchLabel.setBackground(Color.white);
        branchLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        b1.setBounds (550, 90, 400, 40);
        b1.setBackground(Color.white);
        b1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 10));
        
        b2.setBounds (550, 140, 400, 40);
        b2.setBackground(Color.white);
        b2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        b3.setBounds (550, 190, 400, 40);
        b3.setBackground(Color.white);
        b3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        b4.setBounds (550, 240, 400, 40);
        b4.setBackground(Color.white);
        b4.setFont(new Font("Cambzia", Font.CENTER_BASELINE, 18));
        
        b5.setBounds (550, 290, 400, 40);
        b5.setBackground(Color.white);
        b5.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        b6.setBounds(550, 340, 400, 40);
        b6.setBackground(Color.white);
        b6.setFont(new Font("Cambzia", Font.CENTER_BASELINE, 18));
        
        b7.setBounds (550, 390, 400, 40);
        b7.setBackground(Color.white);
        b7.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        b8.setBounds (550, 440, 400, 40);
        b8.setBackground(Color.white);
        b8.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        skillLabel.setBounds (550, 490, 400, 40);
        skillLabel.setBackground(Color.white);
        skillLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        skillTextField.setBounds (550, 540, 400, 40);
        skillTextField.setBackground(Color.white);
        skillTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        Type.setBounds (550, 590, 400, 40);
        Type.setBackground(Color.white);
        Type.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        type1.setBounds(680, 590, 200, 40);
        type1.setBackground(Color.white);
        type1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        saveButton.setBounds (550,650, 100,40);
        saveButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        loginButton.setBounds (660,650,100,40);
        loginButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        updateButton.setBounds (770, 650,100,40);
        updateButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }
    public void addComponentsToFrame()
    {
        frame.add(Title);
        frame.add(CompanyIdLabel);
        frame.add(companyIdTextField);
        frame.add(companynameLabel);
        frame.add(companyNameTextField);
        frame.add(emailLabel);
        frame.add(emailTextField);
        frame.add(contactNoLabel);
        frame.add(contactNoTextField);
        frame.add(AddressLabel);
        frame.add(addressTextField);
        frame.add(HRnameLabel);
        frame.add(HRnameTextField);
        frame.add(cuttoffLabel);
        frame.add(cutoffTextField);
        frame.add(branchLabel);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(skillLabel);
        frame.add(skillTextField);
        frame.add(saveButton);
        frame.add(loginButton);
        frame.add(Type);
        frame.add(type1);
        frame.add(updateButton);
    }
    public void actionEvent()
    {
        saveButton.addActionListener(this);
        loginButton.addActionListener(this);
        updateButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveButton)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Creating Connection Object
                Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
                
                PreparedStatement Pstatement = conn1.prepareStatement ("insert into company_details (CompanyId, Companyname, Email, ContactNo, Address, HRName, Cuttoff, BranchRequired, Skills, BranchType)" + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
               String branch = null;
                 if(b1.isSelected() == true)
                {
                    branch = "AIDS";
                }
                if(b2.isSelected()==true)
                {
                    branch += "CSE(AI&ML)";
                }
                if(b3.isSelected()==true)
                {
                    branch += "CSE";
                }
                if(b4.isSelected()==true)
                {
                    branch += "Electronics";
                }
                if(b5.isSelected()==true)
                {
                    branch += "Mechanical";
                }
                if(b6.isSelected()==true)
                {
                    branch += "Civil";
                }
                if(b7.isSelected()==true)
                {
                    branch += "ISE";
                }
                if (b8.isSelected()==true)
                {
                    branch += "CSE(DS)";
                }
                
                Pstatement.setString(1,companyIdTextField.getText());
                Pstatement.setString(2,companyNameTextField.getText());
                Pstatement.setString(3,emailTextField.getText());
                Pstatement.setString(4,contactNoTextField.getText());
                Pstatement.setString(5,addressTextField.getText());
                Pstatement.setString(6,HRnameTextField.getText());
                Pstatement.setString(7,cutoffTextField.getText());
                Pstatement.setString(8, branch);
                Pstatement.setString(9,skillTextField.getText());
                Pstatement.setString(10,type1.getSelectedItem().toString());
               String usn = companyIdTextField.getText();
               String name = companyNameTextField.getText();
               String email = emailTextField.getText();
        if(usn.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Company Id Is Missing");
        }
        else if (name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Compeny Name Te Mieeing");
        }
        else if (email.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Email Is Missing");
        }
                Statement stmt = conn1.createStatement();
                String query = "SELECT * FROM company_details";
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next())
                {
                    String CompanyId = rs.getString("CompanyId");
                    String Name = rs.getString("CompanyName");
                if (CompanyId.equals(usn) && Name.equals(name))
                {
                    JOptionPane.showMessageDialog(null, "CompanyId Already Exists");
                }
                else
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Company Details Registered Successfully");
                }
               } 
              if(!rs.next())
                {  
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Company Details Regianeran Sancrasfaliy");
                }
             } catch (SQLException el) {
                el.printStackTrace();
             } catch (ClassNotFoundException ex) {
                Logger.getLogger(Company_Details.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource()==updateButton)
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Creating Connection Object
                Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
                //Preapared Statement
                
               String usn = companyIdTextField.getText();
               String name = companyNameTextField.getText();
               String email = emailTextField.getText();
               
                Statement stmt = conn1.createStatement();
                
               String query = "SELECT * FROM company_details";
               ResultSet rs = stmt.executeQuery(query);
                while(rs.next())
                {
                    String CompanyId = rs.getString("CompanyId");
                    String Name = rs.getString("CompanyName");
                
                if (CompanyId.equals(usn) && Name.equals(name))
                {
                    JOptionPane.showMessageDialog(null, "CompanyId Rizeady Exists");
                    JOptionPane.showMessageDialog(null, "You Can Update The Data Or Go Far Login");
                    PreparedStatement Pstatement=conn1.prepareStatement("update company_details set Companyname = ?, Email = ?, ContactNo = ?, Address = ?, HRName = ?, Cuttoff = ?, BranchRequired=?, Skills = ?, BranchType = ? where CompanyId = ?");
                    //Specifying the values of it's parameter
                    String branch = null;
                      if(b1.isSelected() == true)
                     {
                         branch = "AIDS";
                     }
                     if(b2.isSelected()==true)
                     {
                         branch += "CSE(AI&ML)";
                     }
                     if(b3.isSelected()==true)
                     {
                         branch += "CSE";
                     }
                     if(b4.isSelected()==true)
                     {
                         branch += "Electronics";
                     }
                     if(b5.isSelected()==true)
                     {
                         branch += "Mechanical";
                     }
                     if(b6.isSelected()==true)
                     {
                         branch += "Civil";
                     }
                     if(b7.isSelected()==true)
                     {
                         branch += "ISE";
                     }
                     if (b8.isSelected()==true)
                     {
                         branch += "CSE(DS)";
                     } 
                     
                     Pstatement.setString(1,companyNameTextField.getText());
                     Pstatement.setString(2,emailTextField.getText());
                     Pstatement.setString(3,contactNoTextField.getText());
                     Pstatement.setString(4,addressTextField.getText());
                     Pstatement.setString(5,HRnameTextField.getText());
                     Pstatement.setString(6,cutoffTextField.getText());
                     Pstatement.setString(7, branch);
                     Pstatement.setString(8,skillTextField.getText());
                     Pstatement.setString(9,type1.getSelectedItem().toString());
                     Pstatement.setString(10,companyIdTextField.getText());
                     
                     Pstatement.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                     }
                    } 
                    JOptionPane.showMessageDialog(null, "Enter Details Fields Are Empty");

                    if(usn.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Company Id Is Missing");
                    }
                    else if(name.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Company Name Is Missing");
                    }
                    else if (email.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Email Is Missing");
                    }
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                     }    
                    if(e.getSource()==loginButton)
                    {   
                        Login l = new Login();
                        frame.setVisible(false);
                    }
        }
}

class Main4 {
    public static void main(String[] args){
        Company_Details t1 = new Company_Details();
    }
}

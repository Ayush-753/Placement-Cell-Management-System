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

/**
 *
 * @author Ayush
 */
public class Student_Details implements ActionListener
{
    JFrame frame;
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel USNLabel = new JLabel("USN");
    JLabel nameLabel = new JLabel("Name");
    JLabel branchLabel = new JLabel("Branch");
    JLabel yearLabel = new JLabel("Year");
    JLabel CGPA1Label = new JLabel("CGPA1");
    JLabel CGPA2Label = new JLabel("CGPA2");
    JLabel CGPA3Label = new JLabel("CGPA3");
    JLabel CGPA4Label = new JLabel("CGPA4");
    JLabel collegenameLabel = new JLabel("CollegeName");
    JLabel nationalityLabel = new JLabel("Nationality");
    JLabel disabledLabel = new JLabel("Disabled");
    JLabel genderLabel = new JLabel("Gender");
    JLabel skillLabel = new JLabel("Skills");
    JLabel phoneNoLabel = new JLabel("PhoneNo");
    JLabel dobLabel = new JLabel("DOB");
    JLabel addressLabel = new JLabel("Address");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmpassLabel = new JLabel("Confirm Password");
    JLabel Title = new JLabel("Enter Student Details");
    JLabel PlacedLabel = new JLabel("Placed");
    JLabel type = new JLabel("Branch Type");
    
    String[] branch = {"AIDS", "CSE(AI&ML)", "CSE", "Electronics", "Mechanical", "Civil", "ISE", "CSE(DS)"};
    String[] Year = {"FY", "SY", "TY", "Final "};
    String[] Disabled = {"Yes", "No"};
    String[] Placed = {"Yes", "No"};
    String[] Gender = {"Male", "Female", "Other"};
    String[] Type = {"Soft", "Hard"};
    JTextField emailTextField = new JTextField();
    JTextField USNTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JComboBox branchname = new JComboBox (branch);
    JComboBox yearname= new JComboBox (Year);
    JComboBox disabled = new JComboBox (Disabled);
    JComboBox gender = new JComboBox (Gender);
    JComboBox placed = new JComboBox (Placed);
    JComboBox type1 = new JComboBox (Type);
    JTextField CGPA1TextField = new JTextField();
    JTextField CGPA2TextField = new JTextField();
    JTextField CGPA3TextField= new JTextField();
    JTextField CGPA4TextField = new JTextField();
    JTextField collegeTextField = new JTextField();
    JTextField NationalityTextField = new JTextField();
    JTextField disabledTextField = new JTextField();
    JTextField genderTextField = new JTextField();
    JTextField skillTextField = new JTextField();
    JTextField phoneNoTextField = new JTextField();
    JTextField dobTextField = new JTextField();
    JTextField addressTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmpassField = new JPasswordField();
    
    JButton HomeButton = new JButton("Home");
    JButton saveButton = new JButton("Save");
    JButton updateButton = new JButton("Update");
    
    Student_Details()
    {
       createWindow();
       setLocationAndSize();
       addComponentsToFrame();
       actionEvent();
    }
    
    public void createWindow()
    {
       frame=new JFrame();
       frame.setTitle("Student Details Form");
       frame.setBounds(200, 200, 1400, 900);
       frame.getContentPane().setBackground(Color.white);
       frame.getContentPane().setLayout(null);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
    }
    
    public void setLocationAndSize()
    {        
       Title.setBounds (550, 2, 250, 30);
       Title.setBackground(Color.white);
       Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
       
       USNLabel.setBounds(100, 20, 300, 40);
       USNLabel.setBackground(Color.white);
       USNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       USNTextField.setBounds(100, 60, 300, 40);
       USNTextField.setBackground(Color.white);
       USNTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       nameLabel.setBounds (100, 110, 400, 40);
       nameLabel.setBackground(Color.white);
       nameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       nameTextField.setBounds (100,160,300,40);
       nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       nameTextField.setBackground(Color.white);
       
       emailLabel.setBounds (100,210, 400,40);
       emailLabel.setBackground(Color.white);
       emailLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       emailTextField.setBounds (100,260,300,40);
       emailTextField.setBackground(Color.white);
       emailTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       passwordLabel.setBounds (100,310,400,40);
       passwordLabel.setBackground (Color.white);
       passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       passwordField.setBounds (100,360,300,40);
       passwordField.setBackground(Color.white);
       passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       confirmpassLabel.setBounds (100,410,400,40);
       confirmpassLabel.setBackground(Color.white);
       confirmpassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       confirmpassField.setBounds (100,460,300,40);
       confirmpassField.setBackground(Color.white);
       confirmpassField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       branchLabel.setBounds (100, 510, 400, 40);
       branchLabel.setBackground(Color.white);
       branchLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       branchname.setBounds(100, 560, 300, 40);
       branchname.setBackground(Color.white);
       branchname.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       yearLabel.setBounds(100, 610, 300, 40);
       yearLabel.setBackground(Color.white);
       yearLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       yearname.setBounds (100,660,300,40);
       yearname.setBackground(Color.white);      
       yearname.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA1Label.setBounds (450, 20, 300, 40);
       CGPA1Label.setBackground(Color.white);
       CGPA1Label.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA1TextField.setBounds (450, 60, 300, 40);
       CGPA1TextField.setBackground(Color.white);
       CGPA1TextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA2Label.setBounds (450, 110, 300, 40);
       CGPA2Label.setBackground(Color.white);
       CGPA2Label.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA2TextField.setBounds (450, 160, 300, 40);
       CGPA2TextField.setBackground(Color.white);
       CGPA2TextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA3Label.setBounds(450, 210, 300, 40);
       CGPA3Label.setBackground(Color.white);
       CGPA3Label.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA3TextField.setBounds (450, 260, 300, 40);
       CGPA3TextField.setBackground(Color.white);
       CGPA3TextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA4Label.setBounds(450, 310, 300, 40);
       CGPA4Label.setBackground(Color.white);
       CGPA4Label.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       CGPA4TextField.setBounds (450, 360, 300, 40);
       CGPA4TextField.setBackground(Color.white);
       CGPA4TextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       collegenameLabel.setBounds (450, 410, 300, 40);
       collegenameLabel.setBackground(Color.white);
       collegenameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       collegeTextField.setBounds (450, 460, 300, 40);
       collegeTextField.setBackground (Color.white);
       collegeTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       nationalityLabel.setBounds (450, 510, 300, 40);
       nationalityLabel.setBackground(Color.white);
       nationalityLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       NationalityTextField.setBounds (450, 560, 300, 40);
       NationalityTextField.setBackground(Color.white);
       NationalityTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       disabledLabel.setBounds (450, 610, 300, 40);
       disabledLabel.setBackground(Color.white);
       disabledLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       disabled.setBounds (450, 660, 300, 40);
       disabled.setBackground(Color.white);
       disabled.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       genderLabel.setBounds (800, 110, 300, 40);
       genderLabel.setBackground(Color.white);
       genderLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       gender.setBounds (800, 160, 300, 40);
       gender.setBackground(Color.white);
       gender.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       phoneNoLabel.setBounds (800, 210, 300, 40);
       phoneNoLabel.setBackground(Color.white);
       phoneNoLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       phoneNoTextField.setBounds (800, 260, 300, 40);
       phoneNoTextField.setBackground (Color.white);
       phoneNoTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       dobLabel.setBounds(800, 310, 300, 40);
       dobLabel.setBackground(Color.white);
       dobLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       dobTextField.setBounds (800, 360, 300, 40);
       dobTextField.setBackground(Color.white);
       dobTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       addressLabel.setBounds (800, 410, 300, 40);
       addressLabel.setBackground(Color.white);
       addressLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       addressTextField.setBounds (800, 460, 300, 40);
       addressTextField.setBackground(Color.white);
       addressTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       skillLabel.setBounds (800, 510, 300, 40);
       skillLabel.setBackground(Color.white);
       skillLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       skillTextField.setBounds (800, 560, 300, 40);
       skillTextField.setBackground(Color.white);
       skillTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

       PlacedLabel.setBounds (800, 610, 300, 40);
       PlacedLabel.setBackground(Color.white);
       PlacedLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       placed.setBounds (800, 660, 300, 40);
       placed.setBackground(Color.white);
       placed.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       type.setBounds (800, 20, 300, 40);
       type.setBackground(Color.white);
       type.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       type1.setBounds(800, 60, 300, 40);
       type1.setBackground(Color.white);
       type1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       HomeButton.setBounds (200,730, 100,40);
       HomeButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       saveButton.setBounds (540,730,100,40);
       saveButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
       
       updateButton.setBounds (900,730,100,40);
       updateButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    }
    public void addComponentsToFrame()
    {
       frame.add(Title);
       frame.add(USNLabel);
       frame.add(USNTextField);
       frame.add(nameLabel);
       frame.add(nameTextField);
       frame.add(emailLabel);
       frame.add(emailTextField);
       frame.add(passwordLabel);
       frame.add(passwordField);
       frame.add(confirmpassLabel);
       frame.add(confirmpassField);
       frame.add(branchLabel);
       frame.add(branchname);
       frame.add(yearLabel);
       frame.add(yearname);
       frame.add(CGPA1Label);
       frame.add(CGPA1TextField);
       frame.add(CGPA2Label);
       frame.add(CGPA2TextField);
       frame.add(CGPA3Label);
       frame.add(CGPA3TextField);
       frame.add(CGPA4Label);
       frame.add(CGPA4TextField);
       frame.add(collegenameLabel);
       frame.add(collegeTextField);
       frame.add(nationalityLabel);
       frame.add(NationalityTextField);
       frame.add(disabledLabel);
       frame.add(disabled);
       frame.add(genderLabel);
       frame.add(gender);
       frame.add(phoneNoLabel);
       frame.add(phoneNoTextField);
       frame.add(dobLabel);
       frame.add(dobTextField);
       frame.add(addressLabel);
       frame.add(addressTextField);
       frame.add(skillLabel);
       frame.add(skillTextField);
       frame.add(PlacedLabel);
       frame.add(placed);
       frame.add(type1);
       frame.add(type);
       frame.add(HomeButton);
       frame.add(saveButton);
       frame.add(updateButton);    
    }
    public void actionEvent()
    {
       HomeButton.addActionListener(this);
       saveButton.addActionListener(this);
       updateButton.addActionListener(this);
       USNTextField.addActionListener(this);
       nameTextField.addActionListener(this);
       emailTextField.addActionListener(this);
       passwordField.addActionListener(this);
       confirmpassField.addActionListener(this);
       branchname.addActionListener(this);
       yearname.addActionListener(this);
       CGPA1TextField.addActionListener(this);
       CGPA2TextField.addActionListener(this);
       CGPA3TextField.addActionListener(this);
       CGPA4TextField.addActionListener(this);
       collegeTextField.addActionListener(this);
       NationalityTextField.addActionListener(this);
       disabled.addActionListener(this);
       gender.addActionListener(this);
       phoneNoTextField.addActionListener(this);
       dobTextField.addActionListener(this);
       addressTextField.addActionListener(this);
       skillTextField.addActionListener(this);
       placed.addActionListener(this);
       type1.addActionListener(this);
    }
    private boolean userExists(Connection connection, String userId, String password) throws SQLException {
        String query = "SELECT * FROM student_details WHERE USN = ? AND Password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == saveButton) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating Connection Object
            Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");

            String usn = USNTextField.getText();
            String pass = passwordField.getText();
            String re_pass = confirmpassField.getText();
            String email = emailTextField.getText();

            if (usn.equals("") || pass.equals("") || email.equals("")) {
                JOptionPane.showMessageDialog(null, "UserId, Password, and Email are required fields");
            } else if (!pass.equals(re_pass)) {
                JOptionPane.showMessageDialog(null, "Password doesn't match");
            } else {
                // Check if user already exists
                if (userExists(conn1, usn, pass)) {
                    JOptionPane.showMessageDialog(null, "UserId already exists");
                } else {
                    // Prepared Statement
                    PreparedStatement Pstatement = conn1.prepareStatement(
                            "insert into student_details (USN, Name, Email, Password, ConfirmPassword, Branch, Year, CGPA1, CGPA2, CGPA3, CGPA4, CollegeName, Nationality, Disabled, BranchType, Gender, PhoneNo, DOB, Address, Skills, Placed) " +
                                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    // Specify values of parameters
                    Pstatement.setString(1, USNTextField.getText());
                    Pstatement.setString(2, nameTextField.getText());
                    Pstatement.setString(3, emailTextField.getText());
                    Pstatement.setString(4, passwordField.getText());
                    Pstatement.setString(5, confirmpassField.getText());
                    Pstatement.setString(6, branchname.getSelectedItem().toString());
                    Pstatement.setString(7, yearname.getSelectedItem().toString());
                    Pstatement.setString(8, CGPA1TextField.getText());
                    Pstatement.setString(9, CGPA2TextField.getText());
                    Pstatement.setString(10, CGPA3TextField.getText());
                    Pstatement.setString(11, CGPA4TextField.getText());
                    Pstatement.setString(12, collegeTextField.getText());
                    Pstatement.setString(13, NationalityTextField.getText());
                    Pstatement.setString(14, disabled.getSelectedItem().toString());
                    Pstatement.setString(15, type1.getSelectedItem().toString());
                    Pstatement.setString(16, gender.getSelectedItem().toString());
                    Pstatement.setString(17, phoneNoTextField.getText());
                    Pstatement.setString(18, dobTextField.getText());
                    Pstatement.setString(19, addressTextField.getText());
                    Pstatement.setString(20, skillTextField.getText());
                    Pstatement.setString(21, placed.getSelectedItem().toString());
                    

                    // Execute the insert query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "User Registered Successfully");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (e.getSource() == updateButton) {
        // Handle update operation here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating Connection Object
            Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");

            String usn = USNTextField.getText();
            String pass = passwordField.getText();
            String re_pass = confirmpassField.getText();
            String email = emailTextField.getText();

            if (usn.equals("") || pass.equals("") || email.equals("")) {
                JOptionPane.showMessageDialog(null, "UserId, Password, and Email are required fields");
            } else if (!pass.equals(re_pass)) {
                JOptionPane.showMessageDialog(null, "Password doesn't match");
            } else {
                // Check if user exists
                if (!userExists(conn1, usn, pass)) {
                    JOptionPane.showMessageDialog(null, "UserId doesn't exist for update");
                } else {
                    // Prepared Statement for update
                    PreparedStatement Pst = conn1.prepareStatement(
                            "update student_details set Name = ?, Email = ?, Password = ?, ConfirmPassword = ?, Branch = ?, Year = ?, CGPA1 = ?, CGPA2 = ?, CGPA3 = ?, CGPA4 = ?, CollegeName = ?, Nationality = ?, Disabled = ?, BranchType = ?, Gender = ?, PhoneNo = ?, DOB = ?, Address = ?, Skills = ?, Placed = ? where USN = ?");

                    // Specify values of parameters
                    Pst.setString(1, nameTextField.getText());
                    Pst.setString(2, emailTextField.getText());
                    Pst.setString(3, passwordField.getText());
                    Pst.setString(4, confirmpassField.getText());
                    Pst.setString(5, branchname.getSelectedItem().toString());
                    Pst.setString(6, yearname.getSelectedItem().toString());
                    Pst.setString(7, CGPA1TextField.getText());
                    Pst.setString(8, CGPA2TextField.getText());
                    Pst.setString(9, CGPA3TextField.getText());
                    Pst.setString(10, CGPA4TextField.getText());
                    Pst.setString(11, collegeTextField.getText());
                    Pst.setString(12, NationalityTextField.getText());
                    Pst.setString(13, disabled.getSelectedItem().toString());
                    Pst.setString(14, type1.getSelectedItem().toString());
                    Pst.setString(15, gender.getSelectedItem().toString());
                    Pst.setString(16, phoneNoTextField.getText());
                    Pst.setString(17, dobTextField.getText());
                    Pst.setString(18, addressTextField.getText());
                    Pst.setString(19, skillTextField.getText());
                    Pst.setString(20, placed.getSelectedItem().toString());                 
                    Pst.setString(21, USNTextField.getText());

                    // Execute the update query
                    Pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                }
            }
        }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Student_Details.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
        if(e.getSource()==HomeButton)
        {
            Home h = new Home();
            frame.setVisible(false);
        }
    }    
}

    
   
class Main2 {
    public static void main(String[] args){
        Student_Details sd = new Student_Details();
    }
}
    


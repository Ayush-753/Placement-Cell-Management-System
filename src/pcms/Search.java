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
import javax.swing.table.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search implements ActionListener {
    JFrame framel;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton fetchButton;
    JButton resetButton;
    JButton logoutButton;
    
    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;
    int flag=0;
    
    Search() {
        framel = new JFrame();
        framel.setTitle("Placement Details");
        framel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        framel.setSize(1000, 1000);
        framel.setLayout (bagLayout);
        
        bagConstraints.insets = new Insets (15, 40, 0, 0);//Setting the padding between the components and neighboring components
        
        nameLabel = new JLabel("Enter UserId / CompanyName");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        framel.add(nameLabel, bagConstraints);
        
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        bagConstraints.ipady = 10;
        framel.add(nameTextField, bagConstraints);
        
        fetchButton = new JButton("Search Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1; bagConstraints.ipadx = 60;
        framel.add(fetchButton, bagConstraints);
        
        resetButton = new JButton("Reset Data");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        framel.add(resetButton, bagConstraints);
        
        logoutButton = new JButton("Logout");
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        framel.add(logoutButton, bagConstraints);
        
        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);
        logoutButton.addActionListener(this);
        
        framel.setVisible(true);      
        framel.validate();
    }
    
    public static void main(String[] args) {
        new Search();
    }
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchButton) {
        String userName = nameTextField.getText();
        frameSecond(userName);
        }
        if (e.getSource() == resetButton) {
        nameTextField.setText("");
        }
        if (e.getSource() == logoutButton) {
        framel.dispose();//resetting the value of username text field
        JOptionPane.showMessageDialog(null, "Logout Successful");
        }
    }
    public void frameSecond (String userName){
        //setting the properties of second JFrame
        frame2 = new JFrame("Placement Details");
        frame2.setLayout(new FlowLayout());
        frame2.setSize (1500, 1500);
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable (defaultTableModel);
        table.setPreferredScrollableViewportSize (new Dimension (1000, 1000));
        table.setRowHeight (50);
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane (table));
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("USN");
        defaultTableModel.addColumn("Branch");
        defaultTableModel.addColumn("collegeName");
        defaultTableModel.addColumn("CompanyName");
        defaultTableModel.addColumn("Placed");
        defaultTableModel.addColumn("Year");
        defaultTableModel.addColumn("Average");
        defaultTableModel.addColumn("BranchType");
        JTableHeader tableHeader = table.getTableHeader();
        Font headerFont = new Font("Tahoma", Font. PLAIN, 16);
        tableHeader.setFont(headerFont);
        table.setFont (headerFont);
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","admin123");
        statement = connection.createStatement();
        String query = "select distinct s.Name, s.USN, s.Branch, s.collegeName, c.CompanyName, s.Placed, s.Year, r.Average, s.BranchType from student_details s inner join result r on s.USN=r.USN inner join company_details c where s.CGPA1 > c.Cuttoff AND s.CGPA2 > c.Cuttoff AND s.CGPA3 > c.Cuttoff AND s.CGPA4 > c.Cuttoff AND s.BranchType = c.BranchType";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            //Retrieving details from the database and storing it in the String variables
            String name = resultSet.getString("Name");
            String usn = resultSet.getString("USN");
            String dept = resultSet.getString("Branch");
            String CollegeName = resultSet.getString("collegeName");
            String CompanyName = resultSet.getString("CompanyName");
            String placed = resultSet.getString("Placed");
            String year = resultSet.getString("Year");
            String avg = resultSet.getString("Average");
            String type = resultSet.getString("BranchType");
            while(userName.equalsIgnoreCase(usn) || userName.equalsIgnoreCase(CompanyName)) {
                flag = 1;
                defaultTableModel.addRow(new Object[] {name, usn, dept, CollegeName, CompanyName, placed, year, avg, type});
                frame2.setVisible(true);//Setting the visibility of second Frame frame2.validate();
                break;
            }
        }
        if (flag== 0) {
            JOptionPane.showMessageDialog(null, "No Such Username Found");//When invalid username is entered
        }
      } catch (SQLException ee) {
            ee.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

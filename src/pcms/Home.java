/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Home implements ActionListener 
{
    static String prn=null;
    JFrame frame;
    JPanel contentPane;
    JLabel welcome = new JLabel("Welcome to Placement Cell Management "
            + "System!!");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu1 = new JMenu("New");
    JMenu menu2 = new JMenu("Help");
    
    JMenuItem menuItem1 = new JMenuItem("Student Registration");
    JMenuItem menuItem2 = new JMenuItem("PO Registration");
    JMenuItem menuItem3 = new JMenuItem("Login");
    JMenuItem menuItem4 = new JMenuItem("Exit");
    
    JMenuItem menuItem5 = new JMenuItem("Change Password");
    
    ImageIcon backgroundImage;
    JLabel image = new JLabel();
    
    Home()
    {
      createWindow();
      setLocationAndSize();
      addComponentsToFrame();
      actionEvent();
    }
    
public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Home");
        frame.setBounds(300, 300, 1200, 800);

        // Use a JPanel as the content pane
        contentPane = new JPanel() {
            // Override the paintComponent method to draw the background image
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the image at the specified location
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        frame.setContentPane(contentPane);

        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

public void setLocationAndSize()
{
    menuBar.setBounds(2, 2, 1280, 30);
    
    menu1.setBounds(2, 2, 100, 30);
    menu1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    menuItem1.setBounds(2, 2, 100, 40);
    menuItem1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    menuItem2.setBounds(2, 8, 100, 40);
    menuItem2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    menuItem3.setBounds(2, 14, 100, 40);
    menuItem3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
   
    menuItem4.setBounds(2, 20, 100, 40);
    menuItem4.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    
    menu2.setBounds(30, 2, 100, 30);
    menu2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    menuItem5.setBounds(30, 2, 100, 40);
    menuItem5.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    
    
    menu1.add(menuItem1);
    menu1.add(menuItem2);
    menu1.add(menuItem3);
    menu1.add(menuItem4);
    
    menu2.add(menuItem5);
    
    menuBar.add(menu1);
    menuBar.add(menu2);
    
    welcome.setBounds(300, 100, 900, 50);
    welcome.setBackground(Color.white);
    welcome.setForeground(Color.red);
    welcome.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
    
        
}

public void addComponentsToFrame()
{
    frame.add(menuBar);
    frame.add(welcome);
    frame.add(image);
}

public void actionEvent()
{
    menuItem1.addActionListener(this);
    menuItem2.addActionListener(this);
    menuItem3.addActionListener(this);
    menuItem4.addActionListener(this);
    menuItem5.addActionListener(this);    
}

public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==menuItem1)
    {
        Student_Details sd = new Student_Details();
        frame.setVisible(false);
    }
    
    if(e.getSource()==menuItem2)
    {
        PO_Details po = new PO_Details();
        frame.setVisible(false);
    }
    
    if(e.getSource()==menuItem3)
    {
        Login l = new Login();
        frame.setVisible(false);
    }
    
    if(e.getSource()==menuItem4)
    {
        frame.setVisible(false);
    }
    
    if(e.getSource()==menuItem5)
    {
        PassChange pc = new PassChange();
        frame.setVisible(false);
    }
}
}


class Main
{
    public static void main(String args[])
    {
        Home s = new Home();
        s.backgroundImage = new ImageIcon("C:\\Users\\Ayush\\OneDrive\\Pictures\\Saved Pictures\\placement.jpg");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * Login.java
 */


/**
 * The GUI for the creation of a new User into the system.
 * 
 * @author none
 */
public class Login extends JFrame{
    
  JButton create;
  JPanel newUserPanel;
  JTextField userField;
  JTextField passField;
  BufferedReader br = null;
  String line = "";
  String splitOn = ",";
  
  public Login(){
  
    create = new JButton("Create Account");
    newUserPanel = new JPanel();
    userField = new JTextField(20);
    passField = new JTextField(20);
    
    /** sets starintg location
     this can be changed in R2 just placeholder location for now
    **/
    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null);
    
    userField.setBounds(70,30,150,20);
    passField.setBounds(70,65,150,20);
    create.setBounds(110,100,80,20);

    newUserPanel.add(create);
    newUserPanel.add(userField);
    newUserPanel.add(passField);
    
    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    //check to see if file exists or not
    Writer writer = null;
    File f = new File("userList.txt");
    if(f.exists()){
    }else{
      try{
        File texting = new File("userList.txt");
        writer = new BufferedWriter(new FileWriter(texting));
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    
    
    try{
        File file = new File("userList.txt");
        br = new BufferedReader(new FileReader(file));
        FileWriter userList = new FileWriter(file);
        
        String cName = " ";
        String cPass = " ";
        String uNameTextField = userField.getText();
        String upassTextField = passField.getText();
        
        while((line = br.readLine()) != null){
            String[] users = line.split(splitOn);
            cName = users[1];
            cPass = users[2];
        }
        
            if(uNameTextField.equals(cName)){
                JOptionPane.showMessageDialog(null,"Usernames in use");
                userField.setText("");
                passField.setText("");
            }
            else if (uNameTextField.equals("") || upassTextField.equals("")){
                JOptionPane.showMessageDialog(null,"Please fill out both fields");
            }
            else{
                /** write to text file **/
                userList.write(uNameTextField + "," + upassTextField);
                userList.close();
                JOptionPane.showMessageDialog(null,"Account created.");
                dispose();
            }
    }
    catch(IOException d){
        d.printStackTrace();
    }
    }
  }

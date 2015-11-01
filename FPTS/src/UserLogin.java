import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class UserLogin extends JFrame {

	JButton loginB;
	JPanel loginPanel;
	JTextField userName;
	JTextField userPass;
	
	JButton newUser;
	JLabel userLabel;
	JLabel passLabel;
        BufferedReader br = null;
        String line = "";
        String splitOn = ",";
	
	public UserLogin(){
		
		
            loginB = new JButton("Login");
            loginPanel = new JPanel();
            userName = new JTextField(15);
	    userPass = new JPasswordField(15);
	    newUser = new JButton("Setup New User");
	    userLabel = new JLabel("Username");
	    passLabel = new JLabel("Password");
	    
	    setSize(300,200);
	    setLocation(500,300);
	    loginPanel.setLayout(null);
	    
	    loginPanel.add(loginB);
	    loginPanel.add(userName);
	    loginPanel.add(userPass);
	    loginPanel.add(newUser);
	    loginPanel.add(userLabel);
	    loginPanel.add(passLabel);
	    
	    getContentPane().add(loginPanel);
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
	    
	    loginB.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
                    try {
                        File file = new File("userList.txt");
                        br = new BufferedReader(new FileReader(file));
                        Scanner scan = new Scanner(file);;
                        String line = null;
                        FileWriter filewrite = new FileWriter(file, true);

                        String usertxt = " ";
                        String passtxt = " ";
                        String userN = userName.getText();
                        String userP = userPass.getText();


                       while((line = br.readLine()) != null){
                            String[] users = line.split(splitOn);
                            usertxt = users[1];
                            passtxt = users[2];
                        }
        
                        if(userN.equals(usertxt) && userP.equals(userP)){
                            //set to main menu GUI
                            dispose();
                        }
                        else if (userN.equals("") || userP.equals("")){
                            JOptionPane.showMessageDialog(null,"Please fill out both fields");
                        }
                        else{
                            /** write to text file **/
                            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
                            userName.setText("");
                            userPass.setText("");
                            userName.requestFocus();
                        }
                }
                catch (IOException d){
                    d.printStackTrace();
                }
            }
        });
                        
    newUser.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        Login user = new Login();
        dispose();

      }
    });
  } 

}                    
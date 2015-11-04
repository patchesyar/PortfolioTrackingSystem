import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class UserLogin extends JFrame {

	JButton loginB;
        JButton createNew;
	JPanel loginPanel;
	JTextField userName;
	JTextField userPass;
	JLabel userLabel;
	JLabel passLabel;
        BufferedReader br = null;
        String line = "";
        String splitOn = ",";
	
	public UserLogin(){
		
		
            loginB = new JButton("Login");
            createNew = new JButton("Create New");
            loginPanel = new JPanel();
            userName = new JTextField(15);
	    userPass = new JPasswordField(15);
	    userLabel = new JLabel("Username");
	    passLabel = new JLabel("Password");
	    
	    setSize(300,200);
	    setLocation(500,300);
	    loginPanel.setLayout(null);
            
            userName.setBounds(70,30,150,20);
            userPass.setBounds(70,65,150,20);
            loginB.setBounds(100,100,120,20);
            userLabel.setBounds(5,28,80,20);
            passLabel.setBounds(5,63,80,20);
            createNew.setBounds(100,120,120,20);
	    
	    loginPanel.add(loginB);
	    loginPanel.add(userName);
	    loginPanel.add(userPass);
	    loginPanel.add(userLabel);
	    loginPanel.add(passLabel);
            loginPanel.add(createNew);
	    
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


                        while (scan.hasNext()) {
                            usertxt = scan.nextLine();
                            passtxt = scan.nextLine();

                        } 
        
                        if(userN.equals(usertxt) && userP.equals(userP)){
                            EquityGUI u = new EquityGUI();
                            u.setVisible( true );
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
                        
    createNew.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        Login L = new Login();
        L.setVisible( true );
        dispose();

      }
    });
  } 

}                    
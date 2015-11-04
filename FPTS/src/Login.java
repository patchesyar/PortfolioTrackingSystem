import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class Login extends JFrame {
  JButton create;
  JPanel newUserPanel;
  JTextField userName;
  JTextField userPass;
  JLabel userLabel;
  JLabel passLabel;
  User tempUser;


  public Login(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    userName = new JTextField(15);
    userPass = new JPasswordField(15);
    userLabel = new JLabel("username");
    passLabel = new JLabel("password");


    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null); 

    userLabel.setBounds(5,28,80,20);
    passLabel.setBounds(5,63,80,20);
    userName.setBounds(70,30,150,20);
    userPass.setBounds(70,65,150,20);
    create.setBounds(110,100,80,20);

    newUserPanel.add(create);
    newUserPanel.add(userName);
    newUserPanel.add(userPass);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userList.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
    File file = new File("userList.txt");
    Scanner scan = new Scanner(file);;

      FileWriter filewrite = new FileWriter(file, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = userName.getText();
      String ppaswder = userPass.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
        
        tempUser = new User(usertxter,passtxter);
        
        boolean isPass = tempUser.checkPassword(passtxter);
      }

        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          userName.setText("");
          userPass.setText("");
          userName.requestFocus();

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        JOptionPane.showMessageDialog(null,"Account has been created.");
        UserLogin n = new UserLogin();
        dispose();



        }
        } catch (IOException d) {
      d.printStackTrace();
    }

      }
    });
  } 

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class TransactionView extends JFrame{

	JButton buyButton;
	JButton sellButton;
	JPanel transactionPanel;
	JPanel buttonPanel;
	JComboBox dropDown;
	
	User currentUser = UserSystem.getActiveUser();
	Portfolio currentPortfolio = this.currentUser.getPortfolios();
	
	
	public TransactionView(){
		buyButton = new JButton("Buy");
		sellButton = new JButton("Sell");
	    transactionPanel = new JPanel();
	    buttonPanel = new JPanel();
	    
	    buttonPanel.setLayout(new FlowLayout());
	    transactionPanel.setLayout(new BorderLayout());
	    
	    buttonPanel.add(buyButton);
	    buttonPanel.add(sellButton);
	    
	    transactionPanel.add(buttonPanel, BorderLayout.SOUTH);
	    
	       
	    
	    
	    
	    
	    setJFrame();
	    
	    
	    
	}
	
	private void setJFrame(){
		this.setSize(300,200);
		this.setLocation(500,300);
	    this.getContentPane().add(transactionPanel);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	
}

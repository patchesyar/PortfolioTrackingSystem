import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class SellView extends JFrame{

	JButton sellButton;
	JPanel transactionPanel;
	JPanel buttonPanel;
	JComboBox<String> dropDown;
	
//	User currentUser = UserSystem.getActiveUser();
	Portfolio currentPortfolio = getDummyPortfolio();
	
	
	public SellView(){
		sellButton = new JButton("Sell");
	    transactionPanel = new JPanel();
	    buttonPanel = new JPanel();
	    
	    buttonPanel.setLayout(new FlowLayout());
	    transactionPanel.setLayout(new BorderLayout());
	    
	    buttonPanel.add(sellButton);
	    
	    transactionPanel.add(buttonPanel, BorderLayout.SOUTH);
	    
	    ArrayList<Holding> holdingList = currentPortfolio.getHoldings();
	    
	    int equitySize = holdingList.size();
	    int counter = 0;
	    
	    String[] equities = new String[equitySize];
	     
	    
	    for (Holding h : holdingList){
	    	if(h.isEquity()){
	    		equities[counter] = h.getName();
	    		counter++;
	    	}
	    }
	    
	    dropDown = new JComboBox<String>(equities);
	    
	    transactionPanel.add(dropDown, BorderLayout.CENTER);
	    
	    
	    
	    setJFrame();
	    
	    
	    
	}
	
	private void setJFrame(){
		this.setSize(300,200);
		this.setLocation(500,300);
	    this.getContentPane().add(transactionPanel);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	private Portfolio getDummyPortfolio(){
		
		User dummyUser = new User("Adrian", "Password");
		Portfolio dummyPortfolio = new Portfolio(dummyUser);
		Equity A = new Equity("A1", 1, "A", "A", "A", "A");
		Equity B = new Equity("A2", 2, "A", "A", "A", "A");
		Equity C = new Equity("A3", 3, "A", "A", "A", "A");
		Equity D = new Equity("A4", 4, "A", "A", "A", "A");
		Equity E = new Equity("A5", 5, "A", "A", "A", "A");
		
		dummyPortfolio.addHoldings(A);
		dummyPortfolio.addHoldings(B);
		dummyPortfolio.addHoldings(C);
		dummyPortfolio.addHoldings(D);
		dummyPortfolio.addHoldings(E);
		
		return dummyPortfolio;
		
	}
	
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class SellView extends JFrame{

	JButton sellButton;
	JPanel transactionPanel;
	JPanel buttonPanel;
	JPanel centerPanel;
	JComboBox<String> dropDown;
	JTextField soldAmount; 
	Portfolio currentPortfolio;
	User currentUser = UserSystem.getActiveUser();
	ArrayList<Holding> Eqlist;
	
	
	
	public SellView(User u, UserSystem uSys, TrackingSystem tSys, EquitySystem eSys, PortfolioSystem pSys){
		
            currentUser = u;
            currentPortfolio = getDummyPortfolio();
            Eqlist = currentPortfolio.getHoldings();
		/*if (currentUser == null){
			currentPortfolio = getDummyPortfolio();
		} else {
			currentPortfolio = currentUser.getPortfolios();
		}*/
		
		sellButton = new JButton("Sell");
	    transactionPanel = new JPanel();
	    buttonPanel = new JPanel();
	    soldAmount = new JTextField();
	    centerPanel = new JPanel();
	    
	    buttonPanel.setLayout(new FlowLayout());
	    centerPanel.setLayout(new GridLayout(0,1));
	    transactionPanel.setLayout(new BorderLayout());
	    
	    sellButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
                    Equity E = new Equity("A1", 1, "A", "A", "A", "A");
                    int index = 0;
	    		int amount;
	    		
	    		if (soldAmount.getText().equals("")){
	    			amount = 0;
	    		} else {
	    			amount = Integer.parseInt(soldAmount.getText());
	    		}
	    		String ticker = dropDown.getSelectedItem().toString();
                        for(int i =0; i<Eqlist.size(); i++){
                            Holding placeHolder = Eqlist.get(i);
                            index = i;
                            if(placeHolder.getName().equals(ticker)){
                                E = (Equity)placeHolder;
                            }
                        }
                        Eqlist = currentPortfolio.sellEquity(E, amount);
                        
                        currentPortfolio.setList(Eqlist);
                        currentUser.setPortfolio(currentPortfolio);
                        
                        EquityGUI GUI = new EquityGUI(currentUser,uSys,tSys,eSys,pSys);
                        GUI.setVisible( true );
                        dispose();
	    	}
                
	    });
	    
	    
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
	    
	    centerPanel.add(dropDown);
	    centerPanel.add(soldAmount);
	    
	    transactionPanel.add(centerPanel, BorderLayout.CENTER);
	    
	    
	    setJFrame();

	    

	}
	
	private void setJFrame(){
		this.setSize(300,200);
		this.setLocation(800,500);
	    this.getContentPane().add(transactionPanel);
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


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class BuyView extends JFrame{

	JButton buyButton;
        JTable table;
        JPanel topPanel;
	JPanel transactionPanel;
	JPanel buttonPanel;
	JPanel centerPanel;
	JComboBox<String> dropDown;
	JTextField soldAmount; 
	Portfolio currentPortfolio;
	User currentUser = UserSystem.getActiveUser();
	ArrayList<Equity> Eqlist;
        private	JScrollPane scrollPane;
        DefaultTableModel model;
	
        
        //Create Labels for Buying
        JLabel EquityName;
        JLabel NumShares;
        //Create TextFields for entering data
        JTextField eName;
        JTextField ePrice; 
        JButton cancel;
	
	
	public BuyView(User u, UserSystem uSys, TrackingSystem tSys, EquitySystem eSys, PortfolioSystem pSys){
            
            
            currentUser = u;
            currentPortfolio = u.getPortfolios();
            
            setTitle( "Financial Tracking System" );
            setSize( 800, 300 );
            setLocation(400,180);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBackground( Color.gray );
                
                Eqlist = tSys.getEquities();
                buyButton = new JButton("Buy Equity");

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
                
                //Create Transaction Panel for buying Equities
                transactionPanel = new JPanel();
                transactionPanel.setLayout(new GridLayout(3,2));
                
                
                //Add Labels and Buttons to Panel
                EquityName = new JLabel("Equity Ticker Symbol");
                NumShares = new JLabel("Number of Shares");
                eName = new JTextField();
                ePrice = new JTextField();
                cancel = new JButton("Cancel");
                transactionPanel.add(EquityName);
                transactionPanel.add(NumShares);
                transactionPanel.add(eName);
                transactionPanel.add(ePrice);
                transactionPanel.add(buyButton);
                transactionPanel.add(cancel);

                
                model = new DefaultTableModel(); 
                model.addColumn("Name");
                model.addColumn("Ticker");
                model.addColumn("Price");
                

		// Create a new table instance
		table = new JTable( model );
                
                updateTable();    
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
                
                //set Background to white
                scrollPane.getViewport().setBackground(Color.WHITE);
       
                
		topPanel.add( scrollPane, BorderLayout.CENTER );
                topPanel.add( transactionPanel, BorderLayout.SOUTH );
                
                
	    buyButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
                    
                //get text within textfields
                    String buyText = eName.getText();
                    String NumberofShares = ePrice.getText();
                    
                    if(buyText.equals("") || NumberofShares.equals("")){
                        JOptionPane.showMessageDialog(null,"Please fill out both fields");
                    }
                    else{
                        try{
                            Integer.parseInt(NumberofShares);
                            int i = Integer.parseInt(NumberofShares);
                            if (checkEquity(buyText) == true){
                                currentPortfolio.buyEquity(tSys, buyText, i);
                                //Equity purchased = findEquity(buyText);
                            }
                            currentUser.setPortfolio(currentPortfolio);
                            EquityGUI GUI = new EquityGUI(currentUser,uSys,tSys,eSys,pSys);
                            GUI.setVisible( true );
                            dispose();
                            

                        }catch(NumberFormatException d) {
                            JOptionPane.showMessageDialog(null,"Please Enter Number for Shares");
                        }

                    }
	    	}
                
	    });
	    

	    int equitySize = tSys.getEquities().size();
	    int counter = 0;
            String[] names = new String[equitySize];
	    ArrayList<Equity> equities = tSys.getEquities();
	    
	    for (Equity h : equities){
               names[counter] = h.getName();
               counter++;
	    }
	    /*
	    dropDown = new JComboBox<String>(names);
	    
	    centerPanel.add(dropDown);
	    centerPanel.add(soldAmount);
	    
	    transactionPanel.add(centerPanel, BorderLayout.CENTER);
	    
	    
	    setJFrame();

	    
*/
	}
	
        
        
	private void setJFrame(){
		this.setSize(300,200);
		this.setLocation(800,500);
	    this.getContentPane().add(transactionPanel);
	    this.setVisible(true);

        }
        
        public ArrayList<String> fillData(Equity m){
            String name = "";
            ArrayList<String> s = new ArrayList<String>();
            NumberFormat formatter = new DecimalFormat("#,###.00");
            
            String n = m.getName();
            Double d = m.getValue();
            String p = d.toString();
            
            String t = m.getTicker();
            
            p = formatter.format(d);
            
            s.add(n);
            s.add(t);
            s.add(p);
            
            
            return s;
        }
        
        public void updateTable(){
        
            for(int i = 0; i < Eqlist.size(); i++){
                    Equity q = (Equity) Eqlist.get(i);
                    ArrayList<String> p = fillData(q);
                    String a = p.get(0);
                    String b = p.get(1);
                    String c = p.get(2);
                    model.addRow(new Object[]{a,b,c});
                }
            
        }
        
        public boolean checkEquity(String s){
            boolean check = false;
            for(Equity e : Eqlist){
                if(e.getTicker().equals(s)){
                    check = true;
                }
            }
            return check;
        }
        
        public Equity findEquity(String s){
            Equity e = null;
            for(Equity f : Eqlist){
                if(f.getTicker().equals(s)){
                    e = f;
                }
            }
            return e;
        }
        
        private Portfolio getDummyPortfolio(){
		
		User dummyUser = new User("Adrian", "Password");
		Portfolio dummyPortfolio = new Portfolio(dummyUser);
                BankAccount C1 = new BankAccount("C1",100000000,"1111-MM-DD");
                BankAccount C2 = new BankAccount("C2",100000000,"1112-MM-DD");
                BankAccount C3 = new BankAccount("C3",100000000,"1113-MM-DD");
                BankAccount C4 = new BankAccount("C4",100000000,"1114-MM-DD");
                
                
                dummyPortfolio.addHoldings(C1);
                dummyPortfolio.addHoldings(C2);
                dummyPortfolio.addHoldings(C3);
                dummyPortfolio.addHoldings(C4);
		
		return dummyPortfolio;
		
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
public class EquityGUI extends JFrame {
        
	private	JPanel		topPanel;
        private	JPanel		buttonPanel;
        private	JPanel		accountPanel;
	private	JTable		Etable;
	private	JScrollPane scrollPane;
        private	JTable		Atable;
	private	JScrollPane AscrollPane;
        DefaultTableModel model;
        DefaultTableModel Amodel;
        
        
        private User user;
        JButton buy;
        JButton sell;
        JButton simulate;
        JButton watchList;
        ArrayList<Holding> Eqlist;
        ArrayList<Holding> AClist;
        Portfolio currentPortfolio;
        
	public EquityGUI (User u, UserSystem uSys, TrackingSystem tSys, EquitySystem eSys, PortfolioSystem pSys)
	{
                user = u;
                currentPortfolio = getDummyPortfolio();
                
                Eqlist = getEquities(currentPortfolio);
                AClist = getAccounts(currentPortfolio);
                
                
		setTitle( "Financial Tracking System" );
		setSize( 1500, 800 );
                setLocation(200,180);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground( Color.gray );
                buy = new JButton("Buy Equity");
                sell = new JButton("Sell Equity");
                simulate = new JButton("Simulate");
                watchList = new JButton("My Watchlist");

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

                
                // create panel to hold buttons
                buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout());
                buttonPanel.add(buy);
                buttonPanel.add(sell);
                buttonPanel.add(simulate);
                buttonPanel.add(watchList);
                
                updateTable();
                
		// Create columns names
		//String columnNames[] = { "Type", "Ticker Symbol", "Number of Shares" };

		// Create some data
		String dataValues[][] =
		{
                   
		};
                
                String AccountColumn[] = { "Name", "Value" };

		// Create some data
		String AccountDataValues[][] =
		{
		};

		// Create a new table instance
		Etable = new JTable( model );
                Atable = new JTable( Amodel );
                
                accountPanel = new JPanel();
                accountPanel.setLayout(new BorderLayout());

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( Etable );
                AscrollPane = new JScrollPane( Atable );
                
                //set Background to white
                scrollPane.getViewport().setBackground(Color.WHITE);
                AscrollPane.getViewport().setBackground(Color.WHITE);
                
                accountPanel.add(AscrollPane, BorderLayout.CENTER);
		topPanel.add( scrollPane, BorderLayout.CENTER );
                topPanel.add( accountPanel, BorderLayout.SOUTH );
                topPanel.add( buttonPanel, BorderLayout.NORTH );
                
                
                
                
               //open sell pane
                sell.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        SellView s = new SellView(user);
                        s.setVisible( true );

                        }
                    });
                
                //open buy pane
                buy.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        /*ArrayList<Equity> EList = tSys.getEquities();
                        
                        for(Equity E: EList){
                            System.out.println(E.getName());
                        }*/

                        }
                    });
    
    }
        
        
        
        
    public ArrayList getEquities(Portfolio m){
       ArrayList<Equity> Elist = new ArrayList<Equity>();
       Portfolio p = m;
       ArrayList<Holding> hList = p.getHoldings();
       for(int i = 0; i<hList.size(); i++){
           Holding H = hList.get(i);
           if(H.isEquity() == true){
               Equity B = (Equity)H;
               Elist.add(B);
           }           
       }
       
       return Elist;
    }
    
    public ArrayList getAccounts(Portfolio m){
       ArrayList<Holding> Alist = new ArrayList<Holding>();
       Portfolio p = m;
       ArrayList<Holding> hList = p.getHoldings();
       
       for(Holding H : hList){
           if(H.isEquity() == false){
               Alist.add(H);
           }           
       }
       
       return Alist;
    }
    
    
    public ArrayList<String> fillData(Holding m){
        String name = "";
        ArrayList<String> s = new ArrayList<String>();
        NumberFormat formatter = new DecimalFormat("#,###.00");
        
        if(m.getType() == 'E'){
            Equity H = (Equity)m;
            
            
            Double d = H.getTotalValue();
            String v = d.toString();
            v = formatter.format(d);
        
            String n = H.getName();
            
            int shares = H.getShares();
            String num = Integer.toString(shares);

            char t = H.getType();
            String type = Character.toString(t);
            s.add(n);
            s.add(type);
            s.add(num);
            s.add(v);
            
        }
        else{
            
            //value to a string
            Double d = m.getValue();
            String v = d.toString();
            v = formatter.format(d);
            
            //name
            String n = m.getName();
            
            //type to a string
             char t = m.getType();
            String type = Character.toString(t);
            
            // add them to array
            s.add(n);
            s.add(v);
            System.out.println(t);
            s.add(type);
            
        }
        
        
        return s;
        
    }
    
    
    private Portfolio getDummyPortfolio(){
		
		User dummyUser = new User("Adrian", "Password");
		Portfolio dummyPortfolio = new Portfolio(dummyUser);
		Equity A = new Equity("A1", 1, "A", "A", "A", "A");
		Equity B = new Equity("A2", 2, "A", "A", "A", "A");
		Equity C = new Equity("A3", 3, "A", "A", "A", "A");
		Equity D = new Equity("A4", 4, "A", "A", "A", "A");
		Equity E = new Equity("A5", 5, "A", "A", "A", "A");
                CashAccount C1 = new CashAccount("C1",100000000,"1111-MM-DD");
                CashAccount C2 = new CashAccount("C2",100000000,"1112-MM-DD");
                CashAccount C3 = new CashAccount("C3",100000000,"1113-MM-DD");
                CashAccount C4 = new CashAccount("C4",100000000,"1114-MM-DD");
                
                
                
                A.addShares(100);
                A.addToValue(10);
		
		dummyPortfolio.addHoldings(A);
		dummyPortfolio.addHoldings(B);
		dummyPortfolio.addHoldings(C);
		dummyPortfolio.addHoldings(D);
		dummyPortfolio.addHoldings(E);
                dummyPortfolio.addHoldings(C1);
                dummyPortfolio.addHoldings(C2);
                dummyPortfolio.addHoldings(C3);
                dummyPortfolio.addHoldings(C4);
		
		return dummyPortfolio;
		
	}
    
    public void updateTable(){
        
        model = new DefaultTableModel(); 
        model.addColumn("Ticker Symbol");
        model.addColumn("Type");
        model.addColumn("Number of Shares");
        model.addColumn("Value");
        
        for(int i = 0; i < Eqlist.size(); i++){
                    Equity q = (Equity) Eqlist.get(i);
                    ArrayList<String> p = fillData(q);
                    String a = p.get(0);
                    String b = p.get(1);
                    String c = p.get(2);
                    String d = p.get(3);
                    model.addRow(new Object[]{a,b,c,d});
                }
        
        Amodel = new DefaultTableModel();
        Amodel.addColumn("Name");
        Amodel.addColumn("Value");
        //Amodel.addColumn("Type");
        
        for(int i = 0; i < AClist.size(); i++){
                    Holding z = AClist.get(i);
                    ArrayList<String> f = fillData(z);
                    String a = f.get(0);
                    String b = f.get(1);
                    //String c = f.get(2);
                    Amodel.addRow(new Object[]{a,b});
                }
    }
     
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
	private	JTable		table;
	private	JScrollPane scrollPane;
        private User user;
        JButton buy;
        JButton sell;
        JButton simulate;

	public EquityGUI (User u)
	{
            
                user = u;
		setTitle( "Financial Tracking System" );
		setSize( 1000, 500 );
                setLocation(500,280);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground( Color.gray );
                buy = new JButton("Buy Equity");
                sell = new JButton("Sell Equity");
                simulate = new JButton("Simulate");

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
                
                
		// Create columns names
		String columnNames[] = { "Type", "Ticker Symbol", "Number of Shares" };

		// Create some data
		String dataValues[][] =
		{
		};

		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );
                topPanel.add( buttonPanel, BorderLayout.NORTH );
                
                
                
                
               //open sell pane
                sell.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        SellView s = new SellView();
                        s.setVisible( true );

                        }
                    });
    
    }
}

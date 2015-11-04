import java.awt.BorderLayout;
import java.awt.Color;
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
    // Instance attributes used in this example
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;

	// Constructor of main frame
	public EquityGUI ()
	{
		// Set the frame characteristics
		setTitle( "Financial Tracking System" );
		setSize( 1000, 500 );
                setLocation(500,280);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

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
                
                
	}
    
}

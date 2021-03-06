package popt.gui_ticket;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class MainView {
	JFrame guiFrame;
	CardLayout cards;
	JPanel cardPanel;
	JPanel mainCard;
	MissingConnectionPanel mcp;
	MainPanel mainPanel;
	
	JButton ticketSellButt;
	
	// View per il modulo TicketSell
	TicketSellView tsv;

	public MainView() {
		guiFrame = new JFrame();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(guiFrame);
		guiFrame.setUndecorated(true);
		guiFrame.pack();

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		guiFrame.setTitle("PopTomatoes");
		
		guiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		guiFrame.setResizable(false);

		// This will center the JFrame in the middle of the screen
		// guiFrame.setLocationRelativeTo(null);
		guiFrame.getContentPane().setLayout(new BorderLayout());

		JPanel tabsPanel = new JPanel();
		tabsPanel.setPreferredSize(new Dimension(guiFrame.getWidth(), 100));
		tabsPanel.setBackground(new Color(100, 100, 100));

		
		ticketSellButt = new JButton("Sell");
		ticketSellButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		ticketSellButt.setBackground(new Color(159, 182, 205));
		ticketSellButt.setFocusable(false);
		//ticketSellButt.setBorderPainted(false);
		ticketSellButt.setActionCommand("Switch Card");
		ticketSellButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(cardPanel, "TS");
			}
		});
		
		JButton exitButt = new JButton("X");
		exitButt.setFont(new Font("Calibri", Font.BOLD, 39));
		exitButt.setBackground(Color.RED);
		exitButt.setFocusable(false);
		//exitButt.setBorderPainted(false);
		exitButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				guiFrame.setVisible(false);
				guiFrame.dispose();
			}
		});

		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		cards.show(cardPanel, "Main");

		mainCard = new JPanel();
		mainCard.setBackground(Color.BLACK);
		
		mcp = new MissingConnectionPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) mcp.getLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.columnWidths = new int[]{0, 700, 0};
		
		mainPanel = new MainPanel();
		GridBagLayout gridBagLayout2 = (GridBagLayout) mainPanel.getLayout();
		gridBagLayout2.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout2.columnWidths = new int[]{0, 700, 0};
		
		tsv = new TicketSellView();
		tsv.setBackground(new Color(100,100,100));

		cardPanel.add(mainCard, "Main");
		cardPanel.add(tsv,"TS");

		guiFrame.getContentPane().add(tabsPanel, BorderLayout.NORTH);
		GroupLayout gl_tabsPanel = new GroupLayout(tabsPanel);
		gl_tabsPanel.setHorizontalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tabsPanel.createSequentialGroup()
					.addContainerGap(834, Short.MAX_VALUE)
					.addComponent(ticketSellButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_tabsPanel.setVerticalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabsPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ticketSellButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabsPanel.setLayout(gl_tabsPanel);
		guiFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		guiFrame.setVisible(true);
	}
	
	public TicketSellView getTicketSellView() {
		return tsv;
	}
	
public void setInterface(boolean ok) {
		
		GroupLayout gl_mainCard = new GroupLayout(mainCard);
		
		if(ok) {			
			gl_mainCard.setHorizontalGroup(
					gl_mainCard.createParallelGroup(Alignment.CENTER)
						.addGroup(Alignment.CENTER, gl_mainCard.createSequentialGroup()
							.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
							)
				);
				gl_mainCard.setVerticalGroup(
					gl_mainCard.createParallelGroup(Alignment.CENTER)
						.addGroup(Alignment.CENTER, gl_mainCard.createSequentialGroup()
							.addGap(100)
							.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							)
				);
				guiFrame.revalidate();
				guiFrame.repaint();
		} else {
			
			ticketSellButt.setEnabled(false);
			
			gl_mainCard.setHorizontalGroup(
					gl_mainCard.createParallelGroup(Alignment.CENTER)
						.addGroup(Alignment.CENTER, gl_mainCard.createSequentialGroup()
							.addComponent(mcp, GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
							)
				);
				gl_mainCard.setVerticalGroup(
					gl_mainCard.createParallelGroup(Alignment.CENTER)
						.addGroup(Alignment.CENTER, gl_mainCard.createSequentialGroup()
							.addGap(100)
							.addComponent(mcp, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							)
				);
				guiFrame.revalidate();
				guiFrame.repaint();
		}
		mainCard.setLayout(gl_mainCard);
			
	}

}

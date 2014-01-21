package popt.gui_ticket;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainView {
	static JFrame guiFrame;
	CardLayout cards;
	JPanel cardPanel;
	
	// View per il modulo TicketSell
	TicketSellView tsv;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new MainView();
			}
		});

	}

	public MainView() {
		guiFrame = new JFrame();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		guiFrame.setUndecorated(true);
		SwingUtilities.updateComponentTreeUI(guiFrame);
		
		guiFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				guiFrame.setState(JFrame.NORMAL);
                System.out.println("Cant Minimize");				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		guiFrame.pack();

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("PopTomatoes");
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			gd.setFullScreenWindow(guiFrame);
			guiFrame.requestFocusInWindow();
		}

		// This will center the JFrame in the middle of the screen
		// guiFrame.setLocationRelativeTo(null);
		guiFrame.getContentPane().setLayout(new BorderLayout());

		JPanel tabsPanel = new JPanel();
		tabsPanel.setPreferredSize(new Dimension(guiFrame.getWidth(), 100));
		tabsPanel.setBackground(new Color(100, 100, 100));

		
		JButton ticketSellButt = new JButton("Sell");
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
		
		JButton exitButt = new JButton("Exit");
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

		JPanel mainCard = new JPanel();
		mainCard.setBackground(Color.BLACK);
		
		tsv = new TicketSellView();
		tsv.setBackground(new Color(100,100,100));

		cardPanel.add(mainCard, "Main");
		cardPanel.add(tsv,"TS");

		guiFrame.getContentPane().add(tabsPanel, BorderLayout.NORTH);
		GroupLayout gl_tabsPanel = new GroupLayout(tabsPanel);
		gl_tabsPanel.setHorizontalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_tabsPanel.createSequentialGroup()
					.addContainerGap(155, Short.MAX_VALUE)
					.addComponent(ticketSellButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_tabsPanel.setVerticalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabsPanel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(ticketSellButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabsPanel.setLayout(gl_tabsPanel);
		guiFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		guiFrame.setVisible(true);
	}
	
	public static JFrame getGuiFrame() {
		return guiFrame;
	}
	
	public TicketSellView getTicketSellView() {
		return tsv;
	}

}

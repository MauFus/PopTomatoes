package popt.gui_sch;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.GridBagLayout;

public class MainView {
	static JFrame guiFrame;
	CardLayout cards;
	JPanel cardPanel;
	JPanel mainCard;
	MissingConnectionPanel mcp;
	MainPanel mainPanel;
	
	JButton schedulingButt;
	JButton movieListButt;
	JButton insertMovieButt;
	
	// View per il modulo InsertMovie
	InsertMovieView imv;
	MovieListView mlv;
	SchedulerView schv;

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
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("PopTomatoes");
		
		guiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		guiFrame.setResizable(false);

		// This will center the JFrame in the middle of the screen
		// guiFrame.setLocationRelativeTo(null);
		guiFrame.getContentPane().setLayout(new BorderLayout());

		JPanel tabsPanel = new JPanel();
		tabsPanel.setPreferredSize(new Dimension(guiFrame.getWidth(), 100));
		tabsPanel.setBackground(new Color(100, 100, 100));

		
		insertMovieButt = new JButton("Insert Movie");
		insertMovieButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		insertMovieButt.setBackground(Color.ORANGE);
		insertMovieButt.setFocusable(false);
		insertMovieButt.setBorderPainted(false);
		insertMovieButt.setActionCommand("Switch Card");
		
		movieListButt = new JButton("Movie List");
		movieListButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		movieListButt.setBackground(Color.BLUE);
		movieListButt.setFocusable(false);
		movieListButt.setBorderPainted(false);
		movieListButt.setActionCommand("Switch Card");
		
		schedulingButt = new JButton("Scheduling");
		schedulingButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		schedulingButt.setBackground(Color.GREEN);
		schedulingButt.setFocusable(false);
		schedulingButt.setBorderPainted(false);
		schedulingButt.setActionCommand("Switch Card");		

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
		
		imv = new InsertMovieView();
		imv.setBackground(new Color(100,100,100));
		
		mlv = new MovieListView();
		mlv.setBackground(new Color(100,100,100));
		
		schv = new SchedulerView();
		schv.setBackground(new Color(100,100,100));

		cardPanel.add(mainCard, "Main");
		cardPanel.add(imv,"IM");
		cardPanel.add(mlv,"ML");
		cardPanel.add(schv,"SCH");

		guiFrame.getContentPane().add(tabsPanel, BorderLayout.NORTH);
		
		JButton exitButt = new JButton("X");
		exitButt.setFont(new Font("Calibri", Font.BOLD, 39));
		exitButt.setFocusable(false);
		exitButt.setBorderPainted(false);
		exitButt.setBackground(Color.RED);
		exitButt.setActionCommand("Switch Card");
		exitButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiFrame.setVisible(false);
				guiFrame.dispose();
				
			}
		});
		
		GroupLayout gl_tabsPanel = new GroupLayout(tabsPanel);
		gl_tabsPanel.setHorizontalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tabsPanel.createSequentialGroup()
					.addContainerGap(490, Short.MAX_VALUE)
					.addComponent(insertMovieButt)
					.addGap(18)
					.addComponent(movieListButt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(schedulingButt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_tabsPanel.setVerticalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_tabsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(exitButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tabsPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(schedulingButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addComponent(movieListButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addComponent(insertMovieButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabsPanel.setLayout(gl_tabsPanel);
		guiFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		guiFrame.setVisible(true);
	}
	
	/**
	 * Getter per l'InsertMovieView
	 * @return il riferimento alla view
	 */
	public InsertMovieView getInsertMovieView() {
		return imv;
	}
	
	/**
	 * Getter per il MovieListView
	 * @return il riferimento alla view
	 */
	public MovieListView getMovieListView() {
		return mlv;
	}
	
	/**
	 * Getter per lo SchedulerView
	 * @return il riferimento alla view
	 */
	public SchedulerView getSchedulingView() {
		return schv;
	}
	
	public static JFrame getGuiFrame() {
		return guiFrame;
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
			
			insertMovieButt.setEnabled(false);
			movieListButt.setEnabled(false);
			schedulingButt.setEnabled(false);
			
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

	/**
	 * @return the schedulingButt
	 */
	public JButton getSchedulingButt() {
		return schedulingButt;
	}

	/**
	 * @return the movieListButt
	 */
	public JButton getMovieListButt() {
		return movieListButt;
	}

	/**
	 * @return the insertMovieButt
	 */
	public JButton getInsertMovieButt() {
		return insertMovieButt;
	}

	/**
	 * @return the cards
	 */
	public CardLayout getCards() {
		return cards;
	}

	/**
	 * @return the cardPanel
	 */
	public JPanel getCardPanel() {
		return cardPanel;
	}
}

package popt.gui_sch;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainView {
	JFrame guiFrame;
	CardLayout cards;
	JPanel cardPanel;
	
	// View per il modulo InsertMovie
	InsertMovieView imv;
	MovieListView mlv;

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

		
		JButton insertMovieButt = new JButton("Insert Movie");
		insertMovieButt.setBackground(Color.ORANGE);
		insertMovieButt.setFocusable(false);
		insertMovieButt.setBorderPainted(false);
		insertMovieButt.setActionCommand("Switch Card");
		insertMovieButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(cardPanel, "IM");
			}
		});
		
		JButton movieListButt = new JButton("Movie List");
		movieListButt.setBackground(Color.BLUE);
		movieListButt.setFocusable(false);
		movieListButt.setBorderPainted(false);
		movieListButt.setActionCommand("Switch Card");
		movieListButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(cardPanel, "ML");
			}
		});
		
		JButton schedulingButt = new JButton("Scheduling");
		schedulingButt.setBackground(new Color(0,200,0));
		schedulingButt.setFocusable(false);
		schedulingButt.setBorderPainted(false);
		schedulingButt.setActionCommand("Switch Card");
		// TODO spostare in un controller
		schedulingButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(cardPanel, "Fruits");
			}
		});
		

		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		cards.show(cardPanel, "Main");

		JPanel mainCard = new JPanel();
		mainCard.setBackground(Color.BLACK);
		
		imv = new InsertMovieView();
		imv.setBackground(Color.ORANGE);
		
		mlv = new MovieListView();
		mlv.setBackground(new Color(100,100,100));

		JPanel firstCard = new JPanel();
		firstCard.setBackground(Color.GREEN);
		addButton(firstCard, "APPLES");
		addButton(firstCard, "ORANGES");
		addButton(firstCard, "BANANAS");

		JPanel secondCard = new JPanel();
		secondCard.setBackground(Color.BLUE);
		addButton(secondCard, "LEEKS");
		addButton(secondCard, "TOMATOES");
		addButton(secondCard, "PEAS");

		cardPanel.add(mainCard, "Main");
		cardPanel.add(imv,"IM");
		cardPanel.add(mlv,"ML");
		cardPanel.add(firstCard, "Fruits");
		cardPanel.add(secondCard, "Veggies");

		guiFrame.getContentPane().add(tabsPanel, BorderLayout.NORTH);
		GroupLayout gl_tabsPanel = new GroupLayout(tabsPanel);
		gl_tabsPanel.setHorizontalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_tabsPanel.createSequentialGroup()
					.addContainerGap(155, Short.MAX_VALUE)
					.addComponent(insertMovieButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(movieListButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(schedulingButt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_tabsPanel.setVerticalGroup(
			gl_tabsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabsPanel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(schedulingButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieListButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(insertMovieButt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
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

	// All the buttons are following the same pattern
	// so create them all in one place.
	private void addButton(JPanel parent, String name) {
		JButton but = new JButton(name);
		but.setActionCommand(name);
		parent.add(but);
	}
}

package popt.gui_sch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class MovieListView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4042558951286756671L;

	private JPanel MovieListContainer;
	private JButton btnInsert;

	/**
	 * Create the panel.
	 */
	public MovieListView() {
		
		JTextPane txtpnMovieList = new JTextPane();
		txtpnMovieList.setText("Movie List Definition");
		txtpnMovieList.setMargin(new Insets(5, 50, 0, 0));
		txtpnMovieList.setForeground(Color.WHITE);
		txtpnMovieList.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnMovieList.setFocusable(false);
		txtpnMovieList.setEditable(false);
		txtpnMovieList.setBackground(Color.GRAY);
		
		//panel che contiene il pulsante per aprire il dialog per la ricerca dei film
		JPanel MovieInsertControl = new JPanel();
		MovieInsertControl.setBackground(new Color(100,100,100));
		MovieListContainer = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(txtpnMovieList, GroupLayout.DEFAULT_SIZE, 1635, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(MovieListContainer, Alignment.CENTER, 0, 0, Short.MAX_VALUE)
						.addComponent(MovieInsertControl, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnMovieList, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MovieInsertControl, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MovieListContainer, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnInsert = new JButton("Insert in List!");
		btnInsert.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setBackground(Color.GRAY);
		btnInsert.setBorderPainted(false);
		btnInsert.setFocusable(false);
		
		MovieInsertControl.add(btnInsert);
		setLayout(groupLayout);
		
		
		
		/*JTextPane txtpnInsertMovie = new JTextPane();
		txtpnInsertMovie.setEditable(false);
		txtpnInsertMovie.setForeground(new Color(255, 255, 255));
		txtpnInsertMovie.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnInsertMovie.setBackground(new Color(128, 128, 128));
		txtpnInsertMovie.setText("Movie List Definition");
		Insets m = new Insets(5, 50, 0, 0);
		txtpnInsertMovie.setMargin(m);
		txtpnInsertMovie.setFocusable(false);*/

	}
	
	public JButton getBtnInsert() {
		return btnInsert;
	}

	public JPanel getMovieListContainer() {
		return MovieListContainer;
	}
}

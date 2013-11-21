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
		//prova per vedere come viene gestito l'inserimento di un panel Movie nella Lista!
		JPanel MovieListContainer = new JPanel();
		MoviePanel mp = new MoviePanel();
		MoviePanel mp1 = new MoviePanel();
		MovieListContainer.add(mp1);
		MovieListContainer.add(mp);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnMovieList, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(MovieInsertControl, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(MovieListContainer, GroupLayout.PREFERRED_SIZE, 824, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnMovieList, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MovieInsertControl, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MovieListContainer, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("New button");
		MovieInsertControl.add(btnNewButton);
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
}

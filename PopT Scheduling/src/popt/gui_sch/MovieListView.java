package popt.gui_sch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnMovieList, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnMovieList, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
		);
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

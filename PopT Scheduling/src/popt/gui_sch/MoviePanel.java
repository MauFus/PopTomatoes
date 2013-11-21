package popt.gui_sch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoviePanel extends JPanel {

	
	private static final long serialVersionUID = -6066106547042205090L;
	
	private JTextPane txtpnMovieTitle;
	private JTextField txtpnGenre;
	private JButton btnCloseMovie;
	private JTextField txtpnPg;
	private JTextPane txtpnId;
	private JTextPane txtpnReleaseDate;

	public MoviePanel() {
		setBackground(Color.GRAY);
		setSize(800, 100);
		
		txtpnMovieTitle = new JTextPane();
		txtpnMovieTitle.setEditable(false);
		txtpnMovieTitle.setForeground(Color.WHITE);
		txtpnMovieTitle.setFont(new Font("Calibri", Font.BOLD, 28));
		txtpnMovieTitle.setBackground(Color.GRAY);
		txtpnMovieTitle.setText("Movie Title");
		Insets m = new Insets(5, 10, 0, 0);
		txtpnMovieTitle.setMargin(m);
		
		txtpnGenre = new JTextField();
		txtpnGenre.setEditable(false);
		txtpnGenre.setText("Genre: Psycho Thriller Comedy");
		txtpnGenre.setMargin(new Insets(5, 10, 0, 0));
		txtpnGenre.setForeground(Color.WHITE);
		txtpnGenre.setFont(new Font("Calibri", Font.BOLD, 15));
		txtpnGenre.setBorder(null);
		txtpnGenre.setHorizontalAlignment(JTextField.RIGHT);
		txtpnGenre.setBackground(Color.GRAY);
		
		btnCloseMovie = new JButton("X");
		btnCloseMovie.setFont(new Font("Calibri", Font.BOLD, 36));
		btnCloseMovie.setForeground(Color.WHITE);
		btnCloseMovie.setBackground(Color.RED);
		btnCloseMovie.setBorderPainted(false);
		btnCloseMovie.setFocusable(false);
		btnCloseMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtpnPg = new JTextField();
		txtpnPg.setEditable(false);
		txtpnPg.setText("PG-18");
		txtpnPg.setMargin(new Insets(5, 10, 0, 0));
		txtpnPg.setForeground(Color.WHITE);
		txtpnPg.setFont(new Font("Calibri", Font.BOLD, 15));
		txtpnPg.setBorder(null);
		txtpnPg.setHorizontalAlignment(JTextField.RIGHT);
		txtpnPg.setBackground(Color.GRAY);
		
		txtpnId = new JTextPane();
		txtpnId.setEditable(false);
		txtpnId.setForeground(Color.WHITE);
		txtpnId.setFont(new Font("Calibri", Font.BOLD, 15));
		txtpnId.setMargin(new Insets(5, 10, 0, 0));
		txtpnId.setText("ID: 000001");
		txtpnId.setBackground(Color.GRAY);
		
		txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setText("Release Date: 21/12/2012");
		txtpnReleaseDate.setMargin(new Insets(5, 10, 0, 0));
		txtpnReleaseDate.setForeground(Color.WHITE);
		txtpnReleaseDate.setFont(new Font("Calibri", Font.BOLD, 15));
		txtpnReleaseDate.setEditable(false);
		txtpnReleaseDate.setBackground(Color.GRAY);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnMovieTitle, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCloseMovie)
					.addGap(12))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtpnMovieTitle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
									.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(9))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCloseMovie)
							.addGap(20))))
		);
		setLayout(groupLayout);

	}
	
	public void setTxtpnMovieTitle(JTextPane txtpnMovieTitle) {
		this.txtpnMovieTitle = txtpnMovieTitle;
	}

	public void setTxtpnGenre(JTextField txtpnGenre) {
		this.txtpnGenre = txtpnGenre;
	}

	public void setBtnCloseMovie(JButton btnCloseMovie) {
		this.btnCloseMovie = btnCloseMovie;
	}

	public void setTxtpnPg(JTextField txtpnPg) {
		this.txtpnPg = txtpnPg;
	}

	public void setTxtpnId(JTextPane txtpnId) {
		this.txtpnId = txtpnId;
	}

	public void setTxtpnReleaseDate(JTextPane txtpnReleaseDate) {
		this.txtpnReleaseDate = txtpnReleaseDate;
	}

}



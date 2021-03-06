package popt.gui_sch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import popt.data.Genre;

public class SearchMovieDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6781443339082226427L;
	private final JPanel contentPanel = new JPanel();
	private JPanel pnQueryResults;
	private ButtonGroup radioGroup;
	private JTextField textID;
	private JTextField textTitle;
	private JTextField textYear;
	private JTextField textDuration;
	private JComboBox<Genre> comboGenre;
	private JCheckBox checkBoxPG;
	private JButton insertButton;
	private JButton cancelButton;
	private JButton searchButton;

	/**
	 * Create the dialog.
	 */
	
	public SearchMovieDialog () {
		setTitle("Movie Search");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(100,100,100));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane txtMovieSearch = new JTextPane();
		txtMovieSearch.setText("Search your Movie");
		txtMovieSearch.setMargin(new Insets(9, 20, 0, 0));
		txtMovieSearch.setFont(new Font("Calibri", Font.BOLD, 33));
		txtMovieSearch.setBackground(Color.GRAY);
		txtMovieSearch.setForeground(Color.WHITE);
		txtMovieSearch.setFocusable(false);
		txtMovieSearch.setEditable(false);

		JPanel pnSearchMovie = new JPanel();
		pnSearchMovie.setBackground(new Color(0,34,102));
		
		JTextPane txtMovieSearchResult = new JTextPane();
		txtMovieSearchResult.setText("Query Results:");
		txtMovieSearchResult.setMargin(new Insets(3, 20, 0, 0));
		txtMovieSearchResult.setFont(new Font("Calibri", Font.BOLD, 21));
		txtMovieSearchResult.setBackground(Color.GRAY);
		txtMovieSearchResult.setForeground(Color.WHITE);
		txtMovieSearchResult.setFocusable(false);
		txtMovieSearchResult.setEditable(false);

		pnQueryResults = new JPanel();
		pnQueryResults.setBackground(new Color(0,34,102));
		pnQueryResults.setBorder(null);
		JScrollPane scrb = new JScrollPane(pnQueryResults);
		scrb.setBorder(null);
		scrb.setBackground(new Color(0,34,102));
		radioGroup = new ButtonGroup();		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(txtMovieSearch, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnSearchMovie, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addComponent(txtMovieSearchResult, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrb, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtMovieSearch, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnSearchMovie, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMovieSearchResult, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrb, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setEditable(false);
		txtpnId.setBackground(new Color(0,34,102));
		txtpnId.setForeground(Color.WHITE);
		txtpnId.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnId.setText("ID:");

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBorder(null);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(new Color(0,34,102));
		txtpnTitle.setForeground(Color.WHITE);
		txtpnTitle.setText("Title:");
		txtpnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));

		textTitle = new JTextField();
		textTitle.setColumns(10);
		textTitle.setBorder(null);
		
		JTextPane txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setEditable(false);
		txtpnReleaseDate.setBackground(new Color(0,34,102));
		txtpnReleaseDate.setForeground(Color.WHITE);
		txtpnReleaseDate.setText("Year:");
		txtpnReleaseDate.setFont(new Font("Calibri", Font.PLAIN, 15));

		textYear = new JTextField();
		textYear.setColumns(10);
		textYear.setBorder(null);
		
		JTextPane txtpnPg = new JTextPane();
		txtpnPg.setEditable(false);
		txtpnPg.setBackground(new Color(0,34,102));
		txtpnPg.setForeground(Color.WHITE);
		txtpnPg.setText("PG:");
		txtpnPg.setFont(new Font("Calibri", Font.PLAIN, 15));

		checkBoxPG = new JCheckBox("");
		checkBoxPG.setBackground(new Color(0,34,102));
		checkBoxPG.setBorder(null);
		
		JTextPane txtpnGenre = new JTextPane();
		txtpnGenre.setEditable(false);
		txtpnGenre.setBackground(new Color(0,34,102));
		txtpnGenre.setForeground(Color.WHITE);
		txtpnGenre.setText("Genre:");
		txtpnGenre.setFont(new Font("Calibri", Font.PLAIN, 15));

		comboGenre = new JComboBox<Genre>();
		Genre[] genreSet = {(Genre) null, Genre.ACTION, Genre.ADVENTURE, Genre.ANIMATION, Genre.BIOGRAPHY, Genre.COMEDY, Genre.CRIME, 
				Genre.DOCUMENTARY, Genre.DRAMA, Genre.FANTASY, Genre.NOIR, Genre.HISTORY, Genre.HORROR, Genre.MUSICAL, Genre.MYSTERY, 
				Genre.ROMANCE, Genre.SCI_FI, Genre.SPORT, Genre.THRILLER, Genre.WAR, Genre.WESTERN};
		comboGenre.setModel(new DefaultComboBoxModel<Genre>(genreSet));
		comboGenre.setBorder(null);

		JTextPane txtpnDuration = new JTextPane();
		txtpnDuration.setEditable(false);
		txtpnDuration.setBackground(new Color(0,34,102));
		txtpnDuration.setForeground(Color.WHITE);
		txtpnDuration.setText("Duration:");
		txtpnDuration.setFont(new Font("Calibri", Font.PLAIN, 15));

		textDuration = new JTextField();
		textDuration.setColumns(10);
		textDuration.setBorder(null);
		
		searchButton = new JButton("Search");
		GroupLayout gl_pnSearchMovie = new GroupLayout(pnSearchMovie);
		gl_pnSearchMovie.setHorizontalGroup(
			gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnSearchMovie.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pnSearchMovie.createSequentialGroup()
							.addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnSearchMovie.createSequentialGroup()
							.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTitle))
						.addGroup(gl_pnSearchMovie.createSequentialGroup()
							.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textYear)))
					.addGap(18)
					.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnSearchMovie.createSequentialGroup()
								.addComponent(txtpnDuration, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnSearchMovie.createSequentialGroup()
							.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboGenre, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnSearchMovie.createSequentialGroup()
							.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)							
							.addComponent(checkBoxPG, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(searchButton)))

					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnSearchMovie.setVerticalGroup(
				gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnSearchMovie.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnSearchMovie.createSequentialGroup()
								.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnDuration, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboGenre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.TRAILING)
										.addComponent(searchButton)
										.addComponent(checkBoxPG, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_pnSearchMovie.createSequentialGroup()
										.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
											.addComponent(textID)
								.addComponent(txtpnId, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnSearchMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textYear, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addGap(11))
		);
		pnSearchMovie.setLayout(gl_pnSearchMovie);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				insertButton = new JButton("Insert");
				insertButton.setActionCommand("OK");
				buttonPane.add(insertButton);
				getRootPane().setDefaultButton(insertButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public ButtonGroup getRadioGroup() {
		return radioGroup;
	}

	public JTextField getTextID() {
		return textID;
	}

	public JTextField getTextTitle() {
		return textTitle;
	}

	public JTextField getTextYear() {
		return textYear;
	}

	public JTextField getTextDuration() {
		return textDuration;
	}

	public JComboBox<Genre> getComboGenre() {
		return comboGenre;
	}

	public JCheckBox getCheckBoxPG() {
		return checkBoxPG;
	}

	public JButton getInsertButton() {
		return insertButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JPanel getPnQueryResults() {
		return pnQueryResults;
	}

}

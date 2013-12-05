package popt.gui_sch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchMovieDialog dialog = new SearchMovieDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchMovieDialog() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		JTextPane txtMovieSearchResult = new JTextPane();
		txtMovieSearchResult.setText("Query Results:");
		txtMovieSearchResult.setMargin(new Insets(3, 20, 0, 0));
		txtMovieSearchResult.setFont(new Font("Calibri", Font.BOLD, 21));
		txtMovieSearchResult.setBackground(Color.GRAY);
		txtMovieSearchResult.setForeground(Color.WHITE);
		txtMovieSearchResult.setFocusable(false);
		txtMovieSearchResult.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtMovieSearch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addComponent(txtMovieSearchResult, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtMovieSearch, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMovieSearchResult, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setBackground(Color.ORANGE);
		txtpnId.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnId.setText("ID:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setBackground(Color.ORANGE);
		txtpnTitle.setText("Title:");
		txtpnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setBackground(Color.ORANGE);
		txtpnReleaseDate.setText("Year:");
		txtpnReleaseDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JTextPane txtpnPg = new JTextPane();
		txtpnPg.setBackground(Color.ORANGE);
		txtpnPg.setText("PG:");
		txtpnPg.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JTextPane txtpnGenre_1 = new JTextPane();
		txtpnGenre_1.setBackground(Color.ORANGE);
		txtpnGenre_1.setText("Genre:");
		txtpnGenre_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JTextPane txtpnGenre = new JTextPane();
		txtpnGenre.setBackground(Color.ORANGE);
		txtpnGenre.setText("Duration:");
		txtpnGenre.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JComboBox<Genre> comboBox = new JComboBox<Genre>();
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBackground(Color.ORANGE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnGenre_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnGenre_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField)
								.addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insert");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

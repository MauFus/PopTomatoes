package popt.gui_sch;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertMovieView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6155642829306165672L;

	/**
	 * Create the panel.
	 */
	JPanel insertMoviePanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	
	public InsertMovieView() {
		
		JTextPane txtpnInsertMovie = new JTextPane();
		txtpnInsertMovie.setForeground(new Color(255, 255, 255));
		txtpnInsertMovie.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnInsertMovie.setBackground(new Color(128, 128, 128));
		txtpnInsertMovie.setText("Insert Movie");
		Insets m = new Insets(5, 50, 0, 0);
		txtpnInsertMovie.setMargin(m);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Title:");
		textPane.setFont(new Font("Calibri", Font.PLAIN, 15));
		textPane.setBackground(Color.ORANGE);
		
		JTextPane txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setText("Release date:");
		txtpnReleaseDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnReleaseDate.setBackground(Color.ORANGE);
		
		JTextPane txtpnDuration = new JTextPane();
		txtpnDuration.setText("Duration:");
		txtpnDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnDuration.setBackground(Color.ORANGE);
		
		JTextPane txtpnGenre = new JTextPane();
		txtpnGenre.setText("Genre:");
		txtpnGenre.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnGenre.setBackground(Color.ORANGE);
		
		JTextPane txtpnPg = new JTextPane();
		txtpnPg.setText("PG:");
		txtpnPg.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnPg.setBackground(Color.ORANGE);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setBorder(null);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Calibri", Font.PLAIN, 15));
		formattedTextField.setBorder(null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("v.m.18");
		chckbxNewCheckBox.setFont(new Font("Calibri", Font.BOLD, 11));
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setBackground(Color.ORANGE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Genre1", "Genre2", "Genre3", "Genre4", "Genre5", "Genre6"}));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnInsertMovie, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnDuration, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addGap(206)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(337))
								.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBox, 0, 171, Short.MAX_VALUE)
								.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxNewCheckBox))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnInsertMovie, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(formattedTextField)
						.addComponent(txtpnReleaseDate, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_1)
						.addComponent(txtpnDuration, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox)
						.addComponent(txtpnGenre, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnPg, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(149))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		setLayout(groupLayout);
		
	}
}

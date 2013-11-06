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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import popt.data.*;

import javax.swing.JButton;

public class InsertMovieView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6155642829306165672L;

	/**
	 * Create the panel.
	 */
	JPanel insertMoviePanel = new JPanel();
	private JTextField textTitle;
	private JTextField textDuration;
	private JComboBox<Genre> comboBoxGenre;
	private JCheckBox checkPG;
	private JButton buttonInsert;
	private JTextPane textAlert;
	private JTextField textDate;

	public InsertMovieView() {
		
		JTextPane txtpnInsertMovie = new JTextPane();
		txtpnInsertMovie.setEditable(false);
		txtpnInsertMovie.setForeground(new Color(255, 255, 255));
		txtpnInsertMovie.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnInsertMovie.setBackground(new Color(128, 128, 128));
		txtpnInsertMovie.setText("Insert Movie");
		Insets m = new Insets(5, 50, 0, 0);
		txtpnInsertMovie.setMargin(m);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setEditable(false);
		txtpnTitle.setText("Title:");
		txtpnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnTitle.setBackground(Color.ORANGE);
		
		JTextPane txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setEditable(false);
		txtpnReleaseDate.setText("Release date:");
		txtpnReleaseDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnReleaseDate.setBackground(Color.ORANGE);
		
		JTextPane txtpnDuration = new JTextPane();
		txtpnDuration.setEditable(false);
		txtpnDuration.setText("Duration:");
		txtpnDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnDuration.setBackground(Color.ORANGE);
		
		JTextPane txtpnGenre = new JTextPane();
		txtpnGenre.setEditable(false);
		txtpnGenre.setText("Genre:");
		txtpnGenre.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnGenre.setBackground(Color.ORANGE);
		
		JTextPane txtpnPg = new JTextPane();
		txtpnPg.setEditable(false);
		txtpnPg.setText("PG:");
		txtpnPg.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnPg.setBackground(Color.ORANGE);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		textTitle.setBorder(null);
		textTitle.setColumns(10);
		
		textDuration = new JTextField();
		textDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDuration.setBorder(null);
		textDuration.setColumns(10);
		
		
		checkPG = new JCheckBox("v.m.18");
		checkPG.setFont(new Font("Calibri", Font.BOLD, 12));
		checkPG.setBorder(null);
		checkPG.setBackground(Color.ORANGE);
		
		comboBoxGenre = new JComboBox<Genre>();
		comboBoxGenre.setModel(new DefaultComboBoxModel<Genre>(Genre.values()));
		
		buttonInsert = new JButton("Insert!");
		buttonInsert.setForeground(new Color(255, 255, 255));
		buttonInsert.setBackground(new Color(128,128,128));		
		
		textAlert = new JTextPane();
		textAlert.setEditable(false);
		textAlert.setForeground(Color.BLACK);
		textAlert.setBackground(Color.ORANGE);
		textAlert.setFont(new Font("Calibri",Font.PLAIN, 12));
		
		textDate = new JTextField();
		textDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDate.setBorder(null);
		textDate.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnInsertMovie, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(318)
					.addComponent(buttonInsert)
					.addContainerGap(399, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textAlert, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnReleaseDate, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtpnGenre, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
											.addComponent(txtpnDuration, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
										.addComponent(txtpnPg, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
									.addGap(205))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(checkPG)
								.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnInsertMovie, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textTitle)
						.addComponent(txtpnTitle, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textDate)
						.addComponent(txtpnReleaseDate, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textDuration)
						.addComponent(txtpnDuration, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBoxGenre)
						.addComponent(txtpnGenre, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(37)
					.addComponent(buttonInsert, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textAlert, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		setLayout(groupLayout);
		
	}
	
	public JButton getButtonInsert() {
		return buttonInsert;
	}
	
	public JTextField getTextTitle() {
		return textTitle;
	}

	public JTextField getTextDuration() {
		return textDuration;
	}

	public JTextField getTextDate() {
		return textDate;
	}
	
	public JComboBox<Genre> getComboBoxGenre() {
		return comboBoxGenre;
	}

	public JCheckBox getCheckPG() {
		return checkPG;
	}
	
	public JTextPane getTextAlert() {
		return textAlert;
	}
}

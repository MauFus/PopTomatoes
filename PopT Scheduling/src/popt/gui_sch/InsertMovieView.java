package popt.gui_sch;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.DefaultListCellRenderer;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import popt.data.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;

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
	private JCheckBox checkPG;
	private JTextField textDate;
	private JTextField textDuration;
	private JComboBox<Genre> comboBoxGenre;
	private JTextPane textPane;
	private JButton buttonInsert;
	private JTextPane textAlert;

	public InsertMovieView() {
		
		JPanel insertMoviePanel = new JPanel();
		insertMoviePanel.setBackground(Color.ORANGE);
		insertMoviePanel.setPreferredSize(new Dimension(1000,550));
			DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
			dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		textPane = new JTextPane();
		textPane.setText("Insert Movie");
		textPane.setMargin(new Insets(5, 50, 0, 0));
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Calibri", Font.BOLD, 33));
		textPane.setFocusable(false);
		textPane.setEditable(false);
		textPane.setBackground(Color.GRAY);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					)
				.addGroup(Alignment.CENTER, groupLayout.createSequentialGroup()
					.addComponent(insertMoviePanel, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)
					)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(insertMoviePanel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					)
		);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("Title:");
		txtpnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnTitle.setFocusable(false);
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(Color.ORANGE);
		
		JTextPane txtpnReleaseDate = new JTextPane();
		txtpnReleaseDate.setText("Release date:");
		txtpnReleaseDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnReleaseDate.setFocusable(false);
		txtpnReleaseDate.setEditable(false);
		txtpnReleaseDate.setBackground(Color.ORANGE);
		
		JTextPane txtpnDuration = new JTextPane();
		txtpnDuration.setText("Duration:");
		txtpnDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnDuration.setFocusable(false);
		txtpnDuration.setEditable(false);
		txtpnDuration.setBackground(Color.ORANGE);
		
		JTextPane txtpnGenre = new JTextPane();
		txtpnGenre.setText("Genre:");
		txtpnGenre.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnGenre.setFocusable(false);
		txtpnGenre.setEditable(false);
		txtpnGenre.setBackground(Color.ORANGE);
		
		JTextPane txtpnPg = new JTextPane();
		txtpnPg.setText("PG:");
		txtpnPg.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnPg.setFocusable(false);
		txtpnPg.setEditable(false);
		txtpnPg.setBackground(Color.ORANGE);
		
		checkPG = new JCheckBox("v.m.18");
		checkPG.setFont(new Font("Calibri", Font.BOLD, 12));
		checkPG.setBorder(null);
		checkPG.setBackground(Color.ORANGE);
		
		textTitle = new JTextField();
		textTitle.setText("Insert here your movie title");
		textTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		textTitle.setForeground(Color.GRAY);
		textTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		textTitle.setColumns(10);
		textTitle.setBorder(null);
		
		textDate = new JTextField();
		textDate.setText("gg-mm-aaaa");
		textDate.setHorizontalAlignment(SwingConstants.RIGHT);
		textDate.setForeground(Color.GRAY);
		textDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDate.setColumns(10);
		textDate.setBorder(null);
		
		textDuration = new JTextField();
		textDuration.setText("minutes");
		textDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		textDuration.setForeground(Color.GRAY);
		textDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDuration.setColumns(10);
		textDuration.setBorder(null);
		
		comboBoxGenre = new JComboBox<Genre>();
		comboBoxGenre.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxGenre.setBorder(null);
		comboBoxGenre.setBackground(Color.WHITE);
		
		buttonInsert = new JButton("Insert!");
		buttonInsert.setForeground(Color.WHITE);
		buttonInsert.setFont(new Font("Calibri", Font.PLAIN, 15));
		buttonInsert.setFocusable(false);
		buttonInsert.setBorderPainted(false);
		buttonInsert.setForeground(Color.BLACK);
		buttonInsert.setBackground(Color.GRAY);
		
		textAlert = new JTextPane();
		textAlert.setForeground(Color.BLACK);
		textAlert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAlert.setEditable(false);
		textAlert.setBackground(new Color((Color.ORANGE).getRed(),(Color.ORANGE).getGreen()+30,(Color.ORANGE).getBlue()+30));
		GroupLayout gl_insertMoviePanel = new GroupLayout(insertMoviePanel);
		gl_insertMoviePanel.setHorizontalGroup(
			gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_insertMoviePanel.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textAlert, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGroup(Alignment.CENTER, gl_insertMoviePanel.createSequentialGroup()
							.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(527)
							.addComponent(checkPG, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.CENTER, gl_insertMoviePanel.createSequentialGroup()
							.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(454)
							.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.CENTER, gl_insertMoviePanel.createSequentialGroup()
							.addComponent(txtpnDuration, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
							.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.CENTER, gl_insertMoviePanel.createSequentialGroup()
							.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 433, Short.MAX_VALUE)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.CENTER, gl_insertMoviePanel.createSequentialGroup()
							.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(275)
							.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addGap(54))
				.addGroup(Alignment.LEADING, gl_insertMoviePanel.createSequentialGroup()
					.addGap(348)
					.addComponent(buttonInsert, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		gl_insertMoviePanel.setVerticalGroup(
			gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_insertMoviePanel.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textTitle, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textDate)
						.addComponent(txtpnReleaseDate, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textDuration)
						.addComponent(txtpnDuration, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxGenre, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_insertMoviePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(checkPG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(buttonInsert, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textAlert, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		insertMoviePanel.setLayout(gl_insertMoviePanel);
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

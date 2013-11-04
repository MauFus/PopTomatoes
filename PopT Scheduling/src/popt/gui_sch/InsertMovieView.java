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
import javax.swing.JFormattedTextField;
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
	
	public InsertMovieView() {
		
		JTextPane txtpnInsertMovie = new JTextPane();
		txtpnInsertMovie.setForeground(new Color(255, 255, 255));
		txtpnInsertMovie.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnInsertMovie.setBackground(new Color(128, 128, 128));
		txtpnInsertMovie.setText("Insert Movie");
		Insets m = new Insets(5, 50, 0, 0);
		txtpnInsertMovie.setMargin(m);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("Title:");
		txtpnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnTitle.setBackground(Color.ORANGE);
		
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
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		textTitle.setBorder(null);
		textTitle.setColumns(10);
		
		JFormattedTextField textDate = new JFormattedTextField();
		textDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDate.setBorder(null);
		
		textDuration = new JTextField();
		textDuration.setFont(new Font("Calibri", Font.PLAIN, 15));
		textDuration.setBorder(null);
		textDuration.setColumns(10);
		
		
		JCheckBox checkPG = new JCheckBox("v.m.18");
		checkPG.setFont(new Font("Calibri", Font.BOLD, 11));
		checkPG.setBorder(null);
		checkPG.setBackground(Color.ORANGE);
		
		JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(new DefaultComboBoxModel(Genre.values()));
		
		JButton buttonInsert = new JButton("Insert!");
		buttonInsert.setBackground(new Color(250,50,0));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnInsertMovie, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnTitle, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnDuration, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addGap(206)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtpnGenre, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtpnPg, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtpnReleaseDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(comboBoxGenre, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkPG)))))
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(318)
					.addComponent(buttonInsert)
					.addContainerGap(399, Short.MAX_VALUE))
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
						.addComponent(txtpnReleaseDate, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textDuration)
						.addComponent(txtpnDuration, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBoxGenre)
						.addComponent(txtpnGenre, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(checkPG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtpnPg, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(37)
					.addComponent(buttonInsert, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		setLayout(groupLayout);
		
	}
}

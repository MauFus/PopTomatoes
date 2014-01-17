package popt.gui_sch;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.SystemColor;

public class TimeBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9118986192387631937L;

	/**
	 * Create the panel.
	 */
	public TimeBar() {
		setBackground(new Color(102, 204, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 720, 178};
		gridBagLayout.rowHeights = new int[] {30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setEditable(false);
		txtpnA.setBackground(SystemColor.controlHighlight);
		txtpnA.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtpnA.setText("14.00");
		txtpnA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_txtpnA = new GridBagConstraints();
		gbc_txtpnA.insets = new Insets(0, 0, 0, 0);
		gbc_txtpnA.fill = GridBagConstraints.BOTH;
		gbc_txtpnA.gridx = 0;
		gbc_txtpnA.gridy = 0;
		panel.add(txtpnA, gbc_txtpnA);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.controlHighlight);
		textPane_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_1.setText("15.00");
		textPane_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 0;
		panel.add(textPane_1, gbc_textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBackground(SystemColor.controlHighlight);
		textPane_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_2.setText("16.00");
		textPane_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_2 = new GridBagConstraints();
		gbc_textPane_2.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_2.fill = GridBagConstraints.BOTH;
		gbc_textPane_2.gridx = 2;
		gbc_textPane_2.gridy = 0;
		panel.add(textPane_2, gbc_textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBackground(SystemColor.controlHighlight);
		textPane_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_3.setText("17.00");
		textPane_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
		gbc_textPane_3.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_3.fill = GridBagConstraints.BOTH;
		gbc_textPane_3.gridx = 3;
		gbc_textPane_3.gridy = 0;
		panel.add(textPane_3, gbc_textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBackground(SystemColor.controlHighlight);
		textPane_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_4.setText("18.00");
		textPane_4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_4 = new GridBagConstraints();
		gbc_textPane_4.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_4.fill = GridBagConstraints.BOTH;
		gbc_textPane_4.gridx = 4;
		gbc_textPane_4.gridy = 0;
		panel.add(textPane_4, gbc_textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBackground(SystemColor.controlHighlight);
		textPane_5.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_5.setText("19.00");
		textPane_5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_5 = new GridBagConstraints();
		gbc_textPane_5.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_5.fill = GridBagConstraints.BOTH;
		gbc_textPane_5.gridx = 5;
		gbc_textPane_5.gridy = 0;
		panel.add(textPane_5, gbc_textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setBackground(SystemColor.controlHighlight);
		textPane_6.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_6.setText("20.00");
		textPane_6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_6 = new GridBagConstraints();
		gbc_textPane_6.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_6.fill = GridBagConstraints.BOTH;
		gbc_textPane_6.gridx = 6;
		gbc_textPane_6.gridy = 0;
		panel.add(textPane_6, gbc_textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setBackground(SystemColor.controlHighlight);
		textPane_7.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_7.setText("21.00");
		textPane_7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_7 = new GridBagConstraints();
		gbc_textPane_7.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_7.fill = GridBagConstraints.BOTH;
		gbc_textPane_7.gridx = 7;
		gbc_textPane_7.gridy = 0;
		panel.add(textPane_7, gbc_textPane_7);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEditable(false);
		textPane_8.setBackground(SystemColor.controlHighlight);
		textPane_8.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_8.setText("22.00");
		textPane_8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_8 = new GridBagConstraints();
		gbc_textPane_8.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_8.fill = GridBagConstraints.BOTH;
		gbc_textPane_8.gridx = 8;
		gbc_textPane_8.gridy = 0;
		panel.add(textPane_8, gbc_textPane_8);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setEditable(false);
		textPane_9.setBackground(SystemColor.controlHighlight);
		textPane_9.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_9.setText("23.00");
		textPane_9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_9 = new GridBagConstraints();
		gbc_textPane_9.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_9.fill = GridBagConstraints.BOTH;
		gbc_textPane_9.gridx = 9;
		gbc_textPane_9.gridy = 0;
		panel.add(textPane_9, gbc_textPane_9);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setEditable(false);
		textPane_10.setBackground(SystemColor.controlHighlight);
		textPane_10.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_10.setText("00.00");
		textPane_10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_10 = new GridBagConstraints();
		gbc_textPane_10.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_10.fill = GridBagConstraints.BOTH;
		gbc_textPane_10.gridx = 10;
		gbc_textPane_10.gridy = 0;
		panel.add(textPane_10, gbc_textPane_10);
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setEditable(false);
		textPane_11.setBackground(SystemColor.controlHighlight);
		textPane_11.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPane_11.setText("01.00");
		textPane_11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_textPane_11 = new GridBagConstraints();
		gbc_textPane_11.insets = new Insets(0, 0, 0, 0);
		gbc_textPane_11.fill = GridBagConstraints.BOTH;
		gbc_textPane_11.gridx = 11;
		gbc_textPane_11.gridy = 0;
		panel.add(textPane_11, gbc_textPane_11);

	}

}

package popt.gui_sch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Font;

public class MovieInfoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3442282192469863572L;
	private final JPanel contentPanel = new JPanel();
	private JButton deleteButton;
	private JButton cancelButton;
	private JTextPane textTitle;
	private JTextPane textSFTime;

	/**
	 * Create the dialog.
	 */
	public MovieInfoDialog(JFrame parent) {
		super(parent,true);
		setBounds(100, 100, 320, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{10, 0, 20, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 50, 30, 40, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			textTitle = new JTextPane();
			textTitle.setFont(new Font("Calibri", Font.PLAIN, 21));
			textTitle.setEditable(false);
			textTitle.setBackground(SystemColor.controlHighlight);
			GridBagConstraints gbc_textTitle = new GridBagConstraints();
			gbc_textTitle.insets = new Insets(0, 0, 5, 5);
			gbc_textTitle.fill = GridBagConstraints.BOTH;
			gbc_textTitle.gridx = 1;
			gbc_textTitle.gridy = 1;
			contentPanel.add(textTitle, gbc_textTitle);
		}
		{
			textSFTime = new JTextPane();
			textSFTime.setFont(new Font("Calibri", Font.PLAIN, 15));
			textSFTime.setEditable(false);
			textSFTime.setBackground(SystemColor.controlHighlight);
			GridBagConstraints gbc_textSFTime = new GridBagConstraints();
			gbc_textSFTime.insets = new Insets(0, 0, 5, 5);
			gbc_textSFTime.fill = GridBagConstraints.BOTH;
			gbc_textSFTime.gridx = 1;
			gbc_textSFTime.gridy = 2;
			contentPanel.add(textSFTime, gbc_textSFTime);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				deleteButton = new JButton("Delete");
				deleteButton.setActionCommand("DELETE");
				buttonPane.add(deleteButton);
				getRootPane().setDefaultButton(deleteButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextPane getTextTitle() {
		return textTitle;
	}

	public void setTextTitle(JTextPane textTitle) {
		this.textTitle = textTitle;
	}

	public JTextPane getTextSFTime() {
		return textSFTime;
	}

	public void setTextSFTime(JTextPane textSFTime) {
		this.textSFTime = textSFTime;
	}
}

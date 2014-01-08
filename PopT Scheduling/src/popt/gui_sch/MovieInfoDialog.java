package popt.gui_sch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class MovieInfoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3442282192469863572L;
	private final JPanel contentPanel = new JPanel();
	private JButton deleteButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovieInfoDialog dialog = new MovieInfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieInfoDialog() {
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
			JTextPane textPane = new JTextPane();
			textPane.setBackground(SystemColor.controlHighlight);
			GridBagConstraints gbc_textPane = new GridBagConstraints();
			gbc_textPane.insets = new Insets(0, 0, 5, 5);
			gbc_textPane.fill = GridBagConstraints.BOTH;
			gbc_textPane.gridx = 1;
			gbc_textPane.gridy = 1;
			contentPanel.add(textPane, gbc_textPane);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBackground(SystemColor.controlHighlight);
			GridBagConstraints gbc_textPane = new GridBagConstraints();
			gbc_textPane.insets = new Insets(0, 0, 5, 5);
			gbc_textPane.fill = GridBagConstraints.BOTH;
			gbc_textPane.gridx = 1;
			gbc_textPane.gridy = 2;
			contentPanel.add(textPane, gbc_textPane);
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
}

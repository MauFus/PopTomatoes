package popt.gui_ticket;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2838993630507433768L;

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 700, 50, 0};
		gridBagLayout.rowHeights = new int[]{50, 150, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("PopTomatoes \u263A");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 51));
		lblNewLabel_1.setIcon(new ImageIcon(MissingConnectionPanel.class.getResource("/ico/LogoPopT.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

}

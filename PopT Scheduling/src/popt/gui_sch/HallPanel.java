package popt.gui_sch;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;

public class HallPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5314001806476548519L;

	/**
	 * Create the panel.
	 */
	public HallPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 720, 170};
		gridBagLayout.rowHeights = new int[]{100, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextPane txtpnSalaMella = new JTextPane();
		GridBagConstraints gbc_txtpnSalaMella = new GridBagConstraints();
		gbc_txtpnSalaMella.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnSalaMella.gridx = 0;
		gbc_txtpnSalaMella.gridy = 0;
		add(txtpnSalaMella, gbc_txtpnSalaMella);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);

	}

}

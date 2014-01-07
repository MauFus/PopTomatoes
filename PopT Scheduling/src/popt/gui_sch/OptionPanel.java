package popt.gui_sch;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class OptionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8730974701730714361L;
	private JTextField txtHhmm;
	private JTextField txtHhmm_1;
	private JTextField txtMm;

	/**
	 * Create the panel.
	 */
	public OptionPanel() {
		
		JTextPane txtpnApertura = new JTextPane();
		txtpnApertura.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnApertura.setBackground(new Color(240,240,240));
		txtpnApertura.setEditable(false);
		txtpnApertura.setText("Opening Time:");
		
		JTextPane txtpnChiusura = new JTextPane();
		txtpnChiusura.setBackground(new Color(240,240,240));
		txtpnChiusura.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnChiusura.setText("Closing Time:");
		txtpnChiusura.setEditable(false);
		
		JTextPane txtpnGap = new JTextPane();
		txtpnGap.setBackground(new Color(240,240,240));
		txtpnGap.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnGap.setText("Gap:");
		txtpnGap.setEditable(false);
		
		txtHhmm = new JTextField();
		txtHhmm.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtHhmm.setText("hh.mm");
		txtHhmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtHhmm.setColumns(10);
		
		txtHhmm_1 = new JTextField();
		txtHhmm_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtHhmm_1.setText("hh.mm");
		txtHhmm_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHhmm_1.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtMm.setText("mm");
		txtMm.setHorizontalAlignment(SwingConstants.CENTER);
		txtMm.setColumns(10);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.RED);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.controlHighlight);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnChiusura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnApertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHhmm_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHhmm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtHhmm, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addComponent(txtpnApertura, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnChiusura, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHhmm_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtMm, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReset))
						.addComponent(txtpnGap, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}

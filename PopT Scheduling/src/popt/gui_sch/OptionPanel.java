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
import javax.swing.JLabel;

public class OptionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8730974701730714361L;
	
	private JTextField txtOpeningTime;
	private JTextField txtClosingTime;
	private JTextField txtGap;
	private JTextPane txtBarMessage;
	private JLabel txtpnToday;
	
	private JButton btnValidate;
	private JButton btnReset;

	/**
	 * Create the panel.
	 */
	public OptionPanel() {
		setBackground(new Color(102, 204, 0));
		setBorder(null);
		
		JTextPane txtpnOpening = new JTextPane();
		txtpnOpening.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnOpening.setBackground(new Color(102, 204, 0));
		txtpnOpening.setEditable(false);
		txtpnOpening.setText("Opening Time:");
		
		JTextPane txtpnClosing = new JTextPane();
		txtpnClosing.setBackground(new Color(102, 204, 0));
		txtpnClosing.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnClosing.setText("Closing Time:");
		txtpnClosing.setEditable(false);
		
		JTextPane txtpnGap = new JTextPane();
		txtpnGap.setBackground(new Color(102, 204, 0));
		txtpnGap.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnGap.setText("Gap:");
		txtpnGap.setEditable(false);
		
		txtOpeningTime = new JTextField();
		txtOpeningTime.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtOpeningTime.setText("14:00");
		txtOpeningTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtOpeningTime.setColumns(10);
		
		txtClosingTime = new JTextField();
		txtClosingTime.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtClosingTime.setText("02:00");
		txtClosingTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtClosingTime.setColumns(10);
		
		txtGap = new JTextField();
		txtGap.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtGap.setText("45min");
		txtGap.setHorizontalAlignment(SwingConstants.CENTER);
		txtGap.setColumns(10);
		
		btnValidate = new JButton("Validate");
		btnValidate.setBackground(Color.ORANGE);
		btnValidate.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.RED);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		txtBarMessage = new JTextPane();
		txtBarMessage.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtBarMessage.setEditable(false);
		txtBarMessage.setBackground(new Color(132, 234, 0));
		
		txtpnToday = new JLabel();
		txtpnToday.setOpaque(true);
		txtpnToday.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnToday.setFont(new Font("Calibri", Font.BOLD, 27));
		txtpnToday.setForeground(Color.WHITE);
		txtpnToday.setBackground(new Color(132, 234, 0));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnClosing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnOpening, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtClosingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOpeningTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnToday, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(txtBarMessage, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnValidate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtOpeningTime, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
									.addComponent(btnValidate))
								.addComponent(txtpnOpening, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnClosing, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtClosingTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(txtpnToday, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtGap, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReset))
						.addComponent(txtpnGap, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBarMessage, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public JTextField getTxtOpeningTime() {
		return txtOpeningTime;
	}

	public JTextField getTxtClosingTime() {
		return txtClosingTime;
	}

	public JTextField getTxtGap() {
		return txtGap;
	}

	public JTextPane getTxtBarMessage() {
		return txtBarMessage;
	}

	public JButton getBtnValidate() {
		return btnValidate;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JLabel getTxtpnToday() {
		return txtpnToday;
	}
}

package popt.gui_sch;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Dimension;

public class SchedulingView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3430564401934270962L;
	
	/**
	 * Create the panel.
	 */
	public SchedulingView() {
		
		JTextPane txtpnWeekScheduling = new JTextPane();
		txtpnWeekScheduling.setText("Week Scheduling");
		txtpnWeekScheduling.setMargin(new Insets(5, 50, 0, 0));
		txtpnWeekScheduling.setForeground(Color.WHITE);
		txtpnWeekScheduling.setFont(new Font("Calibri", Font.BOLD, 33));
		txtpnWeekScheduling.setFocusable(false);
		txtpnWeekScheduling.setEditable(false);
		txtpnWeekScheduling.setBackground(Color.GRAY);
		
		//TODO prelevare dinamicamente il numero delle sale
		//int nHall = 5;
		JPanel SchContainer = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000,50));
		panel.setBackground(SystemColor.windowBorder);
		
		JButton button = new JButton("Thursday");
		button.setFocusable(false);
		button.setBackground(Color.DARK_GRAY);
		button.setActionCommand("Switch Card");
		
		JButton button_1 = new JButton("Friday");
		button_1.setFocusable(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setActionCommand("Switch Card");
		
		JButton button_2 = new JButton("Saturday");
		button_2.setFocusable(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.DARK_GRAY);
		button_2.setActionCommand("Switch Card");
		
		JButton button_3 = new JButton("Sunday");
		button_3.setFocusable(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(Color.DARK_GRAY);
		button_3.setActionCommand("Switch Card");
		
		JButton button_4 = new JButton("Monday");
		button_4.setFocusable(false);
		button_4.setBorderPainted(false);
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setActionCommand("Switch Card");
		
		JButton button_5 = new JButton("Tuesday");
		button_5.setFocusable(false);
		button_5.setBorderPainted(false);
		button_5.setBackground(Color.DARK_GRAY);
		button_5.setActionCommand("Switch Card");
		
		JButton button_6 = new JButton("Wednesday");
		button_6.setFocusable(false);
		button_6.setBorderPainted(false);
		button_6.setBackground(Color.DARK_GRAY);
		button_6.setActionCommand("Switch Card");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(txtpnWeekScheduling, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(SchContainer, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
					)
					
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnWeekScheduling, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 50, GroupLayout.DEFAULT_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SchContainer, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}

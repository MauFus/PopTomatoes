package popt.gui_sch;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchedulingView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3430564401934270962L;
	
	/**
	 * Create the panel.
	 */
	
	private JPanel SchContainer;
	private DailyCard SchContainerTh;
	private DailyCard SchContainerFr; 
	private DailyCard SchContainerSa;
	private DailyCard SchContainerSu;
	private DailyCard SchContainerMo;
	private DailyCard SchContainerTu;
	private DailyCard SchContainerWe;
	
	CardLayout cards;
	
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
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000,50));
		panel.setBackground(SystemColor.windowBorder);
		
		JButton buttonTh = new JButton("Thursday");
		buttonTh.setFocusable(false);
		buttonTh.setBackground(Color.DARK_GRAY);
		buttonTh.setActionCommand("Switch Card");
		buttonTh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "TH");
			}
		});
		
		JButton buttonFr = new JButton("Friday");
		buttonFr.setFocusable(false);
		buttonFr.setBorderPainted(false);
		buttonFr.setBackground(Color.DARK_GRAY);
		buttonFr.setActionCommand("Switch Card");
		buttonFr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "FR");
			}
		});
		
		JButton buttonSa = new JButton("Saturday");
		buttonSa.setFocusable(false);
		buttonSa.setBorderPainted(false);
		buttonSa.setBackground(Color.DARK_GRAY);
		buttonSa.setActionCommand("Switch Card");
		buttonSa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "SA");
			}
		});
		
		JButton buttonSu = new JButton("Sunday");
		buttonSu.setFocusable(false);
		buttonSu.setBorderPainted(false);
		buttonSu.setBackground(Color.DARK_GRAY);
		buttonSu.setActionCommand("Switch Card");
		buttonSu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "SU");
			}
		});
		
		JButton buttonMo = new JButton("Monday");
		buttonMo.setFocusable(false);
		buttonMo.setBorderPainted(false);
		buttonMo.setBackground(Color.DARK_GRAY);
		buttonMo.setActionCommand("Switch Card");
		buttonMo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "MO");
			}
		});
		
		JButton buttonTu = new JButton("Tuesday");
		buttonTu.setFocusable(false);
		buttonTu.setBorderPainted(false);
		buttonTu.setBackground(Color.DARK_GRAY);
		buttonTu.setActionCommand("Switch Card");
		buttonTu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "TU");
			}
		});
		
		JButton buttonWe = new JButton("Wednesday");
		buttonWe.setFocusable(false);
		buttonWe.setBorderPainted(false);
		buttonWe.setBackground(Color.DARK_GRAY);
		buttonWe.setActionCommand("Switch Card");
		buttonWe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//cards.next(cardPanel);
				cards.show(SchContainer, "WE");
			}
		});
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setFocusable(false);
		btnAccept.setBorderPainted(false);
		btnAccept.setBackground(Color.GREEN);
		//btnAccept.setActionCommand("Switch Card");
		
		cards = new CardLayout();
		SchContainer = new JPanel();
		SchContainer.setLayout(cards);
		cards.show(SchContainer, "TH");

		SchContainerTh = new DailyCard();
		SchContainerTh.setBackground(new Color(100,100,100));
		SchContainerFr = new DailyCard();
		SchContainerFr.setBackground(new Color(100,100,100));
		SchContainerSa = new DailyCard();
		SchContainerSa.setBackground(new Color(100,100,100));
		SchContainerSu = new DailyCard();
		SchContainerSu.setBackground(new Color(100,100,100));
		SchContainerMo = new DailyCard();
		SchContainerMo.setBackground(new Color(100,100,100));
		SchContainerTu = new DailyCard();
		SchContainerTu.setBackground(new Color(100,100,100));
		SchContainerWe = new DailyCard();
		SchContainerWe.setBackground(new Color(100,100,100));

		SchContainer.add(SchContainerTh, "TH");
		SchContainer.add(SchContainerFr, "FR");
		SchContainer.add(SchContainerSa, "SA");
		SchContainer.add(SchContainerSu, "SU");
		SchContainer.add(SchContainerMo, "MO");
		SchContainer.add(SchContainerTu, "TU");
		SchContainer.add(SchContainerWe, "WE");
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(buttonTh, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonFr, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonSa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonSu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonMo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonTu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buttonWe, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(138)
					.addComponent(btnAccept, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addComponent(buttonTh, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonFr, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonSa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonSu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonMo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonTu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonWe, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnAccept, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
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

	public DailyCard getSchContainerTh() {
		return SchContainerTh;
	}

	public DailyCard getSchContainerFr() {
		return SchContainerFr;
	}

	public DailyCard getSchContainerSa() {
		return SchContainerSa;
	}

	public DailyCard getSchContainerSu() {
		return SchContainerSu;
	}

	public DailyCard getSchContainerMo() {
		return SchContainerMo;
	}

	public DailyCard getSchContainerTu() {
		return SchContainerTu;
	}

	public DailyCard getSchContainerWe() {
		return SchContainerWe;
	}
}

package popt.gui_ticket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.StyleConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TicketSellView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8373517673540077922L;

	private JPanel ticketSellContainer;
	private JTextField editNumberOfTickets;
	private SeatRect aSeat;
	
	/**
	 * Create the panel.
	 */
	public TicketSellView() {
		
		JTextPane txtPnTicketSell = new JTextPane();
		txtPnTicketSell.setEditable(false);
		txtPnTicketSell.setText("Ticket Sales");
		txtPnTicketSell.setMargin(new Insets(5, 50, 0, 0));
		txtPnTicketSell.setForeground(Color.WHITE);
		txtPnTicketSell.setFont(new Font("Calibri", Font.BOLD, 33));
		txtPnTicketSell.setBackground(Color.GRAY);
		txtPnTicketSell.setFocusable(false);
		
		ticketSellContainer = new JPanel();
		ticketSellContainer.setPreferredSize(new Dimension(1000, 550));
		ticketSellContainer.setBackground(new Color(100,100,100));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addGroup(Alignment.CENTER, groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(ticketSellContainer, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addComponent(txtPnTicketSell))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtPnTicketSell, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(ticketSellContainer, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addGap(33))
		);
		GridBagLayout gbl_ticketSellContainer = new GridBagLayout();
		gbl_ticketSellContainer.columnWidths = new int[]{250, 600, 140, 0};
		gbl_ticketSellContainer.rowHeights = new int[]{0, 0};
		gbl_ticketSellContainer.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_ticketSellContainer.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		ticketSellContainer.setLayout(gbl_ticketSellContainer);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(159,182,205));
		GridBagConstraints gbc_searchPanel = new GridBagConstraints();
		gbc_searchPanel.insets = new Insets(0, 0, 0, 5);
		gbc_searchPanel.fill = GridBagConstraints.BOTH;
		gbc_searchPanel.gridx = 0;
		gbc_searchPanel.gridy = 0;
		ticketSellContainer.add(searchPanel, gbc_searchPanel);
		
		JTextPane txtpnMovieTitle = new JTextPane();
		txtpnMovieTitle.setEditable(false);
		txtpnMovieTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnMovieTitle.setBackground(new Color(159,182,205));
		txtpnMovieTitle.setText("Movie Title:");
		
		JComboBox titleBox = new JComboBox();
		titleBox.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JTextPane txtpnSelectYourShowtime = new JTextPane();
		txtpnSelectYourShowtime.setEditable(false);
		txtpnSelectYourShowtime.setText("Select your Showtime:");
		txtpnSelectYourShowtime.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnSelectYourShowtime.setBackground(new Color(159, 182, 205));
		
		JComboBox dateBox = new JComboBox();
		dateBox.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JTextPane txtpnNumberOfTickets = new JTextPane();
		txtpnNumberOfTickets.setEditable(false);
		txtpnNumberOfTickets.setText("Number of Tickets:");
		txtpnNumberOfTickets.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtpnNumberOfTickets.setBackground(new Color(159, 182, 205));
		
		editNumberOfTickets = new JTextField();
		editNumberOfTickets.setFont(new Font("Calibri", Font.PLAIN, 15));
		editNumberOfTickets.setColumns(10);
		
		JButton searchButt = new JButton("Search!");
		searchButt.setFont(new Font("Calibri", Font.PLAIN, 33));
		searchButt.setBackground(new Color(0,200,0));
		searchButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton manualButt = new JButton("Manual Selection");
		manualButt.setFont(new Font("Calibri", Font.PLAIN, 18));
		manualButt.setBackground(new Color(0,150,0));
		
		GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
		gl_searchPanel.setHorizontalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(titleBox, 0, 225, Short.MAX_VALUE)
						.addComponent(txtpnMovieTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateBox, 0, 225, Short.MAX_VALUE)
						.addComponent(txtpnSelectYourShowtime, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addGroup(gl_searchPanel.createSequentialGroup()
							.addComponent(txtpnNumberOfTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(editNumberOfTickets, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addComponent(searchButt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addComponent(manualButt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_searchPanel.setVerticalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnMovieTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(titleBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnSelectYourShowtime, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(dateBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnNumberOfTickets, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(editNumberOfTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(searchButt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(manualButt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		searchPanel.setLayout(gl_searchPanel);
		
		JPanel hallPanel = new JPanel();
		hallPanel.setBackground(new Color(159,182,205));
		GridBagConstraints gbc_hallPanel = new GridBagConstraints();
		gbc_hallPanel.fill = GridBagConstraints.VERTICAL;
		gbc_hallPanel.anchor = GridBagConstraints.WEST;
		gbc_hallPanel.insets = new Insets(0, 0, 0, 5);
		gbc_hallPanel.gridx = 1;
		gbc_hallPanel.gridy = 0;
		
		ticketSellContainer.add(hallPanel, gbc_hallPanel);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(159,182,205));
		
		JPanel HallViewer = new JPanel();
		HallViewer.setBackground(Color.LIGHT_GRAY);
		
		GroupLayout gl_hallPanel = new GroupLayout(hallPanel);
		gl_hallPanel.setHorizontalGroup(
			gl_hallPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
				.addComponent(HallViewer, GroupLayout.PREFERRED_SIZE, 595, Short.MAX_VALUE)
		);
		gl_hallPanel.setVerticalGroup(
			gl_hallPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hallPanel.createSequentialGroup()
					.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(HallViewer, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
		);
		GridBagLayout gbl_HallViewer = new GridBagLayout();
		gbl_HallViewer.columnWidths = new int[]{30, 570};
		gbl_HallViewer.rowHeights = new int[]{22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22};
		gbl_HallViewer.columnWeights = new double[]{0.0, 0.0};
		gbl_HallViewer.rowWeights = new double[]{0.0};
		HallViewer.setLayout(gbl_HallViewer);
		
		for (int i = 0; i < 20; i++) {
		JTextPane txtpnRowNumber = new JTextPane();
		//txtpnRowNumber.setBorder(null);
		txtpnRowNumber.setBackground(new Color(100+5*i,0,0));
		GridBagConstraints gbc_txtpnRowNumber = new GridBagConstraints();
		gbc_txtpnRowNumber.insets = new Insets(0, 0, 0, 0);
		gbc_txtpnRowNumber.fill = GridBagConstraints.BOTH;
		gbc_txtpnRowNumber.gridx = 0;
		gbc_txtpnRowNumber.gridy = i;
		HallViewer.add(txtpnRowNumber, gbc_txtpnRowNumber);
		}
		
		for (int i = 0; i < 20; i++) {
			RowPanel panel = new RowPanel();
			for(int j = 0; j < 20; j++)
			{
				SeatRect sr = new SeatRect();
				panel.add(sr);
			}
			//panel.setBorder(null);
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(0);
			flowLayout.setHgap(0);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = i;
			HallViewer.add(panel, gbc_panel);
		}
		
		headerPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel textHeader = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", SwingConstants.CENTER);
		textHeader.setFont(new Font("Calibri", Font.PLAIN, 15));
		textHeader.setBorder(null);
		headerPanel.add(textHeader);
		
		JPanel screenPanel = new JPanel();
		screenPanel.setBackground(Color.DARK_GRAY);
		headerPanel.add(screenPanel);
		GridBagLayout gbl_screenPanel = new GridBagLayout();
		gbl_screenPanel.columnWidths = new int[]{30, 570, 0};
		gbl_screenPanel.rowHeights = new int[]{40, 0};
		gbl_screenPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_screenPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		screenPanel.setLayout(gbl_screenPanel);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		screenPanel.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		SeatRect screen = new SeatRect();
		screen.setPreferredSize(new Dimension(300, 30));
		panel_1.add(screen);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(0);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		screenPanel.add(panel_1, gbc_panel_1);
		
		hallPanel.setLayout(gl_hallPanel);
		
		JPanel acceptPanel = new JPanel();
		acceptPanel.setBackground(new Color(159,182,205));
		GridBagConstraints gbc_acceptPanel = new GridBagConstraints();
		gbc_acceptPanel.fill = GridBagConstraints.BOTH;
		gbc_acceptPanel.gridx = 2;
		gbc_acceptPanel.gridy = 0;
		ticketSellContainer.add(acceptPanel, gbc_acceptPanel);
		
		JButton acceptButt = new JButton("Accept");
		acceptButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		acceptButt.setBackground(new Color(0,200,0));
		
		JButton cancelButt = new JButton("Cancel");
		cancelButt.setFont(new Font("Calibri", Font.PLAIN, 15));
		cancelButt.setBackground(Color.RED);
		
		JTextPane txtpnErrors = new JTextPane();
		txtpnErrors.setEditable(false);
		txtpnErrors.setBackground(new Color(179,202,225));
		GroupLayout gl_acceptPanel = new GroupLayout(acceptPanel);
		gl_acceptPanel.setHorizontalGroup(
			gl_acceptPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_acceptPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_acceptPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(acceptButt, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(cancelButt, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(txtpnErrors, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_acceptPanel.setVerticalGroup(
			gl_acceptPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_acceptPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(acceptButt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cancelButt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnErrors, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
						)
		);
		acceptPanel.setLayout(gl_acceptPanel);
		setLayout(groupLayout);
	}
}

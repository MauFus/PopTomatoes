package popt.ctrl_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

import popt.data.CinemaHall;
import popt.data.Movie;
import popt.gui_sch.DailyCard;
import popt.gui_sch.HallPanel;
import popt.gui_sch.HallPanelContainer;
import popt.gui_sch.OptionPanel;
import popt.model_sch.DailyCardModel;

public class DailyCardController {
	
	private DailyCard card;
	private DailyCardModel model;

	public DailyCardController(DailyCard view, DailyCardModel dailyModel) {
		card = view;
		model = dailyModel;
		
		initOptionsPanelListeners(card.getOptPanel());
		addHallPanels(card.getHallPCont());
	}

	/**
	 * Inizializza tutti i listener per i vari componenti dell'OptionPanel
	 * @param optPanel
	 */
	private void initOptionsPanelListeners(final OptionPanel optPanel) {
		optPanel.getTxtGap().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int gap = Integer.parseInt(optPanel.getTxtGap().getText());
					if (gap > 0) {
						model.setGap(gap);
						optPanel.getTxtBarMessage().setText("");
					} else {
						optPanel.getTxtBarMessage().setText("Errore - Il Gap deve avere un valore intero positivo");
						optPanel.getTxtGap().setText("45");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Gap non nel formato corretto");
					optPanel.getTxtGap().setText("45");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				optPanel.getTxtGap().setText("");
			}
		});
		
		optPanel.getTxtOpeningTime().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int opening = Integer.parseInt(optPanel.getTxtOpeningTime().getText());
					int closing = Integer.parseInt(optPanel.getTxtClosingTime().getText());
					if (opening < 0 || opening > 23 || (closing > 14 && opening > closing) 
							|| (closing <= 2 && opening > closing && opening < 14) ) {
						optPanel.getTxtBarMessage().setText("Errore - L'Orario di Apertura non è nel range corretto");
						optPanel.getTxtOpeningTime().setText("14");
					} else {
						model.setOpening(opening);
						optPanel.getTxtBarMessage().setText("");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Apertura non nel formato corretto");
					optPanel.getTxtOpeningTime().setText("14");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				optPanel.getTxtOpeningTime().setText("");
			}
		});
		
		optPanel.getTxtClosingTime().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int opening = Integer.parseInt(optPanel.getTxtOpeningTime().getText());
					int closing = Integer.parseInt(optPanel.getTxtClosingTime().getText());
					if (closing < 0 || closing > 23 || (closing < opening && opening <= 2) 
							|| (closing < opening && closing >= 14)) {
						optPanel.getTxtBarMessage().setText("Errore - L'Orario di Chiusura non è nel range corretto");
						optPanel.getTxtClosingTime().setText("2");
					} else {
						model.setClosing(closing);
						optPanel.getTxtBarMessage().setText("");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Chiusura non nel formato corretto");
					optPanel.getTxtClosingTime().setText("2");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				optPanel.getTxtClosingTime().setText("");
			}
		});
		
		optPanel.getBtnValidate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO implementare validazione
			}
		});
		
		optPanel.getBtnReset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO implementare reset
			}
		});
	}

	/**
	 * Aggiunge un HallPanel per ogni sala del cinema
	 * @param hallPCont
	 */
	private void addHallPanels(HallPanelContainer hallPCont) {
		if (model.getHallList() != null) {
			for (CinemaHall hall : model.getHallList()) {
				HallPanel newPanel = new HallPanel();
				newPanel.setCinemaHallID(hall.getId());
				newPanel.getTxtpnHall().setText(hall.getName());
				
				Vector<String> comboBoxList = new Vector<>();
				for (Movie m : model.getMovieList()) {
					comboBoxList.add(m.getTitle());
				}
				newPanel.getComboBoxMovie().setModel(new DefaultComboBoxModel<>(comboBoxList));
				hallPCont.add(newPanel);
			}
			// TODO aggiungere i film al MovieLine
		}
	}
}

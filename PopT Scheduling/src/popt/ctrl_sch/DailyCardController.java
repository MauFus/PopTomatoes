package popt.ctrl_sch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

import popt.data.CinemaHall;
import popt.data.Movie;
import popt.data.Showtime;
import popt.gui_sch.DailyCard;
import popt.gui_sch.HallPanel;
import popt.gui_sch.HallPanelContainer;
import popt.gui_sch.MovieRect;
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
						optPanel.getTxtGap().setText(gap + " min");
						optPanel.getTxtBarMessage().setText("");
					} else {
						optPanel.getTxtBarMessage().setText("Errore - Il Gap deve avere un valore intero positivo");
						optPanel.getTxtGap().setText("45 min");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Gap non nel formato corretto");
					optPanel.getTxtGap().setText("45 min");
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
						optPanel.getTxtOpeningTime().setText("14:00");
					} else {
						model.setOpening(opening);
						optPanel.getTxtBarMessage().setText("");
						optPanel.getTxtOpeningTime().setText(opening + ":00");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Apertura non nel formato corretto");
					optPanel.getTxtOpeningTime().setText("14:00");
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
						optPanel.getTxtClosingTime().setText("2:00");
					} else {
						model.setClosing(closing);
						optPanel.getTxtBarMessage().setText("");
						optPanel.getTxtClosingTime().setText(closing + ":00");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Chiusura non nel formato corretto");
					optPanel.getTxtClosingTime().setText("2:00");
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
				final HallPanel newPanel = new HallPanel();
				newPanel.setCinemaHallID(hall.getId());
				newPanel.getTxtpnHall().setText(hall.getName());
				
				Vector<String> comboBoxList = new Vector<>();
				for (Movie m : model.getMovieList()) {
					String title = m.getTitle() + " (" + m.getDuration() + "')";
					if (title.length() > 24)
						title = title.substring(0, 23) + "...";
					comboBoxList.add(title);
				}
				newPanel.getComboBoxMovie().setModel(new DefaultComboBoxModel<>(comboBoxList));
				newPanel.getComboBoxMovie().addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						String selected = newPanel.getComboBoxMovie().getItemAt(newPanel.getComboBoxMovie().getSelectedIndex());
						if (selected.contains("("))
							selected = selected.split("\\(")[0].trim();
						Showtime newShow = new Showtime();
						newShow.setId(-1);
						for (Movie movie : model.getMovieList()) {
							if (movie.getTitle().startsWith(selected)) {
								newShow.setMovie(movie);
								break;
							}
						}
						for (CinemaHall hall : model.getHallList()) {
							if (hall.getId() == newPanel.getCinemaHallID()) {
								newShow.setHall(hall);
								break;
							}
						}
						newShow.setDate(model.getDate());
						newShow.setTime("18:00");
						newShow.setAuditors(0);
						MovieRect r = new MovieRect(newShow.getMovie().getDuration(), 
								50, Color.DARK_GRAY);
						
						newPanel.getMovieLine().add(r);
						r.repaint();
					}
				});
				
				for (Showtime show : selectHallShowtimes(hall.getId())) {
					MovieRect rect = new MovieRect(show.getMovie().getDuration(), 50, Color.DARK_GRAY);
					rect.setMovieRectModel(show);
					rect.setBounds(calculateXPos(show.getTime()), 25, show.getMovie().getDuration(), 50);
					newPanel.getMovieLine().add(rect);
				}
				
				hallPCont.add(newPanel);
			}
		}
	}
	
	/**
	 * Selezione le proiezioni di una particolare sala tra tutte quelle della giornata
	 * @param cinemaHallID - ID della sala in questione
	 * @return la lista delle proiezioni della sala
	 */
	private LinkedList<Showtime> selectHallShowtimes(char cinemaHallID) {
		LinkedList<Showtime> result = new LinkedList<>();
		for (Showtime showtime : model.getShowList()) {
			if (showtime.getHall().getId() == cinemaHallID)
				result.add(showtime);
		}
		return result;
	}
	
	private int calculateXPos (String time) {
		String[] splitted = time.split(":");
		return (Integer.parseInt(splitted[0].trim()) - 14) * 60 + Integer.parseInt(splitted[1].trim());
	}
}

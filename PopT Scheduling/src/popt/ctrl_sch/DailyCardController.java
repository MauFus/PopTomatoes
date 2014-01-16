package popt.ctrl_sch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

import popt.data.CinemaHall;
import popt.data.Movie;
import popt.data.Showtime;
import popt.gui_sch.DailyCard;
import popt.gui_sch.HallPanel;
import popt.gui_sch.HallPanelContainer;
import popt.gui_sch.MainView;
import popt.gui_sch.MovieInfoDialog;
import popt.gui_sch.MovieLine;
import popt.gui_sch.MovieRect;
import popt.gui_sch.OptionPanel;
import popt.main_sch.Main;
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
	 * 
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
						optPanel.getTxtBarMessage()
								.setText(
										"Errore - Il Gap deve avere un valore intero positivo");
						optPanel.getTxtGap().setText(model.getGap() + " min");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText(
							"Errore - Valore di Gap non nel formato corretto");
					optPanel.getTxtGap().setText(model.getGap() + " min");
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
					if (opening < 3)
						opening += 24; // Per evitare di ragionare con ore 00:00 - 02:00
					int closing = model.getClosing() < 3? model.getClosing()+24 : model.getClosing();
					if (opening < 14 || opening > 26 || opening >= closing) {
						optPanel.getTxtBarMessage()	.setText("Errore - L'Orario di Apertura non è nel range corretto");
						optPanel.getTxtOpeningTime().setText(model.getOpening() + ":00");
					} else {
						model.setOpening(opening % 24);
						optPanel.getTxtBarMessage().setText("");
						optPanel.getTxtOpeningTime().setText((opening % 24) + ":00");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Apertura non nel formato corretto");
					optPanel.getTxtOpeningTime().setText(model.getOpening() + ":00");
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
					int closing = Integer.parseInt(optPanel.getTxtClosingTime().getText());
					if (closing < 3)
						closing += 24; // Per evitare di ragionare con ore 00:00 - 02:00
					int opening = model.getOpening() < 3? model.getOpening()+24 : model.getOpening();
					if (closing < 14 || closing > 26 || closing <= opening) {
						optPanel.getTxtBarMessage().setText("Errore - L'Orario di Chiusura non è nel range corretto");
						optPanel.getTxtClosingTime().setText(model.getClosing() + ":00");
					} else {
						model.setClosing(closing % 24);
						System.out.println("settato - " + closing % 24);
						optPanel.getTxtBarMessage().setText("");
						optPanel.getTxtClosingTime().setText((closing % 24) + ":00");
					}
				} catch (NumberFormatException nfe) {
					optPanel.getTxtBarMessage().setText("Errore - Valore di Orario di Chiusura non nel formato corretto");
					optPanel.getTxtClosingTime().setText(model.getClosing() + ":00");
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

				card.getOptPanel().getTxtBarMessage().setText("");
				
				// itera il validate su ciascuna sala
				for (CinemaHall cinemaHall : model.getHallList()) {
					
					boolean isValidated = true;
					
					// seleziona le proiezioni relative alla sala
					LinkedList<Showtime> hallShowtimes = selectHallShowtimes(cinemaHall.getId());
					
					// Controllo sull'ora di inizio
					for (Showtime show : hallShowtimes) {
						if (calculateXPos(show.getTime()) < (model.getOpening() > 13? model.getOpening()-14 : model.getOpening()+10)*60) {
							isValidated = false;
							break;
						}
					}
					
					// Controllo sull'ora di fine
					if (isValidated) {
						for (Showtime show : hallShowtimes) {
							System.out.println(model.getClosing());
							System.out.println("Upper bound " + (model.getClosing() < 3? model.getClosing()+10 : model.getClosing()-14)*60);
							if (calculateXPos(show.getTime())+show.getMovie().getDuration() > 
									(model.getClosing() < 3? model.getClosing()+10 : model.getClosing()-14)*60) {
								isValidated = false;
								break;
							}
						}
					}
					
					// Controllo su gap e sovrapposizioni
					if (isValidated && hallShowtimes.size() > 1) {
						for (int i = 0; i < hallShowtimes.size()-1; i++) {
							for (int j = i+1; j < hallShowtimes.size(); j++) {
								int start1 = calculateXPos(hallShowtimes.get(i).getTime());
								int start2 = calculateXPos(hallShowtimes.get(j).getTime());
								int finish1 = calculateXPos(hallShowtimes.get(i).getTime()) + hallShowtimes.get(i).getMovie().getDuration();
								int finish2 = calculateXPos(hallShowtimes.get(j).getTime()) + hallShowtimes.get(j).getMovie().getDuration();
								
								// caso: sovrapposizione
								if ((start1 < start2 && finish1 > start2) || (start2 < start1 && finish2 > start1)) {
									isValidated = false;
									System.out.println("A - Sala " + cinemaHall.getId() + " - isValidated " + isValidated);
									break;
								}
								
								//caso: gap non rispettato
								if ((start1 > finish2 && (start1 - finish2 < model.getGap())) 
										|| (start2 > finish1 && (start2 - finish1 < model.getGap()))) {
									isValidated = false;
									System.out.println("C - Sala " + cinemaHall.getId() + " - isValidated " + isValidated);
									break;
								}
							}
							
							if (!isValidated)
								break;
						}
					}

					System.out.println("Sala " + cinemaHall.getId() + " - isValidated " + isValidated);
					for (int h = 0; h < card.getHallPCont().getComponentCount(); h++) {
						if (((HallPanel)card.getHallPCont().getComponent(h)).getCinemaHallID() == cinemaHall.getId())
							if (!isValidated)
								((HallPanel)card.getHallPCont().getComponent(h)).getTxtpnHall().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
							else
								((HallPanel)card.getHallPCont().getComponent(h)).getTxtpnHall().setBorder(BorderFactory.createEmptyBorder());
					}
					if (!isValidated)
						card.getOptPanel().getTxtBarMessage().setText("Sono stati riscontrati errori in fase di validazione");
				}
			}
		});

		optPanel.getBtnReset().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.getOptPanel().getTxtBarMessage().setText("");
		        model.setShowList(Main.searchShowtimes(new Showtime(0l, null, null, model.getDate(), "")));
				card.getHallPCont().removeAll();
				addHallPanels(card.getHallPCont());
			}
		});
	}

	/**
	 * Aggiunge un HallPanel per ogni sala del cinema
	 * 
	 * @param hallPCont
	 */
	private void addHallPanels(HallPanelContainer hallPCont) {
		if (model.getHallList() != null) {
			for (CinemaHall hall : model.getHallList()) {
				final HallPanel newPanel = new HallPanel();
				newPanel.setCinemaHallID(hall.getId());
				newPanel.getTxtpnHall().setText(hall.getName());

				Vector<String> comboBoxList = new Vector<>();
				comboBoxList.add("Insert a showtime...");
				for (Movie m : model.getMovieList()) {
					String title = m.getTitle() + " (" + m.getDuration() + "')";
					if (title.length() > 24)
						title = title.substring(0, 23) + "...";
					comboBoxList.add(title);
				}
				newPanel.getComboBoxMovie().setModel(new DefaultComboBoxModel<>(comboBoxList));
				newPanel.getComboBoxMovie().addActionListener(
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (newPanel.getComboBoxMovie().getSelectedIndex() > 0) {
									String selected = newPanel.getComboBoxMovie()
											.getItemAt(newPanel.getComboBoxMovie().getSelectedIndex());
									if (selected.contains("("))
										selected = selected.split("\\(")[0].trim();
									else if (selected.endsWith("..."))
										selected = selected.substring(0, selected.indexOf(".")-1);
									Showtime newShow = new Showtime();
									newShow.setId(-1);
									for (Movie movie : model.getMovieList()) {
										if (movie.getTitle().startsWith(selected)) {
											newShow.setMovie(movie);
											break;
										}
									}
									CinemaHall currentHall = null;
									for (CinemaHall hall : model.getHallList()) {
										if (hall.getId() == newPanel.getCinemaHallID()) {
											currentHall = hall;
											newShow.setHall(hall);
											break;
										}
									}
									newShow.setDate(model.getDate());
									newShow.setTime(((int)((720-newShow.getMovie().getDuration()) / 60)+14) + ":00");
									newShow.setAuditors(0);
									model.getShowList().add(newShow);

									addMovieRect(currentHall,newPanel.getMovieLine());
								}
							}
						});

				addMovieRect(hall, newPanel.getMovieLine());
				hallPCont.add(newPanel);
			}
		}
	}

	/**
	 * Aggiunge le proiezioni di un giorno-sala alla linea temporale
	 * 
	 * @param hall
	 * @param line
	 */
	private void addMovieRect(CinemaHall hall, MovieLine line) {

		line.removeAll();
		for (Showtime show : selectHallShowtimes(hall.getId())) {
			int a = show.getMovie().getGenre().ordinal();
			Color col=null;
			switch (a) {
			case 0:
				col = new Color(100, 0, 0);
				break;
			case 1:
				col = new Color(0, 100, 0);
				break;
			case 2:
				col = new Color(0, 0, 100);
				break;
			case 3:
				col = new Color(100, 100, 0);
				break;
			case 4:
				col = new Color(100, 0, 100);
				break;
			case 5:
				col = new Color(0, 100, 100);
				break;
			case 6:
				col = new Color(50, 0, 0);
				break;
			case 7:
				col = new Color(0, 50, 0);
				break;
			case 8:
				col = new Color(0, 0, 50);
				break;
			case 9:
				col = new Color(50, 50, 0);
				break;
			case 10:
				col = new Color(50, 0, 50);
				break;
			case 11:
				col = new Color(0, 50, 50);
				break;
			case 12:
				col = new Color(100, 50, 0);
				break;
			case 13:
				col = new Color(100, 0, 50);
				break;
			case 14:
				col = new Color(0, 100, 50);
				break;
			case 15:
				col = new Color(0, 50, 100);
				break;
			case 16:
				col = new Color(50, 100, 0);
				break;
			case 17:
				col = new Color(50, 0, 100);
				break;
			case 18:
				col = new Color(100, 100, 50);
				break;
			case 19:
				col = new Color(100, 50, 50);
				break;

			default:
				break;
			}
			final MovieRect rect = new MovieRect(show.getMovie().getDuration(),
					50, col);
			
			rect.setMovieRectModel(show);
			rect.setBounds(calculateXPos(show.getTime()), 25, show.getMovie()
					.getDuration(), 50);

			rect.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					rect.setText(rect.getMovieRectModel().getMovie().getTitle());
					rect.setBounds(rect.getX(), rect.getY(), rect.getWidth(),
							rect.getHeight());
					// setta l'orario di inizio nell'oggetto showtime
					rect.getMovieRectModel().setTime(
							(14 + rect.getX() / 60) + ":" + (rect.getX() % 60));

				}

				@Override
				public void mousePressed(MouseEvent e) {
					rect.setxOld(e.getX());
					rect.setText(((14 + rect.getX() / 60) % 24) + ":"
							+ (rect.getX() % 60 < 10 ? "0" : "")
							+ (rect.getX() % 60) + "   "
							+ ((14 + rect.getFinishTime() / 60) % 24) + ":"
							+ (rect.getFinishTime() % 60 < 10 ? "0" : "")
							+ (rect.getFinishTime() % 60));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					rect.setBackground(rect.getColor());
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					rect.setBackground(new Color(
							rect.getColor().getRed() + 100, rect.getColor()
									.getGreen() + 100, rect.getColor()
									.getBlue() + 100));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON3) {
						final MovieInfoDialog mid = new MovieInfoDialog(MainView
								.getGuiFrame());
						mid.setVisible(true);
						mid.getTextTitle().setText(
								rect.getMovieRectModel().getMovie().getTitle());
						mid.getTextSFTime()
								.setText(
										((14 + rect.getX() / 60) % 24)
												+ ":"
												+ (rect.getX() % 60 < 10 ? "0"
														: "")
												+ (rect.getX() % 60)
												+ "           "
												+ ((14 + rect.getFinishTime() / 60) % 24)
												+ ":"
												+ (rect.getFinishTime() % 60 < 10 ? "0"
														: "")
												+ (rect.getFinishTime() % 60));
						mid.getCancelButton().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								mid.setVisible(false);
							}
						});
						
						mid.getDeleteButton().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								model.getShowList().remove(rect.getMovieRectModel());
								mid.setVisible(false);
								
								card.getHallPCont().removeAll();
								addHallPanels(card.getHallPCont());			
							}
						});
						
					}
				}
			});

			rect.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {

				}

				@Override
				public void mouseDragged(MouseEvent e) {
					int xNew = e.getX();
					int xRectOld = rect.getStartTime();

					if (xNew < rect.getxOld() - xRectOld)
						xNew = rect.getxOld() - xRectOld;
					else if (xNew > 720 - (xRectOld + rect.getSize().width - rect
							.getxOld()))
						xNew = 720 - (xRectOld + rect.getSize().width - rect
								.getxOld());

					rect.setLocation(rect.getX() + xNew - rect.getxOld(),
							rect.getY());
					rect.setText(((14 + rect.getX() / 60) % 24) + ":"
							+ (rect.getX() % 60 < 10 ? "0" : "")
							+ (rect.getX() % 60) + "   "
							+ ((14 + rect.getFinishTime() / 60) % 24) + ":"
							+ (rect.getFinishTime() % 60 < 10 ? "0" : "")
							+ (rect.getFinishTime() % 60));
					rect.repaint();
				}
			});

			line.add(rect);
		}
	}

	/**
	 * Selezione le proiezioni di una particolare sala tra tutte quelle della
	 * giornata
	 * 
	 * @param cinemaHallID
	 *            - ID della sala in questione
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

	private int calculateXPos(String time) {
		String[] splitted = time.split(":");
		return (Integer.parseInt(splitted[0].trim()) - 14) * 60
				+ Integer.parseInt(splitted[1].trim());
	}
}

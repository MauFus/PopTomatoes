/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Controller del client di Ticketing
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.ctrl_ticket;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import popt.data.Movie;
import popt.data.Row;
import popt.data.Seat;
import popt.data.SeatStatus;
import popt.data.Showtime;
import popt.gui_ticket.RowPanel;
import popt.gui_ticket.SeatRect;
import popt.gui_ticket.TicketSellView;
import popt.main_ticket.MainTicketing;
import popt.main_ticket.TicketPrinter;
import popt.model_ticket.RectStatus;
import popt.model_ticket.TicketSellModel;

public class TicketSellController {
	
	private TicketSellModel model;
	private TicketSellView view;
	private Hashtable<Integer, RowPanel> rowPanels;

	public TicketSellController(TicketSellModel model, TicketSellView view) {
		this.model = model;
		this.view = view;
		this.rowPanels = new Hashtable<>();
		
		model.setComingShowtimes(MainTicketing.getCurrentShowtimeList());
		model.setComingMovies(model.findCurrentMovies());
		initInterfaceAndListeners();
	}

	private void initInterfaceAndListeners() {

		Vector<String> comboBoxList2 = new Vector<>();
		comboBoxList2.add("Select a Showtime!");
		view.getDateBox().setModel(new DefaultComboBoxModel<>(comboBoxList2));
		
		Vector<String> comboBoxList = new Vector<>();
		comboBoxList.add("Select a Movie!");
		if (!model.getComingMovies().isEmpty()) {
			for (Movie m : model.getComingMovies()) {
				comboBoxList.add(m.getTitle());
			}
		}
		view.getTitleBox().setModel(new DefaultComboBoxModel<>(comboBoxList));
		view.getTitleBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTitleBox().getSelectedIndex() > 0) {
					String selected = view.getTitleBox().getItemAt(view.getTitleBox().getSelectedIndex()).trim();
					
					if (!model.getComingMovies().isEmpty()) {
						for (Movie movie : model.getComingMovies()) {
							if (movie.getTitle().startsWith(selected)) {
								model.getCurrentShowtime().setMovie(movie);
								break;
							}
						}
					}
					
					Vector<String> comboBoxList2 = new Vector<>();
					comboBoxList2.add("Select a Showtime!");
					if (!model.getComingShowtimes().isEmpty()) {
						for (Showtime show : model.getComingShowtimes()) {
							if (show.getMovie().equals(model.getCurrentShowtime().getMovie()))
								comboBoxList2.add(show.getDate() + "_" + show.getTime());
						}
					}
					view.getDateBox().setModel(new DefaultComboBoxModel<>(comboBoxList2));
				} else {
					model.setCurrentShowtime(new Showtime());
					Vector<String> comboBoxList2 = new Vector<>();
					comboBoxList2.add("Select a Showtime!");
					view.getDateBox().setModel(new DefaultComboBoxModel<>(comboBoxList2));
				}

			}
		});
		
		view.getDateBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getDateBox().getSelectedIndex() > 0) {
					String selected = view.getDateBox().getItemAt(view.getDateBox().getSelectedIndex());
					String date = selected.split("_")[0].trim();
					String time = selected.split("_")[1].trim();
					
					if (!model.getComingShowtimes().isEmpty()) {
						for (Showtime show : model.getComingShowtimes()) {
							if (show.getMovie().equals(model.getCurrentShowtime().getMovie())
									&& show.getDate().equals(date) && show.getTime().equals(time)){
								model.setCurrentShowtime(show);
								break;
							}
						}
					}
				}
			}
		});
		
		view.getEditNumberOfTickets().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					int n = Integer.parseInt(view.getEditNumberOfTickets().getText());
					if (n > 0) {
						model.setTotSeats(n);
						view.getTxtpnErrors().setText("");
						view.getEditNumberOfTickets().setBorder(BorderFactory.createEmptyBorder());
					} else {
						view.getEditNumberOfTickets().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						view.getTxtpnErrors().setText("Inserted input is not valid!");
					}

				} catch (NumberFormatException nfe) {
					if (!view.getEditNumberOfTickets().getText().equals("")) {
						view.getEditNumberOfTickets().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						view.getTxtpnErrors().setText("Inserted input is not valid!");
					} else {
						model.setTotSeats(0);
						view.getEditNumberOfTickets().setBorder(BorderFactory.createEmptyBorder());
					}
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				view.getEditNumberOfTickets().setBorder(BorderFactory.createEmptyBorder());
				view.getTxtpnErrors().setText("");
			}
		});
		
		view.getEditSpecialSeats().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					int n = Integer.parseInt(view.getEditSpecialSeats().getText());
					if (n >= 0) {
						model.setSpecialSeats(n);
						view.getTxtpnErrors().setText("");
					} else {
						view.getEditSpecialSeats().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						view.getTxtpnErrors().setText("Inserted input is not valid!");
					}
						
				} catch (NumberFormatException nfe) {
					if (!view.getEditSpecialSeats().getText().equals("")) {
						view.getEditSpecialSeats().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						view.getTxtpnErrors().setText("Inserted input is not valid!");
					} else {
						model.setSpecialSeats(0);
						view.getEditSpecialSeats().setBorder(BorderFactory.createEmptyBorder());
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				view.getEditSpecialSeats().setBorder(BorderFactory.createEmptyBorder());
				view.getTxtpnErrors().setText("");
			}
		});
		
		view.getSearchButt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTitleBox().getSelectedIndex() > 0 && view.getDateBox().getSelectedIndex() > 0
						&& model.getCurrentShowtime() != null && model.getTotSeats() > 0) {

					Seat[] suggested = MainTicketing.searchRaccomendedSeats(model.getCurrentShowtime(), model.getTotSeats());
					if (suggested.length == model.getTotSeats()*2) {
						Seat[] first = new Seat[model.getTotSeats()];
						Seat[] second = new Seat[model.getTotSeats()];
						for (int i = 0; i < model.getTotSeats(); i++) {
							first[i] = suggested[i];
							second[i] = suggested[i + model.getTotSeats()];
						}
						model.setSolution1(first);
						model.setSolution2(second);
						view.getTxtpnErrors().setText("Choose a suggested solution or proceed with manual selection.");
					} else if (suggested.length == model.getTotSeats()) {
						model.setSolution1(suggested);
						view.getTxtpnErrors().setText("Only one solution found!");
					} else
						view.getTxtpnErrors().setText("No solution found! Proceed with manual selection.");
					
					if (model.getSpecialSeats() > 0) {
						int[] special = MainTicketing.searchSpecialSeats(model.getCurrentShowtime(), model.getSpecialSeats());
						if (special != null)
							model.setSpecialSolution(special);
						else
							view.getTxtpnErrors().setText("Error - Number of special seats not available.");
					}
					
					model.setRowList(MainTicketing.getShowtimeTicketing(model.getCurrentShowtime()));
					if (!model.getRowList().isEmpty()) {
						diplayTicketingStatus(model.getRowList());
					}
				} else
					view.getTxtpnErrors().setText("There are some problems with the research... Check your inputs, please.");
			}
		});
		
		view.getManualButt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTitleBox().getSelectedIndex() > 0 && view.getDateBox().getSelectedIndex() > 0
						&& model.getCurrentShowtime() != null) {

					if (model.getSpecialSeats() > 0) {
						int[] special = MainTicketing.searchSpecialSeats(model.getCurrentShowtime(), model.getSpecialSeats());
						if (special != null)
							model.setSpecialSolution(special);
						else
							view.getTxtpnErrors().setText("Error - Number of special seats not available.");
					}
					
					model.setRowList(MainTicketing.getShowtimeTicketing(model.getCurrentShowtime()));
					if (!model.getRowList().isEmpty()) {
						diplayTicketingStatus(model.getRowList());
					}
				} else
					view.getTxtpnErrors().setText("There are some problems with the research... Check your inputs, please.");
			}
		});
		
		view.getAcceptButt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.getSpecialSeats());
				if (model.getSpecialSeats() > 0) {
					if (model.getSpecialSolution() == null || model.getSpecialSolution().length != model.getSpecialSeats()) {
						int[] special = MainTicketing.searchSpecialSeats(model.getCurrentShowtime(), model.getSpecialSeats());
						if (special != null) {
							model.setSpecialSolution(special);
						}
					}
					
					if (model.getSpecialSolution() != null) {
						for (int i = 0; i < model.getSpecialSolution().length; i++) {
							System.out.println(model.getSpecialSolution()[i]);
							MainTicketing.sellSpecialSeat(model.getCurrentShowtime(), model.getSpecialSolution()[i]);
							new TicketPrinter(model.getCurrentShowtime(), new Seat(0, model.getSpecialSolution()[i])).print();
						}
					} else {
						view.getTxtpnErrors().setText("Error - Number of special seats not available.");
						return;
					}
				}
				
				switch (model.getSolutionIndex()) {
					case 1 :
						MainTicketing.sellSeats(model.getCurrentShowtime(), model.getSolution1());
						view.getTxtpnErrors().setText("Tickets sell!");
						for (int j = 0; j < model.getSolution1().length; j++)
							new TicketPrinter(model.getCurrentShowtime(), model.getSolution1()[j]).print();
						resetInterface();
						break;
					case 2 :
						MainTicketing.sellSeats(model.getCurrentShowtime(), model.getSolution2());
						view.getTxtpnErrors().setText("Tickets sell!");
						for (int j = 0; j < model.getSolution2().length; j++)
							new TicketPrinter(model.getCurrentShowtime(), model.getSolution2()[j]).print();
						resetInterface();
						break;
					case 3 :
						if (!model.getSolutionCustom().isEmpty()) {
							Seat[] solution = new Seat[model.getSolutionCustom().size()];
							for (int i = 0; i < model.getSolutionCustom().size(); i++)
								solution[i] = model.getSolutionCustom().get(i);
							MainTicketing.sellSeats(model.getCurrentShowtime(), solution);
							view.getTxtpnErrors().setText("Tickets sell!");
							for (int j = 0; j < solution.length; j++)
								new TicketPrinter(model.getCurrentShowtime(), solution[j]).print();
							resetInterface();
						} else
							view.getTxtpnErrors().setText("Error - No solution selected!");
						break;
					default :
						view.getTxtpnErrors().setText("Error - No solution selected!");
						break;
				}
			}
		});
		
		view.getCancelButt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTitleBox().getSelectedIndex() > 0 && view.getDateBox().getSelectedIndex() > 0
						&& model.getCurrentShowtime() != null) {
					model.setRowList(MainTicketing.getShowtimeTicketing(model.getCurrentShowtime()));
					if (!model.getRowList().isEmpty()) {
						diplayTicketingStatus(model.getRowList());
					}
				} else
					view.getTxtpnErrors().setText("There are some problems with the research... Check your inputs, please.");
			}
		});
	}

	/**
	 * genera la schermata dello stato di vendita biglietti della sala
	 * @param rowList
	 */
	private void diplayTicketingStatus(LinkedList<Row> rowList) {
		
		view.getTextHeader().setText(model.getCurrentShowtime().getDate() + " " + model.getCurrentShowtime().getTime() + " - "
				+ model.getCurrentShowtime().getHall().getName() + " - " + model.getCurrentShowtime().getMovie().getTitle());
		
		view.getHallViewer().removeAll();
		view.getHallViewer().revalidate();
		LinkedList<Row> orderedList = orderRows(rowList);

		GridBagLayout gbl_HallViewer = new GridBagLayout();
		gbl_HallViewer.columnWidths = new int[]{30, 570};
		gbl_HallViewer.rowHeights = new int[orderedList.size()];
		for (int s = 0; s < orderedList.size(); s++)
			gbl_HallViewer.rowHeights[s] = 22;
		gbl_HallViewer.columnWeights = new double[]{0.0, 0.0};
		gbl_HallViewer.rowWeights = new double[]{0.0};
		view.getHallViewer().setLayout(gbl_HallViewer);
		
		for (int i = 0; i < orderedList.size(); i++) {
			
			// Aggiunge i numeri di fila
			JTextPane txtpnRowNumber = new JTextPane();
			txtpnRowNumber.setBackground(new Color(179,202,225));
			txtpnRowNumber.setText(Integer.toString(orderedList.get(i).getNumber()));
			GridBagConstraints gbc_txtpnRowNumber = new GridBagConstraints();
			gbc_txtpnRowNumber.insets = new Insets(0, 0, 0, 0);
			gbc_txtpnRowNumber.fill = GridBagConstraints.BOTH;
			gbc_txtpnRowNumber.gridx = 0;
			gbc_txtpnRowNumber.gridy = i;
			view.getHallViewer().add(txtpnRowNumber, gbc_txtpnRowNumber);

			// Aggiunge le file con i posti
			RowPanel panel = new RowPanel();
			for (int j = 0; j < orderedList.get(i).getSeats(); j++) {
				final SeatRect sr = new SeatRect(orderedList.get(i).getNumber(), j + 1);
				sr.setSuggest(false);
				// Se il posto non è occupato, viene marcato come assegnabile
				if (orderedList.get(i).getStatus()[j].equals(SeatStatus.LIBERO)) {
					sr.setStatus(RectStatus.FREE);
					sr.setSuggest(false);
				}

				if (model.getSolution1() != null) {
					for (int s = 0; s < model.getSolution1().length; s++) {
						if (new Seat(sr.getRowNumber(), sr.getSeatNumber()).equals(model.getSolution1()[s])) {
							sr.setStatus(RectStatus.SUGGESTED);
							sr.setSuggest(true);
						}
					}
				}
				if (model.getSolution2() != null) {
					for (int s = 0; s < model.getSolution2().length; s++) {
						if (new Seat(sr.getRowNumber(), sr.getSeatNumber()).equals(model.getSolution2()[s])) {
							sr.setStatus(RectStatus.SUGGESTED);
							sr.setSuggest(true);
						}
					}
				}
				
				sr.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						switch (sr.getStatus()) {
						case FREE:
							sr.setBackground(new Color(200,200,200));
							break;
						default:
							break;
						}
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						switch (sr.getStatus()) {
						case FREE:
							sr.setBackground(new Color(240,240,240));
							break;
						default:
							break;
						}
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (sr.getStatus().equals(RectStatus.FREE)) {
							// resetta eventuali soluzioni già selezionate
							if (model.getSolutionIndex() == 1) {
								if (model.getSolution1() != null) {
									for (int j = 0; j < model.getSolution1().length; j++) {
										if (rowPanels.containsKey(model.getSolution1()[j].getRow() - 1)) {
											SeatRect temp = (SeatRect) rowPanels.get(model.getSolution1()[j].getRow() - 1)
													.getComponent(model.getSolution1()[j].getSeat()-1);
											temp.setStatus(RectStatus.SUGGESTED);
										}
									}
								}
							} else if (model.getSolutionIndex() == 2) {
								if (model.getSolution2() != null) {
									for (int j = 0; j < model.getSolution2().length; j++) {
										if (rowPanels.containsKey(model.getSolution2()[j].getRow() - 1)) {
											SeatRect temp = (SeatRect) rowPanels.get(model.getSolution2()[j].getRow() - 1)
													.getComponent(model.getSolution2()[j].getSeat()-1);
											temp.setStatus(RectStatus.SUGGESTED);
										}
									}
								}
							}
							
							// Aggiunge il posto alla soluzione custom
							sr.setStatus(RectStatus.CHECKED);
							Seat clicked = new Seat(sr.getRowNumber(), sr.getSeatNumber());
							model.getSolutionCustom().add(clicked);
							model.setSolutionIndex(3);							
							
						} else if (!sr.isSuggest() && sr.getStatus().equals(RectStatus.CHECKED)) {
							// Resetta a libero il posto selezionato
							sr.setStatus(RectStatus.FREE);
							Seat clicked = new Seat(sr.getRowNumber(), sr.getSeatNumber());
							for (Seat s : model.getSolutionCustom()) {
								if (s.equals(clicked))
									model.getSolutionCustom().remove(s);
							}
							if (model.getSolutionCustom().isEmpty())
								model.setSolutionIndex(0);
							
						} else if (sr.getStatus().equals(RectStatus.BUSY)) {
							// Non fa nulla per i posti già occupati
							sr.setStatus(RectStatus.BUSY);
							
						} else if (sr.getStatus().equals(RectStatus.SUGGESTED)) {
							// Setta la soluzione proposta come scelta
							sr.setStatus(RectStatus.CHECKED);
							
							Seat clicked = new Seat(sr.getRowNumber(), sr.getSeatNumber());
							if (model.getSolution1() != null) {
								for (int i = 0; i < model.getSolution1().length; i++) {
									if (model.getSolution1()[i].equals(clicked)) {
										// Il posto selezionato fa parte della Soluzione 1
										model.setSolutionIndex(1);
										for (int j = 0; j < model.getSolution1().length; j++) {
											if (rowPanels.containsKey(model.getSolution1()[j].getRow() - 1)) {
												SeatRect temp = (SeatRect) rowPanels.get(model.getSolution1()[j].getRow() - 1)
														.getComponent(model.getSolution1()[j].getSeat()-1);
												temp.setStatus(RectStatus.CHECKED);
											}
										}

										if (model.getSolution2() != null) {
											for (int j = 0; j < model.getSolution2().length; j++) {
												if (rowPanels.containsKey(model.getSolution2()[j].getRow() - 1)) {
													SeatRect temp = (SeatRect) rowPanels.get(model.getSolution2()[j].getRow() - 1)
															.getComponent(model.getSolution2()[j].getSeat()-1);
													temp.setStatus(RectStatus.SUGGESTED);
												}
											}
										}
										
										if (!model.getSolutionCustom().isEmpty()) {
											for (Seat s : model.getSolutionCustom()) {
												if (rowPanels.containsKey(s.getRow() - 1)) {
													SeatRect temp = (SeatRect) rowPanels.get(s.getRow() - 1).getComponent(s.getSeat()-1);
													temp.setStatus(RectStatus.FREE);
												}
											}
											model.getSolutionCustom().clear();
										}
										break;
									}
								}
							} 
							
							if (model.getSolution2() != null) {
								for (int i = 0; i < model.getSolution2().length; i++) {
									if (model.getSolution2()[i].equals(clicked)) {
										// Il posto selezionato fa parte della Soluzione 2
										model.setSolutionIndex(2);
										for (int j = 0; j < model.getSolution2().length; j++) {
											if (rowPanels.containsKey(model.getSolution2()[j].getRow() - 1)) {
												SeatRect temp = (SeatRect) rowPanels.get(model.getSolution2()[j].getRow() - 1)
														.getComponent(model.getSolution2()[j].getSeat()-1);
												temp.setStatus(RectStatus.CHECKED);
											}
										}

										if (model.getSolution1() != null) {
											for (int j = 0; j < model.getSolution1().length; j++) {
												if (rowPanels.containsKey(model.getSolution1()[j].getRow() - 1)) {
													SeatRect temp = (SeatRect) rowPanels.get(model.getSolution1()[j].getRow() - 1)
															.getComponent(model.getSolution1()[j].getSeat()-1);
													temp.setStatus(RectStatus.SUGGESTED);
												}
											}
										}
										
										if (!model.getSolutionCustom().isEmpty()) {
											for (Seat s : model.getSolutionCustom()) {
												if (rowPanels.containsKey(s.getRow() - 1)) {
													SeatRect temp = (SeatRect) rowPanels.get(s.getRow() - 1).getComponent(s.getSeat()-1);
													temp.setStatus(RectStatus.FREE);
												}
											}
											model.getSolutionCustom().clear();
										}
										break;
									}
								}
							}
							
						} else if (sr.isSuggest() && sr.getStatus().equals(RectStatus.CHECKED)) {
							// Resetta lo stato a Suggerito
							sr.setStatus(RectStatus.SUGGESTED);
							
							Seat clicked = new Seat(sr.getRowNumber(), sr.getSeatNumber());
							if (model.getSolution1() != null) {
								for (int i = 0; i < model.getSolution1().length; i++) {
									if (model.getSolution1()[i].equals(clicked)) {
										// Resetta soluzione scelta a nessuna
										model.setSolutionIndex(0);
										for (int j = 0; j < model.getSolution1().length; j++) {
											if (rowPanels.containsKey(model.getSolution1()[j].getRow() - 1)) {
												SeatRect temp = (SeatRect) rowPanels.get(model.getSolution1()[j].getRow() - 1)
														.getComponent(model.getSolution1()[j].getSeat()-1);
												temp.setStatus(RectStatus.SUGGESTED);
											}
										}
										break;
									}
								}
							} 
							
							if (model.getSolution2() != null) {
								for (int i = 0; i < model.getSolution2().length; i++) {
									if (model.getSolution2()[i].equals(clicked)) {
										// Resetta soluzione scelta a nessuna
										model.setSolutionIndex(0);
										for (int j = 0; j < model.getSolution2().length; j++) {
											if (rowPanels.containsKey(model.getSolution2()[j].getRow() - 1)) {
												SeatRect temp = (SeatRect) rowPanels.get(model.getSolution2()[j].getRow() - 1)
														.getComponent(model.getSolution2()[j].getSeat()-1);
												temp.setStatus(RectStatus.SUGGESTED);
											}
										}
										break;
									}
								}
							}
						}
					}
				});
				
				panel.add(sr);
			}
			
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(0);
			flowLayout.setHgap(0);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = i;
			view.getHallViewer().add(panel, gbc_panel);
			rowPanels.put(i, panel);
		}
		
		view.getHallViewer().revalidate();
		view.getHallViewer().repaint();
	}

	/**
	 * Riordina le file di una sala secondo il numero di fila (crescente)
	 * @param rowList - La lista delle file di una sala
	 * @return un'array di row ordinato
	 */
	private LinkedList<Row> orderRows(LinkedList<Row> rowList) {
		Row[] array = new Row[maxNumber(rowList)];
		for (Row row : rowList) {
			array[row.getNumber()-1] = row;
		}
		LinkedList<Row> list = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
				list.add(array[i]);
		}
		return list;
	}

	/**
	 * Trova il numero massimo di fila
	 * @param rowList - lista di file in cui cercate
	 * @return un intero corrispondente al numero di fila massimo
	 */
	private int maxNumber(LinkedList<Row> rowList) {
		int max = 0;
		for (Row row : rowList) {
			if (row.getNumber() > max)
				max = row.getNumber();
		}
		return max;
	}

	private void resetInterface() {
		view.getHallViewer().removeAll();
		view.getTitleBox().setSelectedIndex(0);
		view.getDateBox().setSelectedIndex(0);
		view.getEditNumberOfTickets().setText("");
		view.getEditSpecialSeats().setText("");
		view.getTextHeader().setText("");
		model.setSolution1(null);
		model.setSolution2(null);
		model.setSolutionCustom(new LinkedList<Seat>());
		model.setSolutionIndex(0);
		model.setCurrentShowtime(new Showtime());
		model.setTotSeats(0);
		model.setSpecialSeats(0);
		model.setSpecialSolution(null);
		model.setRowList(new LinkedList<Row>());
		
		view.revalidate();
		view.repaint();
	}

	/**
	 * @return the model
	 */
	public TicketSellModel getModel() {
		return model;
	}

	/**
	 * @return the view
	 */
	public TicketSellView getView() {
		return view;
	}
}

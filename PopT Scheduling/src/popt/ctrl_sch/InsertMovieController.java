/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Modello per l'interfaccia di Insert Movie
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date November 2013
 */

package popt.ctrl_sch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import popt.data.Genre;
import popt.gui_sch.InsertMovieView;
import popt.main_sch.Main;
import popt.model_sch.InsertMovieModel;

public class InsertMovieController {

	private InsertMovieView view;
	private InsertMovieModel model;

	public InsertMovieController(InsertMovieView v, InsertMovieModel m) {
		view = v;
		model = m;
	}

	/**
	 * Initialize all the listeners on InsertMovieView
	 */
	public void initListeners() {

		/**
		 * Focus Listener on Title TextBox
		 */
		view.getTextTitle().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (view.getTextTitle().getText().compareTo("") == 0) {
					view.getTextTitle().setText("No movie name inserted");
					view.getTextTitle().setForeground(Color.RED);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getTextTitle().setText("");
				view.getTextTitle().setForeground(Color.BLACK);

			}
		});

		/**
		 * Focus Listener on Duration TextBox
		 */
		view.getTextDuration().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if (Integer.parseInt(view.getTextDuration().getText()) <= 0) {
						view.getTextDuration().setText(
								"Duration must be a positive value");
						view.getTextDuration().setForeground(Color.RED);
					}
				} catch (NumberFormatException nfe) {
					view.getTextDuration().setText("Not a Number");
					view.getTextDuration().setForeground(Color.RED);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getTextDuration().setText("");
				view.getTextDuration().setForeground(Color.BLACK);
			}
		});

		/**
		 * Focus listener on Date TextBox
		 */
		view.getTextDate().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		/**
		 * Action listener on Insert Button
		 */
		view.getButtonInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!view.getTextTitle().getText().isEmpty()
							&& (!view.getTextDuration().getText().isEmpty() && Integer
									.parseInt(view.getTextDuration().getText()) > 0)
							&& !view.getTextDate().getText().isEmpty()
							/* TODO && Data è una data*/) {

						model.getMovie()
								.setTitle(view.getTextTitle().getText());
						model.getMovie().setDuration(
								Integer.parseInt(view.getTextDuration()
										.getText()));
						// TODO controllare se Genere funziona correttamente
						model.getMovie().setDate(view.getTextDate().getText());
						model.getMovie().setGenre(
								(Genre) view.getComboBoxGenre()
										.getSelectedItem());
						model.getMovie().setPG(view.getCheckPG().isSelected());
					}
					// TODO invocazione e gestione dell'insert
					boolean success = Main.RequestInsert(model.getMovie());
					if (success) {
						// TODO stampare operazione riuscita o getStatus()
					} else {
						// TODO chiedere errore e stamparlo
					}

				} catch (NumberFormatException nfe) {
					// TODO segnalare che Duration non è un numero
				}
			}
		});
	}
}

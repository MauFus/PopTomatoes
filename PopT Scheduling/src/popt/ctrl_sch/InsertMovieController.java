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

import javax.swing.BorderFactory;

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
		
		initListeners();
	}

	/**
	 * Initialize all the listeners on InsertMovieView
	 */
	private void initListeners() {

		/**
		 * Focus Listener on Title TextBox
		 */
		view.getTextTitle().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (view.getTextTitle().getText().compareTo("") == 0) {
					view.getTextTitle().setText("No movie name inserted");
					view.getTextTitle().setForeground(Color.RED);
					view.getTextTitle().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getTextTitle().setText("");
				view.getTextTitle().setForeground(Color.BLACK);
				view.getTextTitle().setBorder(BorderFactory.createEmptyBorder());
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
						view.getTextDuration().setText("Not Positive");
						view.getTextDuration().setForeground(Color.RED);
						view.getTextDuration().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					}
				} catch (NumberFormatException nfe) {
					view.getTextDuration().setText("NaN");
					view.getTextDuration().setForeground(Color.RED);
					view.getTextDuration().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getTextDuration().setText("");
				view.getTextDuration().setForeground(Color.BLACK);
				view.getTextDuration().setBorder(BorderFactory.createEmptyBorder());
			}
		});

		/**
		 * Focus listener on Date TextBox
		 */
		view.getTextDate().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!isDate(view.getTextDate().getText())) {
					view.getTextDate().setText("Invalid Date!");
					view.getTextDate().setForeground(Color.RED);
					view.getTextDate().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getTextDate().setText("");
				view.getTextDate().setForeground(Color.BLACK);
				view.getTextDate().setBorder(BorderFactory.createEmptyBorder());
			}
		});

		/**
		 * Action listener on Insert Button
		 */
		view.getButtonInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if ((!view.getTextTitle().getText().isEmpty() && 
							!view.getTextTitle().getText().equals("No movie name inserted") 
							&& view.getTextTitle().getForeground() != Color.GRAY)
							&& (!view.getTextDuration().getText().isEmpty() && Integer
									.parseInt(view.getTextDuration().getText()) > 0)
							&& (!view.getTextDate().getText().isEmpty() && isDate(view
									.getTextDate().getText()))) {
						
						model.getMovie()
						.setTitle(view.getTextTitle().getText());
						model.getMovie().setDuration(
								Integer.parseInt(view.getTextDuration()
										.getText()));
						model.getMovie().setDate(view.getTextDate().getText());
						model.getMovie().setGenre(
								(Genre) view.getComboBoxGenre()
								.getSelectedItem());
						model.getMovie().setPG(view.getCheckPG().isSelected());

						// Invocazione e gestione dell'insert
						boolean success = Main.requestInsert(model.getMovie());
						if (success) {
							view.getTextTitle().setText("");
							view.getTextDuration().setText("");
							view.getTextDate().setText("");
							view.getComboBoxGenre().setSelectedIndex(0);
							view.getCheckPG().setSelected(false);
						}

						view.getTextAlert().setText(Main.getServerStatus());
					} else {
						view.getTextAlert().setText(
										"Errore: Alcuni campi non sono completati correttamente!");
					}
				} catch (NumberFormatException nfe) {
					view.getTextAlert().setText(
							"ERRORE - Non tutti i campi sono stati inseriti");
				}
			}
		});
	}

	protected boolean isDate(String d) {
		String[] tokens = d.split("-");
		try {
			int g = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			int a = Integer.parseInt(tokens[2]);

			// check su mese, anno e giorno
			if (g < 1 || g > 31 || m < 1 || m > 12 || a < 1900)
				return false;
			if ((m == 4 || m == 6 || m == 9 || m == 11) && g > 30)
				return false;
			if (m == 2 && g > 29)
				return false;

			return true;

		} catch (Exception e) {
			return false;
		}
	}
}

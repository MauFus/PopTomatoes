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
import java.util.Date;

import popt.data.Genre;
import popt.gui_sch.InsertMovieView;
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
				// TODO Auto-generated method stub

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
				// TODO Inserire controllo prima di modificare il model

				model.getMovie().setTitle(view.getTextTitle().getText());
				model.getMovie().setDuration(
						Integer.parseInt(view.getTextDuration().getText()));
				// TODO controllare se Data e Genere funzionano correttamente
				model.getMovie().setDate(new Date(Long.parseLong(view.getTextDate().getText())));
				model.getMovie().setGenre(
						(Genre) view.getComboBoxGenre().getSelectedItem());
				model.getMovie().setPG(view.getCheckPG().isSelected());
			}
		});
	}
}

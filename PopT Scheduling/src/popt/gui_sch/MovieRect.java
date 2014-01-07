package popt.gui_sch;

import java.awt.Color;

public interface MovieRect {

	  // restituiscono lunghezza e larghezza
	  public int getLength();
	  public int getWidth();
	  // assegnano nuova lunghezza e larghezza
	  public void setLength (int l);
	  public void setWidth (int w);

	  // restituisce il colore
	  public Color getColor();
	  // assegna un nuovo colore
	  public void setColor(Color c);

	  // restituiscono le coordinate dell'angolo di x ed y minima del rettangolo, chiamato "punto di aggancio"
	  public int getMinX();
	  public int getMinY();
	  // assegnano nuove coordinate all'angolo di x ed y minima
	  public void setMinX(int x);
	  public void setMinY(int y);
	
}

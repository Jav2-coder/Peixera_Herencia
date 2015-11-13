package net.jimenez.herencia;

import acm.graphics.GImage;

public class Peix_Fantasma extends Peix {

	/**
	 * Constructor de l'objecte Tauro que hereta del 
	 * objecte abstracte Peix.
	 * 
	 * @param img
	 * @param sex
	 * @param x
	 * @param y
	 */
	public Peix_Fantasma(GImage img, String sex, int x, int y) {
		super(img, sex, x, y);
	}

	/**
	 * Metode que controlara si l'objecte Peix_Fantasma matara 
	 * o es reproduira
	 * 
	 * @param p Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoPeix(Peix p) {

		if (p instanceof Peix_Fantasma) {

			if (this.sexePeixos(p)) {
				return true;
			}
			return false;
		}
		return false;
	}
}

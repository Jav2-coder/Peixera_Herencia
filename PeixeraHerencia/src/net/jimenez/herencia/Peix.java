package net.jimenez.herencia;

import acm.graphics.GImage;

public class Peix extends Animal {

	/**
	 * Constructor de l'objecte Tauro que hereta del 
	 * objecte abstracte Peix.
	 * 
	 * @param img
	 * @param sex
	 * @param x
	 * @param y
	 */
	public Peix(GImage img, String sex, int x, int y) {
		super(img, sex, x, y);
	}

	/**
	 * Metode que controlara si l'objecte Peix_Fantasma matara 
	 * o es reproduira
	 * 
	 * @param a Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoAnimal(Animal a) {

		if (a instanceof Peix) {

			if (this.sexeAnimals(a)) {
				return true;
			}
			return false;
		}
		return false;
	}
}

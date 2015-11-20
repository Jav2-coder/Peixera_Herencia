package net.jimenez.herencia;

import acm.graphics.GImage;

public class Tauro extends Animal {

	/**
	 * Constructor de l'objecte Tauro que hereta del 
	 * objecte abstracte Peix.
	 * 
	 * @param img
	 * @param sex
	 * @param x
	 * @param y
	 */
	public Tauro(GImage img, String sex, int x, int y) {
		
		super(img, sex, x, y);
		
	}

	/**
	 * Metode que controlara si l'objecte Tauro matara o es reproduira
	 * 
	 * @param p Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoAnimal(Animal a) {
		
		if (a instanceof Peix || this.sexeAnimals(a)) {
			return true;
		}
		return false;
	}
}

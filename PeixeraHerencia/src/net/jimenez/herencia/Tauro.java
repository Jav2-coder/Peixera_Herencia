package net.jimenez.herencia;

import acm.graphics.GImage;

public class Tauro extends Peix {

	boolean esTauro = true;
	
	public Tauro(GImage img, String sex, int x, int y) {
		
		super(img, sex, x, y);
		
	}

	@Override
	public boolean matoPeix() {
		// TODO Auto-generated method stub
		return false;
	}
}

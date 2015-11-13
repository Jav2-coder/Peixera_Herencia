package net.jimenez.herencia;

import acm.graphics.GImage;

public class Peix_Fantasma extends Peix {

	public Peix_Fantasma(GImage img, String sex, int x, int y) {
		super(img, sex, x, y);
	}

	@Override
	public boolean matoPeix() {
		
	return true;
	
	}
}

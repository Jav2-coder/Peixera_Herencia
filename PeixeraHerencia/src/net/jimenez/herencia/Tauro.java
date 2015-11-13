package net.jimenez.herencia;

import acm.graphics.GImage;

public class Tauro extends Peix {

	public Tauro(GImage img, String sex, int x, int y) {
		
		super(img, sex, x, y);
		
	}

	@Override
	public boolean matoPeix(Peix p) {
		
		if (p instanceof Peix_Fantasma || this.sexePeixos(p)) {
			return true;
		}
		return false;
	}
}

package net.jimenez.herencia;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

/**
 * 
 * @author Surrui
 *
 */
public abstract class Animal {

	String sexe;
	int movX;
	int movY;
	GImage imatge;
	boolean vida = true;
	boolean reproduccio = true;

	/**
	 * Constructor de l'objecte Peix
	 * 
	 * @param img parametre que dona el valor GImage de "imatge" a l'objecte
	 * Peix
	 * @param sex parametre que dona el valor String de "sexe" a l'objecte Peix
	 * @param x parametre que dona el valor Integer de "movX" a l'objecte Peix
	 * @param y parametre que dona el valor Integer de "movY" a l'objecte Peix
	 */
	public Animal(GImage img, String sex, int x, int y) {

		imatge = img;
		sexe = sex;
		movX = x;
		movY = y;
	}

	/**
	 * Metode que retorna un boolean que comprova si l'objecte Peix pot
	 * reproduirse o no.
	 * 
	 * @return
	 */
	public boolean getRepro() {
		return reproduccio;
	}

	/**
	 * Metode que permet modificar el boolean que comprova si l'objecte Peix pot
	 * reproduirse o no.
	 * 
	 * @param r boolean que modificara si pot o no reproduirse l'objecte Peix.
	 */
	public void setRepro(boolean r) {
		reproduccio = r;
	}

	/**
	 * Metode que retorna l'amplada de la imatge.
	 * 
	 * @return
	 */
	public int widthImg() {
		int w = (int) imatge.getWidth();
		return w;
	}

	/**
	 * Metode que retorna l'alçada de la imatge.
	 * 
	 * @return
	 */
	public int heightImg() {
		int h = (int) imatge.getHeight();
		return h;
	}

	/**
	 * Metode que retorna el String sexe de l'objecte Peix.
	 * 
	 * @return
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * Metode que retorna la posicio Y del GImage del objecte Peix.
	 * 
	 * @return
	 */
	public int getPosY() {
		return (int) imatge.getY();
	}

	/**
	 * Metode que retorna la posicio X del GImage del objecte Peix.
	 * 
	 * @return
	 */
	public int getPosX() {
		return (int) imatge.getX();
	}

	/**
	 * Metode que retorna el boolean que determina si l'objecte Peix es vio o
	 * no.
	 * 
	 * @return
	 */
	public boolean getVida() {
		return vida;
	}

	/**
	 * Metode que modifica el boolean vida de Peix.
	 * 
	 * @param life
	 */
	public void setVida(boolean life) {
		vida = life;
	}

	/**
	 * Metode que retorna true o false al comparar el String sexe de dos
	 * objectes Peix.
	 * 
	 * @param p Objecte Peix que utilitzem per comparar els Strings sexe.
	 * @return
	 */
	public boolean sexeAnimals(Animal a) {

		if (a.getSexe().equals(sexe)) {
			return true;
		}
		return false;
	}

	/**
	 * Metode abstracte que controlara si els objectes s'eliminen o no.
	 * 
	 * @param p Objecte peix que utilitzarem per saber si s'ha d'eliminar
	 * o no al fer la colisio.
	 * @return
	 */
	public abstract boolean matoAnimal(Animal a);
	
	/**
	 * Metode que retorna un GRectangle a partir dels limits de la GImage.
	 * 
	 * @return
	 */
	public GRectangle getRectangle() {
		return imatge.getBounds();
	}

	/**
	 * Metode que mou el GImage del objecte Peix en el canvas.
	 */
	public void movimentAnimal() {
		imatge.move(movX, movY);
	}

	/**
	 * Metode que canvia la direcció de moviment dels objectes Peix.
	 */
	public void canviDireccio() {
		movX = movX * -1;
		movY = movY * -1;
	}

	/**
	 * Metode que posiciona el GImage dins del canvas.
	 * 
	 * @param X Integer que dona el valor al eix X de la GImage
	 * @param Y Integer que dona el valor al eix Y de la GImage
	 */
	public void setPosicio(int X, int Y) {
		imatge.setLocation(X, Y);
	}

	/**
	 * Mètode per girar la imatge quan aquesta surt de la pantalla.
	 */
	public void flipHorizontal() {
        int[][] array = imatge.getPixelArray();
        int height = array.length;
        int width = array[0].length;

        for (int y = 0; y < height; y++) {
            for (int x1 = 0; x1 < width / 2; x1++) {
                int x2 = width - x1 - 1;
                int temp = array[y][x1];
                array[y][x1] = array[y][x2];
                array[y][x2] = temp;
            }
        }
        imatge.setImage(new GImage(array).getImage());
    }	
}

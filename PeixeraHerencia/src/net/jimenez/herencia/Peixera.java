package net.jimenez.herencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GRectangle;

/**
 * 
 * @author Surrui
 *
 */
public class Peixera {

	private static final String[] GENERE = { "mascle", "femella" };

	List<Peix> Peixos;
	List<Peix> Bebes = new ArrayList<Peix>();
	App pantalla;
	Random rnd;
	GRectangle peixera;

	/**
	 * Constructor de l'objecte Peixera
	 * 
	 * @param fish
	 *            parametre que dona el valor List de "Peixos" a l'objecte Peix.
	 * @param a
	 *            parametre que fa referencia al App del programa.
	 */
	public Peixera(List<Peix> fish, App a) {

		Peixos = fish;
		pantalla = a;
	}

	/**
	 * Metode que inicia el programa
	 * 
	 * @return
	 */
	public boolean inici() {

		peixera = new GRectangle(0, 0, pantalla.getWidth(), pantalla.getHeight());

		posicionament();

		while (Peixos.size() > 0) {
			mourePeixos();
			pantalla.pause(5);
			colisioPeixos();
		}

		return true;
	}

	/**
	 * Metode que posiciona totes les GImage de tots els objectes Peix.
	 */
	private void posicionament() {

		rnd = new Random();

		for (int i = Peixos.size() - 1; i >= 0; i--) {

			boolean semafor = true;

			while (semafor) {

				int interseccio = 0;

				int posicio = rnd.nextInt(4);

				if (posicio == 0) {

					int altImg = Peixos.get(i).heightImg();

					Peixos.get(i).setPosicio(0, rnd.nextInt(pantalla.getHeight() - altImg));

				} else if (posicio == 1) {

					int ampImg = Peixos.get(i).widthImg();

					Peixos.get(i).setPosicio(rnd.nextInt(pantalla.getWidth() - ampImg), 0);

				} else if (posicio == 2) {

					int altImg = Peixos.get(i).heightImg();
					int ampImg = Peixos.get(i).widthImg();

					Peixos.get(i).setPosicio(pantalla.getWidth() - ampImg, rnd.nextInt(pantalla.getHeight() - altImg));

				} else {

					int altImg = Peixos.get(i).heightImg();
					int ampImg = Peixos.get(i).widthImg();

					Peixos.get(i).setPosicio(rnd.nextInt(pantalla.getWidth() - ampImg), pantalla.getHeight() - altImg);

				}
				GRectangle peix1 = Peixos.get(i).getRectangle();

				for (int j = 0; j < Peixos.size(); j++) {

					GRectangle peix2 = Peixos.get(j).getRectangle();

					if (i != j && peix1.intersects(peix2)) {
						interseccio++;
					}
				}
				if (interseccio == 0) {
					semafor = false;
				}
			}
			semafor = true;
		}
	}

	/**
	 * Metode que s'encarrega del moviment dels objectes Peix
	 */
	private void mourePeixos() {

		for (int i = 0; i < Peixos.size(); i++) {

			GRectangle peix = Peixos.get(i).getRectangle();

			if (peix.intersects(peixera) && Peixos.get(i).getVida()) {

				Peixos.get(i).movimentPeix();

			} else {

				Peixos.get(i).canviDireccio();
				Peixos.get(i).movimentPeix();

			}
		}
	}

	/**
	 * Metode que s'encarrega de produir el resultat de la colisio dels objectes
	 * Peix i decideix si elminiar els objectes o crear un nou objecte Peix
	 * depenent del seu valor del String sexe.
	 */
	private void colisioPeixos() {

		for (int i = 0; i < Peixos.size(); i++) {

			Peix peix1 = Peixos.get(i);

			Peix peix2 = XocaAmbPeix(peix1);

			if (peix2 == null) {

				// ja pot tornar a tenir sexe
				Peixos.get(i).setRepro(true);

			} else {

				if (peix1 instanceof Peix_Fantasma) {

					boolean matarPeix = peix1.matoPeix(peix2);

					if (matarPeix) {

						peix1.setVida(false);
						peix2.setVida(false);

						peix1.setPosicio(1000, 1000);
						peix2.setPosicio(1000, 1000);

					} else if (!matarPeix && peix2 instanceof Peix_Fantasma) {

						if (peix1.getRepro() && peix2.getRepro()) {

							peix1.setRepro(false);

							String sex = GENERE[rnd.nextInt(2)];

							Peix p = pantalla.crearPeix(sex);

							if (peix1.equals(sex)) {

								int X = peix1.getPosX();
								int Y = peix1.getPosY();
								p.setPosicio(X, Y);

							} else {

								int X = peix2.getPosX();
								int Y = peix2.getPosY();
								p.setPosicio(X, Y);

							}
							Bebes.add(p);
						}
					}
				} else {

					boolean matarPeix = peix1.matoPeix(peix2);

					if (matarPeix) {

						if (peix2 instanceof Tauro) {

							peix1.setVida(false);
							peix2.setVida(false);

							peix1.setPosicio(1000, 1000);
							peix2.setPosicio(1000, 1000);

						} else {

							peix2.setVida(false);

							peix2.setPosicio(1000, 1000);

						}
					} else {
						if (peix1.getRepro() && peix2.getRepro()) {

							peix1.setRepro(false);

							String sex = GENERE[rnd.nextInt(2)];

							Peix p = pantalla.crearTauro(sex);

							if (peix1.equals(sex)) {

								int X = peix1.getPosX();
								int Y = peix1.getPosY();
								p.setPosicio(X, Y);

							} else {

								int X = peix2.getPosX();
								int Y = peix2.getPosY();
								p.setPosicio(X, Y);

							}
							Bebes.add(p);
						}
					}
				}
			}
		}
		netejarPeixera();

		for (int i = Bebes.size() - 1; i >= 0; i--) {

			Peix peix1 = Bebes.get(i);

			Peix peix2 = XocaAmbPeix(peix1);

			if (peix2 == null) {

				Peixos.add(peix1);
				Bebes.remove(i);

			}
		}
	}

	/**
	 * Metode que comprova si hi ha colisio entre els objectes Peix, retornant
	 * un objecte Peix o un null per saber amb quin ha tingut la colisio
	 * l'objecte que pasem per parametre
	 * 
	 * @param peix1
	 * @return
	 */
	private Peix XocaAmbPeix(Peix peix1) {

		GRectangle peix1rect = peix1.getRectangle();

		for (Peix peix2 : Peixos) {

			if (peix2 != peix1) {

				GRectangle peix2rect = peix2.getRectangle();

				if (peix1rect.intersects(peix2rect)) {
					return peix2;
				}
			}
		}
		return null;
	}

	/**
	 * Metode que s'encarrega d'eliminar els objectes Peix que estan morts.
	 */
	private void netejarPeixera() {

		for (int i = Peixos.size() - 1; i >= 0; i--) {

			if (!Peixos.get(i).getVida()) {

				Peixos.remove(i);

			}
		}
	}
}
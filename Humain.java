package allumettes;

import java.util.NoSuchElementException;
import java.util.Scanner;

/** La stratégie humain correspond à la stratégie où on demande à
 * l'utilisateur le nombre d'allumettes
 * à retirer.
 * @author Héloïse Lafargue
 * @version 1
 */
public class Humain implements Strategie {

	private String nom;
	private static Scanner scanner;

	public Humain(String nom) {
		this.scanner = new Scanner(System.in);
		this.nom = nom;
	}
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu
	 * @param jeu le jeu actuel
	 */
	@Override
	public int getPrise(Jeu jeu) throws NoSuchElementException, NumberFormatException,
										IllegalStateException {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);
		int prise = 0;
		String priseStr = "0";
		System.out.print(this.nom + ", combien d'allumettes ? ");
		boolean nbDonne = false;
		while (!nbDonne) {
			try {
				priseStr = this.scanner.next();
				prise = Integer.parseInt(priseStr);
				nbDonne = true;
			} catch (NumberFormatException e) {
				if (priseStr.equals("triche")) {
					nbDonne = true;
					throw new TricheException();
				} else {
					System.out.println("Vous devez donner un entier.");
					System.out.print(this.nom + ", combien d'allumettes ? ");
				}
			}
		}
		return prise;
	}
	@Override
	public String toString() {
		return "humain";
	}
}

package allumettes;

/** Strategie correspond une stratégie.
 * @author Héloïse Lafargue
 * @version 1
 */

public interface Strategie {
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu.
	 * @param jeu le jeu actuel
	 * @return le nombre d'allumette à retirer
	 */
	int getPrise(Jeu jeu) throws CoupInvalideException;
	String toString();
}

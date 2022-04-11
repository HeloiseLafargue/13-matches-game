package allumettes;

/** La stratégie rapide correspond à la stratégie où l’ordinateur prend
 * le maximum d’allumettes possible.
 * @author Héloïse Lafargue
 * @version 1
 */
public class Rapide implements Strategie {

	public Rapide() {
	}
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu
	 * @param jeu le jeu actuel
	 */
	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);
		return Math.min(jeu.PRISE_MAX, jeu.getNombreAllumettes());
	}
	@Override
	public String toString() {
		return "rapide";
	}
}

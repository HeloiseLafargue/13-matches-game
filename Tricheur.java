package allumettes;
/** La stratégie tricheur correspond à la stratégie où le joueur triche.
 * @author Héloïse Lafargue
 * @version 1
 */
public class Tricheur implements Strategie {
	public Tricheur() {
	}
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu.
	 * @param jeu le jeu actuel
	 */
	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		int n = jeu.getNombreAllumettes();
		assert (jeu != null && n > 0);
		System.out.println("[Je triche...]");
		while (n != 2) {
			jeu.retirer(1);
			n = n - 1;
		}
		System.out.println("[Allumettes restantes : 2]");
		return 1;
	}
	@Override
	public String toString() {
		return "tricheur";
	}
}

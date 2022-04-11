package allumettes;
import java.util.Random;

/** La stratégie expert correspond à la stratégie où l’ordinateur
 * joue du mieux qu’il peut.
 * @author Héloïse Lafargue
 * @version 1
 */
public class Expert implements Strategie {

	public Expert() {
	}
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu.
	 * @param jeu le jeu actuel
	 */
	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);
		Random random = new Random();
		int n = jeu.getNombreAllumettes();
		if ((n - 1) % (jeu.PRISE_MAX + 1) == 0) { //mauvaise posture, tirage aléatoire
			return random.nextInt(Math.min(jeu.PRISE_MAX, n)) + 1;
		} else { // l'expert gagne assurément
			return (n - 1) % (jeu.PRISE_MAX + 1);
		}
	}
	@Override
	public String toString() {
		return "expert";
	}
}

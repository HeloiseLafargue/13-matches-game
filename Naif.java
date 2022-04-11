package allumettes;
import java.util.Random;
/** La stratégie naif correspond à la stratégie où l'ordinateur choisit aléatoirement un
 * nombre entre 1 et PRISE_MAX.
 * @author Héloïse Lafargue
 * @version 1
 */
public class Naif implements Strategie {
	public Naif() {
	}
	/** Retourne le nombre d'allumettes que la stratégie prévoit de retirer du jeu
	 * @param jeu le jeu actuel
	 */
	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);
		Random random = new Random();
		return 1 + random.nextInt(Math.min(jeu.PRISE_MAX, jeu.getNombreAllumettes()));
	}
	@Override
	public String toString() {
		return "naif";
	}
}

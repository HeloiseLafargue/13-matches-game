package allumettes;

public class JeuReel implements Jeu {

	private int nbAllumettes;
	//private Arbitre arbitre;

	public JeuReel(int allumettes) {
		this.nbAllumettes =  allumettes;
	}

	/** Retourne le nombre actuel d'allumettes.
	*/
	@Override
	public int getNombreAllumettes() {
		return this.nbAllumettes;
	}

	/** Retire un nombre donné d'allumettes du jeu.
	*/
	@Override
	public void retirer(int prise) throws CoupInvalideException {
		if (prise > PRISE_MAX && this.nbAllumettes > PRISE_MAX) {
			// && arbitre.estConfiant()
			throw new CoupInvalideException(prise, "(> " + PRISE_MAX + ")");
		}
		if (prise > this.nbAllumettes) {
			throw new CoupInvalideException(prise, "(> " + this.nbAllumettes + ")");
		}
		if (prise < 1) {
			throw new CoupInvalideException(prise, "(< " + 1 + ")");
		}
		this.nbAllumettes -= prise;
	}
	public String toString() {
		return "nb_allumettes = " + this.nbAllumettes;
	}
}

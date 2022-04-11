package allumettes;

public class Joueur {
	private String nom;
	private Strategie strategie;

	public Joueur(String nom, Strategie strategie) {
		assert (nom != null && strategie != null);
		this.nom = nom;
		this.strategie = strategie;
	}

	/**Retourne le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}
	/**Retourne le nombre d'allumettes que le joueur retire.
	 */
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);
		return this.strategie.getPrise(jeu);
	}
	/**Retourne la stratégie du joueur.
	 */
	public Strategie getStrategie() {
		return this.strategie;
	}
	/**Modifie la stratégie du joueur.
	 */
	public void setStrategie(Strategie strategie) {
		assert (strategie != null);
		this.strategie = strategie;
	}
	public String couper() {
		return ("Nom : " + this.nom + ", stratégie : " + this.strategie);
	}
	public String toString() {
		return this.nom + " - " + this.strategie.toString();
	}
}

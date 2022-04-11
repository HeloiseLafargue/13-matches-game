package allumettes;
import java.util.NoSuchElementException;

public class Arbitre {
	private Joueur j1;
	private Joueur j2;
	private boolean confiant;

	public Arbitre(Joueur j1, Joueur j2) {
		assert (j1 != null && j2 != null);
		this.j1 = j1;
		this.j2 = j2;
		this.confiant = false;
	}

	/** Obtenir le premier joueur du jeu
	 * @return joueur1
	 */
	public Joueur getJoueur1() {
		return this.j1;
	}
	/** Obtenir le second joueur du jeu
	 * @return joueur2
	 */
	public Joueur getJoueur2() {
		return this.j2;
	}
	/** Obtenir si l'arbitre est confiant
	 * @return confiant
	 */
	public boolean estConfiant() {
		return this.confiant;
	}
	public void setConfiant(boolean confiant) {
		this.confiant = confiant;
	}
	/** Arbitrer une partie de jeu
	 * @param jeu le jeu
	 */
	public void arbitrer(Jeu jeu) {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);

		boolean triche = false;
		boolean tourj1 = true;
		boolean fin = false;

		while (!fin) {
			Joueur joueur = this.j1;
			System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
			if (!tourj1) {
				joueur = this.j2;
			}
			try {
				boolean tourSuivant = false;
				while (!tourSuivant) {
					try {
						Jeu jeuPourJoueur = jeu;
						if (!this.confiant) {
							jeuPourJoueur = new JeuProxy(jeu);
						}
						int prise = joueur.getPrise(jeuPourJoueur);

						String nom = joueur.getNom();
						if (prise == 1 || prise == 0 || prise == -1) {
							System.out.println(nom + " prend " + prise + " allumette.");
						} else {
							System.out.println(nom + " prend " + prise + " allumettes.");
						}
						jeu.retirer(prise);
						tourSuivant = true;
					} catch (TricheException e) {
						try {
							jeu.retirer(1);
							System.out.println("[Une allumette en moins, plus que "
								+ jeu.getNombreAllumettes() + ". Chut !]");
						} catch (CoupInvalideException exc) {
						}
					} catch (NoSuchElementException e) {
						System.out.println("Vous devez donner un entier.");
					} catch (IllegalStateException e) {
						System.out.println("Vous devez donner un entier.");
					}
				}

				System.out.println();
				tourj1 = !tourj1;
				fin = (jeu.getNombreAllumettes() == 0);

			} catch (OperationInterditeException e) {
				System.out.println("Abandon de la partie car " + joueur.getNom()
				+ " triche !");
				triche = true;
				fin = true;
			} catch (CoupInvalideException e) {
				System.out.println("\n Impossible ! Nombre invalide : " + e.getCoup()
				+ " " + e.getProbleme());
			}
		}
		// Retourner le gagnant et le perdant
		if (!triche) {
				Joueur vainqueur = this.j1;
				Joueur perdant = this.j2;
				if (!tourj1) {
					perdant = this.j1;
					vainqueur = this.j2;
				}
				System.out.println(perdant.getNom() + " perd !");
				System.out.println(vainqueur.getNom() + " gagne !");
			}
	}
	public String toString() {
		return "j1 = " + this.j1 + " j2 = " + this.j2;
	}
}

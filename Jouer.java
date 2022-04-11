package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Héloïse Lafargue
 * @version	1
 */
public class Jouer {

	public static final int ALLUMDEB = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
			verifierFormatArgument(args);
			Jeu jeu = new JeuReel(ALLUMDEB);
			int indice = args.length - 2;
			// indice vaut 0 si l'arbitre n'est pas confiant, 1 sinon
			Joueur j1 = setJoueur(args[indice]);
			Joueur j2 = setJoueur(args[indice + 1]);
			Arbitre arbitre = new Arbitre(j1, j2);

			if (indice == 1) { // si on a trois arguments alors l'arbitre est confiant
				arbitre.setConfiant(true);
			}
			arbitre.arbitrer(jeu);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}
	/** Vérifier que le format des entrées est correct. */
	private static void verifierFormatArgument(String[] args) {
		int nbJoueur = 2;
		if (args.length == nbJoueur + 1) {
			if (!args[0].equals("-confiant") | !args[1].contains("@")
					| !args[2].contains("@")) {
				throw new ConfigurationException("Format incorrect des arguments");
			}
		} else {
			if (!args[0].contains("@") | !args[1].contains("@")) {
				throw new ConfigurationException("Format incorrect des arguments");
			}
		}
		//int indice = args.length - 2;
		//if (indice == 1) {
		//	if (!args[indice - 1].equals("-confiant") | !args[indice].contains("@")
		//			| !args[indice + 1].contains("@")) {
		//		throw new ConfigurationException("Format incorrect des arguments");
		//} else {
		//	if(!args[indice].contains("@") | !args[indice + 1].contains("@")) {
		//		throw new ConfigurationException("Format incorrect des arguments");
		//}
	}
	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}
	public static Joueur setJoueur(String chaine) {
		String[] arg = chaine.split("@");
		if (arg.length > 2 | arg[0].length() < 1) {
			throw new ConfigurationException("Mauvaise forme pour " + chaine);
		}
		String nom = arg[0];
		String strategieString = arg[1];
		Strategie strategie = null;
		if (strategieString.equals("humain")) {
			strategie = new Humain(nom);
		} else if (strategieString.equals("rapide")) {
			strategie = new Rapide();
		} else if (strategieString.equals("naif")) {
			strategie = new Naif();
		} else if (strategieString.equals("expert")) {
			strategie = new Expert();
		} else if (strategieString.equals("tricheur")) {
			strategie = new Tricheur();
		} else {
			throw new ConfigurationException("Mauvaise forme pour " + strategieString);
		}
		return (new Joueur(nom, strategie));
	}
}

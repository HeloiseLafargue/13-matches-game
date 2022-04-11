package allumettes;

public class JeuProxy implements Jeu {

	private Jeu jeu;

	public JeuProxy(Jeu jeu) {
		assert (jeu != null);
		this.jeu = jeu;
	}

	protected Jeu getJeu() {
		return this.jeu;
	}

	@Override
	public int getNombreAllumettes() {
		return this.jeu.getNombreAllumettes();
	}

	@Override
	public void retirer(int prise) throws CoupInvalideException {
		throw new OperationInterditeException("triche");
	}
}

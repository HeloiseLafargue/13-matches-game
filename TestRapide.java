package allumettes;
import org.junit.*;
import static org.junit.Assert.*;
/** Classe de test de la classe Rapide héritant de Strategie.
 * @author	Héloïse Lafargue
 * @version 1.0
 */
public class TestRapide {
	private Strategie strategie;
	
	@Before public void setUp() {
		this.strategie = new Rapide();
	}
	@Test public void TesttoString() {
		assertEquals(this.strategie.toString(), "rapide");
	}
	@Test public void TestgetPrise() throws CoupInvalideException {
		assertEquals(this.strategie.getPrise(new JeuReel(2)), 2);
		assertEquals(this.strategie.getPrise(new JeuReel(10)), 3);
		assertEquals(this.strategie.getPrise(new JeuReel(3)), 3);
		assertEquals(this.strategie.getPrise(new JeuReel(1)), 1);
		assertEquals(this.strategie.getPrise(new JeuReel(13)), 3);
	}
}

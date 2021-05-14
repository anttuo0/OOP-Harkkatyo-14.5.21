import java.util.Random;


/**
 * @author Antti Tuominen Nimike luokka on geneerinen yläluokka kaikille nimike
 *         olioille.
 * 
 * 
 * 
 * 
 */

abstract class Nimike {
	/**
	 * @param boolean vapaa String nimi int nimikenumero
	 */
	protected boolean vapaa;
	protected String nimi;
	protected int nimikenumero;

	/**
	 * Luokan konstruktori
	 * 
	 * @param nimi: Tuotteen nimi.
	 * @param tila: Onko nimike vapaa vuokrattavaksi. Konstruktori kutsuu luokassa
	 *              olevaa metodia jolla asetaan Nimikenumero, nimikenumero ei ole
	 *              toistaiseksi käytössä mutta voi olla hyödyllinen Vuokraamon
	 *              laajentuessa.
	 */
	public Nimike(String nimi, boolean tila) {
		this.nimi = nimi;
		this.vapaa = tila;
		this.nimikenumero = asetaNimikenumero();
	}

	/**
	 * Asetus metodi jolla voi antaa tuotteelle nimen.
	 * 
	 * @param nimi
	 */
	public void asetaNimi(String nimi) {
		this.nimi = nimi;
	}

	/**
	 * Havainnointi metodi jolla voi kysyä tuotteen nimeä.
	 * 
	 * @return
	 */
	public String annaNimi() {
		return this.nimi;
	}

	/**
	 * Asetusmetodi jolla asettaa tuotteen tilan vapaaksi (true) tai ei vapaaksi
	 * (false).
	 * 
	 * @param tila metodi palauttaa boolean.
	 */
	public void asetaVapaa(boolean tila) {
		this.vapaa = tila;
	}

	/**
	 * Havainnointimetodi jolla kysyä onko tuote vapaa vuokrattavaksi.
	 * 
	 * @return boolean.
	 */
	public boolean annaVapaa() {
		return vapaa;
	}

	/**
	 * Asetusmetodi jolla asetetaan nimikenumero konstruktorissa.
	 * 
	 * @return int
	 */
	public int asetaNimikenumero() {
		Random nimikenumero = new Random();
		return new Random().nextInt();
	}

	/**
	 * Havainnointimetodi jolla voi tarkistaa nimikenumeron.
	 * 
	 * @return int
	 */
	public int annaNimikenumero() {
		return this.nimikenumero;
	}

	/**
	 * Abstrakti metodi jota käytetään tyypin saamiseksi tulosteeseen.
	 * 
	 * 
	 */
	public abstract String annaTyyppi();

}


/**@author Antti Tuominen

 * Vuokra luokassa on vuokraukseen liittyvät metodit sekä Vuokran konstruktori.
 * Vuokra luokassa asetetaan Vuokra olio uudelle vuokrauksella sekä palautetaan tuote vuokrauksesta. 
 * 
 */



import java.util.Random;

public class Vuokra {
	/*
	 * Vuokraaja Vuokrattava nimike
	 * 
	 * 
	 */

	// atribuutit:
	private String vuokraaja;
	private Nimike nimike;
	private String vuokranumero;

	/**
	 * Luokan konstruktori.
	 * 
	 * @param vuokraaja
	 * @param nimike
	 */
	public Vuokra(String vuokraaja, Nimike nimike) {

		this.vuokraaja = vuokraaja;
		this.nimike = nimike;
		this.vuokranumero = asetaVuokranumero();

	}

	/**
	 * Havainnointimetodi Vuokratun nimikkeen saamiseksi.
	 * 
	 * @return nimike.
	 */
	public Nimike annaVuokrattuNimike() {
		return nimike;
	}

	/**
	 * Asetusmetodi Vuokraajan asettamiseksi.
	 * 
	 * @param vuokraaja
	 */
	public void asetaVuokraaja(String vuokraaja) {
		this.vuokraaja = vuokraaja;
	}

	/**
	 * Havainnointimetodi Vuokraaja saamiseksi.
	 * 
	 * @return
	 */
	public String annaVuokraaja() {
		return vuokraaja;
	}

	
	
	/**
	 * Vuokran palautus metodi, palauttaa nimikkeen vuokralta ja asettaa sen
	 * vapaaksi, vuokrattavaksi uudelleen. Poistaa vuokra Vuokratut ArrayLististä.
	 * 
	 * @param vuokraaja
	 * @return
	 */
	public void asetaPalautus() {
		this.nimike.vapaa = true;
		
		System.out.println("Nimike palautettu.");
		
	}

	/**
	 * Asetusmetodi vuokranumeron asettamiseksi, käytetään konstruktorissa.
	 * 
	 * @return palauttaa vuokranumeron merkkijono muodossa.
	 */
	public String asetaVuokranumero() {
		return String.valueOf(new Random().nextInt(99));
	}

	/**
	 * Havainnointimetodi vuokranumeron saamiseksi.
	 * 
	 * @return palauttaa vuokranumeron merkkijonona.
	 */
	public String annaVuokranumero() {
		return vuokranumero;
	}

}

/**@author Antti Tuominen
 *  Pulkka luokassa on konstruktori jolla voi luoda uuden Pulkka olion.
 *
 */


/**
 * Pulkka -luokka perii Nimike - luokan ja Liukuri -luokan ja on yläluokka
 * Rattikelkka -luokalle.
 */
class Pulkka extends Liukuri {
	/**
	 * Atribuutit: String nimi: boolean vapaa: Peritään Nimike luokasta boolean
	 * naru: Onko pulkassa naru.
	 */
	protected boolean naru;

	/**
	 * Konstruktori
	 * 
	 * @param nimi
	 * @param vapaa
	 * @param naru
	 */
	public Pulkka(String nimi, boolean vapaa, boolean naru) {
		super(nimi, vapaa);
		this.naru = true;

	}

	
	/**
	 * Uudelleen toteutettu metodi yläluokasta Nimike. Käytetään käyttäjälle
	 * näytettävään tulosteeseen.
	 */
	@Override
	public String annaTyyppi() {
		return "Pulkka";
	}
	/*
	 * public void asetaPulkka(boolean vapaa, boolean naru) { this.vapaa = vapaa;
	 * this.naru = naru;
	 * 
	 * }
	 */
}

/**@author Antti Tuominen
 * 
 * Liukuri luokassa on konstruktori jolla voi luoda uuden Liukuri olion.
 */

/**
 * Liukuri -luokka perii Nimike -luokan ja on yläluokka Pulkka- ja Rattikelkka
 * -luokille.
 */
class Liukuri extends Nimike {
	/**
	 * Atribuutit: String nimi: boolean vapaa: Peritään Nimike luokasta
	 */
	protected boolean vapaa;

	/**
	 * Luokan konstruktori Parametrit peritään yläluokalta Nimike.
	 * 
	 * @param nimi:
	 * @param vapaa:
	 */
	public Liukuri(String nimi, boolean vapaa) {
		super(nimi, vapaa);

	}
	

	/**
	 * Uudelleen toteutettu metodi yläluokasta Nimike. Käytetään käyttäjälle
	 * näytettävään tulosteeseen.
	 */
	@Override
	public String annaTyyppi() {
		return "Liukuri";
	}
}

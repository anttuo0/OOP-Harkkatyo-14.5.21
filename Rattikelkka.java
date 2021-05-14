/**
 * @author Antti Tuominen Rattikelkka -luokka perii Pulkka -luokkan, Liukuri
 *         -luokan ja Nimike -luokan,
 */
class Rattikelkka extends Pulkka {
	/**
	 * Atribuutit: String nimi: boolean vapaa: Peritään Nimike luokasta boolean naru
	 * peritään Pulkka -luokasta.
	 */

	protected boolean jarrut;
	protected boolean ratti;

	/**
	 * Luokan kostruktori
	 * 
	 * @param nimi
	 * @param vapaa
	 * @param naru
	 * @param jarrut
	 */
	public Rattikelkka(String nimi, boolean vapaa, boolean naru, boolean jarrut) {
		super(nimi, vapaa, naru);
		this.jarrut = jarrut;

		
	}

	/**
	 * Uudelleen toteutettu metodi yläluokasta Nimike. Käytetään käyttäjälle
	 * näytettävään tulosteeseen.
	 */
	@Override
	public String annaTyyppi() {
		return "Rattikelkka";
	}

}

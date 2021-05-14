
/**@author Antti Tuominen
*/

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka Vuokraamo sisältää Vuokraamon toiminnallisuudet käyttäjälle. Vuokraamo
 * luokasta voi tehdä vuokrauksia sekä palauttaa vuokratun nimikkeen.
 */

public class Vuokraamo {
	/**
	 * Vuokratut ArrayList sisältää vuokralla olevat Vuokrat(nimike, vuokraaja,
	 * vuokranumero. Vuokratut ArrayList sisältää vuokralla olevat Vuokrat(nimike,
	 * vuokraaja, vuokranumero.
	 */
	static ArrayList<Nimike> Nimikkeet = new ArrayList<>();
	static ArrayList<Vuokra> Vuokratut = new ArrayList<>();

	/**
	 * Main metodin sisällä on ohjelman käyttäjälle näkyvät toiminnallisuudet.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Ohjelman käynnistyksen yhteydessä alustetaan vuokrattavat nimikkeet.
		 * 
		 */

		Liukuri Hidas = new Liukuri("Hidas", true);
		Liukuri Nopea = new Liukuri("Nopea", true);
		Liukuri Laiska = new Liukuri("Leppoisa", true);
		Pulkka Punainen = new Pulkka("Punainen", true, true);
		Pulkka Musta = new Pulkka("Musta", true, true);
		Rattikelkka Turbo = new Rattikelkka("Turbo", true, true, true);
		Rattikelkka Stiga = new Rattikelkka("Stiga", true, true, true);

		/**
		 * Alustetut nimikkeet tallennetaan Nimikkeet ArrayList:aan.
		 */

		
		Nimikkeet.add(Hidas);
		Nimikkeet.add(Nopea);
		Nimikkeet.add(Laiska);
		Nimikkeet.add(Punainen);
		Nimikkeet.add(Musta);
		Nimikkeet.add(Turbo);
		Nimikkeet.add(Stiga);
		String lopetaOhjelma = "lopeta";
		String palautusKomento = "palauta";
		/**
		 * Ohjelma alkaa, käyttäjälle tulostetaan valikko.
		 */

		System.out.println("Tervetuloa vuokraamoon!" + "\n");

		System.out.println("Vuokrattavana tällä hetkellä:");
		/**
		 * Silmukka käy läpi vuokrattavana olevat nimikkeet.
		 * 
		 */
		for (Nimike n : Nimikkeet) {
			if (n.vapaa == true) {

				// public String toString() {
				/**
				 * Tulostaa vapaana olevat nimikkeet indeksinumeron johon selkeyden vuoksi
				 * lisätään yksi, sekä nimikkeen tyyppi
				 * 
				 */
				System.out.println(Nimikkeet.indexOf(n) + 1 + " " + n.annaNimi() + " " + n.annaTyyppi());
				// System.out.println("Valitse yllä olevista tuotteista ja anna tuotteen
				// numero.");
			}
		}
		System.out.println();
		/**
		 * Scanner ottaa vastaan käyttäjän syötteen.
		 */
		Scanner sc = new Scanner(System.in);

		boolean status = false;

		while (!status) {

			while (true) {

				System.out.println("Vuokraa antamalla tuotteen nimi, esim. Hidas");
				System.out.println("Palauta tuote syöttämällä: palauta");
				System.out.println("Sulje ohjelma, kirjoittamalla: lopeta");

				String syote = sc.nextLine();
				/**
				 * Lukijaluokan metodilla tarkistaan syötteen oikeallisuus. jos syöte sisältää
				 * sopivia merkkejä Vuokra asetetaan.
				 */
				status = Lukija.tarkastaTeksti(syote);

				if (syote.equals("lopeta")) {
					System.out.println("Näkemiin!");
					break;

				} else if (syote.equals("palauta")) {
					System.out.println("Anna vuokranumerosi:");
					String vuokranumero = sc.nextLine();

					Vuokraamo.Palauta(vuokranumero);

				} else if (status) {
					Vuokra vuokra = Vuokraa(syote, sc);

					if (vuokra != null) {
						Vuokratut.add(vuokra);
					}

//					} else if (syote.equals("palauta")) {
//						System.out.println("Anna vuokranumerosi:");
//						String vuokranumero = syote;
//						//String vuokranumero.Palauta(vuokranumero);
//						Vuokraamo.Palauta(vuokranumero);

				} else {
					System.out.println("Anna nimi listalta.");
				}

			}

		}
	}

	/**
	 * Metodilla vuokrataan nimike ja asetetaan vuokraaja.
	 * 
	 * @param nimi
	 * @param sc
	 * @return null
	 */
	public static Vuokra Vuokraa(String nimi, Scanner sc) {
		Nimike nimike = etsiNimike(nimi);
		if (nimike == null) {
			System.out.println("Nimikettä ei ole.");
			return null;
		}
		System.out.println("Anna nimi:");
		String vuokraaja = sc.nextLine();
		Vuokra Vuokra = new Vuokra(vuokraaja, nimike);
		System.out.println("Vuokranumerosi on " + Vuokra.annaVuokranumero());
		System.out.println("Kiitos, vuokrauksesi on käsitelty.");
		return Vuokra;
	}

	/**
	 * Metodilla etsitään Nimikelistasta käyttäjän syöttämä nimike jotta se voidaan
	 * palauttaa.
	 *
	 * 
	 * @param nimi
	 * @return nimike
	 */
	public static Nimike etsiNimike(String nimi) {
		for (Nimike nimike : Nimikkeet) {
			if (nimike.annaNimi().equalsIgnoreCase(nimi) && nimike.annaVapaa() == true) {
				return nimike;
			}
		}
		return null;
	}

	/**
	 * Metodilla palautetaan vuokrattu nimike, vuokra poistetaan Vuokratut
	 * ArrayListista.
	 * 
	 * @param vuokranumero
	 * @param sc
	 */
	public static void Palauta(String vuokranumero) {
		Vuokra palautettavaVuokra = etsiPalautettava(vuokranumero);
		if (palautettavaVuokra == null) {
			System.out.println("Sinulla ei ole avointa vuokrausta.");
		} else {
			palautettavaVuokra.asetaPalautus();
			Vuokraamo.Vuokratut.remove(palautettavaVuokra);
			System.out.println("Vuokraamasi tuote on palautettu.");
		}
	}

	// return Vuokra;

	// if vuokranumero --> remove vuokra.
	/**
	 * Etsii Vuokratut ArrayLististä käyttäjän syöttämän vuokranumeron perusteella
	 * vuokran
	 * 
	 * @param vuokranumero
	 * @return
	 */
	public static Vuokra etsiPalautettava(String vuokranumero) {
		for (Vuokra vuokra : Vuokratut) {
			if (vuokra.annaVuokranumero().equalsIgnoreCase(vuokranumero)) {
				return vuokra;
			}
		}
		return null;

	}
}

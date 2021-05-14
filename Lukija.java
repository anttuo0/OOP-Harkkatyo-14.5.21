
/** @author Antti Tuominen
 */
import java.util.Scanner;

/**
 * 
 * Scanneri luokka sisältää scannerit, joiden avulla keskustellaan asiakkaan
 * kanssa. Scanneri luokkassa on metodi jolla tarkistetaan käyttäjän syöttämien
 * merkkijonojen oikeallisuus.
 */
public class Lukija {

	Scanner s = new Scanner(System.in);

	/**
	 * Metodi jolla tarkistetaan käyttäjän syöttämän merkijonon oikeallisuus.
	 * 
	 * @param rivi
	 * @return
	 */
	public static boolean tarkastaTeksti(String rivi) {
		boolean status = true;

		
		// jos rivi ei ole tyhjä. tarkastetaan välilyönnit.

		if (!rivi.isEmpty()) {

			// jos välilyöntejä, ilmoitetaan väärästä syötteestä.
			if (rivi.isBlank()) {
				System.out.println("Syötä kirjaimia, tyhjät merkit eivät ole kelvollisia");
				status = false;
			}
		} else {
			System.out.println("Syötä ainakin yksi merkki");
			status = false;
		}

		return status;

	}
	/*
	 * Metodi jolla tarkistetaan kokonaislukujen oikeallisuus käyttäjän syötteestä.
	 * Metodi ei ole käytössä mutta voisi tulla mahdollisesti tarpeeseen Vuokraamoa
	 * laajennettaessa. 
	 * 
	 * public static int tarkastaLuvut(String rivi) { boolean
	 * status = true;
	 * 
	 * while (true) { String rivi = s.nextLine();
	 * 
	 * try { int luku = Integer.parseInt(rivi); return luku; } catch
	 * (NumberFormatException e) { System.out.println("Anna kelvollinen luku." +
	 * rivi);
	 * 
	 * } s.close(); }
	 * 
	 * }
	 */
}

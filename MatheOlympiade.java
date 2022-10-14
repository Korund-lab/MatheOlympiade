import java.util.Scanner;//Importanweisung für Scanner

public class MatheOlympiade {
	static int fehlerAnzahl;//KLassenvariable soll von allen 4 Rechenmethoden genutzt werden
	static int aufgabenAnzahl;//Aufgabenanzahl wird in der Start-Methode festgelegt und in der generieren-Methode genutzt

	static void starteProgramm() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wie viele Aufgaben willst du lösen?");
		aufgabenAnzahl = scanner.nextInt();//Anzahl der Aufgaben wird in Klassenvariable gespeichert

		System.out.println("Gib den Wertebereich an!");
		int werteBereich = scanner.nextInt();//Wertebereich wird in lokaler Variabler gespeichert
		generiereAufgaben(werteBereich);//Methode wird aufgerufen und Wertebereich wird übergeben
	}

	static void gibInfo() {
		System.out.println("Fehleranzahl: " + fehlerAnzahl);//Konsolenausgabe zur Klassenvariable Fehleranzahl
	}

	static void generiereAufgaben(int werteBereich) {
		int bereich = 0;//lokale Variable speichert die Zufallszahl

		for (int i = 1; i <= aufgabenAnzahl; i++) {
			bereich = (int) (Math.random() * 3);//Zufallszahl wird jedes Mal neu ermittelt
			System.out.println(i + ".Aufgabe");//Konsolenausgabe zur Aufgabenanzahl 1., 2., 3. usw.
			switch (bereich) {
			case 0:
				System.out.println("Addition");//Aufforderung zur Berechnung
				addiere(werteBereich);//addieren-Methode wird aufgerufen und Wertebereich wird übergeben
				break;
			case 1:
				System.out.println("Subtraktion");//Aufforderung zur Subtraktion
				subtrahiere(werteBereich);//subtrahieren-Methode wird aufgerufen und Wertebereich wird übergeben
				break;
			case 2:
				System.out.println("Multipliziere");//Aufforderung zur Multiplikation
				multipliziere(werteBereich);//multiplizieren-Methode wird aufgerufen und Wertebereich wird übergeben
				break;
			default:
				System.out.println("Dividiere");//Aufforderung zur Division
				dividiere(werteBereich);//Dividiere-Methode wird aufgerufen und Wertebereich wird übergeben
				break;
			}
		}
		gibInfo();//Nachdem Schleife komplett durchlaufen wurde, wird die gibInfo() Methode aufgerufen
	}

	static void addiere(int werteBereich) {
		int sumEins = (int) (Math.random() * werteBereich);//Zufallszahl für Summand Eins
		int sumZwei = (int) (Math.random() * werteBereich);//Zufallszahl für Summand Zwei
		int summe = sumEins + sumZwei;//Summe = Summand +  Summand
		Scanner scanner = new Scanner(System.in);//Scanner-Objekt mit Referenzvariable scanner

		while (summe >= werteBereich) {
			sumEins = (int) Math.random() * werteBereich;//neue Zufallszahl
			sumZwei = (int) Math.random() * werteBereich;//neue ZUfallszahl
			summe = sumEins + sumZwei;//neue Summe
		}
		System.out.println(sumEins + "+" + sumZwei);//Konsolenanweisung
		int eingabe = scanner.nextInt();//Eingabe wird durch die Referenzvariable Scanner gespeichert
		if (summe != eingabe) {
			fehlerAnzahl++;//Fehleranzahl wird erhöht
			System.out.println("Falsch");//Feedback falls Ergbebnis falsch ist
		} else {
			System.out.println("Richtig");//Feedback, falls Ergebnis richtig ist
		}
	}

	static void subtrahiere(int werteBereich) {
		int minuend = (int) (Math.random() * werteBereich);
		int subtrahent = (int) (Math.random() * werteBereich);
		int differenz = minuend - subtrahent;
		Scanner scanner = new Scanner(System.in);

		while (subtrahent > minuend) {
			minuend = (int) (Math.random() * werteBereich);
			subtrahent = (int) (Math.random() * werteBereich);
			differenz = minuend - subtrahent;
		}
		System.out.println(minuend + "-" + subtrahent);
		int eingabe = scanner.nextInt();
		if (eingabe != differenz) {
			System.out.println("Falsch");
			fehlerAnzahl++;
		} else {
			System.out.println("Richtig");
		}
	}

	static void multipliziere(int werteBereich) {
		int fakEins = (int) (Math.random() * werteBereich);
		int fakZwei = (int) (Math.random() * werteBereich);
		int produkt = fakEins * fakZwei;
		Scanner scanner = new Scanner(System.in);

		while (produkt > werteBereich) {
			fakEins = (int) (Math.random() * werteBereich);
			fakZwei = (int) (Math.random() * werteBereich);
			produkt = fakEins * fakZwei;
		}
		System.out.println(fakEins + "*" + fakZwei);
		int eingabe = scanner.nextInt();
		if (eingabe != produkt) {
			System.out.println("Falsch");
			fehlerAnzahl++;
		} else {
			System.out.println("Richtig");
		}
	}

	static void dividiere(int werteBereich) {
		int divident = (int) (Math.random() * werteBereich);
		int divisor = (int) (Math.random() * werteBereich) + 1;//Null als Zufallszahl wird ausgeschlossen
		int quotient = divident / divisor;
		Scanner scanner = new Scanner(System.in);

		while (divident % divisor != 0) {
			divident = (int) (Math.random() * werteBereich);
			divisor = (int) (Math.random() * werteBereich) + 1;//Zufallszahl ist größer Null
			quotient = divident / divisor;
		}
		System.out.println(divident + "/" + divisor);
		int eingabe = scanner.nextInt();
		if (eingabe != quotient) {
			System.out.println("Falsch");
			fehlerAnzahl++;
		} else {
			System.out.println("Richtig");
		}
	}

	public static void main(String[] args) {
		starteProgramm();
	}
}

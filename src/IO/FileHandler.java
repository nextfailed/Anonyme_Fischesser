package IO;

import actors.*;
import actors.Leckerbissen;
import de.hsrm.mi.prog2.TextIO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Kümmert sich um das Auslesen der Dateien.
 */
public class FileHandler {

    /**
     * Versucht die Akteure aus der Datei, als Liste auszulesen und erstellte passende {@code Akteur}-Objekte wenn möglich.
     * @param file Zu lesende Datei
     * @return Liste aller Ereignisse in der Szene
     */
    public static ArrayList<Leckerbissen> readAkteureAsList(File file) {
        ArrayList<Leckerbissen> leckerbissenListe = new ArrayList<>();
        try {
            ArrayList<String> fileStream = TextIO.read(file);

            for(String currentLine : fileStream) {
                String[] arguments = splitArguments(currentLine);

                Leckerbissen newLeckerbissen;

                switch(arguments[0].toLowerCase()) {
                    case "fisch":
                        newLeckerbissen = new Fisch(arguments[1], Integer.parseInt(arguments[4]), Esstyp.valueOf(arguments[3]), Integer.parseInt(arguments[5]));
                        leckerbissenListe.add(newLeckerbissen);
                        break;
                    case "schildkroete":
                        newLeckerbissen = new Schildkroete(arguments[1], Integer.parseInt(arguments[4]), Esstyp.valueOf(arguments[3]), Integer.parseInt(arguments[5]));
                        leckerbissenListe.add(newLeckerbissen);
                        break;
                    case "seestern":
                        newLeckerbissen = new Seestern(arguments[1], Integer.parseInt(arguments[4]), Nahrungstyp.valueOf(arguments[2]), Esstyp.valueOf(arguments[3]), Integer.parseInt(arguments[5]));
                        leckerbissenListe.add(newLeckerbissen);
                        break;
                    case "taucher":
                        newLeckerbissen = new Taucher(arguments[1], Integer.parseInt(arguments[2]));
                        leckerbissenListe.add(newLeckerbissen);
                        break;
                    case "muell":
                        newLeckerbissen = new Muell(Integer.parseInt(arguments[1]));
                        leckerbissenListe.add(newLeckerbissen);
                        break;
                    case "seetang":
                        newLeckerbissen = new Seetang(Integer.parseInt(arguments[1]));
                        leckerbissenListe.add(newLeckerbissen);
                    default:
                        //TODO
                        break;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            System.err.printf(e.getMessage());
        }
        return leckerbissenListe;
    }

    /**
     * Versucht die Szene aus der Datei, als Liste auszulesen.
     * @param file Zu lesende Datei
     * @return Liste aller Ereignisse in der Szene
     */
    public static ArrayList<String> readSceneAsList(File file) {
        ArrayList<String> szene = new ArrayList<>();
        try {
            return TextIO.read(file);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            System.err.printf(e.getMessage());
        }
        return szene;
    }

    /**
     * Teilt die Argumente aus einer Zeile der Datei bei jedem ','.
     * @param line Zu teilende Zeile
     * @return Argumente als String[]
     * @throws IllegalArgumentException
     */
    public static String[] splitArguments(String line) throws IllegalArgumentException {
        if(!line.contains(",")) {
            throw new IllegalArgumentException("Argumente wurden nicht mit ',' getrennt.");
        }
        return line.split(",");
    }

    /**
     * Versucht ein {@code Akteur}-Objekt mit dem ersten String im übergebenen Array zu instanziieren.
     * Die anderen Argumente im übergebenen Array werden entsprechend zu den Parametern des Objekts
     * gecastet.
     * @param arguments String-Array, das alle Parameter des zu kreierenden Objekts enthält.
     * @return Instanz eines {@code Akteur}-Objekts
     */
    private static Akteur createAkteur(String[] arguments) {

        try{
            final String PACKAGE_NAME = "actors.";
            String akteurKlasse = arguments[0];
            String akteurName = arguments[1];
            Nahrungstyp akteurNahrungstyp = Nahrungstyp.valueOf(arguments[2]);
            Esstyp akteurEsstyp = Esstyp.valueOf(arguments[3]);
            int akteurGewicht = Integer.parseInt(arguments[4]);
            int akteurAppetitGrenze = Integer.parseInt(arguments[5]);

            Class<?> klasse = Class.forName(PACKAGE_NAME + akteurKlasse);
            Constructor<?> konstruktor = klasse.getDeclaredConstructor(String.class, int.class, Nahrungstyp.class, Esstyp.class, int.class);
            Object akteur = konstruktor.newInstance(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);

            return (Akteur) akteur;
        }
        catch(ClassCastException e) {
            System.err.println("Konnte Klasse nicht zu Akteur-Klasse casten.");
        }
        catch(ClassNotFoundException e) {
            System.err.println("Konnte keine Klasse mit dem Namen '" + arguments[0] + "' finden.");
        }
        catch(NoSuchMethodException e) {
            System.err.println("Die Klasse '" + arguments[0] + "' besitzt keinen passenden Konstruktor.");
        }
        catch(Exception e) {
            System.err.println("Konnte keine Instanz der Klasse '" + arguments[0] + "' mit diesen Parametern erstellen.");
        }

        return null;
    }

    /**
     * Versucht ein Objekt, dass das {@code Leckerbissen}-Interface implementiert,
     * mit dem ersten String im übergebenen Array zu instanziieren.
     * Die anderen Argumente im übergebenen Array werden entsprechend zu den Parametern des Objekts
     * gecastet.
     * @param arguments String-Array, das alle Parameter des zu kreierenden Objekts enthält.
     * @return Instanz eines {@code Leckerbissen}-Objekts
     */
    private static Leckerbissen createSnack(String[] arguments) {
        try {
            final String PACKAGE_NAME = "actors.";
            String leckerbissenKlasse = arguments[0];
            int leckerbissenGewicht = Integer.parseInt(arguments[1]);

            Class<?> klasse = Class.forName(PACKAGE_NAME + leckerbissenKlasse);
            Constructor<?> konstruktor = klasse.getDeclaredConstructor(int.class);
            Object leckerbissen = konstruktor.newInstance(leckerbissenGewicht);

            return (Leckerbissen) leckerbissen;
        }
        catch(ClassCastException e) {
            System.err.println("Konnte Klasse nicht zu Leckerbissen-Klasse casten.");
        }
        catch(ClassNotFoundException e) {
            System.err.println("Konnte keine Klasse mit dem Namen '" + arguments[0] + "' finden.");
        }
        catch(NoSuchMethodException e) {
            System.err.println("Die Klasse '" + arguments[0] + "' besitzt keinen passenden Konstruktor.");
        }
        catch(Exception e) {
            System.err.println("Konnte keine Instanz der Klasse '" + arguments[0] + "' mit Parameter '" + arguments[1] + "' erstellen.");
        }
        return null;
    }
}

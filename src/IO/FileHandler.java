package IO;

import actors.*;
import de.hsrm.mi.prog2.TextIO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<Akteur> readAkteureAsList(File file) {
        ArrayList<Akteur> akteure = new ArrayList<>();
        try {
            ArrayList<String> fileStream = TextIO.read(file);

            for(String currentLine : fileStream) {
                String[] arguments = splitArguments(currentLine);
                Akteur newAkteur = createAkteur(arguments);
                akteure.add(newAkteur);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            System.err.printf(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return akteure;
    }

    public static ArrayList<Object> readSceneAsList(File file) {
        ArrayList<Object> szene = new ArrayList<>();
        try {
            ArrayList<String> fileStream = TextIO.read(file);

            for(String currentLine : fileStream) {
                String[] arguments = splitArguments(currentLine);
                Object leckerbissen = createLeckerbissen(arguments);
                szene.add(leckerbissen);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            System.err.printf(e.getMessage());
        }
        return szene;
    }

    private static String[] splitArguments(String line) throws IllegalArgumentException {
        if(!line.contains(",")) {
            throw new IllegalArgumentException("Argumente wurden nicht mit ',' getrennt.");
        }
        return line.split(",");
    }

    private static Akteur createAkteur(String[] arguments) throws ClassNotFoundException {
        String akteurKlasse = arguments[0];
        String akteurName = arguments[1];
        Nahrungstyp akteurNahrungstyp = Nahrungstyp.valueOf(arguments[2]);
        Esstyp akteurEsstyp = Esstyp.valueOf(arguments[3]);
        int akteurGewicht = Integer.parseInt(arguments[4]);
        int akteurAppetitGrenze = Integer.parseInt(arguments[5]);

        if(akteurKlasse.equalsIgnoreCase("fisch")) {
            return new Fisch(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
        }
        if(akteurKlasse.equalsIgnoreCase("schildkroete")) {
            return new Schildkroete(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
        }
        if(akteurKlasse.equalsIgnoreCase("taucher")) {
            return new Taucher(akteurName, akteurGewicht);
        }
        if(akteurKlasse.equalsIgnoreCase("seestern")) {
            // TODO Seestern
        }
        else {
            throw new ClassNotFoundException("Die Klasse " + akteurKlasse + " wurde nicht gefunden.");
        }

        return null;
    }

    private static Object createLeckerbissen(String[] arguments) {
        try {
            String leckerbissenKlasse = arguments[0];
            int leckerbissenGewicht = Integer.parseInt(arguments[1]);
            Class<?> klasse = Class.forName(arguments[0]);
            Constructor<?> konstruktor = klasse.getDeclaredConstructor(int.class);
            Object leckerbissen = konstruktor.newInstance(leckerbissenGewicht);
            return leckerbissen;
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

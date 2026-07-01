package IO;

import actors.*;
import de.hsrm.mi.prog2.TextIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AkteurCreator {

    public static ArrayList<Akteur> readAkteureAsList(File file) {
        ArrayList<Akteur> akteure = new ArrayList<>();
        try {
            ArrayList<String> fileStream = TextIO.read(file);

            for(String currentLine : fileStream) {
                String[] arguments = splitAkteurArguments(currentLine);
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

    private static String[] splitAkteurArguments(String line) throws IllegalArgumentException {
        if(!line.contains(",")) {
            throw new IllegalArgumentException("Argumente wurden nicht mit ',' getrennt.");
        }
        return line.split(",");
    }

    private static Akteur createAkteur(String[] arguments) throws ClassNotFoundException {
        String akteurName = arguments[1];
        Nahrungstyp akteurNahrungstyp = Nahrungstyp.valueOf(arguments[2]);
        Esstyp akteurEsstyp = Esstyp.valueOf(arguments[3]);
        int akteurGewicht = Integer.parseInt(arguments[4]);
        int akteurAppetitGrenze = Integer.parseInt(arguments[5]);

        String akteurKlasse = arguments[0].trim().toLowerCase();

        return switch(akteurKlasse){
            case "fisch" -> new Fisch(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
            case "schildkroete" -> new Schildkroete(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
            case "taucher" -> new Taucher(akteurName, akteurGewicht);
            case "seestern" -> new Seestern(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);

            default -> throw new ClassNotFoundException("Die Klasse " + akteurKlasse + " wurde nicht gefunden.");
        };

        /*
        if(akteurKlasse.equalsIgnoreCase("fisch")) {
            return new Fisch(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
        }

        else if(akteurKlasse.equalsIgnoreCase("schildkroete")) {
            return new Schildkroete(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
        }

        else if(akteurKlasse.equalsIgnoreCase("taucher")) {
            return new Taucher(akteurName, akteurGewicht);
        }

        else if(akteurKlasse.equalsIgnoreCase("seestern")) {
            return new Schildkroete(akteurName, akteurGewicht, akteurNahrungstyp, akteurEsstyp, akteurAppetitGrenze);
        }

        else {
            throw new ClassNotFoundException("Die Klasse " + akteurKlasse + " wurde nicht gefunden.");
        }
        */

    }

}

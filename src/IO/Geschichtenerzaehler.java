package IO;

import actors.Leckerbissen;
import actors.Meeresbewohner;
import exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Kümmert sich das Schreiben der Geschichte.
 */
public class Geschichtenerzaehler {

    private static final String FILE_PATH_GESCHICHTE = "src/geschichte.txt";

    /**
     * Schreibt den Ablauf der Geschichte in eine Datei, indem die Szene mit den Listen aller vorhandenen Akteure
     * und aller Leckerbissen verglichen wird. Wenn sowohl der Akteur, als auch der Leckerbissen in der Liste vorhanden sind,
     * wird das Ereignis in der Geschichte verzeichnet.
     * <p>
     *     <u>HINWEIS:</u> Auch wenn der Akteur oder Leckerbissen nicht vorhanden ist, wird dies in der Datei vermerkt.
     * </p>
     * @param akteurListe Liste aller vorhandenen Akteure
     * @param szene Liste der Ereignisse
     */
    public static void schreibeGeschichte(ArrayList<Leckerbissen> akteurListe, ArrayList<String> szene) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(alleAkteureToString(akteurListe));
        stringBuilder.append("\n");
        stringBuilder.append("#### Und die Geschichte verläuf wie folgt: #####");
        stringBuilder.append("\n");

        for(String aktuellesEreignis : szene) {
            try {
                String[] ereignisArgumente = FileHandler.splitArguments(aktuellesEreignis);

                String akteurName = ereignisArgumente[0];
                String snackName = ereignisArgumente[1];
                Leckerbissen aktuellerAkteur;
                Leckerbissen aktuellerSnack;

                if(!akteurListe.toString().contains(akteurName)) {
                    throw new UnbekannterAkteurException(akteurName + " befindet sich nicht in diesen Gewässern.");
                }
                else {
                    aktuellerAkteur = getLeckerbissenMitNamen(akteurListe, akteurName);
                }

                if(!akteurListe.toString().contains(snackName)) {
                    throw new UnbekannterLeckerbissenException(snackName + " befindet sich nicht in diesen Gewässern.");
                }
                else {
                    aktuellerSnack = getLeckerbissenMitNamen(akteurListe, snackName);
                }

                // Lass den Akteur den Leckerbissen verspeisen -- oder auch nicht.
                if(aktuellerAkteur instanceof Meeresbewohner) {
                    ((Meeresbewohner) aktuellerAkteur).fressen(aktuellerSnack);
                    stringBuilder.append(akteurName).append(" frisst ").append(snackName).append(".");
                    stringBuilder.append("\n");
                }

            }
            catch(UnbekannterAkteurException | UnbekannterLeckerbissenException | FressException e) {
                stringBuilder.append(e.getMessage());
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("#### Ende der Geschichte! ####");
        stringBuilder.append("\n");
        stringBuilder.append(alleAkteureToString(akteurListe));
        stringBuilder.append("\n");

        File file = new File(FILE_PATH_GESCHICHTE);
        writeFile(stringBuilder, file);
    }

    /**
     * Sucht in der übergebenen Liste das {@code Akteur}-Objekt mit dem übergebenen Namen.
     * @param akteurListe Liste der Akteure
     * @param akteurName Name des Akteurs
     * @return {@code Akteur}-Objekt
     */
    private static Leckerbissen getLeckerbissenMitNamen(ArrayList<Leckerbissen> akteurListe, String akteurName) {
        for(Leckerbissen aktuellerAkteur : akteurListe) {
            if(!aktuellerAkteur.getName().contains(akteurName)) {
                continue;
            }
            return aktuellerAkteur;
        }
        return null;
    }

    /**
     * Schreibt den übergebenen StringBuilder in die übergebene Datei.
     * @param stringBuilder ein StringBuilder
     */
    private static void writeFile(StringBuilder stringBuilder, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String alleAkteureToString(ArrayList<Leckerbissen> akteurListe) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("Alle Akteure und Gegenstände im Ozean:");
        stringBuilder.append("\n");

        for(Leckerbissen aktuellerLeckerbissen : akteurListe) {
            stringBuilder.append(aktuellerLeckerbissen);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

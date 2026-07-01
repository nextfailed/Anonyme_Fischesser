package IO;

import actors.Akteur;
import actors.Leckerbissen;
import exceptions.UnbekannterAkteurException;
import exceptions.UnbekannterLeckerbissenException;

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
    public static void schreibeGeschichte(ArrayList<Akteur> akteurListe, ArrayList<String> szene) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#### START ####");
        stringBuilder.append("\n");

        for(String aktuellesEreignis : szene) {
            try {
                String[] ereignisArgumente = FileHandler.splitArguments(aktuellesEreignis);

                String akteurName = ereignisArgumente[0];
                Akteur aktuellerAkteur;

                if(!akteurListe.toString().contains(akteurName)) {
                    throw new UnbekannterAkteurException(akteurName + " befindet sich nicht in diesen Gewässern.");
                }
                else {
                    aktuellerAkteur = getAkteurMitNamen(akteurListe, akteurName);
                }

                String leckerbissenName = ereignisArgumente[1];
                Leckerbissen aktuellerLeckerbissen;

//                if(!leckerbissenListe.toString().contains(leckerbissenName)) {
//                    throw new UnbekannterLeckerbissenException(leckerbissenName + " befindet sich nicht in diesen Gewässern.");
//                }
//                else {
//                    aktuellerLeckerbissen = getLeckerbissenMitNamen(leckerbissenListe, leckerbissenName);
//                }

                // Lass den Akteur den Leckerbissen verspeisen -- oder auch nicht.
                //TODO
            }
            catch(UnbekannterAkteurException e) {
                stringBuilder.append(e.getMessage());
                stringBuilder.append("\n");
            }
            catch(UnbekannterLeckerbissenException e) {
                stringBuilder.append(e.getMessage());
                stringBuilder.append("\n");
            }

        }

        stringBuilder.append("#### ENDE ####");

        File file = new File(FILE_PATH_GESCHICHTE);
        writeFile(stringBuilder, file);
    }

    /**
     * Sucht in der übergebenen Liste das {@code Akteur}-Objekt mit dem übergebenen Namen.
     * @param akteurListe Liste der Akteure
     * @param akteurName Name des Akteurs
     * @return {@code Akteur}-Objekt
     */
    private static Akteur getAkteurMitNamen(ArrayList<Akteur> akteurListe, String akteurName) {
        for(Akteur aktuellerAkteur : akteurListe) {
            if(!aktuellerAkteur.toString().contains(akteurName)) {
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
}

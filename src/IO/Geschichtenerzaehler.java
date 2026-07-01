package IO;

import actors.Akteur;
import actors.Leckerbissen;
import exceptions.UnbekannterAkteurException;
import exceptions.UnbekannterLeckerbissenException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Geschichtenerzaehler {

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
            }
            catch(UnbekannterLeckerbissenException e) {
                stringBuilder.append(e.getMessage());
            }
            finally {
                try {
                    FileWriter fileWriter = new FileWriter("geschichte.txt");
                    fileWriter.append(stringBuilder);
                    fileWriter.close();
                }
                catch(IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private static Akteur getAkteurMitNamen(ArrayList<Akteur> akteurListe, String akteurName) {
        for(Akteur aktuellerAkteur : akteurListe) {
            if(!aktuellerAkteur.toString().contains(akteurName)) {
                continue;
            }
            return aktuellerAkteur;
        }
        return null;
    }
}

import java.io.File;
import java.util.ArrayList;

import IO.FileHandler;
import actors.Akteur;
import actors.Leckerbissen;

public class Meer {

    public static void main(String[] args) {

        File akteureDatei = new File(args[0]);
        File szeneDatei = new File(args[1]);

        ArrayList<Akteur> akteure = FileHandler.readAkteureAsList(akteureDatei);
        ArrayList<Leckerbissen> leckerbissens = FileHandler.readSceneAsList(szeneDatei);
    }
}
import java.io.File;
import java.util.ArrayList;

import IO.AkteurCreator;
import actors.Akteur;

public class Meer {

    public static void main(String[] args) {

        File akteureDatei = new File(args[0]);
//        File szeneDatei = new File(args[1]);

        ArrayList<Akteur> akteure = AkteurCreator.readAkteureAsList(akteureDatei);
    }
}
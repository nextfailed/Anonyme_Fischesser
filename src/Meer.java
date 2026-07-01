import java.io.File;
import java.util.ArrayList;

import IO.*;
import actors.Leckerbissen;

public class Meer {

    public static void main(String[] args) {

        File akteureDatei = new File(args[0]);
        File szeneDatei = new File(args[1]);

        ArrayList<Leckerbissen> akteure = FileHandler.readAkteureAsList(akteureDatei);
        ArrayList<String> szene = FileHandler.readSceneAsList(szeneDatei);

        Geschichtenerzaehler.schreibeGeschichte(akteure, szene);
    }
}
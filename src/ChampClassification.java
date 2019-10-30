import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.antlr.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Scanner;

import static sun.misc.Version.print;

public class ChampClassification {

    public static void main(String args[]){

        try {
            File arquivoFis = new File(ChampClassification.class.getResource("champClassification.flc").toURI());

            String conteudoArquivoFis = new String(Files.readAllBytes(arquivoFis.toPath()));
            FIS fis = FIS.createFromString(conteudoArquivoFis, true);

            fis.setVariable("damage", 1.0);
            fis.setVariable("resistance", 1.0);
            fis.setVariable("reach", 1.0);
            fis.setVariable("utility", 1.0);

            fis.evaluate();

            Variable resultado = fis.getVariable("champclass");

            System.out.println(resultado);

            JFuzzyChart.get().chart(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        FIS fis = getFCLFromFile();
//
//        fis.setVariable("damage", 10);
//        fis.setVariable("resistance", 1);
//        fis.setVariable("reach", 10);
//        fis.setVariable("utility", 1);

        // mostra os graficos
//        JFuzzyChart.get().chart(fis);
    }

//    private static FIS getFCLFromFile() {
//
//        // Load from 'FCL' file
//        String fileName = "./src/champClassification.fcl";
//        FIS fis = FIS.load(fileName, true);
//
//        if (fis == null) {
//            System.err.println("Can't load file: '" + fileName + "'");
//            return null;
//        }
//
//        fis.evaluate();
//
//        System.out.println(fis.getVariable("champclass").getValue());
//
//        return fis;
//    }

}

import model.Eveniment;
import parser.XMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String xmlFilePath="fisier.xml";
        XMLParser xmlParser = XMLParser.getInstance();

        List<Eveniment> punkteListe = new ArrayList<>();


        try {

            punkteListe=xmlParser.parseStudents(xmlFilePath);

        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea fișierului  " + e.getMessage());
        }

        //a) lesen von der Datei und auf dem Bildschirm zeigen

        for (Eveniment result : punkteListe) {
            System.out.println(result.toString());
        }


        //b) incepe cu litera data de la tastatura

        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib eine Buchstabe: ");
        String letter = scanner.nextLine();

        for (Eveniment result : punkteListe) {
            if (result.getName().startsWith(letter)) {
                System.out.println(result.getName());

            }
        }


    }
}
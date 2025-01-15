import model.Eveniment;
import model.Haus;
import parser.XMLParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String xmlFilePath = "evenimente.xml";
        XMLParser xmlParser = XMLParser.getInstance();

        List<Eveniment> punkteListe = new ArrayList<>();


        try {

            punkteListe = xmlParser.parseStudents(xmlFilePath);

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


//        //c)sortare
//
//        System.out.print("Die Sortierung : ");
//        punkteListe.sort(Comparator.comparing(Eveniment::getDate));
//
//        for (Eveniment result : punkteListe) {
//            if (result.getHaus() == Haus.STARK) {
//                System.out.println(result.getDate() + " " + result.getName() + " " + result.getEreignis());
//            }
//        }
//
//
//        //d)
//
//        int punktehaus1=0;
//        int punktehaus2=0;
//        int punktehaus3=0;
//        int punktehaus4=0;
//        List<String> ergebnisListe = new ArrayList<>();
//        ergebnisListe.add("Gryffindor#" + punktehaus1);
//        ergebnisListe.add("Hufflepuff#" + punktehaus2);
//        ergebnisListe.add("Ravenclaw#" + punktehaus3);
//        ergebnisListe.add("Slytherin#" + punktehaus4);
//
//        // Sortarea listei în ordine descrescătoare a punctelor
//
////        ergebnisListe.sort((a, b) -> {
////            int puncteA = Integer.parseInt(a.split("#")[1]);
////            int puncteB = Integer.parseInt(b.split("#")[1]);
////            return Integer.compare(puncteB, puncteA); // Ordine descrescătoare
////        });
//
//        //sortatre lista dupa nume
//        ergebnisListe.sort((a, b) -> {
//            String puncteA = a.split("#")[0];
//            String puncteB = b.split("#")[0];
//            return puncteB.compareTo(puncteA); // Ordine descrescătoare
//        });
//
//
//
////scriu in fisier
//        String fileName = "ergebnis.txt";
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (String ergebnis : ergebnisListe) {
//                writer.write(ergebnis);
//                writer.newLine();
//            }
//
//        } catch (IOException e) {
//            System.out.println("A apărut o eroare la salvarea datelor: " + e.getMessage());
//        }
//    }


    }
}


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



    }
}

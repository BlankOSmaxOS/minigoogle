package searchengine;

import com.opencsv.CSVParser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static spark.Spark.*;

public class MiniGoogle {
    private static String input;

    // GUI


    public static void main(String[] args) throws IOException {

        GUISetup();
        input = "Call me, MAYBE.";
        // TEST INPUT
        // TEST


        File file = new File("C:/Users/Blanco/Documents/_privat/Studium_IMI/2021_03_SoSe/B15_Informatik_3/exercise/Info3_Lab_05/src/main/resources/comics.csv");
        Scanner scan = new Scanner(file);
        CSVParser csvParser = new CSVParser();


        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] words = csvParser.parseLine(line);
            //System.out.println(scan.nextLine());
            /*
            System.out.println(words[0]);
            System.out.println("______________");
            System.out.println(words[1]);
            System.out.println("______________");
            System.out.println(words[2]);
             */

            if (words[2].equals(input)) {
                System.out.print("Link: ");
                System.out.println(words[0]);
                System.out.print("Titel: ");
                System.out.println(words[1]);
                System.out.print("Text: ");
                System.out.println(words[2]);
                System.out.println("______________");
            }

        }


        //get("/", (req, res) -> {
          //  return "MiniGoogle by Blank Maximilian, Y"; // TODO: replace X and Y by your name(s)





            //TODO: Scanner + Streams
            //TODO: Create/Parse Lists/Arrays Link , Title, Text
            //TODO: Tag Input If
            //TODO: Seach Conditions
            //TODO: Link/Print Results

            //String input = seachInput.getText();
            //if (input.matches("a-zA-Z")) {




            //TODO: GUI

            // TODO: OPTIONS Case Sensitive etc.


       // });

    }

    //string input = seachInput.getText();


    public static void GUISetup() {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame("TEST MINI GOOGLE");
        frame.setSize(300, 300);
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter Text");
        userLabel.setBounds(10, 10, 10, 10);
        panel.add(userLabel);

        JTextField seachInput = new JTextField(30);
        seachInput.setBounds(200, 20, 300, 25);
        panel.add(seachInput);

        JButton button = new JButton("Enter");
        button.setBounds(10, 50, 50, 25);
        panel.add(button);


        JLabel result = new JLabel("");
        result.setBounds(255, 50, 300, 40);
        panel.add(result);
    }


}

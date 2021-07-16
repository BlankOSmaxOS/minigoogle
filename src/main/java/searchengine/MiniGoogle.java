package searchengine;

import com.opencsv.CSVParser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import static spark.Spark.*;

public class MiniGoogle {
    private static String input;

    // GUI


    public static void main(String[] args) throws IOException {

        GUISetup();
        input = "fres";

        String [] inputCS = input.split("");
        System.out.println(inputCS[0]);


        // TEST INPUT
        // TEST



        File file = new File("C:/Users/Blanco/Documents/_privat/Studium_IMI/2021_03_SoSe/B15_Informatik_3/exercise/Info3_Lab_05/src/main/resources/comics.csv");
        Scanner scan = new Scanner(file);
        CSVParser csvParser = new CSVParser();


        if (input.matches("[a-z A-Z]*")) {



            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] words = csvParser.parseLine(line);

                String inputLOW = input.toLowerCase();
                String test = words[2].toLowerCase(Locale.ROOT);
                //System.out.println(test);
                String[] testWords = test.split(" ");
                String[] testWordsCS = test.split("");
                //System.out.println(testWords[1]);


                //System.out.println(test);

                //test = words[1].replaceAll("[a-z]{7}\\b","");

                //System.out.println(scan.nextLine());

                for (int i = 0; i < inputCS.length; i++) {

                    int size = 0;
                    for (int j = 0; j < testWordsCS.length; j++) {
                        if (inputCS[i].matches(testWordsCS[j])) {
                            System.out.println(input);
                            System.out.println(testWordsCS[j]);
                            i++;
                            size++;
                            if (size == inputCS.length ) {
                                System.out.print("Input: ");
                                System.out.println(input);
                                System.out.print("Link: ");
                                System.out.println(words[0]);
                                System.out.print("Titel: ");
                                System.out.println(words[1]);
                                System.out.print("Text: ");
                                System.out.println(words[2]);
                                System.out.println("______________");
                                break;
                            }

                        } else {
                            j++;
                            i = 0;

                        }

                    }

                }
                System.out.println("______TEST________");









 /*


                 ////// CASE SENSITIV
                for (int i = 0; i < testWords.length; i++) {
                    if (testWords[i].matches(inputLOW)) {

                        System.out.print("Link: ");
                        System.out.println(words[0]);
                        System.out.print("Titel: ");
                        System.out.println(words[1]);
                        System.out.print("Text: ");
                        System.out.println(words[2]);
                        System.out.println("______________");
                    }

                }

  */

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

package searchengine;

import com.opencsv.CSVParser;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static spark.Spark.*;


public class MiniGoogle {
    private static String input;

    private String link;
    private String title;
    private String text;


    public String getLink(String link) {
        return this.link = link;
    }

    public String getTitle(String title) {
        return this.title = title;
    }

    public String getText(String text) {
        return this.text = text;
    }
    // GUI


    public static void main(String[] args) throws IOException {

        input = "for";

        get("/search", (rq, rs) -> {
            List<Hyperlink> results = new ArrayList<Hyperlink>();
            //results.add(new Hyperlink("link", "title", "text"));

            boolean caseSensitiv = true;
            boolean wholeWord = true;
            File file = new File("C:/Users/Blanco/Documents/_privat/Studium_IMI/2021_03_SoSe/B15_Informatik_3/exercise/Info3_Lab_05/src/main/resources/comics.csv");
            Scanner scan = new Scanner(file);
            CSVParser csvParser = new CSVParser();

            //if (input.matches("[a-z A-Z]*")) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] words = csvParser.parseLine(line);

                if (caseSensitiv == true) {
                    String[] inputCaseSensitive = input.split("");
                    String[] wordsCaseSensitive = words[2].split("");

                    int i = 0;
                    int size = 0;
                    for (int j = 0; j < wordsCaseSensitive.length; j++) {
                        if (inputCaseSensitive[i].equals(wordsCaseSensitive[j])) {
                            i++;
                            size++;
                            if (size == inputCaseSensitive.length - 1) {

                                    /*String link = words[0];
                                    String title = words[1];
                                    String text = words[2];
                                    //results.add(new Hyperlink("TEST2","rew", "tr"));


                                     */
                                //results.add(new Hyperlink("link2", "title2", "text"));

                                results.add(new Hyperlink(words[0], words[1], words[2]));
                                System.out.print("Input: ");
                                System.out.println(input);
                                System.out.print("Link: ");
                                System.out.println(words[0]);
                                System.out.print("Titel: ");
                                System.out.println(words[1]);
                                System.out.print("Text: ");
                                System.out.println(words[2]);
                                System.out.println("______________");
                                i = 0;
                            }
                        } else {
                            // System.out.println("nothingvin line " + line);
                            i = 0;
                            size = 0;
                        }

                    }
                }

                if (caseSensitiv == false) {
                    if (wholeWord == true) {
                        String inputLowerCase = input.toLowerCase();
                        String wordsLowerCase = words[2].toLowerCase(Locale.ROOT);
                        String[] wordsLowerCaseSplit = wordsLowerCase.split(" ");
                        for (int i = 0; i < wordsLowerCaseSplit.length; i++) {
                            if (wordsLowerCaseSplit[i].matches(inputLowerCase)) {
                                System.out.print("Link: ");
                                System.out.println(words[0]);
                                System.out.print("Titel: ");
                                System.out.println(words[1]);
                                System.out.print("Text: ");
                                System.out.println(words[2]);
                                System.out.println("______________");
                            }
                        }
                    }
                    if (wholeWord == false) {
                        String inputLowerCase = input.toLowerCase();
                        String wordsLowerCase = words[2].toLowerCase(Locale.ROOT);
                        String[] inputLowerCaseSplit = inputLowerCase.split("");
                        String[] wordsLowerCaseSplit = wordsLowerCase.split("");
                        int i = 0;
                        int size = 0;
                        for (int j = 0; j < wordsLowerCaseSplit.length; j++) {
                            if (inputLowerCaseSplit[i].equals(wordsLowerCaseSplit[j])) {
                                i++;
                                size++;
                                if (size == inputLowerCaseSplit.length - 1) {
                                    System.out.print("Input: ");
                                    System.out.println(input);
                                    System.out.print("Link: ");
                                    System.out.println(words[0]);
                                    System.out.print("Titel: ");
                                    System.out.println(words[1]);
                                    System.out.print("Text: ");
                                    System.out.println(words[2]);
                                    System.out.println("______________");
                                    i = 0;
                                }
                            } else {
                                // System.out.println("nothingvin line " + line);
                                i = 0;
                                size = 0;
                            }
                        }
                    }
                }
            }


            Map<String, Object> map = new HashMap<String, Object>();
            map.put("results", results);
            return new ModelAndView(map, "search");
        }, new JadeTemplateEngine());


        // get("/", (req, res) -> {
        //           return "MiniGoogle by Blank Maximilian, Y"; // TODO: replac   e X and Y by your name(s)


    }


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

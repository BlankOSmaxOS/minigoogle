package searchengine;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import static spark.Spark.*;

public class MiniGoogle {

    // GUI


    public static void main(String[] args) throws IOException {

        GUISetup();

        get("/", (req, res) -> {
            return "MiniGoogle by Blank Maximilian, Y"; // TODO: replace X and Y by your name(s)

            //TODO: Scanner + Streams

            //TODO: Seach Condition
            //String input = seachInput.getText();
            //if (input.matches("a-zA-Z")) {


            //TODO: GUI

            // TODO: OPTIONS Case Sensitive etc.


        });

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

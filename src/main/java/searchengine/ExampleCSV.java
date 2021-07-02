package searchengine;

import com.opencsv.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ExampleCSV {
    public static void main(String[] args) throws IOException {
        CSVParser csvParser;
        Scanner scanner;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("comics.csv");
        csvParser = new CSVParser();
        scanner = new Scanner(inputStream);
        String line = scanner.nextLine();
        String[] words = csvParser.parseLine(line);
        System.out.println("URL: " + words[0]);
        System.out.println("alt: " + words[1]);
        System.out.println("title: " + words[2]);
    }
}


/// TEST TEST TEST
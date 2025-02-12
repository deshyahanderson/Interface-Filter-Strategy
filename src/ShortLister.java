package src;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {  // Check if it's a String
            String s = (String) x;    // Cast to String
            return s.length() < 5;
        }
        return false; // If it's not a String, reject it
    }
}

public class ShortLister {

    public static ArrayList<String> collectAll(ArrayList<String> words, Filter filter) {
        ArrayList<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (filter.accept(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            ArrayList<String> words = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineWords = line.toLowerCase().split("[\\p{Punct}\\s]+");
                    for (String word : lineWords) {
                        if (!word.isEmpty()){
                            words.add(word);
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ShortWordFilter shortWordFilter = new ShortWordFilter();
            ArrayList<String> shortWords = collectAll(words, shortWordFilter);

            if (shortWords.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No short words found in file", "No Words", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder sb = new StringBuilder();
                for (String word : shortWords) {
                    sb.append(word).append("\n");
                }

                JTextArea textArea = new JTextArea(sb.toString());
                JScrollPane scrollPane = new JScrollPane(textArea);

                JOptionPane.showMessageDialog(null, scrollPane, "Short Words", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
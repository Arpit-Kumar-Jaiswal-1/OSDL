package Lab5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileCharStream {
    public static void main(String[] args) {
       
        String sourceFile = "textsource.txt";
        String destinationFile = "textdestination.txt";

        try (
           
            FileReader fr = new FileReader(sourceFile);
           
            FileWriter fw = new FileWriter(destinationFile)
        ) {
            int data;
           
            while ((data = fr.read()) != -1) {
                fw.write(data);
            }

            System.out.println("Text file copied successfully using character streams!");
        } catch (IOException e) {
            System.out.println("Error occurred while copying file.");
            e.printStackTrace();
        }
    }
}

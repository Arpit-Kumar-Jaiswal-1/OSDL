package Lab5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByteStream {
    public static void main(String[] args) {
        String sourceFile = "source.txt";       
        String destinationFile = "destination.txt"; 

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully using byte streams!");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

package file_handling;
import java.io.*;
import java.util.*;

public class files {
    public static void main(String[] args) {
        try {
            File obj = new File("Aniket.txt");
            // obj contains information about the file path — acts as a reference to a potential file

            if (obj.createNewFile()) {
                System.out.println("File created: " + obj.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (Exception e) {
            System.out.println("Error while creating file: " + e);
        }

        // Write to file in append mode
        try {
            FileWriter writer = new FileWriter("Aniket.txt", true);
            writer.write("\nHello Aniket here");
            writer.close();
            System.out.println("Successfully wrote to the file in append mode.");
        } catch (Exception e) {
            System.out.println("Error while writing to file: " + e);
        }

        // ✅ Read from the file using Scanner connected to the File object
        try {
            File fileToRead = new File("Aniket.txt");
            Scanner sc = new Scanner(fileToRead);
            System.out.println("\n--- File Contents ---");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error while reading file: " + e);
        }
    }
}

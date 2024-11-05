package section3;

import java.io.*;
import java.nio.file.*;

public class FileHandlingProgramme {
    public static void main(String[] args) {
        
        String filePath = "example.txt";  // Change this to the file you want to read

        
        int wordCount = 0;
        int lineCount = 0;
        int charCount = 0;

       
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                lineCount++;  
                charCount += line.length();  

               
                String[] words = line.split("\\s+");
                wordCount += words.length;  
            }

            
            System.out.println("File: " + filePath);
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file does not exist.");
        } catch (IOException e) {
            System.out.println("Error: An issue occurred while reading the file.");
        }
    }
}


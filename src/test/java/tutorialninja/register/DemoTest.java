package tutorialninja.register;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DemoTest {

	
		
		 public static void main(String[] args) {
			 String filePath = "/Users/triveous/eclipse-workspace/SeleniumJavaFramework/Text.txt";

		        // TreeSet to store unique words (case-insensitive and sorted)
		        Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;

		            while ((line = reader.readLine()) != null) {
		                // Split each line into words using non-word characters as delimiters
		                String[] words = line.split("\\W+");

		                for (String word : words) {
		                    if (!word.trim().isEmpty()) {
		                        uniqueWords.add(word.trim());
		                    }
		                }
		            }

		            // Print unique words
		            System.out.println("Unique words from the file:");
		            for (String word : uniqueWords) {
		                System.out.println(word);
		            }

		        } catch (IOException e) {
		            System.err.println("Error reading the file: " + e.getMessage());
		        }
		    }	}



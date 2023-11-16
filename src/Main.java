import Helpers.ReadFile;
import Helpers.ResultFormatter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // File Path
        String filePath = "C:\\Users\\ackoc\\Desktop\\Seminar1 - java\\numbers.txt";

        // Units to test
        int[] elementsToTest = {
                100,
                1000,
                10000,
                100000,
                1000000};

        // Algorithms to test
        String[] algorithms = {
                "Insertion Iterative",
                "Insertion Recursive",
                "QS Median Pivot Iterative",
                "QS Median Pivot Recursive",
                "QS Random Pivot Iterative",
                "QS Random Pivot Recursive",
                "QS Array[0] Pivot Iterative",
                "QS Array[0] Pivot Recursive",
                "Binary Search"};

        // Number of times it will run the method
        int numberOfRuns = 10;

        // Running through the units to test
        for (int numberOfElements : elementsToTest) {

            // Print results using ResultFormatter class
            ResultFormatter.printTableHeader();

            // Read number.txt
            List<Integer> numbers = ReadFile.readNumbersFromFile(filePath, numberOfElements);

            for (String algorithm : algorithms) {

                // Printing time results
                AlgorithmRunner.runAlgorithm(algorithm, numbers, numberOfRuns, numberOfElements, 20);
            }
        }
    }
}

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
                "QS Median Pivot Recursive",
                "QS Median Pivot Iterative",
                "QS Random Pivot Iterative",
                "QS Random Pivot Recursive",
                "QS Array[0] Pivot Iterative",
                "QS Array[0] Pivot Recursive",
                "Binary Search"};

        // 10 cycles to get an average
        int numberOfRuns = 10;

        // Running through the units to test
        for (int numberOfElements : elementsToTest) {

            // Print the header for the information
            ResultFormatter.printTableHeader();

            // Read file and add to list
            List<Integer> numbers = ReadFile.readNumbersFromFile(filePath, numberOfElements);

            //Loop algorithms to run them with list from readfile
            for (String algorithm : algorithms) {
                // Printing time results and showing first 20 elements of array
                // Showing array in order to show the sorting works
                AlgorithmRunner.runAlgorithm(algorithm, numbers, numberOfRuns, numberOfElements, 20);
            }
        }
    }
}

// PalmerPenguinsM6.java
// Alejandro Cueto
// 6/19/26
// Reads the CSV file and parses data into arrays using user-defined methods

import java.io.*;
import java.util.*;

public class PalmerPenguinsM6 {

    static final String FILE_NAME = "PalmerPenguins.csv";

    // Constants representing species and count
    public static final int NUM_SPECIES = 3;
    public static final String SP_CHINSTRAP = "Chinstrap";
    public static final String SP_GENTOO = "Gentoo";
    public static final String SP_ADELIE = "Adelie";

    public static void main(String[] args) {

        // TODO 1: Read species data from CSV file
        String[] speciesData = readSpeciesData();

        // TODO 2: Create species count array
        int[] speciesCount = initializeSpeciesCount();

        // TODO 3: Check whether data array is empty
        if (isDataEmpty(speciesData)) {
            System.out.println("No data found.");
            return;
        }

        // TODO 4: Count amount of penguins of each species
        countSpecies(speciesData, speciesCount);

        // TODO 5: Show the count of each species
        printSpeciesCount(speciesCount);
    }

    /**
     * TODO 1: Create a method readSpeciesData that calls
     * CSVReader.readFile(FILE_NAME, 1) and returns the resulting String[].
     *
     * @return array containing species data
     */
    public static String[] readSpeciesData() {
        return CSVReader.readFile(FILE_NAME, 1);
    }

    /**
     * TODO 2: Define a method initializeSpeciesCount that returns
     * a new integer array of size NUM_SPECIES.
     *
     * @return initialized species count array
     */
    public static int[] initializeSpeciesCount() {
        return new int[NUM_SPECIES];
    }

    /**
     * TODO 3: Implement a method isDataEmpty that takes a String[]
     * array as a parameter and returns true if its length is 0.
     *
     * @param data array to check
     * @return true if empty, false otherwise
     */
    public static boolean isDataEmpty(String[] data) {
        return data.length == 0;
    }

    /**
     * TODO 4: Write a method countSpecies that accepts String[]
     * speciesData and int[] speciesCount as parameters and updates
     * the species counts.
     *
     * @param speciesData array containing species names
     * @param speciesCount array containing species counts
     */
    public static void countSpecies(String[] speciesData, int[] speciesCount) {
        for (String species : speciesData) {
            if (species.equals(SP_CHINSTRAP)) {
                speciesCount[0]++;
            } else if (species.equals(SP_GENTOO)) {
                speciesCount[1]++;
            } else if (species.equals(SP_ADELIE)) {
                speciesCount[2]++;
            }
        }
    }

    /**
     * TODO 5: Implement a method printSpeciesCount that prints the
     * count of each species using the predefined constants.
     *
     * @param speciesCount array containing species counts
     */
    public static void printSpeciesCount(int[] speciesCount) {
        System.out.println(SP_CHINSTRAP + ": " + speciesCount[0]);
        System.out.println(SP_GENTOO + ": " + speciesCount[1]);
        System.out.println(SP_ADELIE + ": " + speciesCount[2]);
    }
}

class CSVReader {

    /**
     * readFile reads a file line by line, extracts the specified column
     * from each line, and returns an array containing the extracted values.
     *
     * @param FILE_NAME the file name to read
     * @param column the zero-based index of the column to extract
     * @return an array of extracted column values
     */
    public static String[] readFile(String FILE_NAME, int column) {
        List<String> columnValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                if (column >= 0 && column < tokens.length) {
                    columnValues.add(tokens[column]);
                } else {
                    columnValues.add("");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        return columnValues.toArray(new String[0]);
    }
}
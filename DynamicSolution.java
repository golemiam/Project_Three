import java.util.Arrays;

/**
 * Dynamic Solution provides a class to create an immutable object that
 * calculates the optimizal knapsack solution using a tabulzation method. Allows
 * the user to getMaxValue, print the generated tab table, and fetch the given
 * items in optimal solution in combination with a given name array.
 * 
 * Based on the ideas described and code provided in this article.
 * https://www.w3schools.com/dsa/dsa_ref_knapsack.php
 * 
 * @author Valor Goff
 */
public class DynamicSolution {
    // = = = Attributes = = =
    private int[] weights, values;
    private int capacity;
    private int[][] tab;

    // = = = Behaviors = = =

    /**
     * Set up constructor for DynamicSolution object. Arrays are expected to be same
     * length. The item ID of each element from data corrisponds to each index+1.
     * 
     * @param weights     Weights of each element.
     * @param values      Values of each element.
     * @param maxCapacity Max capacity of any calculation.
     */
    public DynamicSolution(int[] weights, int[] values, int maxCapacity) {
        // collect
        this.weights = Arrays.copyOf(weights, weights.length);
        this.values = Arrays.copyOf(values, values.length);
        capacity = maxCapacity;
        // callculate
        knapsack_tabulation();
    }

    /**
     * 
     * @return The max value of the given data.
     */
    public int getMaxValue() {
        return tab[values.length][capacity];
    }

    /**
     * Finds the items included in the final tab calculation and prints the name at
     * the matching n index. Guided by W3Schools's article "DSA 0/1 Knapsack"
     * 
     * @param names Corrisponding array of names.
     */
    public void printElements(String[] names) {
        // start bottom right
        int n = values.length; // total items
        int w = capacity;

        while (tab[n][w] != 0) { // while value != 0
            if (tab[n - 1][w] == tab[n][w]) // not included
                n--; // move to next item
            else { // item found
                System.out.print(names[n - 1] + ", "); // 1-n -> 0 to n-1
                n--;
                w -= weights[n]; // subtract weight from current value
            }
        }
    }

    // print entire table
    public void printTab() {
        System.out.println("Table: (n=" + values.length + ", c=" + capacity + ")");
        for (int[] row : tab) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // = = = Helper Methods = = =

    /**
     * For each item, at each possible weight, calculate and add the most optimal
     * value. Each cell in tab is most optimal weight at that many considered items
     * (At the max n (num of items) all items are considered).
     * 
     * Tabulation solution from W3Schools Demo Knapsack Tabulation. Trimmed to fit
     * by Valor.
     * 
     * @author W3Schools
     */
    private void knapsack_tabulation() {
        int n = values.length; // total items
        tab = new int[n + 1][capacity + 1]; // 1-n array logic (not 0 to n-1)

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    int include_item = values[i - 1] + tab[i - 1][w - weights[i - 1]];
                    int exclude_item = tab[i - 1][w];
                    tab[i][w] = Math.max(include_item, exclude_item);
                } else {
                    tab[i][w] = tab[i - 1][w];
                }
            }
        }
    }

    // = = = = = Test Driver = = = = =
    public static void main(String[] args) {
        // w3 schools data
        int[] w3_values = { 300, 200, 400, 500 };
        int[] w3_weights = { 2, 1, 5, 3 };
        int w3_capacity = 10;
        String[] w3_names = { "Scope", "Globe", "Trophy", "Crown" };
        // w3 testing
        DynamicSolution sack = new DynamicSolution(w3_weights, w3_values, w3_capacity);
        sack.printTab();
        System.out.println("\nMaximum value in Knapsack = " + sack.getMaxValue());
        sack.printElements(w3_names);

        System.out.println(); // linebreak

        // space shuttle data
        String[] names = { "Cloud Patterns", "Solar Flares", "Solar Power", "Binary Stars", // 1-4
                "Relativity", "Seed Viability", "Sun Sports", "Mice Tumors", // 5-8
                "Microgravity Plant Growth", "Micrometeorites", "Cosmic Rays", "Yeast Fermentation" }; // 9-12
        int[] weights = { 36, 264, 188, 203, // 1-4
                104, 7, 90, 65, // 5-8
                75, 170, 80, 27 }; // 9-12
        int[] raitings = { 5, 9, 6, 8, // 1-4
                8, 4, 2, 8, // 5-8
                5, 9, 7, 4 }; // 9-12
        int maxWeight = 700;
        // shuttle testing
        DynamicSolution payload = new DynamicSolution(weights, raitings, maxWeight);
        System.out.println("\nMaximum value in Payload = " + payload.getMaxValue());
        payload.printElements(names);
    }
}
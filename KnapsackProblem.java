public class KnapsackProblem {
    static final int MAX_WEIGHT = 700;

  //-------- sorting methods-----------//

    // Method to sort by weight
    public static void sortByWeight(List<Experiment> experiments) {
        experiments.sort(Comparator.comparingInt(Experiment::getWeight).reversed()); // reversed, to list heaviest to lightest
        
        for (Experiment experiment : experiments) {
            System.out.println(experiment);
        }
    }
    
     // ---outputs--//
        public static void main(String[] args) {
        
        // list of all experiments
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(1, "Cloud Patterns", 36, 5));
        experiments.add(new Experiment(2, "Solar Flares", 264, 9));
        experiments.add(new Experiment(3, "Solar Power", 188, 6));
        experiments.add(new Experiment(4, "Binary Stars", 203, 8));
        experiments.add(new Experiment(5, "Relativity", 104, 8));
        experiments.add(new Experiment(6, "Seed Viability", 7, 4));
        experiments.add(new Experiment(7, "Sun Spots", 90, 2));
        experiments.add(new Experiment(8, "Mice Tumors", 65, 8));
        experiments.add(new Experiment(9, "Microgravity Plant Growth", 75, 5));
        experiments.add(new Experiment(10, "Micrometeorites", 170, 9));
        experiments.add(new Experiment(11, "Cosmic Rays", 80, 7));
        experiments.add(new Experiment(12, "Yeast Fermentation", 27, 4));
        
        // Printing unsorted list
        System.out.println("Unsorted experiments:");
        experiments.forEach(System.out::println);

        System.out.println();

        // Sorting by weight output
         System.out.println("\nExperiments sorted by weight(descending):");
         sortByWeight(experiments);

}

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * Demonstrating solutions to the Knapsack Problem using several methods.
 * Sorting and choosing objects based on weight, rating, and weight/rating
 * ratio.
 * A brute-force approach to find the combination of items that maximizes the
 * rating
 * while staying within the weight limit.
 * 
 * @author Daniel Frear
 */
public class TestClientDynamic {

	/**
	 * 
	 * 
	 * - A constructor to initialize the name, weight, and rating of the object.
	 * - Getter methods for retrieving the name, weight, and rating.
	 * - A method to compute the ratio of weight to rating.
	 * 
	 * @author Daniel Frear
	 */
	public static RatedObjects[] extracted() {

		// Create all of our objects. Probably a better way of doing this like three
		// arrays and a loop.
		RatedObjects cloudPatterns = new RatedObjects("Cloud Patterns", 36, 5);
		RatedObjects solarFlares = new RatedObjects("Solar Flares", 264, 9);
		RatedObjects solarPower = new RatedObjects("Solar Power", 188, 6);
		RatedObjects binaryStars = new RatedObjects("Binary Stars", 203, 8);
		RatedObjects relativity = new RatedObjects("Relativity", 104, 8);
		RatedObjects seedViability = new RatedObjects("Seed Viability", 7, 4);
		RatedObjects sunSpots = new RatedObjects("Sun Spots", 90, 2);
		RatedObjects miceTumors = new RatedObjects("Mice Tumors", 65, 8);
		RatedObjects microPlant = new RatedObjects("Microgravity Plant Growth", 75, 5);
		RatedObjects micrometeors = new RatedObjects("Micrometeors", 170, 9);
		RatedObjects cosmicRays = new RatedObjects("Cosmic Rays", 80, 7);
		RatedObjects yeastFermantation = new RatedObjects("Yeast Fermentation", 27, 4);

		// Building the array of the base items we have.
		RatedObjects[] items = { cloudPatterns, solarFlares, solarPower, binaryStars, relativity, seedViability,
				sunSpots, miceTumors, microPlant, micrometeors, cosmicRays, yeastFermantation };

		return items;
	}

	// Weight Method
	/**
	 * @param Array of RatedObjects
	 */
	static void fillWeight(RatedObjects[] items) {

		// ArrayList: We don't know how many objects will be added
		ArrayList<RatedObjects> returnedItems = new ArrayList<RatedObjects>();

		// Total Weight and Rating
		int totalWeight = 0;
		int totalRating = 0;

		// Current position in the array
		int current = 0;

		// Check if we are at the end of the array (No more objects to add)
		boolean noMore = false;

		// Sort by weight (smallest to largest)
		Arrays.sort(items, Comparator.comparingInt(RatedObjects::getWeight));

		// Loop while totalWeight is below threshold (700) and there are more objects
		// that can be added
		while (totalWeight < 700 && noMore == false) {

			// If current == length there are no more objects in the array to look at
			if (current == items.length - 1) {
				noMore = true;
			}

			// If current total weight + new item weight < 700 add the item, its weight and
			// rating
			else if (items[current].getWeight() + totalWeight < 700) {
				returnedItems.add(items[current]);
				totalWeight += items[current].getWeight();
				totalRating += items[current].getRating();
			}

			// Increment current position by 1
			current += 1;
		}

		// Print out our total weight and rating
		System.out.println("Weight:" + totalWeight);
		System.out.println("Rating:" + totalRating);

		// Print out items added to return array
		for (int j = 0; j < returnedItems.size(); j++) {
			System.out.println(returnedItems.get(j));
		}
	}

	// Rating Method
	/**
	 * @param Array of RatedObjects
	 */
	static void fillRating(RatedObjects[] items) {

		// ArrayList: We don't know how many objects will be added
		ArrayList<RatedObjects> returnedItems = new ArrayList<RatedObjects>();

		// Total Weight and Rating
		int totalWeight = 0;
		int totalRating = 0;

		// Current position in the array, we want the largest first so we start at the
		// end
		int current = 11;

		// Check if we are at the end of the array (No more objects to add)
		boolean noMore = false;

		// Sort by rating (smallest to largest)
		Arrays.sort(items, Comparator.comparingInt(RatedObjects::getRating));

		// Loop while totalWeight is below threshold (700) and there are more objects
		// that can be added
		while (totalWeight < 700 && noMore == false) {
			// If current == 0 there are no more objects that can be added
			if (current == 0) {
				noMore = true;
			}

			// If current total weight + new item weight < 700 add the item, its weight, and
			// its rating
			if (items[current].getWeight() + totalWeight < 700) {
				returnedItems.add(items[current]);
				totalWeight += items[current].getWeight();
				totalRating += items[current].getRating();
			}

			// Decrement current position by 1
			current -= 1;
		}

		// Print out our total weight and rating
		System.out.println("Weight:" + totalWeight);
		System.out.println("Rating:" + totalRating);

		// Print out items added to return array
		for (int j = 0; j < returnedItems.size(); j++) {
			System.out.println(returnedItems.get(j));
		}
	}

	// Ratio Method
	/**
	 * @param Array of RatedObjects
	 */
	static void fillRatio(RatedObjects[] items) {

		// ArrayList: We don't know how many objects will be added
		ArrayList<RatedObjects> returnedItems = new ArrayList<RatedObjects>();

		// Total Weight and Rating
		int totalWeight = 0;
		int totalRating = 0;

		// Current position in the array
		int current = 0;

		// Check if we are at the end of the array (No more objects to add)
		boolean noMore = false;

		// Sort by ratio (smallest to largest)
		Arrays.sort(items, Comparator.comparingInt(RatedObjects::getRatio));

		// Loop while totalWeight is below threshold (700) and there are more objects
		// that can be added
		while (totalWeight < 700 && noMore == false) {
			// If current == end of list, there are no more objects that can be added
			if (current == items.length - 1) {
				noMore = true;
			}

			// If current total weight + new item weight < 700 add the item and its weight +
			// rating
			if (items[current].getWeight() + totalWeight < 700) {
				returnedItems.add(items[current]);
				totalWeight += items[current].getWeight();
				totalRating += items[current].getRating();
			}

			// Increment current position by 1
			current += 1;
		}

		// Print out the Weight and Rating.
		System.out.println("Weight:" + totalWeight);
		System.out.println("Rating:" + totalRating);

		// Print out items in return Array
		for (int j = 0; j < returnedItems.size(); j++) {
			System.out.println(returnedItems.get(j));
		}
	}

	//////// Brute-Force Method ////////

	/**
	 * Solves the knapsack problem using a bruteforce approach.
	 *
	 * Finds all possible combinations of items to find the one
	 * that maximizes the total rating without going over the weight limit.
	 * It considers two choices for each item: either include the item in the
	 * current selection or exclude it. The maximum rating of these two options
	 * is returned as the result. https://www.w3schools.com/dsa/dsa_ref_knapsack.php
	 * inspired the approach.
	 *
	 * @param items       array of RatedObjects
	 * @param capacity    The remaining weight capacit
	 * @param n           The number of items left
	 * @param currentList The current list of selected items
	 * @param bestList    The list of items that provide the highest rating.
	 * 
	 * @return The max rating with the given capacity and items.
	 * 
	 * @author Jose Ojeda
	 * @author Robbie PLatt
	 */
	public static int bruteForce(RatedObjects[] items, int capacity, int n, List<RatedObjects> currentList,
			List<RatedObjects> bestList) {

		// Base case, no items left or capacity is 0 (maxxed out)
		if (n == 0 || capacity == 0) {
			int currentRating = getTotalRating(currentList);
			if (currentRating > getTotalRating(bestList)) {
				bestList.clear();
				bestList.addAll(currentList);
			}
			return currentRating;
		}

		// If the weight of an item is more than remaining capacity, skip it
		if (items[n - 1].getWeight() > capacity) {
			return bruteForce(items, capacity, n - 1, currentList, bestList);
		}

		// Include the an item
		currentList.add(items[n - 1]);
		int includeRating = bruteForce(items, capacity - items[n - 1].getWeight(), n - 1, currentList, bestList);

		// Remove the item after considering it
		currentList.remove(currentList.size() - 1);

		// Option 2: Exclude the nth item
		int excludeRating = bruteForce(items, capacity, n - 1, currentList, bestList);

		// Return the maximum of including or excluding the item
		return Math.max(includeRating, excludeRating);
	}

	private static int getTotalRating(List<RatedObjects> items) {
		int totalRating = 0;
		for (RatedObjects item : items) {
			totalRating += item.getRating();
		}
		return totalRating;
	}

	public static void main(String[] args) {

		// Input all of the info... There is probably a better way of doing this. i.e. 3
		// arrays and a loop would probably be more compact.
		RatedObjects[] items = extracted();

		/*
		 * Testing
		 * //Original Array
		 * for (int i = 0; i < items.length; i++) {
		 * System.out.println(items[i] + "  Ratio:  " + items[i].getRatio());
		 * System.out.println();
		 * }
		 */

		System.out.println("Lightest Objects");
		fillWeight(items);

		System.out.println();

		System.out.println("Best Rating Objects");
		fillRating(items);
		System.out.println();

		System.out.println();

		System.out.println("Objects with best weight/rating ratio;");
		fillRatio(items);
		System.out.println();

		// brute force

		System.out.println("Brute force method");
		int capacity = 700; // weight limit
		int n = items.length; // Total number of items
		List<RatedObjects> currentList = new ArrayList<>();
		List<RatedObjects> bestList = new ArrayList<>();

		int maxRating = bruteForce(items, capacity, n, currentList, bestList);

		System.out.println("Best rating possible: " + maxRating);
		System.out.println("Items included:");

		for (RatedObjects item : bestList) {
			System.out.println(item);
		}

	}
}

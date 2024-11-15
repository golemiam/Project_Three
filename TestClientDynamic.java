import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class TestClientDynamic {

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

		fillWeight(items);
		System.out.println();
		fillRating(items);
		System.out.println();
		fillRatio(items);
		System.out.println();

		// brute force

		// TODO- i'll clean up, organize output before video - (jose)
		System.out.println("brute force");
		
		System.out.println("Brute force using recursive method");
		int capacity = 700; // Your weight limit
		int n = items.length; // Total number of items
		int maxRating = bruteForce(items, capacity, n);

		System.out.println("Maximum rating achievable: " + maxRating);

	}

	/**
	 * @return Our Array of objects
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

	/* Brute-Force Method
	TODO -- finish commenting code, before video -(jose) 
 	* W3 school inspired brute force, edited to fit project parameters
	*/
	public static int bruteForce(RatedObjects[] items, int capacity, int n) {
		// Base case, NO items left or capacity is 0(maxxed)
		if (n == 0 || capacity == 0) {
			return 0;
		}

		// if items weight < capacity then include it (capacity-current item's weight)
		if (items[n - 1].getWeight() > capacity) {
			return bruteForce(items, capacity, n - 1);
		} else {
			// Calculate the max value by either including or excluding the nth item
			int include_item = items[n - 1].getRating() +
					bruteForce(items, capacity - items[n - 1].getWeight(), n - 1);
			int exclude_item = bruteForce(items, capacity, n - 1);

			return Math.max(include_item, exclude_item);
		}
	}
}

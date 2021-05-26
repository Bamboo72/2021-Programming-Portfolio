// Jacob Schwartz - 4/21/2021
// Programming 2 assignment to learn about collections - I've been assigned to HashMaps

/*
1. Intended use (what the collection is typically used for)
- "A map allows you to associate elements from a key set with elements from a value collection.
 You use a map when you want to look up objects by using a key."
- Pretty much, a map lets you assign things called values (Colors, Integers, etc) to a category called keys (Typically Strings)
 
2. Mutability and Pros/Cons for the collection (what can or can't it do?)
- Use a map if values are accessed by a key that is not a part of the object.
- If the order of the elements does not matter, then use a HashMap over a TreeMap.
- The hash map is usually more efficient, but the tree map keeps the keys in sorted order.

11. CHALLENGE: Code to order the collection (Alpha or Numeric sort)
- It wouldn't make a ton of sense to order HashMaps because they're meant to be used on data where the order doesn't matter.
- If you need to order and sort data in a map, you should use a TreeMap.
*/

// 3. Import Statement required for the specific collection
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {

    public static void main(String[] args) {

        // 4. Necessary code to create/instantiate the collection
        Map<String, Integer> ages = new HashMap<>();

        // 5. Code to populate the collection (including what is needed to load
        // information from a file where applicable)
        // 7. Code to add to the collection
        ages.put("Jacob", 17);
        ages.put("Brooke", 15);
        ages.put("Megan", 9);
        ages.put("Imposter", 1000000);

        // 6. Code to find the length, size, or element count
        int hashMapSize = ages.size();
        System.out.println("The size of the HashMap is " + hashMapSize);

        // 8. Code to update an element
        ages.put("Jacob", 18);

        // 9. Code to remove, clear, or delete the element (based on mutability)
        ages.remove("Imposter");
        hashMapSize = ages.size();
        System.out.println("Now that the imposter is removed, the size of the HashMap is " + hashMapSize);

        // 10. Code the print the entire collection to the console
        System.out.println(ages);

        // Bonus: How to iterate through all the keys, in what is called a keySet
        Set<String> theKeySet = ages.keySet();
        for (String name : theKeySet)
        {
           Integer age = ages.get(name);
           System.out.println(name + " is " + age + " years old.");
        }
    }

}

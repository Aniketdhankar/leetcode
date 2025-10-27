import java.util.ArrayList;
import java.util.Collections;

public class lambda2 {
     public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);

        Collections.sort(list);  // sorts in ascending order
        System.out.println(list); // Output: [1, 2, 5, 9]

        list.sort((a, b) -> a - b); // ascending
        list.sort((a, b) -> b - a); // descending

        list.sort();//error

        /*
         * List.sort() does not have a no-argument version.

          It expects a Comparator: a way to compare two elements.

          Because Collections.sort() has a default version that works if elements are Comparable (like Integer, String).

        List.sort() is more flexible but forces you to provide a comparator, even if you could use the natural order.
         */

    

    }
    
}

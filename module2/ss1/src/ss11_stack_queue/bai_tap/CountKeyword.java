package ss11_stack_queue.bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class CountKeyword {
    public static void main(String[] args) {
        Map<Character, Integer> myMap = new TreeMap<>();
        String str = "Hoanglinhphan16";
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (!myMap.containsKey(str.charAt(i))) {
                myMap.put(str.charAt(i), 1);
            } else myMap.put(str.charAt(i), myMap.get(str.charAt(i)) + 1);
        }

        System.out.println(myMap);
    }
}

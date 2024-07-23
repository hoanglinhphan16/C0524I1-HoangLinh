package ss12_map_tree.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new LinkedHashMap<>();
        Map<Character, Integer> map3 = new TreeMap<>();
        String str = "HOANGLINHPHAN16";
        str = str.toLowerCase();

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");

        System.out.println(map.entrySet());

        for (int i=0; i< str.length(); i++) {
            if (!map3.containsKey(str.charAt(i))) {
                map3.put(str.charAt(i), 1);
            } else map3.put(str.charAt(i), map3.get(str.charAt(i)) + 1);
        }

        System.out.println(map3);
        System.out.println(map.entrySet());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

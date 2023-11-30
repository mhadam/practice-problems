package us.hadam.practice.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magMap = new HashMap<>();
        Map<String, Integer> ransomMap = new HashMap<>();
        for (String c: magazine.split("")) {
            magMap.putIfAbsent(c, 0);
            magMap.compute(c, ((c1, i) -> i + 1));
        }
        for (String c: ransomNote.split("")) {
            if (!magMap.containsKey(c)) {
                return false;
            } else {
                magMap.compute(c, ((c1, i) -> (i - 1) == 0 ? null: i-1));
            }
        }
        return true;
    }
}

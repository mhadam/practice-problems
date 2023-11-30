package us.hadam.practice.hashmaps;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            List<String> letters = Arrays.stream(s.split(""))
                    .sorted()
                    .map(String::toLowerCase)
                    .toList();
            String sortedStr = String.join("", letters);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(s);
        }
        return map.values().stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }
}

package us.hadam.practice.slidingwindow;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxVowelsSubstring {
  public static int maxVowels(String s, int k) {
    int cur = 0;
    Set<Character> vowels =
        Stream.of("aeiou")
            .flatMapToInt(String::chars)
            .mapToObj(c -> (char) c)
            .collect(Collectors.toUnmodifiableSet());
    int[] array = s.chars().map(c -> vowels.contains((char) c) ? 1 : 0).toArray();
    for (int i = 0; i < k; i++) {
      cur += array[i];
    }
    int best = cur;
    for (int i = k; i < s.length(); i++) {
      cur += array[i] - array[i - k];
      if (cur > best) best = cur;
    }
    return best;
  }
}

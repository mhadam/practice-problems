package us.hadam.practice.twopointers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsPalindrome {
  public static boolean isPalindromePointersMethod(String s) {
    int p1 = 0, p2 = s.length() - 1;
    while (p1 < p2) {
      while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))) {
        p1++;
      }
      while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))) {
        p2--;
      }
      if (Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) {
        return false;
      }
      p1++;
      p2--;
    }
    return true;
  }

  public static boolean isPalindromeIndexMethod(String s) {
    Deque<Character> d = new LinkedList<>();
    String normalized =
        Stream.of(s)
            .flatMapToInt(String::chars)
            .filter(Character::isLetterOrDigit)
            .map(Character::toLowerCase)
            .mapToObj(c -> (char) c)
            .map(String::valueOf)
            .collect(Collectors.joining());
    char[] arr = normalized.toCharArray();
    for (int i = 0; i < ((int) Math.floor(arr.length / 2.0)); i++) {
      int opposingIndex = Math.max(0, arr.length - 1 - i);
      if (arr[opposingIndex] != arr[i]) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindrome(String s) {
    Deque<Character> d = new LinkedList<>();
    String normalized =
        Stream.of(s)
            .flatMapToInt(String::chars)
            .filter(Character::isLetterOrDigit)
            .map(Character::toLowerCase)
            .mapToObj(c -> (char) c)
            .map(String::valueOf)
            .collect(Collectors.joining());
    char[] arr = normalized.toCharArray();
    for (int i = 0; i < ((int) Math.floor(arr.length / 2.0)); i++) {
      d.addFirst(arr[i]);
    }
    for (int i = (int) Math.ceil(arr.length / 2.0); i < arr.length; i++) {
      if (d.pop() != arr[i]) {
        return false;
      }
    }
    return true;
  }
}

package us.hadam.practice.twopointers;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();
    }
}

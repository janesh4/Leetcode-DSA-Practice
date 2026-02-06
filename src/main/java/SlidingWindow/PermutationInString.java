package SlidingWindow;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i ++) {
            targetFreq[s1.charAt(i) - 'a']++;
        }
        int windowSize = s1.length();
        for (int r = 0; r < s2.length(); r++) {

            windowFreq[s2.charAt(r) - 'a']++;

            if (r >= windowSize) {
                windowFreq[s2.charAt(r - windowSize) - 'a']--;
            }

            if (matches(targetFreq, windowFreq)) {
                return true;
            }
       
        }
        return false;
    }

    public boolean matches(int[] targetFreq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }

}

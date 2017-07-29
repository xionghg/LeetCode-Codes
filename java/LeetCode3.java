public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] judge = new boolean[256];

        int index = 0;
        int left = 0;
        int max = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);

            if (judge[ch]) {
                int temp = index - left;
                max = temp > max ? temp : max;
                while (left < index && s.charAt(left++) != ch) {
                    judge[s.charAt(left-1)] = false;
                }
            }
            judge[ch] = true;
            index++;
        }
        int last = index - left;
        return last > max ? last : max;
    }
}

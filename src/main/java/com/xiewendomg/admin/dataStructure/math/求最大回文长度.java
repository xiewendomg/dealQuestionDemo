package com.xiewendomg.admin.dataStructure.math;

public class 求最大回文长度 {
    private int lo, maxLen;

    public static void main(String[] args) {
        求最大回文长度 w = new 求最大回文长度();
        System.out.println(w.longestPalindrome("abtteuuuuba"));
        System.out.println(w.lo);
        System.out.println(w.maxLen);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            //extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;//标记最大长度的开始位置
            maxLen = k - j - 1;
        }
    }
}
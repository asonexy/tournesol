package com.junhua.algorithm.leetcode.datastructure.string;


/**
 * 加速回文字符串算法
 */
public class Manacher {

    public static String manacherStr(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');
        return sb.toString();
    }

    public static Tuple getPalindromeLength(String manacherStr) {
        int max = 0;
        int pR = -1, id = -1;

        Tuple res = new Tuple();
        int[] p = new int[manacherStr.length()];

        for (int i = 0; i < manacherStr.length(); i++) {
            if (i < pR) {
                p[i] = Math.min(p[2 * id - i], pR - i);
            } else p[i] = 1;

            while (i + p[i] < manacherStr.length() && i - p[i] >= 0) {
                if (manacherStr.charAt(i + p[i]) == manacherStr.charAt(i - p[i])) {
                    p[i]++;
                } else break;
            }
            if (i + p[i] > pR) {
                pR = i + p[i];
                id = i;
            }
            if (p[i] > max) {
                max = p[i];
                res.setIndex(i);
                res.setLength(max*2-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        Tuple tuple = getPalindromeLength(str1);
        String res = longestPalindrome(str1);
        return;
    }


    static public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        String manacherStr = manacherStr(s);
        Tuple tuple = getPalindromeLength(manacherStr);
        StringBuffer sb = new StringBuffer();
        for (int i = tuple.index - tuple.length / 2; i < tuple.index + tuple.length / 2; i++) {
            if (manacherStr.charAt(i) != '#') sb.append(manacherStr.charAt(i));
        }
        return sb.toString();
    }

    public static class Tuple {
        private int index;
        private int length;

        public Tuple() {
        }

        public Tuple(int index, int length) {
            this.index = index;
            this.length = length;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getIndex() {
            return index;
        }

        public int getLength() {
            return length;
        }
    }
}

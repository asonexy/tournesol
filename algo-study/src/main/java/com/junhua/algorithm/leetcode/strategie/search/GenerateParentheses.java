package com.junhua.algorithm.leetcode.strategie.search;

import java.util.*;

public class GenerateParentheses {

    /**
     * 暴力解法：列出所有的可能性，判断符合条件的情况
     *
     * @param n
     * @return
     */
    static public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        generate(res, "", n * 2, 0);
        return res;
    }

    static public void generate(List<String> res, String element, int size, int cnt) {
        CYCLE_COUNT1++;
        if (element.length() == size) {
            if (isValid(element)) {
                res.add(element);
            }
            return;
        }
        generate(res, element + '(', size, cnt + 1);
        generate(res, element + ')', size, cnt + 1);
    }


    static public int CYCLE_COUNT1 = 0;
    static public int CYCLE_COUNT2 = 0;

    /**
     * @param n
     * @return
     */
    static public List<String> generateParenthesis2(int n) {
        if (n == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        generate2(res, "", n, n);
        return res;
    }

    static public void generate2(List<String> res, String element, int leftSize, int rightSize) {
        CYCLE_COUNT2++;
        if (leftSize == 0 && rightSize == 0) {
            res.add(element);
            return;
        }
        if (leftSize >= 0)
            generate2(res, element + '(', leftSize - 1, rightSize);
        if (rightSize > leftSize)
            generate2(res, element + ')', leftSize, rightSize - 1);
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println("generate 1 " + CYCLE_COUNT1);
        List<String> res2 = generateParenthesis2(3);
        System.out.println("generate 2 " + CYCLE_COUNT2);
        return;
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

package com.junhua.tornesol.util.leetcode.bit;

public class HammingWeight {


    public static void main(String[] args) {
        int i = 15;
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        System.out.println(count);
    }
}

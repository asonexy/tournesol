package com.junhua.algorithm.leetcode.datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {


    static public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> innerList = new ArrayList<>(i);
            innerList.add(1);
            int start = 1;
            int end = i - 2;
            while (start <= end) {
                int num = res.get(i - 2).get(start - 1) + res.get(i - 2).get(start);
                innerList.add(num);
                start++;
            }
            if (end >= 0) innerList.add(1);
            res.add(innerList);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res3 = generate(3);
        List<List<Integer>> res4 = generate(4);
        List<List<Integer>> res5 = generate(5);

        return;
    }
}

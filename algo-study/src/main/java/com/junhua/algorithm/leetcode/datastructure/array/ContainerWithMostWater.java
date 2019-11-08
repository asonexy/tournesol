package com.junhua.algorithm.leetcode.datastructure.array;

public class ContainerWithMostWater {

    /**
     * 暴力求解：O(N^2)
     *
     * @param height
     * @return
     */
    static public int maxArea(int[] height) {

        if (height == null || height.length == 0) return 0;
        int len = height.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int maxArea = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                maxArea = Math.max(maxArea, Math.abs(i - j) * (Math.min(height[i], height[j])));
            }
            res = Math.max(res, maxArea);
        }
        return res;
    }


    /**
     * 双指针：O(N)
     *
     * @param height
     * @return
     */
    static public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.abs(l - r) * (Math.min(height[l], height[r])));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea(height);
        int max2 = maxArea2(height);
        return;
    }
}

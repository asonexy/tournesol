package com.junhua.algorithm.leetcode.datastructure.array;

import java.util.*;

public class ThreeSum {


    /**
     * O（N^2）: 重要的是要去重
     *
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = len - 1;
                int target = nums[i];
                while (l < r) {
                    int num = nums[l] + nums[r];
                    if (num + target == 0) {
                        res.add(Arrays.asList(target, nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (target + num > 0) r--;
                    else l++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        return;
    }
}

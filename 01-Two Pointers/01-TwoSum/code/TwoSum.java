/*
 Two Sum II - Input Array Is Sorted

 LeetCode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 Difficulty: Medium

 Problem:
 Given a 1-indexed integer array numbers sorted in non-decreasing order,
 find two numbers whose sum equals target. Return their 1-based indices
 as [index1, index2], where index1 < index2.

 The array contains exactly one solution, the same element cannot be used
 twice, and the solution must use O(1) extra space.

 Test Case 1:
 Input:  numbers = [2,7,11,15], target = 9
 Output: [1,2]

 Test Case 2:
 Input:  numbers = [2,3,4], target = 6
 Output: [1,3]

 Test Case 3:
 Input:  numbers = [-1,0], target = -1
 Output: [1,2]

*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Brute force: O(n^2) time, O(1) space
    public static int[] twoSumBruteForce(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 }; // 1-indexed
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Better - HashMap: O(n) time, O(n) space
    public static int[] twoSumBetter(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index (0-based)
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement) + 1, i + 1 }; // 1-indexed
            }
            seen.put(numbers[i], i);
        }
        return new int[] { -1, -1 };
    }

    // Optimal - Two Pointer: O(n) time, O(1) space
    public static int[] twoSumOptimal(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 1-indexed
            } else if (sum < target) {
                left++; // sum too small, move left pointer forward
            } else {
                right--; // sum too big, move right pointer backward
            }
        }
        return new int[] { -1, -1 };
    }

    /*
     * Dry run of the optimal solution
     * Input: numbers = [2, 7, 11, 15], target = 9
     *
     * Step 1: left = 0, right = 3 -> sum = 2 + 15 = 17
     * 17 > 9, so right-- -> right = 2
     *
     * Step 2: left = 0, right = 2 -> sum = 2 + 11 = 13
     * 13 > 9, so right-- -> right = 1
     *
     * Step 3: left = 0, right = 1 -> sum = 2 + 7 = 9
     * 9 == 9, found! return [left+1, right+1] = [1, 2]
     *
     * Output: [1, 2]
     */

    // Runs the optimal solution against multiple test cases
    public static void main(String[] args) {

        int[][] testArrays = {
                { 2, 7, 11, 15 },
                { 2, 3, 4 },
                { -1, 0 },
                { 1, 2, 3, 4, 4, 9, 56, 90 },
                { 5, 25, 75 }
        };

        int[] targets = { 9, 6, -1, 8, 100 };

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = twoSumOptimal(testArrays[i], targets[i]);
            System.out.println("Test " + (i + 1) + ": " + java.util.Arrays.toString(result));
        }
    }
}

/*
 Three Sum

 LeetCode: https://leetcode.com/problems/3sum/
 Difficulty: Medium

 Problem:
 Given an integer array nums, return all the unique triplets
 [nums[i], nums[j], nums[k]] such that:

 nums[i] + nums[j] + nums[k] == 0

 The solution must not contain duplicate triplets.

 Test Case 1:
 Input:  nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]

 Test Case 2:
 Input:  nums = [0,1,1]
 Output: []

 Test Case 3:
 Input:  nums = [0,0,0]
 Output: [[0,0,0]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    // Brute force: O(n^3) time, O(1) extra space
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k]);

                        triplet = new ArrayList<>(triplet);
                        triplet.sort(Integer::compareTo);

                        result.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    // Better - HashSet: O(n^2) time, O(n) extra space
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int complement = -(nums[i] + nums[j]);

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(
                            nums[i],
                            nums[j],
                            complement);

                    triplet = new ArrayList<>(triplet);
                    triplet.sort(Integer::compareTo);

                    result.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }

    // Optimal - Sorting + Two Pointers: O(n^2) time, O(1) extra space
    public static List<List<Integer>> threeSumOptimal(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {

        int[][] testCases = {
                { -1, 0, 1, 2, -1, -4 },
                { 0, 1, 1 },
                { 0, 0, 0 },
                { -2, 0, 1, 1, 2 },
                { -1, 0, 1, 2, -1, -4 }
        };

        for (int i = 0; i < testCases.length; i++) {

            List<List<Integer>> result = threeSumOptimal(testCases[i]);

            System.out.println(
                    "Test " + (i + 1) + ": " + result);
        }
    }
}







/*
 Dry Run - Optimal Approach

 Input:
 nums = [-1,0,1,2,-1,-4]

 After sorting:
 nums = [-4,-1,-1,0,1,2]

 Step 1:
 i = 0, left = 1, right = 5
 -4 + (-1) + 2 = -3
 Sum < 0 -> left++

 Step 2:
 i = 0, left = 2, right = 5
 -4 + (-1) + 2 = -3
 Sum < 0 -> left++

 Step 3:
 i = 0, left = 3, right = 5
 -4 + 0 + 2 = -2
 Sum < 0 -> left++

 Step 4:
 i = 0, left = 4, right = 5
 -4 + 1 + 2 = -1
 Sum < 0 -> left++

 Step 5:
 i = 1, left = 2, right = 5
 -1 + (-1) + 2 = 0
 Found: [-1,-1,2]

 Move both pointers and skip duplicates.

 Step 6:
 i = 1, left = 3, right = 4
 -1 + 0 + 1 = 0
 Found: [-1,0,1]

 Output:
 [[-1,-1,2],[-1,0,1]]
*/

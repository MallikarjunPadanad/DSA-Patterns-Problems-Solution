/*
 Move Zeros

 LeetCode: https://leetcode.com/problems/move-zeroes/
 Difficulty: Easy

 Problem:
 Given an integer array nums, move all 0s to the end of the array
 while maintaining the relative order of the non-zero elements.

 You must do this in-place without making a copy of the array.

 Test Case 1:
 Input:  nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]

 Test Case 2:
 Input:  nums = [0]
 Output: [0]

 Test Case 3:
 Input:  nums = [1,2,3]
 Output: [1,2,3]

 Test Case 4:
 Input:  nums = [0,0,1,0,3,0,5]
 Output: [1,3,5,0,0,0,0]
*/

import java.util.Arrays;

public class MoveZeros {

    // Brute Force: Bubble Sort
    // Time: O(n^2)
    // Space: O(1)
    public static void moveZerosBruteForce(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] == 0 && nums[j + 1] != 0) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // Better: Extra Array
    // Time: O(n)
    // Space: O(n)
    public static void moveZerosBetter(int[] nums) {

        int[] result = new int[nums.length];

        int index = 0;

        for (int num : nums) {

            if (num != 0) {
                result[index++] = num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // Optimal: Two Pointer
    // Time: O(n)
    // Space: O(1)
    public static void moveZerosOptimal(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                swap(nums, index, i);

                index++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {0, 1, 0, 3, 12},
                {0},
                {1, 2, 3},
                {0, 0, 1, 0, 3, 0, 5}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            moveZerosOptimal(nums);

            System.out.println(
                    "Test " + (i + 1) + ": " + Arrays.toString(nums));
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:
 nums = [0,1,0,3,12]

 Initial:
 index = 0


 Step 1:
 i = 0

 nums[i] = nums[0] = 0

 0 is ignored.

 index = 0


 Step 2:
 i = 1

 nums[i] = nums[1] = 1

 1 is non-zero.

 Swap nums[index] and nums[i]:

 [0,1,0,3,12]
  ↑ ↑
 index i

 After swap:
 [1,0,0,3,12]

 Move:
 index++

 index = 1


 Step 3:
 i = 2

 nums[i] = nums[2] = 0

 0 is ignored.

 index = 1


 Step 4:
 i = 3

 nums[i] = nums[3] = 3

 3 is non-zero.

 Swap nums[index] and nums[i]:

 [1,0,0,3,12]
    ↑     ↑
  index   i

 After swap:
 [1,3,0,0,12]

 Move:
 index++

 index = 2


 Step 5:
 i = 4

 nums[i] = nums[4] = 12

 12 is non-zero.

 Swap nums[index] and nums[i]:

 [1,3,0,0,12]
       ↑     ↑
     index   i

 After swap:
 [1,3,12,0,0]

 Move:
 index++

 index = 3


 Loop ends.


 Final Output:
 [1,3,12,0,0]


 Two Pointer Pattern:

 [0 ... index-1]       -> Non-zero elements
 [index ... i-1]       -> Zeros
 [i ... n-1]           -> Unprocessed


 Rule:

 nums[i] != 0
 -> swap(index, i)
 -> index++

 nums[i] == 0
 -> do nothing


 Why does this work?

 index always points to the position where
 the next non-zero element should be placed.

 i scans every element from left to right.

 Therefore:

 Non-zero elements move toward the beginning.
 Zeros automatically move toward the end.

 The relative order of non-zero elements is maintained.


 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
*/

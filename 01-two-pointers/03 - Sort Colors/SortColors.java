/*
 Sort Colors

 LeetCode: https://leetcode.com/problems/sort-colors/
 Difficulty: Medium

 Problem:
 Given an array nums with n objects colored red, white, or blue,
 sort them in-place so that objects of the same color are adjacent,
 with the colors in the order red, white, and blue.

 The colors are represented by:
 0 -> Red
 1 -> White
 2 -> Blue

 You must solve this problem without using the library's sort function.

 Test Case 1:
 Input:  nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

 Test Case 2:
 Input:  nums = [2,0,1]
 Output: [0,1,2]

 Test Case 3:
 Input:  nums = [0]
 Output: [0]

 Test Case 4:
 Input:  nums = [1]
 Output: [1]
*/

import java.util.Arrays;

public class SortColors {

    // Brute Force: Bubble Sort
    // Time: O(n^2)
    // Space: O(1)
    public static void sortColorsBruteForce(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // Better: Counting
    // Time: O(n)
    // Space: O(1)
    public static void sortColorsBetter(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {

            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;

        while (count0-- > 0) {
            nums[index++] = 0;
        }

        while (count1-- > 0) {
            nums[index++] = 1;
        }

        while (count2-- > 0) {
            nums[index++] = 2;
        }
    }

    // Optimal: Dutch National Flag Algorithm
    // Time: O(n)
    // Space: O(1)
    public static void sortColorsOptimal(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                swap(nums, low, mid);

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                swap(nums, mid, high);

                high--;
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
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {0},
                {1},
                {1, 2, 0, 2, 1, 0}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            sortColorsOptimal(nums);

            System.out.println(
                    "Test " + (i + 1) + ": " + Arrays.toString(nums));
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:
 nums = [2,0,2,1,1,0]

 Initial:
 low = 0
 mid = 0
 high = 5


 Step 1:
 nums[mid] = nums[0] = 2

 2 belongs to the right side.

 Swap nums[mid] and nums[high]:

 [2,0,2,1,1,0]
  ↑         ↑
 mid       high

 After swap:
 [0,0,2,1,1,2]

 Move:
 high--

 low = 0
 mid = 0
 high = 4


 Step 2:
 nums[mid] = nums[0] = 0

 0 belongs to the left side.

 Swap nums[low] and nums[mid]:

 [0,0,2,1,1,2]
  ↑
 low
  ↑
 mid

 After swap:
 [0,0,2,1,1,2]

 Move:
 low++
 mid++

 low = 1
 mid = 1
 high = 4


 Step 3:
 nums[mid] = nums[1] = 0

 0 belongs to the left side.

 Swap nums[low] and nums[mid]:

 [0,0,2,1,1,2]
    ↑
   low
    ↑
   mid

 After swap:
 [0,0,2,1,1,2]

 Move:
 low++
 mid++

 low = 2
 mid = 2
 high = 4


 Step 4:
 nums[mid] = nums[2] = 2

 2 belongs to the right side.

 Swap nums[mid] and nums[high]:

 [0,0,2,1,1,2]
       ↑   ↑
      mid high

 After swap:
 [0,0,1,1,2,2]

 Move:
 high--

 low = 2
 mid = 2
 high = 3

 Important:
 We do not move mid here because the element
 received from high has not been processed yet.


 Step 5:
 nums[mid] = nums[2] = 1

 1 belongs to the middle.

 Move:
 mid++

 low = 2
 mid = 3
 high = 3


 Step 6:
 nums[mid] = nums[3] = 1

 1 belongs to the middle.

 Move:
 mid++

 low = 2
 mid = 4
 high = 3


 Loop condition:
 mid <= high

 4 <= 3 -> false

 Loop stops.


 Final Output:
 [0,0,1,1,2,2]


 Dutch National Flag Pattern:

 [0 ... low-1]     -> 0
 [low ... mid-1]   -> 1
 [mid ... high]    -> Unknown
 [high+1 ... n-1]  -> 2


 Rules:

 nums[mid] == 0
 -> swap(low, mid)
 -> low++
 -> mid++

 nums[mid] == 1
 -> mid++

 nums[mid] == 2
 -> swap(mid, high)
 -> high--


 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
*/

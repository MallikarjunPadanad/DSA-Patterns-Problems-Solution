/*
 Sort 0 and 1

 Problem:
 Given a binary array containing only 0s and 1s,
 sort the array in-place so that all 0s come before all 1s.

 Test Case 1:
 Input:  nums = [0,1,0,1,1,0]
 Output: [0,0,0,1,1,1]

 Test Case 2:
 Input:  nums = [1,0,1,0]
 Output: [0,0,1,1]

 Test Case 3:
 Input:  nums = [0,0,0]
 Output: [0,0,0]

 Test Case 4:
 Input:  nums = [1,1,1]
 Output: [1,1,1]
*/

import java.util.Arrays;

public class Sort0And1 {

    // Brute Force: Bubble Sort
    // Time: O(n^2)
    // Space: O(1)
    public static void sortBruteForce(int[] nums) {

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
    public static void sortBetter(int[] nums) {

        int count0 = 0;

        for (int num : nums) {

            if (num == 0) {
                count0++;
            }
        }

        int index = 0;

        while (count0-- > 0) {
            nums[index++] = 0;
        }

        while (index < nums.length) {
            nums[index++] = 1;
        }
    }

    // Optimal: Two Pointer
    // Time: O(n)
    // Space: O(1)
    public static void sortOptimal(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] == 0) {
                left++;
            } else if (nums[right] == 1) {
                right--;
            } else {
                swap(nums, left, right);

                left++;
                right--;
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
                {0, 1, 0, 1, 1, 0},
                {1, 0, 1, 0},
                {0, 0, 0},
                {1, 1, 1},
                {1, 0, 0, 1, 0, 1}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            sortOptimal(nums);

            System.out.println(
                    "Test " + (i + 1) + ": " + Arrays.toString(nums));
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:
 nums = [0,1,0,1,1,0]

 Initial:
 left = 0
 right = 5


 Step 1:
 nums[left] = nums[0] = 0

 0 is already on the left side.

 Move:
 left++

 left = 1
 right = 5


 Step 2:
 nums[left] = nums[1] = 1
 nums[right] = nums[5] = 0

 1 is on the wrong side.
 0 is on the wrong side.

 Swap nums[left] and nums[right]:

 [0,1,0,1,1,0]
    ↑       ↑
   left   right

 After swap:
 [0,0,0,1,1,1]

 Move:
 left++
 right--

 left = 2
 right = 4


 Step 3:
 nums[left] = nums[2] = 0

 0 is already on the left side.

 Move:
 left++

 left = 3
 right = 4


 Step 4:
 nums[left] = nums[3] = 1
 nums[right] = nums[4] = 1

 Both elements are already on the correct side.

 Move:
 right--

 left = 3
 right = 3


 Loop condition:
 left < right

 3 < 3 -> false

 Loop stops.


 Final Output:
 [0,0,0,1,1,1]


 Two Pointer Pattern:

 [0 ... left-1]     -> 0
 [left ... right]   -> Unknown
 [right+1 ... n-1]  -> 1


 Rules:

 nums[left] == 0
 -> left++

 nums[right] == 1
 -> right--

 nums[left] == 1 && nums[right] == 0
 -> swap(left, right)
 -> left++
 -> right--


 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
*/

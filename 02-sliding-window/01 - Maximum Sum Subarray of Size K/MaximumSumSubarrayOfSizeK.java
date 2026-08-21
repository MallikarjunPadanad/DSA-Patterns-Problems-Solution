/*
 Maximum Sum Subarray of Size K

 Problem:
 Given an integer array nums and an integer k,
 find the maximum sum of any contiguous subarray
 of size k.

 A subarray must contain exactly k consecutive elements.

 Formula:

 Sum = nums[i] + nums[i + 1] + ... + nums[i + k - 1]

 Test Case 1:
 Input:  nums = [2,1,5,1,3,2], k = 3
 Output: 9

 Explanation:
 Subarrays of size 3:

 [2,1,5] = 8
 [1,5,1] = 7
 [5,1,3] = 9
 [1,3,2] = 6

 Maximum sum = 9

 Test Case 2:
 Input:  nums = [2,3,4,1,5], k = 2
 Output: 7

 Test Case 3:
 Input:  nums = [1,2,3,4,5], k = 3
 Output: 12

 Test Case 4:
 Input:  nums = [5,5,5,5], k = 2
 Output: 10
*/

import java.util.Arrays;

public class MaximumSumSubarrayOfSizeK {

    // Brute Force: Calculate Every Subarray Sum
    // Time: O(n * k)
    // Space: O(1)
    public static int maxSumBruteForce(int[] nums, int k) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Better: Reuse Previous Sum
    // Time: O(n)
    // Space: O(1)
    public static int maxSumBetter(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {

            sum = sum - nums[i - k] + nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Optimal: Sliding Window
    // Time: O(n)
    // Space: O(1)
    public static int maxSumOptimal(int[] nums, int k) {

        int left = 0;
        int right = 0;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (right < nums.length) {

            windowSum += nums[right];

            if (right - left + 1 == k) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= nums[left];

                left++;
            }

            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {2, 1, 5, 1, 3, 2},
                {2, 3, 4, 1, 5},
                {1, 2, 3, 4, 5},
                {5, 5, 5, 5}
        };

        int[] kValues = {
                3,
                2,
                3,
                2
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            int k = kValues[i];

            int result = maxSumOptimal(nums, k);

            System.out.println(
                    "Test " + (i + 1) + ": "
                            + Arrays.toString(nums)
                            + ", k = " + k
                            + " -> " + result);
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:

 nums = [2,1,5,1,3,2]
 k = 3


 Initial:

 left = 0
 right = 0

 windowSum = 0
 maxSum = Integer.MIN_VALUE


 Step 1:

 right = 0

 Add:
 nums[right] = 2

 windowSum = 0 + 2
           = 2

 Window size:

 right - left + 1
 = 0 - 0 + 1
 = 1

 Window size is less than k.

 Move:
 right++


 left = 0
 right = 1


 Step 2:

 Add:
 nums[right] = 1

 windowSum = 2 + 1
           = 3

 Window size:

 right - left + 1
 = 1 - 0 + 1
 = 2

 Window size is less than k.

 Move:
 right++


 left = 0
 right = 2


 Step 3:

 Add:
 nums[right] = 5

 windowSum = 3 + 5
           = 8

 Window size:

 right - left + 1
 = 2 - 0 + 1
 = 3

 Window size == k.

 Current window:

 [2,1,5]

 Current sum:

 8

 maxSum = max(Integer.MIN_VALUE, 8)
        = 8


 Now remove the element
 at the left side of the window.

 Remove:

 nums[left] = 2

 windowSum = 8 - 2
           = 6

 Move:
 left++


 left = 1
 right = 3


 Step 4:

 Add:

 nums[right] = 1

 windowSum = 6 + 1
           = 7

 Window size:

 right - left + 1
 = 3 - 1 + 1
 = 3

 Window size == k.

 Current window:

 [1,5,1]

 Current sum:

 7

 maxSum = max(8, 7)
        = 8


 Remove:

 nums[left] = 1

 windowSum = 7 - 1
           = 6

 Move:
 left++


 left = 2
 right = 4


 Step 5:

 Add:

 nums[right] = 3

 windowSum = 6 + 3
           = 9

 Window size:

 right - left + 1
 = 4 - 2 + 1
 = 3

 Window size == k.

 Current window:

 [5,1,3]

 Current sum:

 9

 maxSum = max(8, 9)
        = 9


 Remove:

 nums[left] = 5

 windowSum = 9 - 5
           = 4

 Move:
 left++


 left = 3
 right = 5


 Step 6:

 Add:

 nums[right] = 2

 windowSum = 4 + 2
           = 6

 Window size:

 right - left + 1
 = 5 - 3 + 1
 = 3

 Window size == k.

 Current window:

 [1,3,2]

 Current sum:

 6

 maxSum = max(9, 6)
        = 9


 Remove:

 nums[left] = 1

 windowSum = 6 - 1
           = 5

 Move:
 left++


 left = 4
 right = 6


 Loop condition:

 right < nums.length

 6 < 6 -> false

 Loop stops.


 Final Output:

 9


 Sliding Window Pattern:

 [2, 1, 5, 1, 3, 2]
  ↑        ↑
 left     right

 First window:

 [2, 1, 5]
 sum = 8


 Slide the window:

 [2, 1, 5, 1]
  ↑           ↑

 Remove 2
 Add 1

 New window:

 [1, 5, 1]
 sum = 7


 Slide again:

 Remove 1
 Add 3

 New window:

 [5, 1, 3]
 sum = 9


 Slide again:

 Remove 5
 Add 2

 New window:

 [1, 3, 2]
 sum = 6


 Maximum:

 max(8, 7, 9, 6) = 9


 Important Rule:

 For a fixed-size sliding window of size K:

 1. Add the right element.
 2. Check if window size == K.
 3. Calculate/update the answer.
 4. Remove the left element.
 5. Move left forward.
 6. Move right forward.


 Why Sliding Window?

 Brute Force recalculates the complete sum
 for every subarray.

 Example:

 [2,1,5] = 8
 [1,5,1] = 7

 Instead of calculating:

 1 + 5 + 1

 again from scratch,

 we can reuse the previous sum:

 Previous sum = 8

 Remove outgoing element:

 8 - 2 = 6

 Add incoming element:

 6 + 1 = 7

 Therefore:

 New sum = Previous sum - outgoing element + incoming element


 This reduces the time complexity from:

 O(n * k)

 to:

 O(n)


 Fixed-Size Sliding Window:

 Window size = k

        k elements
    ┌─────────────┐
    ↓             ↓
 [2, 1, 5, 1, 3, 2]
  ↑           ↑
 left        right


 When window reaches size k:

 Calculate answer.

 Then:

 Remove nums[left]
 left++

 Continue moving right.


 Time Complexity:

 O(n)

 Each element is added to the window once
 and removed from the window once.


 Space Complexity:

 O(1)

 No extra data structure is used.
*/

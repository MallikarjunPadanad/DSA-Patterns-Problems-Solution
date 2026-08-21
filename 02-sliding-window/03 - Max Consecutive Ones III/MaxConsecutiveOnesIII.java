/*
 Max Consecutive Ones III

 LeetCode: https://leetcode.com/problems/max-consecutive-ones-iii/
 Difficulty: Medium

 Problem:
 Given a binary array nums and an integer k,
 return the maximum number of consecutive 1s in the array
 if you can flip at most k zeros.

 A zero can be changed into a one.

 Test Case 1:
 Input:  nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 Output: 6

 Explanation:
 Flip the zeros at positions 5 and 10:

 [1,1,1,0,0,1,1,1,1,1,1]

 Maximum consecutive 1s = 6

 Test Case 2:
 Input:  nums = [0,0,1,1,1,0,0], k = 0
 Output: 3

 Test Case 3:
 Input:  nums = [0,0,0,1], k = 4
 Output: 4

 Test Case 4:
 Input:  nums = [1,1,1,1], k = 0
 Output: 4
*/

import java.util.Arrays;

public class MaxConsecutiveOnesIII {

    // Brute Force: Check Every Subarray
    // Time: O(n^2)
    // Space: O(1)
    public static int longestOnesBruteForce(int[] nums, int k) {

        int maxLength = 0;

        for (int left = 0; left < nums.length; left++) {

            int zeroCount = 0;

            for (int right = left; right < nums.length; right++) {

                if (nums[right] == 0) {
                    zeroCount++;
                }

                if (zeroCount > k) {
                    break;
                }

                int length = right - left + 1;

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    // Better: Sliding Window with Explicit Shrinking
    // Time: O(n)
    // Space: O(1)
    public static int longestOnesBetter(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    // Optimal: Sliding Window
    // Time: O(n)
    // Space: O(1)
    public static int longestOnesOptimal(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };

        int[] kValues = {
                2,
                0,
                4,
                0
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            int k = kValues[i];

            int result = longestOnesOptimal(nums, k);

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

 nums = [1,1,1,0,0,0,1,1,1,1,0]
 k = 2


 Initial:

 left = 0
 zeroCount = 0
 maxLength = 0


 Step 1:

 right = 0
 nums[right] = 1

 zeroCount = 0

 Window:

 [1]

 length = right - left + 1
        = 0 - 0 + 1
        = 1

 maxLength = 1


 Step 2:

 right = 1
 nums[right] = 1

 zeroCount = 0

 Window:

 [1,1]

 length = 2

 maxLength = 2


 Step 3:

 right = 2
 nums[right] = 1

 zeroCount = 0

 Window:

 [1,1,1]

 length = 3

 maxLength = 3


 Step 4:

 right = 3
 nums[right] = 0

 zeroCount++

 zeroCount = 1

 Window:

 [1,1,1,0]

 We can flip this zero.

 length = 4

 maxLength = 4


 Step 5:

 right = 4
 nums[right] = 0

 zeroCount++

 zeroCount = 2

 Window:

 [1,1,1,0,0]

 We can flip both zeros.

 length = 5

 maxLength = 5


 Step 6:

 right = 5
 nums[right] = 0

 zeroCount++

 zeroCount = 3

 Now:

 zeroCount > k

 3 > 2


 We cannot flip 3 zeros.

 Shrink the window.

 nums[left] = 1

 Since nums[left] is 1:

 zeroCount remains 3

 Move:

 left++


 left = 1


 Window is now:

 [1,1,0,0,0]

 Still:

 zeroCount = 3

 zeroCount > k


 Shrink again.

 nums[left] = 1

 zeroCount remains 3

 Move:

 left++


 left = 2


 Window:

 [1,0,0,0]

 Still:

 zeroCount = 3


 Shrink again.

 nums[left] = 1

 zeroCount remains 3

 Move:

 left++


 left = 3


 Window:

 [0,0,0]

 Still:

 zeroCount = 3


 Shrink again.

 nums[left] = 0

 zeroCount--

 zeroCount = 2

 Move:

 left++


 left = 4


 Window:

 [0,0]

 Now:

 zeroCount = 2

 zeroCount <= k


 length:

 right - left + 1
 = 5 - 4 + 1
 = 2

 maxLength = 5


 Step 7:

 right = 6
 nums[right] = 1

 zeroCount = 2

 Window:

 [0,0,1]

 length:

 6 - 4 + 1
 = 3

 maxLength = 5


 Step 8:

 right = 7
 nums[right] = 1

 zeroCount = 2

 Window:

 [0,0,1,1]

 length = 4

 maxLength = 5


 Step 9:

 right = 8
 nums[right] = 1

 zeroCount = 2

 Window:

 [0,0,1,1,1]

 length = 5

 maxLength = 5


 Step 10:

 right = 9
 nums[right] = 1

 zeroCount = 2

 Window:

 [0,0,1,1,1,1]

 length = 6

 maxLength = 6


 maxLength = 6


 Step 11:

 right = 10
 nums[right] = 0

 zeroCount++

 zeroCount = 3

 Now:

 zeroCount > k

 3 > 2


 Shrink window.

 nums[left] = 0

 zeroCount--

 zeroCount = 2

 Move:

 left++


 left = 5


 Window:

 [0,1,1,1,1,0]

 zeroCount = 2

 length:

 right - left + 1
 = 10 - 5 + 1
 = 6

 maxLength = 6


 Loop stops.


 Final Output:

 6


 Sliding Window Pattern:

 The important difference from
 Max Consecutive Ones is:

 Max Consecutive Ones:

 We cannot flip zeros.

 Therefore:

 0 -> reset count


 Max Consecutive Ones III:

 We are allowed to flip at most k zeros.

 Therefore:

 0 -> increase zeroCount

 If:

 zeroCount > k

 Shrink the window.


 Important Rule:

 Maintain a window containing
 at most k zeros.

 Condition:

 zeroCount <= k

 means:

 The current window can be converted
 completely into 1s.


 Example:

 nums = [1,1,0,1,0,1]
 k = 2


 Window:

 [1,1,0,1,0,1]

 Number of zeros = 2

 Since:

 2 <= k

 We can flip both zeros.

 Result:

 [1,1,1,1,1,1]

 Length = 6


 Example:

 nums = [1,1,0,1,0,0,1]
 k = 2


 If the window contains:

 [1,1,0,1,0,0]

 Number of zeros = 3

 But:

 3 > 2


 We cannot keep this entire window.

 Therefore, move left forward
 until the number of zeros becomes <= k.


 Two Pointer Pattern:

        left                 right
          ↓                    ↓
 [1,1,1,0,0,0,1,1,1,1,0]
  └───────────────┘

 Window contains:

 3 zeros

 k = 2


 Since:

 3 > 2

 Move left forward.


 After shrinking:

        left                 right
          ↓                    ↓
 [1,1,1,0,0,0,1,1,1,1,0]
              └─────────────┘

 Now window contains:

 2 zeros

 Therefore:

 zeroCount <= k


 Important Concept:

 We are not actually changing
 0 to 1 in the array.

 We only count how many zeros
 are inside the current window.

 If the number of zeros is <= k,
 then all those zeros can theoretically
 be flipped to 1.

 Therefore:

 Window length = number of consecutive 1s
                after at most k flips.


 Why Sliding Window?

 Brute Force checks every possible
 subarray.

 For each starting position,
 it counts the number of zeros.

 This takes:

 O(n^2)


 Sliding Window avoids recalculating
 the entire window.

 When right moves:

 If nums[right] == 0:

     zeroCount++


 When left moves:

 If nums[left] == 0:

     zeroCount--


 Therefore every element is:

 Added once.

 Removed at most once.


 Time Complexity:

 O(n)

 The left pointer moves forward
 at most n times.

 The right pointer moves forward
 exactly n times.


 Space Complexity:

 O(1)

 Only three variables are used:

 left
 zeroCount
 maxLength


 Sliding Window Template:

 int left = 0;
 int zeroCount = 0;
 int maxLength = 0;

 for (int right = 0; right < nums.length; right++) {

     if (nums[right] == 0) {
         zeroCount++;
     }

     if (zeroCount > k) {

         if (nums[left] == 0) {
             zeroCount--;
         }

         left++;
     }

     maxLength = Math.max(
             maxLength,
             right - left + 1
     );
 }


 Core Pattern:

 Expand right
      ↓
 Count zeros
      ↓
 zeroCount > k ?
      ↓
    Yes
      ↓
 Move left
      ↓
 Remove zero if needed
      ↓
 Calculate maximum window length


 Final Pattern:

 "Longest subarray with at most K zeros"

 This is a very important
 variable-condition Sliding Window pattern.


 Time Complexity:

 O(n)

 Space Complexity:

 O(1)
*/

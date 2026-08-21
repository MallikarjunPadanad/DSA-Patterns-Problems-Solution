/*
 Max Consecutive Ones

 LeetCode: https://leetcode.com/problems/max-consecutive-ones/
 Difficulty: Easy

 Problem:
 Given a binary array nums, return the maximum number
 of consecutive 1s in the array.

 Test Case 1:
 Input:  nums = [1,1,0,1,1,1]
 Output: 3

 Test Case 2:
 Input:  nums = [1,0,1,1,0,1]
 Output: 2

 Test Case 3:
 Input:  nums = [1,1,1,1]
 Output: 4

 Test Case 4:
 Input:  nums = [0,0,0]
 Output: 0
*/

import java.util.Arrays;

public class MaxConsecutiveOnes {

    // Brute Force: Check Every Starting Position
    // Time: O(n^2)
    // Space: O(1)
    public static int maxConsecutiveOnesBruteForce(int[] nums) {

        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 1) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    break;
                }
            }
        }

        return maxCount;
    }

    // Better: Count Consecutive Ones
    // Time: O(n)
    // Space: O(1)
    public static int maxConsecutiveOnesBetter(int[] nums) {

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Optimal: One Pass
    // Time: O(n)
    // Space: O(1)
    public static int maxConsecutiveOnesOptimal(int[] nums) {

        int currentCount = 0;
        int maxCount = 0;

        for (int num : nums) {

            if (num == 1) {
                currentCount++;
            } else {
                currentCount = 0;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i].clone();

            int result = maxConsecutiveOnesOptimal(nums);

            System.out.println(
                    "Test " + (i + 1) + ": "
                            + Arrays.toString(nums)
                            + " -> " + result);
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:

 nums = [1,1,0,1,1,1]


 Initial:

 currentCount = 0
 maxCount = 0


 Step 1:

 num = 1

 Since num == 1:

 currentCount++

 currentCount = 1

 maxCount = max(0, 1)
          = 1


 Step 2:

 num = 1

 Since num == 1:

 currentCount++

 currentCount = 2

 maxCount = max(1, 2)
          = 2


 Step 3:

 num = 0

 Since num != 1:

 currentCount = 0

 maxCount = max(2, 0)
          = 2


 Step 4:

 num = 1

 Since num == 1:

 currentCount++

 currentCount = 1

 maxCount = max(2, 1)
          = 2


 Step 5:

 num = 1

 Since num == 1:

 currentCount++

 currentCount = 2

 maxCount = max(2, 2)
          = 2


 Step 6:

 num = 1

 Since num == 1:

 currentCount++

 currentCount = 3

 maxCount = max(2, 3)
          = 3


 Final Output:

 3


 Consecutive Ones Pattern:

 Input:

 [1, 1, 0, 1, 1, 1]
  ↑  ↑  ↑  ↑  ↑  ↑

 Count:

 1  -> currentCount = 1
 1  -> currentCount = 2
 0  -> currentCount = 0
 1  -> currentCount = 1
 1  -> currentCount = 2
 1  -> currentCount = 3


 Maximum:

 maxCount = 3


 Important Rule:

 If nums[i] == 1:

     currentCount++

 Else:

     currentCount = 0


 After every element:

     maxCount = max(maxCount, currentCount)


 Why do we reset the count?

 Example:

 [1,1,0,1,1]

 Before 0:

 [1,1]
 count = 2

 When we encounter 0,
 the consecutive sequence is broken.

 Therefore:

 count = 0


 Then we start counting again:

 [1,1]
 count = 2


 Pattern:

 1 -> increase count

 1 -> increase count

 0 -> reset count

 1 -> increase count

 1 -> increase count


 One Pass Pattern:

 nums = [1,1,0,1,1,1]

                 currentCount
                      ↓
 [1, 1, 0, 1, 1, 1]
  ↑  ↑  ↑  ↑  ↑  ↑
  1  2  0  1  2  3

 maxCount:

 1 -> 2 -> 2 -> 2 -> 2 -> 3


 Final:

 maxCount = 3


 Why is this optimal?

 We only need to scan the array once.

 Every element is processed exactly one time.

 We do not need:

 - Nested loops
 - Extra arrays
 - HashMap
 - Sliding Window data structure


 Time Complexity:

 O(n)

 We visit every element exactly once.


 Space Complexity:

 O(1)

 Only two variables are used:

 currentCount
 maxCount
*/

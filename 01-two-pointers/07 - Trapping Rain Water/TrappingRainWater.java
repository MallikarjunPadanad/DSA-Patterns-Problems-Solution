/*
 Trapping Rain Water

 LeetCode: https://leetcode.com/problems/trapping-rain-water/
 Difficulty: Hard

 Problem:
 Given n non-negative integers representing an elevation map
 where the width of each bar is 1, compute how much water it can
 trap after raining.

 Formula:

 Water at index i =
 min(leftMax, rightMax) - height[i]

 Test Case 1:
 Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6

 Test Case 2:
 Input:  height = [4,2,0,3,2,5]
 Output: 9

 Test Case 3:
 Input:  height = [1,2,3,4,5]
 Output: 0

 Test Case 4:
 Input:  height = [5,4,3,2,1]
 Output: 0
*/

import java.util.Arrays;

public class TrappingRainWater {

    // Brute Force: Find Left Max and Right Max
    // Time: O(n^2)
    // Space: O(1)
    public static int trapBruteForce(int[] height) {

        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {

            int leftMax = 0;
            int rightMax = 0;

            for (int left = 0; left <= i; left++) {
                leftMax = Math.max(leftMax, height[left]);
            }

            for (int right = i; right < height.length; right++) {
                rightMax = Math.max(rightMax, height[right]);
            }

            int waterLevel = Math.min(leftMax, rightMax);

            totalWater += waterLevel - height[i];
        }

        return totalWater;
    }

    // Better: Prefix Max and Suffix Max
    // Time: O(n)
    // Space: O(n)
    public static int trapBetter(int[] height) {

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            totalWater += waterLevel - height[i];
        }

        return totalWater;
    }

    // Optimal: Two Pointer
    // Time: O(n)
    // Space: O(1)
    public static int trapOptimal(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {4, 2, 0, 3, 2, 5},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] height = testCases[i].clone();

            int result = trapOptimal(height);

            System.out.println(
                    "Test " + (i + 1) + ": "
                            + Arrays.toString(height)
                            + " -> " + result);
        }
    }
}


/*
 Dry Run - Optimal Approach

 Input:
 height = [0,1,0,2,1,0,1,3,2,1,2,1]

 Initial:

 left = 0
 right = 11

 leftMax = 0
 rightMax = 0

 totalWater = 0


 Step 1:

 height[left] = 0
 height[right] = 1

 Since:

 height[left] <= height[right]

 Process left side.

 height[left] >= leftMax

 0 >= 0

 Update:

 leftMax = 0

 Move:

 left++

 left = 1
 right = 11


 Step 2:

 height[left] = 1
 height[right] = 1

 Process left side.

 height[left] >= leftMax

 1 >= 0

 Update:

 leftMax = 1

 Move:

 left++

 left = 2
 right = 11


 Step 3:

 height[left] = 0
 height[right] = 1

 Process left side.

 height[left] < leftMax

 0 < 1

 Water:

 leftMax - height[left]
 = 1 - 0
 = 1

 totalWater = 1

 Move:

 left++

 left = 3
 right = 11


 Step 4:

 height[left] = 2
 height[right] = 1

 Since:

 height[left] > height[right]

 Process right side.

 height[right] >= rightMax

 1 >= 0

 Update:

 rightMax = 1

 Move:

 right--

 left = 3
 right = 10


 Step 5:

 height[left] = 2
 height[right] = 2

 Since:

 height[left] <= height[right]

 Process left side.

 height[left] >= leftMax

 2 >= 1

 Update:

 leftMax = 2

 Move:

 left++

 left = 4
 right = 10


 Step 6:

 height[left] = 1
 height[right] = 2

 Process left side.

 height[left] < leftMax

 1 < 2

 Water:

 2 - 1 = 1

 totalWater = 2

 Move:

 left++

 left = 5
 right = 10


 Step 7:

 height[left] = 0
 height[right] = 2

 Process left side.

 Water:

 2 - 0 = 2

 totalWater = 4

 Move:

 left++

 left = 6
 right = 10


 Step 8:

 height[left] = 1
 height[right] = 2

 Process left side.

 Water:

 2 - 1 = 1

 totalWater = 5

 Move:

 left++

 left = 7
 right = 10


 Step 9:

 height[left] = 3
 height[right] = 2

 Process right side.

 height[right] >= rightMax

 2 >= 1

 Update:

 rightMax = 2

 Move:

 right--

 left = 7
 right = 9


 Step 10:

 height[left] = 3
 height[right] = 1

 Process right side.

 height[right] < rightMax

 1 < 2

 Water:

 2 - 1 = 1

 totalWater = 6

 Move:

 right--

 left = 7
 right = 8


 Step 11:

 height[left] = 3
 height[right] = 2

 Process right side.

 height[right] >= rightMax

 2 >= 2

 Update:

 rightMax = 2

 Move:

 right--

 left = 7
 right = 7


 Loop condition:

 left < right

 7 < 7 -> false

 Loop stops.


 Final Output:

 6


 Two Pointer Pattern:

 left                           right
  ↓                               ↓
[0,1,0,2,1,0,1,3,2,1,2,1]


 Maintain:

 leftMax  -> Maximum height seen from left
 rightMax -> Maximum height seen from right


 Important Rule:

 If:

 height[left] <= height[right]

 Process the LEFT side.

 Otherwise:

 Process the RIGHT side.


 Left Side:

 If height[left] >= leftMax

 -> update leftMax

 Else

 -> water = leftMax - height[left]


 Right Side:

 If height[right] >= rightMax

 -> update rightMax

 Else

 -> water = rightMax - height[right]


 Why does this work?

 Water at any position depends on:

 water = min(leftMax, rightMax) - height[i]

 When:

 height[left] <= height[right]

 the left side is the limiting side.

 Therefore, we can safely calculate the water
 at the left pointer using leftMax.

 Similarly, when:

 height[left] > height[right]

 the right side is the limiting side.

 Therefore, we can safely calculate the water
 at the right pointer using rightMax.


 Example:

 left height  = 2
 right height = 5

 Since:

 2 <= 5

 The left side can determine the water level.

 We process left.


 Another example:

 left height  = 5
 right height = 2

 Since:

 5 > 2

 The right side can determine the water level.

 We process right.


 Two Pointer Pattern:

 [processed] [left ... right] [processed]

      ↑                   ↑
     left               right


 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
*/

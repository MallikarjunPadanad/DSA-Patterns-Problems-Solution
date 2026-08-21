/*
 Container With Most Water

 LeetCode: https://leetcode.com/problems/container-with-most-water/
 Difficulty: Medium

 Problem:
 You are given an integer array height of length n.

 There are n vertical lines drawn such that the two endpoints
 of the ith line are (i, 0) and (i, height[i]).

 Find two lines that, together with the x-axis, form a container
 that holds the most water.

 Return the maximum amount of water a container can store.

 You may not slant the container.

 Formula:

 Area = width * minimum(height[left], height[right])

 Test Case 1:
 Input:  height = [1,8,6,2,5,4,8,3,7]
 Output: 49

 Test Case 2:
 Input:  height = [1,1]
 Output: 1

 Test Case 3:
 Input:  height = [4,3,2,1,4]
 Output: 16

 Test Case 4:
 Input:  height = [1,2,1]
 Output: 2
*/

import java.util.Arrays;

public class ContainerWithMostWater {

    // Brute Force: Check Every Pair
    // Time: O(n^2)
    // Space: O(1)
    public static int maxAreaBruteForce(int[] height) {

        int maxArea = 0;

        for (int left = 0; left < height.length; left++) {

            for (int right = left + 1; right < height.length; right++) {

                int width = right - left;

                int minHeight = Math.min(height[left], height[right]);

                int area = width * minHeight;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // Better: Calculate Width and Height Carefully
    // Time: O(n^2)
    // Space: O(1)
    public static int maxAreaBetter(int[] height) {

        int maxArea = 0;

        for (int left = 0; left < height.length - 1; left++) {

            int right = left + 1;

            while (right < height.length) {

                int width = right - left;

                int minHeight;

                if (height[left] < height[right]) {
                    minHeight = height[left];
                } else {
                    minHeight = height[right];
                }

                int area = width * minHeight;

                if (area > maxArea) {
                    maxArea = area;
                }

                right++;
            }
        }

        return maxArea;
    }

    // Optimal: Two Pointer
    // Time: O(n)
    // Space: O(1)
    public static int maxAreaOptimal(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;

            int minHeight = Math.min(height[left], height[right]);

            int area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7},
                {1, 1},
                {4, 3, 2, 1, 4},
                {1, 2, 1}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] height = testCases[i].clone();

            int result = maxAreaOptimal(height);

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
 height = [1,8,6,2,5,4,8,3,7]

 Initial:

 left = 0
 right = 8

 height[left] = 1
 height[right] = 7


 Step 1:

 width = right - left
       = 8 - 0
       = 8

 minHeight = min(1,7)
           = 1

 area = width * minHeight
      = 8 * 1
      = 8

 maxArea = 8


 Since height[left] < height[right]:

 1 < 7

 Move:
 left++


 left = 1
 right = 8


 Step 2:

 height[left] = 8
 height[right] = 7

 width = 8 - 1
       = 7

 minHeight = min(8,7)
           = 7

 area = 7 * 7
      = 49

 maxArea = 49


 Since height[left] > height[right]:

 8 > 7

 Move:
 right--


 left = 1
 right = 7


 Step 3:

 height[left] = 8
 height[right] = 3

 width = 7 - 1
       = 6

 minHeight = min(8,3)
           = 3

 area = 6 * 3
      = 18

 maxArea = 49


 Since height[left] > height[right]:

 8 > 3

 Move:
 right--


 left = 1
 right = 6


 Step 4:

 height[left] = 8
 height[right] = 8

 width = 6 - 1
       = 5

 minHeight = min(8,8)
           = 8

 area = 5 * 8
      = 40

 maxArea = 49


 Heights are equal.

 Move:
 right--


 left = 1
 right = 5


 Step 5:

 height[left] = 8
 height[right] = 4

 width = 5 - 1
       = 4

 minHeight = min(8,4)
           = 4

 area = 4 * 4
      = 16

 maxArea = 49


 Since height[left] > height[right]:

 8 > 4

 Move:
 right--


 left = 1
 right = 4


 Step 6:

 height[left] = 8
 height[right] = 5

 width = 4 - 1
       = 3

 minHeight = min(8,5)
           = 5

 area = 3 * 5
      = 15

 maxArea = 49


 Move:
 right--


 left = 1
 right = 3


 Step 7:

 height[left] = 8
 height[right] = 2

 width = 3 - 1
       = 2

 minHeight = min(8,2)
           = 2

 area = 2 * 2
      = 4

 maxArea = 49


 Move:
 right--


 left = 1
 right = 2


 Step 8:

 height[left] = 8
 height[right] = 6

 width = 2 - 1
       = 1

 minHeight = min(8,6)
           = 6

 area = 1 * 6
      = 6

 maxArea = 49


 Move:
 right--


 left = 1
 right = 1


 Loop condition:

 left < right

 1 < 1 -> false

 Loop stops.


 Final Output:

 49


 Two Pointer Pattern:

 [left] ---------------- [right]

 width = right - left

 area = width * min(height[left], height[right])


 Important Rule:

 If height[left] < height[right]
 -> left++

 Else
 -> right--


 Why do we move the smaller height?

 The area depends on:

 area = width * minimum height

 When we move the taller line, the width decreases
 but the limiting smaller height does not improve.

 Therefore, moving the taller line cannot give us
 a better container from that pair.

 We move the smaller line because there is a possibility
 of finding a taller line that increases the minimum height.


 Example:

 left height  = 8
 right height = 3

 Current limiting height = 3

 Moving right may find:

 height = 7

 New limiting height could become 7.

 But moving left would keep the right height of 3
 as the limiting factor while reducing the width.


 Two Pointer Pattern:

 Start with the widest container.

        left                    right
          ↓                       ↓
 [1, 8, 6, 2, 5, 4, 8, 3, 7]

 Calculate area.

 Move the pointer having the smaller height.

 Continue until:

 left >= right


 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
*/

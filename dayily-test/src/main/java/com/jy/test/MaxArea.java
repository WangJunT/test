package com.jy.test;

public class MaxArea {
    public int maxArea1(int[] height) {
        int maxArea = 0;
        int maxI = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[maxI] >= height[i]) {
                continue;
            }
            maxI = i;
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
                maxArea = maxArea > area ? maxArea : area;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int area = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
            maxArea = maxArea > area ? maxArea : area;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}

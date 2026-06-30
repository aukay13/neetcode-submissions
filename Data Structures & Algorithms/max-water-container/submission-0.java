class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;

        int left = 0;
        int right = heights.length-1;

        while (left<right) {
            ans = Integer.max(ans, Integer.min(heights[left],heights[right]) * (right-left));

            if(heights[left]<heights[right]){
                left++;
            }
            else if(heights[right]<heights[left]){
                right--;
            }
            else{
                left++;
                right--;
            }
        }

        return ans;
    }
}

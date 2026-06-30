class Solution {
    public int trap(int[] height) {
        int[] leftmax = new int[height.length];
        leftmax[0] = height[0];
        int[] rightmax = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];

        int lmax = height[0];
        for(int i=1;i<height.length;i++){
            leftmax[i] = lmax;
            if(lmax<height[i]){
                lmax = height[i];
            }
        }

        int rmax = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmax[i] = rmax;
            if(rmax<height[i]){
                rmax = height[i];
            }
        }

        int ans = 0;
        for(int i=1;i<height.length-1;i++){
             if(Integer.min(leftmax[i], rightmax[i]) - height[i]>0){
                ans += Integer.min(leftmax[i], rightmax[i]) - height[i];
             }
        }

        return ans;
    }
}

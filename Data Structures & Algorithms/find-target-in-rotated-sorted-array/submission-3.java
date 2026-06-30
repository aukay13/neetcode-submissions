class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int last = nums[nums.length-1];

        while (left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>last){
                if(target>last){
                    if(nums[mid]>target){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if (target<=last) {
                    if(nums[mid]>target){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
                else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}

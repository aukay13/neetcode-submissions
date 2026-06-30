class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==1 && nums2.length==1) {
            return (double)(nums1[0]+nums2[0])/2;
        }


        int []A;
        int []B;
        
        if(nums1.length>=nums2.length){
            A = nums1;
            B = nums2;
        }
        else{
            A = nums2;
            B = nums1;
        }

        int low = 0;
        int high = A.length-1;

        int leftElements = (nums1.length + nums2.length)/2 + 1;

        double ans = -1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            int i = mid;
            int j = leftElements - mid - 2;

            if(B.length==0 || j<0){
                if((nums1.length+nums2.length)%2!=0){
                    return (double)A[i];
                }else{
                    return (double)(A[i]+A[i+1])/2;
                }
            }

            if(j>=B.length){
                low = mid + 1;
                continue;
            }

            if(j==B.length-1){
                if(B[j]<=A[i+1]){
                   if((nums1.length+nums2.length)%2!=0){
                        return (double)Math.max(A[i], B[j]);
                   }else{
                        return (double)(A[i]+B[j])/2;
                   }
                }
                else{
                    low = mid + 1;
                    continue;
                }
            }


            if(i==A.length-1){
                if(A[i]<=B[j+1]){
                    if((nums1.length+nums2.length)%2!=0){
                        return (double)Math.max(A[i], B[j]);
                    }
                    else{
                        return (double)(A[i]+B[j])/2;
                    }
                }
                else{
                    high = mid - 1;
                    continue;
                }
            }

            if(A[i]<=B[j+1] && B[j]<=A[i+1]){
                if((nums1.length+nums2.length)%2!=0){
                    ans = Math.max(A[i], B[j]);
                }
                else{
                    ans = (Math.min(A[i], B[j]) + Math.max(A[i+1],B[j+1]))/2;
                }
                return ans;
            }
            else{
                if(A[i]>B[j+1]){
                    high = mid - 1;
                }
                if(B[j]>A[i+1]){
                    low  = mid + 1;
                }
            }
        }
        return ans;
    }
}

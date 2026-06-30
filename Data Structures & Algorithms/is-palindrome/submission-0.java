class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right  = s.length()-1;

        while (left<right) {
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            else if(Character.toLowerCase(s.charAt(right)) == Character.toLowerCase(s.charAt(left))){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}

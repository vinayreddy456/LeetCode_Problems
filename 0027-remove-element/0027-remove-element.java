class Solution {
    public int removeElement(int[] nums, int val) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                j=i;
                break;
            }
            
        }
        if(j==-1){
            return nums.length;
        }
        else{
            for(int k=j+1;k<nums.length;k++){
                if(nums[k]!=val){
                    int temp=nums[k];
                    nums[k]=nums[j];
                    nums[j]=temp;
                    j++;
                }
            }
        }
        int count=0;
        for(int h=0;h<nums.length;h++){
            if(nums[h]==val){
                break;
            }
            count++;
        }
        return count;
    }
}
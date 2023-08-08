class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int[] mix=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
             if(nums1[i]<nums2[j]){
                 mix[k]=nums1[i];
                 i++;
             }
             else{
                 mix[k]=nums2[j];
                 j++;
             }
             k++;
        }
        while(i<nums1.length){
            mix[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            mix[k]=nums2[j];
            j++;
            k++;
        }
        return mix.length%2==0?(double)(mix[mix.length/2]+mix[(mix.length/2)-1])/2:(double)mix[mix.length/2];
        
    }
}
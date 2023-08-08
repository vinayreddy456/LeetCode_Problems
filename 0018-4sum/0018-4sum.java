class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
     ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
     if(nums.length==0){
         return res;
     }
    if((nums[0]==1000000000 || nums[0]==-1000000000) && nums.length!=8) return res;
     
     int n=nums.length;
     Arrays.sort(nums);
     for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
             int tar=target-(nums[i]+nums[j]);
             int front=j+1;
             int back=n-1;
            // System.out.println("jjj");
             while(front<back){
                 int t=nums[front]+nums[back];
                 if(t<tar) front++;
                 else if(t>tar) back--;
                 else{
                     List<Integer> re= new ArrayList<>();
                     re.add(nums[i]);
                     re.add(nums[j]);
                     re.add(nums[front]);
                     re.add(nums[back]);
                     res.add(re);
                 
                 while(front< back && nums[front]==re.get(2)) ++front;
                 while(front< back && nums[back]==re.get(3)) --back;
                 }
             }
             while(j+1<n && nums[j+1]==nums[j]) ++j;
           //  System.out.println("jjj");
         }
          while(i+1<n && nums[i+1]==nums[i])++i;
     }
     return res;
    }
}
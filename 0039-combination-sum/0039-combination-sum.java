class Solution {
    public void findcombinations(int ind,int[] arr,int k,List<List<Integer>> ans,List<Integer> ds){
        if(ind==arr.length){
            if(k==0){
            ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind]<=k){
            ds.add(arr[ind]);
            findcombinations(ind,arr,k-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        findcombinations(ind+1,arr,k,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findcombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
}
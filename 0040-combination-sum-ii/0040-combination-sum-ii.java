class Solution {
    public void  findcombinations(int k,int[] candidates,int target,List<List<Integer>> ans,List<Integer> res){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=k;i<candidates.length;i++){
            if(i>k && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            res.add(candidates[i]);
            findcombinations(i+1,candidates,target-candidates[i],ans,res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        findcombinations(0,candidates,target,ans,new ArrayList<Integer> ());
        return ans;
    }
}
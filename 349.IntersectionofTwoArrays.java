class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        for(int n : nums2){
            set2.add(n);
        }
        return helper(set1, set2);
    }

    public int[] helper(Set<Integer> set1, Set<Integer> set2){
        if(set1.size() > set2.size()){
            return helper(set2, set1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int n : set1){
            if(set2.contains(n)){
                result.add(n);
            }
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}

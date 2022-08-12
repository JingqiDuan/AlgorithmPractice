class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                List<Integer> subset = new ArrayList<>();
                subset.add(i);
                map.put(arr[i], subset);
                if(subset.size() == arr[i]){
                    result.add(subset);
                    map.remove(arr[i]);
                }
            }else{
                List<Integer> subset = map.get(arr[i]);
                if(subset.size() < arr[i]){
                    subset.add(i);
                }
                if(subset.size() == arr[i]){
                    result.add(subset);
                    map.remove(arr[i]);
                }
            }
        }
        return result;
    }
}

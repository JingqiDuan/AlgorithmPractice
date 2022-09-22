class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] piece : pieces){
            ArrayList<Integer> list = new ArrayList<>();
            for(int p : piece){
                list.add(p);
            }
            map.put(piece[0], list);
        }
        int index = 0;
        for(int i = 0; i < arr.length;){
            if(map.containsKey(arr[i])){
                ArrayList<Integer> tmp = map.get(arr[i]);
                for(int num : tmp){
                    if(arr[i++] != num) return false;
                    index++;
                }
            }else{
                return false;
            }
        }
        return index == arr.length;
    }
}

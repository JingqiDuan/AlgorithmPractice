class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //A point can only form a side or a diagonal with another point
        HashSet<Integer> set = new HashSet<>();
        set.add(helper(p1, p2));
        set.add(helper(p1, p3));
        set.add(helper(p1, p4));
        set.add(helper(p2, p3));
        set.add(helper(p2, p4));
        set.add(helper(p3, p4));
        if(set.size() != 2 || set.contains(0)){
            return false;
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        if(arr.get(0) > arr.get(1)){
            return arr.get(0) == 2 * arr.get(1);
        }
        return arr.get(1) == 2 * arr.get(0);
    }
    public int helper(int[] p1, int[] p2){
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy; 
    }
}

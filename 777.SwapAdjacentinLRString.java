class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0, len = start.length();
        while(i < len || j < len){
            while(i < len && start.charAt(i) == 'X') i++;
            while(j < len && end.charAt(j) == 'X') j++;
            if(i == len || j == len) return i == j;
            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i < j) return false;
            if(start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m > n){
            return result;
        }
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        int index = 0;
        while(index < m){
            counter1[s.charAt(index) - 'a']++;
            counter2[p.charAt(index) - 'a']++;
            index++;
        }
        if(Arrays.equals(counter1, counter2)){
            result.add(0);
        }
        while(index < n){
            counter1[s.charAt(index) - 'a']++;
            counter1[s.charAt(index - m) - 'a']--;
            if(Arrays.equals(counter1, counter2)){
                result.add(index - m + 1);
            }
            index++;
        }
        return result;
    }
}

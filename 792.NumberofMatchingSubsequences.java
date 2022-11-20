class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char tmp = s.charAt(i);
            //map.put(tmp, map.getOrDefault(tmp, new ArrayList<>()).add(i));
            ArrayList<Integer> list = map.getOrDefault(tmp, new ArrayList<>());
            list.add(i);
            map.put(tmp, list);
        }
        for(String str : words){
            int len = str.length(), index = -1;
            boolean valid = true;
            for(int i = 0; i < len && valid; i++){
                ArrayList<Integer> list = map.getOrDefault(str.charAt(i), new ArrayList<>());
                int left = 0, right = list.size() - 1;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(list.get(mid) > index){
                        right = mid;// = mid - 1? mid bigger than target, still consider it in range of search
                    }else{
                        left = mid + 1;
                    }
                }
                if(right < 0 || list.get(right) <= index){
                    valid = false;
                }else{
                    index = list.get(right);
                }
            }
            if(valid) ans++;
        }
        return ans;
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0 || s == null){
		return "";
	}
	int[] counter = new int[26];
	boolean[] visited = new boolean[26];
	for(int i = 0; i < s.length(); i++){
		counter[s.charAt(i) - 'a']++;
	}
	StringBuilder sb = new StringBuilder();
	for(char ch : s.toCharArray()){		
		if(visited[ch - 'a']){
            counter[ch - 'a']--;
            continue;
        }
        if(sb.length() > 0){
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && counter[sb.charAt(sb.length() - 1) - 'a'] > 1){
                char lastChar = sb.charAt(sb.length() - 1);
                visited[lastChar - 'a'] = false;
                counter[lastChar - 'a']--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append(ch);
        visited[ch - 'a'] = true;
	}
	return sb.toString();
    }
}

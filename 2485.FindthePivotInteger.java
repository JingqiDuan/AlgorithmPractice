class Solution {
	public int pivotInteger(long n) {
		for(int i = 1; i <= n; i++){
            if(i * (i + 1) / 2 == (n + i) * (n - i + 1) / 2) return i;
        } 
        return -1;
	}
}

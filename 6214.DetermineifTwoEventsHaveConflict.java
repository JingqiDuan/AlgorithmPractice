
class Solution {

	public boolean haveConflict(String[] event1, String[] event2) {
        //s1 <= e2 && s2 <= e1
		return 60 * Integer.parseInt(event1[0].substring(0, 2)) + Integer.parseInt(event1[0].substring(3)) <= 
            60 * Integer.parseInt(event2[1].substring(0, 2)) + Integer.parseInt(event2[1].substring(3))
				&& 60 * Integer.parseInt(event2[0].substring(0, 2)) + Integer.parseInt(event2[0].substring(3)) <= 
            60 * Integer.parseInt(event1[1].substring(0, 2)) + Integer.parseInt(event1[1].substring(3));
	}
}

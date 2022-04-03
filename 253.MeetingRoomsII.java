class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals == null || intervals[0] == null || intervals[0].length == 0){
            return 0;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int activeRoom = 0;
        int room = 0;
        while(i < intervals.length && j < intervals.length){
            if(start[i] < end[j]){
                activeRoom++;
                i++;
            }else{
                activeRoom--;
                j++;
            }
            room = Math.max(room, activeRoom);
        }
        return room;
    }
}

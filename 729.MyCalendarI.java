class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (end <= l || start >= r) {
                continue;
            }else{
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}

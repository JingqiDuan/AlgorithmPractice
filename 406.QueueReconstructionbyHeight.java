class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b ) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[result.size()][]);
    }
}

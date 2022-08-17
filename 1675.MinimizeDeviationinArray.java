class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num % 2 == 0 ? num : num * 2);
        }

        int cut = treeSet.last() - treeSet.first();
        while (cut > 0 && (treeSet.last() % 2 == 0)) {
            int value = treeSet.last();
            treeSet.remove(value);
            treeSet.add(value / 2);
            cut = Math.min(cut, treeSet.last() - treeSet.first());
        }
        return cut;
    }
}

class NumberContainers {
    private Map<Integer, Integer> map;
    private Map<Integer, TreeSet<Integer>> smallMap;
    public NumberContainers() {
        map = new HashMap<>();
        smallMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        Integer oldNum = map.get(index);
        if(oldNum != null){
            //TreeSet remove by value
            smallMap.get(oldNum).remove(index);
        }
        map.put(index, number);
        TreeSet<Integer> indexSet = smallMap.containsKey(number) ? smallMap.get(number) : new TreeSet<Integer>();
        indexSet.add(index);
        smallMap.put(number, indexSet);
    }
    
    public int find(int number) {
        //if TreeSet has no element, NoSushElementException
        TreeSet<Integer> indexSet = smallMap.getOrDefault(number, new TreeSet<Integer>());
        return indexSet.isEmpty() ? -1 : indexSet.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

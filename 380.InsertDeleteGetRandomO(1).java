class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> theList;
    public RandomizedSet() {
        //map(numValue, index in list)
        map = new HashMap<>();
        theList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        theList.add(val);
        int lastIndex = theList.size() - 1;
        map.put(val, lastIndex);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int newIndex = map.get(val);
        int lastIndex = theList.size() - 1;
        //move the last num of list to new index
        map.put(theList.get(lastIndex), newIndex);
        //update list, replace with the last elem, and remove the last
        theList.set(newIndex, theList.get(lastIndex));
        theList.remove(lastIndex);
        //remove deleted value from map
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int len = theList.size();
        Random random = new Random();
        //generate random number
        int randIndex = random.nextInt(len);
        return theList.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

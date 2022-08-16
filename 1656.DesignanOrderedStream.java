class OrderedStream {
    int targetNum;
    String[] arr;
    public OrderedStream(int n) {
        this.targetNum = 1;
        this.arr = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        if(idKey != targetNum){
            return new ArrayList<>();
        }
        int i = targetNum;
        List<String> result = new ArrayList<>();
        for(; i < arr.length && arr[i] != null; i++){
            result.add(arr[i]);
        }
        targetNum = i;
        return result;

    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

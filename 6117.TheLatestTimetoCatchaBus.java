class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int lenB = buses.length;
        int lenP = passengers.length;
        int result = - 1;
        int pP = 0;
        int pB = 0;
        while(pB < lenB){
            for(int i = 0; i < capacity && pB < lenB && pP < lenP; i++){
                if(pB == lenB - 1 && i == capacity - 1){
                    while(pP >= 1 && passengers[pP] - 1 == passengers[pP - 1]){
                        passengers[pP]--;
                    }
                    return passengers[pP] - 1;
                }
                if(buses[pB] >= passengers[pP]){
                   pP++; 
                }else{
                    break;
                }
            }
            pB++;
        }
        return result;
    }
}

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        int len = energy.length;
        for(int i = 0; i < len; i++){
            if(initialEnergy <= energy[i]){
                int diff = energy[i] - initialEnergy + 1;
                initialEnergy += diff;
                result += diff;
            }
            if(initialExperience <= experience[i]){
                int diff = experience[i] - initialExperience + 1;
                initialExperience += diff;
                result += diff;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return result;
    }
}

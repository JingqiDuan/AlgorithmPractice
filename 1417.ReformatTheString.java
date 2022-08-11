class Solution {
    public String reformat(String s) {
        int digiNum = 0;
        char[] charArr = s.toCharArray();
        for(char ch : charArr){
            if(Character.isDigit(ch)){
                digiNum++;
            }
        }
        int alphaNum = s.length() - digiNum;
        if(Math.abs(alphaNum - digiNum) > 1){
            return "";
        }
        boolean flag = digiNum > alphaNum;
        for(int i = 0, j = 1; i < charArr.length; i += 2){
            if(Character.isDigit(charArr[i]) != flag){
                while(Character.isDigit(charArr[j]) != flag){
                    j += 2;
                }
                swap(charArr, i, j);
            }
        }
        return new String(charArr);
    }

    public void swap(char[] charArr, int i, int j){
        char tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
    }
}

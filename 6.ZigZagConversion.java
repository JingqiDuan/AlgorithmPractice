class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        
        int index = 0;
        int row = 0;
        int len = s.length();
        StringBuilder[] result = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++)
            result[i] = new StringBuilder();
        
        while(index < len){
            while(index < len && row < numRows){
                result[row].append(s.charAt(index++));
                row++;
            }

            if(index == len)
                break;

            if(row == numRows)
                row = row - 2;

            while(index < len && row >= 0){
                char ch = s.charAt(index++);
                result[row].append(ch);
                row--;
            }

            row += 2;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            ans.append(result[i]);
        }
        return ans.toString();
    }
}

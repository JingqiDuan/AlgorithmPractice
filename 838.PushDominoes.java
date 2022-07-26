class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] force = new int[len];
        char[] domiArr = dominoes.toCharArray();
        int curForce = 0;
        for(int i = 0; i < len; i++){
            if(domiArr[i] == 'R'){
                curForce = len;
            }else if(domiArr[i] == 'L'){
                curForce = 0;
            }else{
                curForce = Math.max(curForce - 1, 0);
            }
            force[i] += curForce;
        }

        curForce = 0;
        for(int i = len - 1; i >= 0; i--){
            if(domiArr[i] == 'L'){
                curForce = len;
            }else if(domiArr[i] == 'R'){
                curForce = 0;
            }else{
                curForce = Math.max(curForce - 1, 0);
            }
            force[i] -= curForce;
        }

        StringBuilder sb = new StringBuilder();
        for(int f : force){
            if(f > 0){
                sb.append('R');
            }else if(f < 0){
                sb.append('L');
            }else{
                sb.append('.');
            }
        }
        return sb.toString();
    }
}

/*
class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes.length() <= 1)    return dominoes;
        String res = "";
        while(!res.equals(dominoes)){
            res = dominoes;
            dominoes = dominoes.replace("R.L","T");
            dominoes = dominoes.replace("R.","RR");
            dominoes = dominoes.replace(".L","LL");
            dominoes = dominoes.replace("T","R.L");
        }
        return dominoes;
    }
}
*/

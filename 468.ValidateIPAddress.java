class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.indexOf(".") >= 0){
            if(checkV4(queryIP)){
                return "IPv4";
            }
        }
        if(queryIP.indexOf(":") >= 0){
            if(checkV6(queryIP)){
                return "IPv6";
            }
        }
        return "Neither";
    }
    public boolean checkV4(String queryIP){
        if(queryIP.charAt(queryIP.length() - 1) == '.'){
            return false;
        }
        String[] strArr = queryIP.split("\\.");
        if(strArr.length != 4){
            return false;
        }
        for(String str : strArr){
            if(str.length() > 4){
                return false;
            }
            if(str == null || str.length() == 0){
                return false;
            }
            for(char ch : str.toCharArray()){
                if(!Character.isDigit(ch)){
                    return false;
                }
            }
            if(str.charAt(0) == '0' && str.length() > 1){
                return false;
            }
            if(str.compareTo("255") > 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkV6(String queryIP){
        if(queryIP.charAt(queryIP.length() - 1) == ':'){
            return false;
        }
        String[] strArr = queryIP.split(":");
        if(strArr.length != 8){
            return false;
        }
        for(String str : strArr){
            if(str == null || str.length() == 0){
                return false;
            }
            if(str.length() > 4){
                return false;
            }
            for(char ch : str.toCharArray()){
                if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F'){

                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

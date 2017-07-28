public class LeetCode8 {
    
    static final int max = 0x7fffffff;
    static final int min = 0x80000000;
    
    public int myAtoi(String str) {
        String trim = str.trim();
        int len = trim.length();
        for (int i = len -1; i>0;i--) {
            if (!isNum(value(trim.charAt(i)))) {
                trim = trim.substring(0,i);
            }
        }
        if ((len=trim.length()) == 0) return 0;

        boolean isPositive = true;
        if(trim.charAt(0) == '-' || trim.charAt(0) == '+'){
            if(trim.charAt(0) == '-') isPositive = false;
            trim = trim.substring(1,len);
            len--;
        }
        if (len==0 || !isNum(value(trim.charAt(0)))) return 0;
        
        int sum = value(trim.charAt(0));
        int index = 1;
        boolean isOver = false;
        while(index<len) {
            if ((sum = calSumAndCheck(sum, value(trim.charAt(index++)))) == -1) {
                isOver = true;
            }
        }
        if(isOver){
            return isPositive?max:min;
        }else{
            return isPositive?sum:-sum;
        }
        
    }
    
    private int calSumAndCheck(int current, int next) {
        int sum = current;
        if (sum==0) return next;
        if(max/sum<10){
            return -1;
        }else{
            sum*=10;
            int temp = max-sum;
            return temp<next?-1:sum+next;
        }
    }
    
    private int value(char c) {
        return c - 48;
    }
    
    private boolean isNum(int n) {
        return n>=0 && n <=9;
    }
}

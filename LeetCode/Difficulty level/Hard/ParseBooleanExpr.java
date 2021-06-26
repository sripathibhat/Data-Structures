// 1106
class Solution {
    public boolean parseBoolExpr(String exp) {
        return helper(exp, 0, exp.length()-1);
    }
    
    private boolean helper(String e, int lo, int hi) {
        char op = e.charAt(lo);
        int prev = lo+2;
        if(lo==hi){
            return op=='t'? true:false;
        }
        boolean res=op=='|'?false:true;
        int cnt=0;
        for(int i=lo+1;i<=hi;i++){
            char c = e.charAt(i);
            if(c=='(') cnt++;
            else if(c==')') cnt--;
            if((cnt==1 && c==',') || (cnt==0 && c==')')){
                //evaluate
                boolean next = helper(e,prev,i-1);
                prev=i+1;
                if(op=='|')
                    res=res|next;
                else if(op=='&')
                    res=res&next;
                else if(op=='!')
                    res=!next;
            }
        }
        return res;
    }
}

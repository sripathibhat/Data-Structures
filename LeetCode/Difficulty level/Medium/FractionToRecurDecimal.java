// 166
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if(numerator<0 && denominator>0 || numerator>0 && denominator<0) {
            sb.append("-");
        }
        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);
        // System.out.println(dividend + " " + divisor);
        sb.append(dividend/divisor);
        long rem = dividend % divisor;
        if(rem == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        int parenPos = sb.length();
        Map<Long, Integer> map = new HashMap();
        while(rem != 0) {
            if(map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem/divisor);
            rem %= divisor;
        }
        
        return sb.toString();
    }
}
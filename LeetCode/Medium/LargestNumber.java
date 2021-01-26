// 179
class Solution {
    public String largestNumber(int[] nums) {
        if(nums ==null || nums.length == 0) {
            return "";
        }
        String res = "";
        String[] numsStr = new String[nums.length];
        boolean nonZero = false;
        for(int i=0; i<nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
            if(!numsStr[i].equals("0")) {
                nonZero = true;
            }
        }
        if(!nonZero) return "0";
        // for(int i=0; i<nums.length; i++) {
        //     for(int j=i+1;j<nums.length;j++) {
        //         if((numsStr[i]+numsStr[j]).compareTo(numsStr[j] + numsStr[i]) < 0) {
        //             String t = numsStr[i];
        //             numsStr[i] = numsStr[j];
        //             numsStr[j] = t;
        //         }
        //     }
        // }
        Arrays.sort(numsStr, new Comparator<String>() {
            public int compare(String a, String b) {
                String xy = a+b;
                String yx = b+a;
                return yx.compareTo(xy);
            }
        });
        for(int i=0; i<nums.length; i++) {
            res += numsStr[i];
        }
        return res;
    }
}
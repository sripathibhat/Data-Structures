// 149
import java.math.*;
class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 1) {
            return points.length;
        }
        
        int max = 1;
        Set<String> set = new HashSet();
        for(int i=0; i<points.length-1; i++) {
            if(set.contains(points[i][0] + " " + points[i][1])) {
                continue;
            }
            Map<BigDecimal, Integer> map = new HashMap();
            int localMax = 1;
            int same = 0;
            for(int j=i+1; j<points.length; j++) {
                if(isSame(points[i], points[j])) {
                    same++;
                    continue;
                }
                BigDecimal slope = findSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                if(map.get(slope) > localMax) {
                    localMax = map.get(slope);
                }
            }
            // for(Map.Entry<BigDecimal, Integer> entry: map.entrySet()) {
            //     System.out.println(entry.getKey() + " " + entry.getValue());
            // }
            set.add(points[i][0] + " " + points[i][1]);
            max = Math.max(localMax+same, max);
        }
        
        return max;
    }
    
    private boolean isSame(int point1[], int point2[]) {
        return point1[0] == point2[0] && point1[1] == point2[1];    
    }
    
    private BigDecimal findSlope(int point1[], int point2[]) {
        if(point1[0] == point2[0]) {
            return BigDecimal.valueOf(Double.MAX_VALUE);
        }
        if(point1[1] == point2[1]) {
            return BigDecimal.valueOf(0);
        } 
        // return ((double) point2[0]-point1[0]) / ((double) point2[1]-point1[1]);
        return BigDecimal.valueOf(point2[1]-point1[1]).divide(BigDecimal.valueOf(point2[0]-point1[0]), MathContext.DECIMAL128);
    }
}
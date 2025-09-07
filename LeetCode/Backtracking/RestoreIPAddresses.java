/*

A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order. 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]


Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
*/


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // IP address must be between 4 and 12 digits
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 parts and used all digits, we found a valid IP
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        
        // If we have 4 parts but haven't used all digits, or vice versa
        if (current.size() == 4 || start == s.length()) {
            return;
        }
        
        // Try different lengths for the next part (1 to 3 digits)
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);
            
            // Skip if part has leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }
            
            // Skip if part is greater than 255
            int value = Integer.parseInt(part);
            if (value > 255) {
                continue;
            }
            
            // Add valid part and continue recursion
            current.add(part);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1);
        }
    }
}

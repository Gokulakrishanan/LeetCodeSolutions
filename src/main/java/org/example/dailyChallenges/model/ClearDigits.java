package org.example.dailyChallenges.model;

/*You are given a string s.
Your task is to remove all digits by doing this operation repeatedly:
Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.
Example 1:
Input: s = "abc"
Output: "abc"
Explanation:
There is no digit in the string.
Example 2:
Input: s = "cb34"
Output: ""
Explanation:
First, we apply the operation on s[2], and s becomes "c4".
Then we apply the operation on s[1], and s becomes "".
Constraints:
1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.
*/
public class ClearDigits {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty()) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(ch);
            }
        }
        return stack.toString();
    }
}

package org.example.dailyChallenges.model;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/
public class ZigZagConversion {
    public String zigzagConversion(String s, int numRows) {
        if (s == null || numRows >= s.length()) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean isGoingDown = false;
        for (char ch : s.toCharArray()) {
            rows[currentRow].append(ch);
            if (currentRow == 0 || currentRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            currentRow += isGoingDown ? 1 : -1;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}

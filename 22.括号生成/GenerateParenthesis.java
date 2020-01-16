import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.72%)
 * Likes:    694
 * Dislikes: 0
 * Total Accepted:    66.1K
 * Total Submissions: 90.7K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n, n*2);
        return res;
    }

    private void backtrack(List res, String cur, int left, int right, int max, int len) {
        if (cur.length() == len) {
            res.add(cur);
            return;
        }
        if (left < max) {
            backtrack(res, cur+"(", left+1, right, max, len);
        } 
        
        if (left > right){
            backtrack(res, cur+")", left, right+1, max, len);
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.48%)
 * Likes:    1961
 * Dislikes: 0
 * Total Accepted:    127.8K
 * Total Submissions: 350.3K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int center = (m+n)/2 + 1;
        int[] tmp = new int[center];
        int i=0, j=0, k=0;
        while (i<n && j<m && k<center){
            if (nums1[i]<nums2[j]){
                tmp[k++] = nums1[i++];
            } else{
                tmp[k++] = nums2[j++];
            }
        }
        while (i<n && k<center) {
            tmp[k++] = nums1[i++];
        }
        while (j<m && k<center) {
            tmp[k++] = nums2[j++];
        }
        if (((m+n)&1) != 1){
            return (tmp[center-1] + tmp[center-2]) / 2.0;
        } else{
            return tmp[center-1];
        }
    }
}
// @lc code=end


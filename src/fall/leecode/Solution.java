package fall.leecode;

/*
 *
 * @author Xinyu Zhu
 * @version 5/8/2022 09:44
 */


//1
//class Solution {
//
//    public int[] twoSum(int[] nums, int target) {
//        int[] two = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    two[0] = i;
//                    two[1] = j;
//                    return two;
//                }
//            }
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
//    }
//}


//2


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//
//
//}
//
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        List<Integer> bl1 = new ArrayList<>();
//        List<Integer> bl2 = new ArrayList<>();
//
//        while (!(l1.next == null)) {
//            bl1.add(l1.val);
//            l1 = l1.next;
//        }
//        bl1.add(l1.val);
//
//        while (!(l2.next == null)) {
//            bl2.add(l2.val);
//            l2 = l2.next;
//        }
//        bl2.add(l2.val);
//
//        Comparator<Integer> c = Collections.reverseOrder();
//        bl1.sort(c);
//        bl2.sort(c);
//        StringBuffer bbl1 = new StringBuffer();
//        StringBuffer bbl2 = new StringBuffer();
//        for (Integer entry : bl1) {
//            bbl1.append(entry);
//        }
//        for (Integer entry : bl2) {
//            bbl2.append(entry);
//        }
//        int sum = Integer.parseInt(bbl1.toString()) + Integer.parseInt(bbl2.toString());
//        String s = String.valueOf(sum);
//        char[] chars = s.toCharArray();
//        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(chars[chars.length-1])));
//        for (int i = chars.length - 2; i >= 0; i--) {
//            listNode.next = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
//            if (i >= 1) {
//                listNode = listNode.next;
//            }
//        }
//
//        return listNode;
//    }
//}

//2
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode();
//        ListNode cur = pre;
//        int carry = 0;
//        while (!(l1 == null) || !(l2 == null)) {
//
//            int sum = 0;
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//            sum = x + y + carry;
//            carry = sum / 10;
//            int value = sum % 10;
//            cur.next = new ListNode(value);
//            cur = cur.next;
//            if (!(l1 == null)) {
//                l1 = l1.next;
//            }
//            if (!(l2 == null)) {
//                l2 = l2.next;
//            }
//            if (carry == 1) {
//                cur.next = new ListNode(1);
//            }
//
//
//        }
//        return pre.next;
//    }
//}

//3
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//    }
//    public static int lengthOfLongestSubstring(String s) {
//        int rk = -1;
//        int ans = 0;
//        HashSet<Character> occ = new HashSet<>();
//        for (int i = 0; i < s.length();i++ ) {
//            if (i>0){
//                occ.remove(s.charAt(i-1));
//            }
//            while ((rk + 1 < s.length()) && !occ.contains(s.charAt(rk + 1))) {
//                occ.add(s.charAt(rk + 1));
//                rk++;
//            }
//            ans = Math.max(ans, rk + 1 - i);
//        }
//        return ans;
//    }
//}

//4
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        List<Double> list = new ArrayList<>();
//        for (int j : nums2) {
//            list.add((double) j);
//        }
//        for (int j : nums1) {
//            list.add((double) j);
//        }
//        Collections.sort(list);
//        return list.size() % 2 == 1 ? list.get((list.size() + 1) / 2 - 1) : (list.get((list.size() / 2) - 1) + list.get((list.size() / 2))) / 2;
//    }
//}

//5 最长回文串
//最长包裹（错误答案）
//class Solution {
//    public static void main(String[] args) {
//        String ans = "abcdab";
//        System.out.println(longestPalindrome(ans));
//    }
//
//    public static String longestPalindrome(String s) {
//        String ans = "";
//        if (s.length()==1){
//            return s;
//        }
//        for (int i = 0; i < s.length(); i++) {
//
//            int max = 1;
//            for (int rk= i;rk<s.length();rk++){
//                if(s.charAt(rk)==s.charAt(i)){
//                    max = Math.max(max,rk+1-i);
//                }
//            }
//            if (ans.length() <= s.substring(i, i +max).length()) {
//                ans = s.substring(i, i+max);
//            }
//        }
//        return ans;
//    }
//}

//正确答案
public class Solution {
    public static void main(String[] args) {
        int i = 7;
        int j = 8;
        int n = (i|j)%(i&j);
        System.out.println(n);
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (!(s.charAt(start) == s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
       int max = 1;
        String maxString = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s,i,j) &&  s.substring(i,j+1).length()>=max){
                   maxString = s.substring(i,j+1);
                   max = s.substring(i,j+1).length();
                }
            }
        }
        return maxString;


//        int len = s.length();
//        if (len < 2) {return s;}
//        int maxLen = 1;
//        int begin = 0;
//        // dp[i][j] 表示 s[i..j] 是否是回文串
//        boolean[][] dp = new boolean[len][len];
//        // 初始化：所有长度为 1 的子串都是回文串
//        for (int i = 0; i < len; i++) {dp[i][i] = true;}
//        char[] charArray = s.toCharArray();
//        // 递推开始
//        // 先枚举子串长度
//        for (int L = 2; L <= len; L++) {
//            // 枚举左边界，左边界的上限设置可以宽松一些
//            for (int i = 0; i < len; i++) {
//                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
//                int j = L + i - 1;
//                // 如果右边界越界，就可以退出当前循环
//                if (j >= len) {break;}
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {dp[i][j] = true;}
//                    else {dp[i][j] = dp[i + 1][j - 1];}
//                }
//                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
    }
}


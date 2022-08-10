package jensen;

public class MaxArea {

    public static void main(String[] args) {
        int maxArea = MaxArea(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(maxArea);
    }
    public static int MaxArea(int[] height) {
        int result = 0, n = height.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int w = j-i;
                int h = Math.min(height[i], height[j]);
                result = Math.max(result, w*h);
            }
        }
        return result;
    }

//    public static int MaxArea(int[] height) {
//        int res = 0;
//        int i = 0;
//        int j = height.length - 1;
//        while (i < j) {
//            int s = (j - i) * Math.min(height[i], height[j]);
//            res = Math.max(res, s);
//            //移动矮柱子
//            if (height[i] < height[j]) i++;
//            else j--;
//        }
//        return res;
//    }

}
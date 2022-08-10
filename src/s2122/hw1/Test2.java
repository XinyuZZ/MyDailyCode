
package s2122.hw1;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {
        int escapeTimes = 1;
        int currentTrial = 0;
        int projectTrial = 1000000;

        for (int i = 1; i <= projectTrial; i++) {

            if (escapeSuccess()) { //这里写错了
                escapeTimes++;
                currentTrial++;
            } else {
                currentTrial++;
            }
        }

        double escapeRate = (double) escapeTimes / (double) currentTrial;
        DecimalFormat format = new DecimalFormat("0.000");
        System.out.println("The Monte Carlo simulation result of one million runs:");
        System.out.println("No. of successful escape: " + escapeTimes);
        System.out.println("Success Rate P: " + format.format(escapeRate));
    }

    private static boolean escapeSuccess() {
        Set<Integer> vis = new HashSet<>();
        int x = 0;
        int y = 0;
        vis.add(getHash(x, y)); //存入hash
        x++;
        vis.add(getHash(x, y)); //因为机器人是从（1，0）正式出发的
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(getHash(x, y));

        while (!queue.isEmpty()) {
            int curPoint = queue.poll();
            int curX = curPoint / 6;
            int curY = curPoint % 6;
            int[] dir = getDirection();
            int nx = curX + dir[0];
            int ny = curY + dir[1];
            if (nx == 5 && ny == 5) {
                return true;
            }
            if (!isValid(nx, ny, vis)) {
                continue;
            }
            queue.offer(getHash(nx, ny));
            vis.add(getHash(nx, ny));
        }

        return false;
    }

    private static int[] getDirection() {
        int direction = (int) (Math.random() * 100); //生成随机移动方向
        if (direction >= 0 && direction <= 59) {//直行
            return new int[]{1, 0};
        } else if (direction >= 60 && direction <= 79) { //左转
            return new int[]{0, -1};
        } else if (direction >= 80 && direction <= 99) { //右转
            return new int[]{0, 1};
        }
        return new int[]{};
    }

    private static int getHash(int x, int y) {
        return x * 6 + y;
    }

    private static boolean isValid(int x, int y, Set<Integer> vis) {
        if (x < 0 || x >= 6 || y < 0 || y >= 6) {
            return false;
        }
        return !vis.contains(getHash(x, y));
    }

}





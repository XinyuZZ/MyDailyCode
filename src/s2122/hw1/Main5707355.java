
package s2122.hw1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main5707355 {

    public static void main(String[] args) {

        int escapeTimes = 0;
        int projectTrial = 1000;

    }

    private static class Maze {
        private static boolean escapeSuccess() {
            Set<Integer> vis = new HashSet<>();
            int x = 0;
            int y = 0;


            vis.add(Robot.getHash(x, y)); // Save into Hash



            Queue<Integer> queue = new LinkedList<>();
            queue.offer(Robot.getHash(x, y));
            int realNext = 0;
            int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int next = 0;
            while (true) {
                int curPoint = queue.poll();
                int curX = curPoint / 7;
                int curY = curPoint % 7;
                if (!isSomewhereValid(curX, curY, vis)) {
                    return false;

                }
                while (true) {

                    int dir = Robot.getDirection();
                    next = (realNext + dir + 4) % 4;
                    x = curX + direction[next][0];
                    y = curY + direction[next][1];
                    if (x == 6 && y == 6) {
                        return true;
                    }
                    if (isValid(x, y, vis)) {
                        queue.offer(Robot.getHash(x, y));
                        vis.add(Robot.getHash(x, y));
                        realNext = next;

                        break;
                    }
                }
            }
        }

        private static boolean isSomewhereValid(int x, int y, Set<Integer> vis) {
            return isValid(x + 1, y, vis) || isValid(x - 1, y, vis) || isValid(x, y + 1, vis) || isValid(x - 1, y - 1, vis);
        }

        private static boolean isValid(int x, int y, Set<Integer> vis) {
            if (x < 0 || x > 6 || y < 0 || y > 6) {
                return false;
            }
            return !vis.contains(Robot.getHash(x, y));
        }
    }

    private static class Robot {



        private static int getDirection() {
            double p = Math.random();
            if (p < 0.6) {
                return 0;
            } else if (p < 0.8) {
                return 1;
            } else {
                return -1;
            }
        }
        private static int getHash(int x, int y) {
            return x * 7 + y;
        }
    }
}






package s2122.hw1;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int escapeTimes = 0;
        int projectTrial = 1000000;
        for (int i = 0; i < projectTrial; i++) {
            if (Maze.escapeSuccess()) {
                escapeTimes++;
            }
        }


        double escapeRate = (double) escapeTimes / (double) projectTrial;
        DecimalFormat format = new DecimalFormat("0.000");
        System.out.println("The Monte Carlo simulation result of one million runs:");
        System.out.println("No. of successful escape: " + escapeTimes);
        System.out.println("Success Rate P: " + format.format(escapeRate));
    }

    private static class Maze {
        private static boolean escapeSuccess() {
            Set<Integer> vis = new HashSet<>();
            int x = 0;
            int y = 0;


            vis.add(getHash(x, y)); // Save into Hash


            Queue<Integer> queue = new LinkedList<>();
            queue.offer(getHash(x, y));
            int realNext = 0;
            int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int next;
            while (true) {
                int curPoint = queue.poll();
                int curX = curPoint / 7;
                int curY = curPoint % 7;
                if (curX == 6 && curY == 6) {
                    return true;
                }
                if (!isSomewhereValid(curX, curY, vis)) {
                    return false;
                }
                while (true) {

                    int dir = Robot.getDirection();
                    next = (realNext + dir + 4) % 4;
                    x = curX + direction[next][0];
                    y = curY + direction[next][1];
//                    continueNextStep(curX, curY, realNext,direction);

                    if (!isValid(x, y, vis)) {
                        continue;
                    }
                    queue.offer(getHash(x, y));
                    vis.add(getHash(x, y));
                    realNext = next;
                    break;
                }
            }
        }

        private static boolean isSomewhereValid(int x, int y, Set<Integer> vis) {
            return isValid(x + 1, y, vis) || isValid(x - 1, y, vis) || isValid(x, y + 1, vis) || isValid(x, y - 1, vis);
        }

        private static boolean isValid(int x, int y, Set<Integer> vis) {
            return x >= 0 && x <= 6 && y >= 0 && y <= 6 && !vis.contains(getHash(x, y));
//             return !vis.contains(Robot.getHash(x, y));
        }

        private static int getHash(int x, int y) {
            return x * 7 + y;
        }
//        private static int[][] continueNextStep(int curX,  int curY,int realNext, int[][] direction) {
//            int dir = Robot.getDirection();
//
//            int next = (realNext + dir + 4) % 4;
//            return curX + direction[next][0;
//        }
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

    }

}







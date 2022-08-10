//
//package s2122.hw1;
//
//import java.text.DecimalFormat;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
//public class Main57017355template {
//
//    public static void main(String[] args) {
//
//        int escapeTimes = 0;
//        int projectTrial = 10000;
//
//        for (int i = 0; i < projectTrial; i++) {
//            if (Maze.escapeSuccess()) {
//                escapeTimes++;
//            }
//        }
//
//        double escapeRate = (double) escapeTimes / (double) projectTrial;
//        DecimalFormat format = new DecimalFormat("0.000");
//        System.out.println("The Monte Carlo simulation result of one million runs:");
//        System.out.println("No. of successful escape: " + escapeTimes);
//        System.out.println("Success Rate P: " + format.format(escapeRate));
//    }
//
//    private static class Maze {
//        private int map[][] = new int[10][10];
//
//
//        public void initial() {
//            for (int i = 0; i < 7; i++) {
//                for (int j = 0; j < 7; j++) {
//                    map[i][j] = 0;
//                }
//            }
//            map[0][0] = 1;
//        }
//        private static boolean escapeSuccess() {
//            Maze maze = new Maze();
//            maze.initial();
////            Set<Integer> vis = new HashSet<>();
//            int x = 0;
//            int y = 0;
//            int next = 0;
//
//
////            vis.add(Robot.getHash(x, y)); // Save into Hash
//
//
////            Queue<Integer> queue = new LinkedList<>();
////            queue.offer(Robot.getHash(x, y));
//            int realNext = 0;
//            int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//
//            while (true) {
////                int curPoint = queue.poll();
//                int curX = curPoint / 7;
//                int curY = curPoint % 7;
//                if (!isSomewhereValid(curX, curY, vis)) {
//                    return false;
//
//                }
//                while (true) {
//
//                    int dir = Robot.getDirection();
////                    int nx = curX + dir[0];
////                    int ny = curY + dir[1];
//
//                    next = (realNext + dir + 4) % 4;
//                    x = curX + direction[next][0];
//                    y = curY + direction[next][1];
//                    if (x == 6 && y == 6) {
//                        return true;
//                    }
//                    if (isValid(x, y, vis)) {
//                        queue.offer(Robot.getHash(x, y));
//                        vis.add(Robot.getHash(x, y));
//                        realNext = next;
//                        break;
//                    }
//                }
//            }
//        }
//
//        private static boolean isSomewhereValid(int x, int y, Set<Integer> vis) {
//            return isValid(x + 1, y, vis) || isValid(x - 1, y, vis) || isValid(x, y + 1, vis) || isValid(x - 1, y - 1, vis);
//        }
//
//        private static boolean isValid(int x, int y, Set<Integer> vis) {
//            if (x < 0 || x > 6 || y < 0 || y > 6) {
//                return false;
//            }
//            return !vis.contains(Robot.getHash(x, y));
//        }
//    }
//
//    private static class Robot {
//
//
//
//        //        private static int[] getDirection() {
////            int direction = (int) (Math.random() * 100); // Generate move direction
////            if (direction >= 0 && direction <= 59) {//直行
////                return new int[]{1, 0};
////            } else if (direction >= 60 && direction <= 79) { //左转
////                return new int[]{0, -1};
////            } else if (direction >= 80 && direction <= 99) { //右转
////                return new int[]{0, 1};
////            }
////            return new int[]{};
////        }
//        private static int getDirection() {
//            double p = Math.random();
//            if (p < 0.6) {
//                return 0;
//            } else if (p < 0.8) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//
//
//
//        private static int getHash(int x, int y) {
//            return x * 7 + y;
//        }
//    }
//}
//
//
//
//

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s2122.hw1;

/**
 *
 * @author Mia
 */
public class Main56903411 {

    public static void main(String[] args) {
        Robot robot = new Robot();
        Maze maze = new Maze();
        int count = 0;
        int dir;
        for (int i = 0; i < 1000000; i++) {
            maze.initial();
            while (true) {
                dir = robot.move();
                if  (maze.isDest(dir)) {
                    count ++;
                    break;
                }
                if (maze.isAppro(dir) == false) {
                    continue;
                }
                if (maze.move(dir) == false) {
                    break;
                }
            }
        }
        Double p = count / 1000000.000;
        p= (double) Math.round(p * 1000) / 1000;
        System.out.println("The Monte Carlo simulation result of one million runs:");
        System.out.println("No. of successful escape:" + count);
        System.out.println("Success Rate P:" + p);
    }

    private static class Robot {
        public int move() {
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

    private static class Maze {

        private int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        private int map[][] = new int[10][10];
        private int x;
        private int y;
        private int next;

        public void initial() {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    map[i][j] = 0;
                }
            }
            map[0][0] = 1;
            x = 0;
            y = 0;
            next = 0;
        }

        public boolean isAppro(int robot) {
            int temp = (next + robot + 4) % 4;
            int tempx = x + dir[temp][0];
            int tempy = y + dir[temp][1];
            if (tempx >= 0 && tempx <= 6 && tempy >= 0 && tempy <= 6 && map[tempx][tempy] == 0) {
                return true;
            }
            return false;
        }

        public boolean isContinue() {
            for (int i = 0; i < 4; i++) {
                if (this.isAppro(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isDest(int robot) {
            int temp = (next + robot + 4) % 4;
            int tempx = x + dir[temp][0];
            int tempy = y + dir[temp][1];
            if (tempx == 6 && tempy == 6) {
                return true;
            } else {
                return false;
            }
        }

        public boolean move(int robot) {
            next = (next + robot + 4) % 4;
            x = x + dir[next][0];
            y = y + dir[next][1];
            map[x][y] = 1;
            return this.isContinue();
        }
    }
}

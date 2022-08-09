package s2122.hw1;

/**
 * author: Xinyu Zhu
 */
public class Main57017355 {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Maze maze = new Maze();
        int escapeTimes = 0;
        int direction;
        for (int i = 0; i < 1000000; i++) {
            maze.initial(); // Initialize the aze map
            while (true) {
                direction = robot.move();
                if (maze.isDest(direction)) {  // Judge whether the robot arrives at the destination
                    escapeTimes++;
                    break;
                }
                if (!maze.isAvailable(direction)) { // Judge whether the robot is at an available position
                    continue;
                }
                if (!maze.move(direction)) { // Judge whether the robot is available after a further move
                    break;
                }
            }
        }
        Double p = escapeTimes / 1000000.000;
        p = (double) Math.round(p * 1000) / 1000;
        System.out.println("The Monte Carlo simulation result of one million runs:");
        System.out.println("No. of successful escape:" + escapeTimes);
        System.out.println("Success Rate P:" + p);
    }

    private static class Robot {
        public int move() {
            double p = Math.random();
            if (p < 0.6) {       // Go straight
                return 0;
            } else if (p < 0.8) {  // Turn right
                return 1;
            } else {              // Turn left
                return -1;
            }
        }
    }

    private static class Maze {

        private int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        private int map[][] = new int[7][7]; // Generate a 7*7 map
        private int x;
        private int y;
        private int next;

        public void initial() { // Maze map initialization
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

        public boolean isAvailable(int robot) { // Judge whether the next move is available
            int temp = (next + robot + 4) % 4;
            int tempx = x + dir[temp][0];
            int tempy = y + dir[temp][1];
            if (tempx >= 0 && tempx <= 6 && tempy >= 0 && tempy <= 6 && map[tempx][tempy] == 0) {
                return true;
            }
            return false;
        }

        public boolean isContinue() {  // Judge whether the next move is an impasse
            for (int i = 0; i < 4; i++) {
                if (this.isAvailable(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isDest(int robot) {  // Judge whether the robot arrives at the destination
            int temp = (next + robot + 4) % 4;
            int tempx = x + dir[temp][0];
            int tempy = y + dir[temp][1];
            if (tempx == 6 && tempy == 6) {
                return true;
            } else {
                return false;
            }
        }

        public boolean move(int robot) { // Execute a step
            next = (next + robot + 4) % 4;
            x = x + dir[next][0];
            y = y + dir[next][1];
            map[x][y] = 1;
            return this.isContinue();
        }
    }
}

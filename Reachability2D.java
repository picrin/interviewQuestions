import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
public class Reachability2D {
    public static int size = 9;
    public static int[][] twoD;
    public static int[][] visited;
    public static Random generator;
    public static boolean checkWithinBounds(Integer[] exploreFrom) {
        return ((exploreFrom[0] < size) && (exploreFrom[0] >= 0) && (exploreFrom[1] < size) && (exploreFrom[1] >= 0));
    }
     
    public static void explorePoint(Integer[] exploreFrom, int markWith) {
        if (!checkWithinBounds(exploreFrom)){
            return;
        }
        int row = exploreFrom[0];
        int col = exploreFrom[1];
        if ((twoD[row][col] != 0) && (visited[row][col] == 0)) {
            visited[row][col] = markWith;
            Integer[] up = new Integer[]{row - 1, col};
            Integer[] down = new Integer[]{row + 1, col};
            Integer[] left = new Integer[]{row, col + 1};
            Integer[] right = new Integer[]{row, col - 1};
            explorePoint(up, markWith);
            explorePoint(down, markWith);
            explorePoint(left, markWith);
            explorePoint(right, markWith);
        }
        
    }
    public static void main(String[] args) {
        twoD = new int[size][size];
        generator = new Random();
        int counter = 1;
        ArrayList<Integer[]> allFilled = new ArrayList<Integer[]>();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (generator.nextBoolean()) {
                    twoD[i][j] = 0;
                } else {
                    twoD[i][j] = counter;
                    allFilled.add(new Integer[]{i, j});
                    counter += 1;
                }
            }
        }
        visited = new int[size][size];
        while (allFilled.size() != 0) {
            Integer[] point = allFilled.remove(0);
             
            explorePoint(point, twoD[point[0]][point[1]]);
        }
        System.out.println("original Puzzle");
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(twoD[i][j] + " ");
                if(twoD[i][j] < 10) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("solution");
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(visited[i][j] + " ");
                if(visited[i][j] < 10) System.out.print(" ");
            }
            System.out.println();
        }
        HashMap<Integer, Boolean> disjoint = new HashMap<Integer, Boolean>();
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (visited[i][j] > 0) {
                    disjoint.put(visited[i][j], true);
                }
            }
        }
        System.out.println("disjoint " + disjoint.size());
    }  
}

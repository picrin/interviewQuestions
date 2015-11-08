public class NQueensProblem {
    static int size = 9;
    public static void main(String[] args) {
        solveQueens(new int[0], size);
    }
    static void solveQueens(int[] partialSolution, int rowsLeft) {
        if (rowsLeft == 0) {
            printArray(partialSolution);
        }
        for (int column = 0; column < size; column++) {
            int[] larger = largerArray(partialSolution, column);
            if (checkValid(larger)) {
                solveQueens(larger, rowsLeft - 1);
            }
        }
    }

    static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static int[] largerArray(int[] array, int value) {
        int newSize = array.length + 1;
        int[] larger = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            larger[i] = array[i];
        }
        larger[newSize - 1] = value;
        return larger;
    }

    static boolean checkValid(int[] array) {
        int lastRow = array.length - 1;
        int lastCol = array[lastRow];
        for (int i = 0; i < lastRow; i++) {
            if (array[i] == lastCol) return false;
            int columnDiff = lastCol - array[i];
            int rowDiff = lastRow - i;
            if ((columnDiff == rowDiff) || (-columnDiff == rowDiff)) return false;
        }
        return true;
    }
}

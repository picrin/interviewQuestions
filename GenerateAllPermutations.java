
public class GenerateAllPermutations {

    public static void main(String[] args) {
        int setSize = 6;
        int[] numbers = new int[setSize];
        for (int i = 1; i <=setSize; i++) {
            numbers[i - 1] = i;
        }
        generatePermutations(numbers, "");
    }
    
    public static int[] copyNumbersWithout(int[] numbers, int index) {
        int[] newNumbers = new int[numbers.length - 1];
        int skipped = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                newNumbers[i - skipped] = numbers[i];
            } else {
                skipped += 1;
            }
        }
        return newNumbers;
    } 
   
    public static void generatePermutations(int[] numbers, String prefix) {
        if (numbers.length == 0) {
           System.out.println(prefix);
           return;
        }
        for (int i = 0; i < numbers.length; i++) {
            int[] otherNumbers = copyNumbersWithout(numbers, i);
            String newPrefix = prefix + numbers[i] + " ";
            generatePermutations(otherNumbers, newPrefix);
        }
    }
}

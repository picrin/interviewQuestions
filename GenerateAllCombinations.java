public class GenerateAllCombinations {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("give two integer arguments, n, k");
            System.exit(1);
        }
        int N = Integer.parseInt(args[0]);
        int K = Integer.parseInt(args[1]);
        if (N < K) {
            System.err.println("n must be > k");
            System.exit(1);
        }
        int[] combinationSet = new int[N];
        for (int i = 0; i < N; i++) {
            combinationSet[i] = i + 1;
        }
        
        combinations(combinationSet, "", K);
    }
    
    public static int[] newSetExclude (int[] combinationSet, int exclude) {
        int[] newCombinationSet = new int[combinationSet.length - exclude];
        int skipped = 0;
        for (int i = 0; i < combinationSet.length; i++) {
            if (i < exclude) {
                skipped += 1;
            } else {
                newCombinationSet[i - skipped] = combinationSet[i];
            }
        }
        return newCombinationSet;
    }
    
    public static void combinations (int[] combinationSet, String prefix, int size) {
        if (size == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < combinationSet.length - (size - 1); i++) {
            int[] newCombinationSet = newSetExclude(combinationSet, i + 1);
            String newPrefix = prefix + combinationSet[i] + " ";
            combinations(newCombinationSet, newPrefix, size - 1 );
        }
    }
}


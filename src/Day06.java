public class Day06 {
    public static void main(String[] args) {
        long held = 0;
        long time;
        long distance;
        int solutions = 0;
        int solutionsMultiplied = 1;
//        int[] timeLimit = new int[]{7, 15, 30};
//        int[] recordDistance = new int[]{9, 40, 200};
//        int[] timeLimit = new int[]{40, 82, 91, 66};
//        int[] recordDistance = new int[]{277, 1338, 1349, 1063};
//        int[] timeLimit = new int[]{71530};
//        int[] recordDistance = new int[]{940200};
        int[] timeLimit = new int[]{40829166};
        long[] recordDistance = new long[]{277133813491063L};
        int temp = 0;
        while (temp < 1) {
            for (int i = 0; i < timeLimit[temp]; i++) {
                held = i;
                time = timeLimit[temp] - held; // how much time is left
                distance = time * held; // how far
                if (distance > recordDistance[temp]) {
                    solutions++;
                }
            }
            solutionsMultiplied *= solutions;
            solutions = 0;
            temp++;
        }
        System.out.println(solutionsMultiplied);
    }
}
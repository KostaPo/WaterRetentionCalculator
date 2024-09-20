import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testExample1();
        testExample2();
        testExample3();
        testExample4();
    }

    private static void testExample1() {
        System.out.println("Пример 1:");
        int[][] heightMap = {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };

        WaterRetentionCalculator waterRetention = new WaterRetentionCalculator(heightMap);
        int[][] result = waterRetention.trapRainWater();

        printResult(result);
    }

    private static void testExample2() {
        System.out.println("Пример 2:");
        int[][] heightMap = {
                {1, 3, 4, 5},
                {4, 1, 1, 4},
                {5, 6, 7, 2}
        };

        WaterRetentionCalculator waterRetention = new WaterRetentionCalculator(heightMap);
        int[][] result = waterRetention.trapRainWater();

        printResult(result);
    }

    private static void testExample3() {
        System.out.println("Пример 3:");
        int[][] heightMap = {
                {1, 3, 4, 5},
                {4, 1, 0, 4},
                {5, 6, 7, 2}
        };

        WaterRetentionCalculator waterRetention = new WaterRetentionCalculator(heightMap);
        int[][] result = waterRetention.trapRainWater();

        printResult(result);
    }

    private static void testExample4() {
        System.out.println("Пример 4:");
        int[][] heightMap = {
                {1, 2, 1, 4, 4, 1},
                {2, 1, 4, 1, 1, 4},
                {2, 1, 3, 1, 1, 4},
                {1, 2, 1, 4, 4, 1},
                {1, 1, 1, 1, 1, 1}
        };

        WaterRetentionCalculator waterRetention = new WaterRetentionCalculator(heightMap);
        int[][] result = waterRetention.trapRainWater();

        printResult(result);
    }

    private static void printResult(int[][] result) {
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
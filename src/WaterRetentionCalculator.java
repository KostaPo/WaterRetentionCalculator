import java.util.Comparator;
import java.util.PriorityQueue;

public class WaterRetentionCalculator {
    private final int[][] heightMap;
    private final boolean[][] visited;
    private final int[][] waterLevel;
    private final int rows;
    private final int cols;

    private final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public WaterRetentionCalculator(int[][] heightMap) {
        this.heightMap = heightMap;
        this.rows = heightMap.length;
        this.cols = heightMap[0].length;
        this.visited = new boolean[rows][cols];
        this.waterLevel = new int[rows][cols];
    }

    public int[][] trapRainWater() {
        if (rows == 0 || cols == 0) {
            return new int[0][0];
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        // Края карты в очередь
        for (int i = 0; i < rows; i++) {
            addCellToQueue(i, 0, pq);
            addCellToQueue(i, cols - 1, pq);
        }

        for (int j = 0; j < cols; j++) {
            addCellToQueue(0, j, pq);
            addCellToQueue(rows - 1, j, pq);
        }

        // Обработка в порядке высоты
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] direction : directions) {
                int newX = cell.x + direction[0];
                int newY = cell.y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    // Если соседняя ячейка ниже текущей
                    if (heightMap[newX][newY] < cell.height) {
                        if (heightMap[newX][newY] == 0) {
                            // Если это дырка
                            waterLevel[newX][newY] = 0;
                        } else {
                            waterLevel[newX][newY] = Math.max(waterLevel[newX][newY], cell.height - heightMap[newX][newY]);
                        }
                    }
                    // Cоседнюю ячейку в очередь с максимальной высотой
                    pq.offer(new Cell(newX, newY, Math.max(cell.height, heightMap[newX][newY])));
                }
            }
        }
        return waterLevel;
    }

    private void addCellToQueue(int x, int y, PriorityQueue<Cell> pq) {
        pq.offer(new Cell(x, y, heightMap[x][y]));
        visited[x][y] = true;
    }
}
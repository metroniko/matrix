import java.util.Random;

public class CreateMatrixClass {

    public int[][] getNewMatrix(int countOfString, int countOfColumns) {
        int[][] newMatrix = new int[countOfString][countOfColumns];
        Random random = new Random();
        for (int i = 0; i < countOfString; i++) {
            for (int j = 0; j < countOfColumns; j++) {
                newMatrix[i][j] = random.nextInt(10);
            }
        }
        return newMatrix;
    }
}

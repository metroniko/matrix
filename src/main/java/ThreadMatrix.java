import java.util.concurrent.*;

public class ThreadMatrix  {


    private int firstMatrixStrings;
   // private int firstMatrixColumns;
  //  private int secondMatrixStrings;
    private int secondMatrixColumns;
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] result;
    private int[][] result2;

    public ThreadMatrix(int firstMatrixStrings, int firstMatrixColumns, int secondMatrixColumns,
                        int[][] firstMatrix, int[][] secondMatrix ) {
        this.firstMatrixStrings = firstMatrixStrings;
      //  this.firstMatrixColumns = firstMatrixColumns;
      //  this.secondMatrixStrings = secondMatrixStrings;
        this.secondMatrixColumns = secondMatrixColumns;
        this.result = new int[firstMatrixColumns][firstMatrixStrings];
        this.result2 = new int[firstMatrixColumns][firstMatrixStrings];
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    public int[][] CountMatrix() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i = 0; i < firstMatrixStrings; i++) {
            for (int j = 0; j < secondMatrixColumns; j++) {
                executorService.submit(new countThread(result, firstMatrix, secondMatrix, i, j));
            }
        }
        executorService.shutdown();

        return result;
    }
    public int[][] CountUsualMatrix() {
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    result2[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result2;
    }
    static class countThread implements Runnable {

        private int[][] firstMatrix;
        private int[][] secondMatrix;
        private int[][] resultMatrix;
        private int numberOfColumn;
        private int numberOfString;

        public countThread(int[][] resultMatrix, int[][] firstMatrix, int[][] secondMatrix,
                           int numberOfString, int numberOfColumn) {
            this.firstMatrix = firstMatrix;
            this.secondMatrix = secondMatrix;
            this.numberOfString = numberOfString;
            this.numberOfColumn = numberOfColumn;
            this.resultMatrix = resultMatrix;
        }

        public void run() {
            for (int i = 0; i < secondMatrix.length; i++) {
                resultMatrix[numberOfString][numberOfColumn] += firstMatrix[numberOfString][i]*secondMatrix[i][numberOfColumn];
            }
        }
    }


}

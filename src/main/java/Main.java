public class Main {
    public static void main(String[] args) {
        int firstMatrixStrings = 1000;
        int firstMatrixColumns = 1000;
        int secondMatrixColumns = 1000;

        CreateMatrixClass createMatrixClass = new CreateMatrixClass();
        int[][] firstMatrix = createMatrixClass.getNewMatrix(firstMatrixStrings, firstMatrixColumns);
        int[][] secondMatrix = createMatrixClass.getNewMatrix(firstMatrixColumns, secondMatrixColumns);


        ThreadMatrix threadMatrix = new ThreadMatrix(firstMatrixStrings, firstMatrixColumns,
                secondMatrixColumns, firstMatrix, secondMatrix);

        long start = System.currentTimeMillis();
        threadMatrix.CountUsualMatrix();
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;

        long start2 = System.currentTimeMillis();
        threadMatrix.CountMatrix();
        long finish2 = System.currentTimeMillis();
        long timeConsumedMillis2 = finish2 - start2;

        System.out.println(timeConsumedMillis);
        System.out.println(timeConsumedMillis2);

    }
}

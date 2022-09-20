package labo2;

public class MatrixToolbox {

    /**
     * Multiply two matrices.
     * Matrices are row-major, i.e., { { row0 }, { row1 }, ... }.
     *
     * @param matA First matrix
     * @param matB Second matrix
     * @return The result matrix of the multiplication A x B
     */
    public static Double[][] multiply(Double[][] matA, Double[][] matB) {
        Double[][] matC;

        int nbColMatA = matA[0].length;
        int nbColMatB = matB[0].length;
        int nbLigMatA = matA.length;
        int nbLigMatB = matB.length;
        int ligne = nbLigMatA;
        int colone = nbColMatB;

        if (nbColMatA != nbLigMatB) {
            return new Double[][]{{Double.NaN}};
        }

        matC = new Double[ligne][colone];

        ligne = 0;
        for (Double[] doubles : matA) {
            colone = 0;
            for (int n = 0; n < nbColMatB; n++) {
                double res = 0.0;
                for (int m = 0; m < nbLigMatB; m++) {
                    res += doubles[m] * matB[m][n];
                }
                matC[ligne][colone] = res;
                colone++;
            }
            ligne++;
        }
        return matC;
    }

    /**
     * Display the content of a matrix.
     *
     * @param mat Matrix to display (row-major)
     */
    public static void printMat(Double[][] mat) {
        for (Double[] row : mat) {
            System.out.print("[ ");
            for (Double val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        Double[][] mat1 = {{2.0, 3.0}, {4.0, 5.0}};
        Double[][] mat2 = {{6.0, 7.0}, {8.0, 9.0}};
        Double[][] res1 = multiply(mat1, mat2);
        printMat(res1);
        System.out.println();

        Double[][] mat3 = {{1.0, 0.0}, {3.0, 2.0}};
        Double[][] mat4 = {{8.0, 6.0, 2.0}, {4.0, 1.0, 0.0}};
        Double[][] res2 = multiply(mat3, mat4);
        printMat(res2);
        System.out.println();

        Double[][] mat5 = {{5.0, 6.0, 7.0}};
        Double[][] mat6 = {{1.0, 0.0}, {0.0, 1.0}, {1.0, 1.0}};
        Double[][] res3 = multiply(mat5, mat6);
        printMat(res3);
        System.out.println();
    }

}

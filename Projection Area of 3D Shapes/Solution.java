public class Solution {

    /**
     * Regresa el área de la suma de las 3 proyecciones bidimensionales de una
     * figura hecha de cuadros de 1x1x1
     * 
     * @param grid Descripción en una matriz de los cuadros de 1x1x1
     * @return Suma de las áreas
     */
    public int projectionArea(int[][] grid) {

        int n, output;
        n = grid.length;
        output = 0;

        for (int i = 0; i < n; i++) {

            int maxXZ = 0, maxYZ = 0;

            for (int j = 0; j < n; j++) {

                /* Cuenta el área de la base */
                if (0 < grid[i][j])
                    output += 1;

                /* Obtiene el área de una sola fila en el plano xz */
                if (maxXZ < grid[i][j])
                    maxXZ = grid[i][j];

                /* Obtiene el área de una sola fila en el plano xz */
                if (maxYZ < grid[j][i])
                    maxYZ = grid[j][i];

            }
            /* Se suman las áreas. */
            output += (maxXZ + maxYZ);
        }
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test_1 = { { 1, 2 }, { 3, 4 } };
        int[][] test_2 = { { 2 } };
        int[][] test_3 = { { 1, 0 }, { 0, 2 } };

        System.out.println("test 1, [[1,2][3,4]]: " + solution.projectionArea(test_1) +
                "\ntest 2, [[2]]: " + solution.projectionArea(test_2) +
                "\ntest 3, [[1,0],[0,2]]: " + solution.projectionArea(test_3));
    }
}
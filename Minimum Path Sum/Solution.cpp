using namespace std;
#include <vector>
#include <iostream>

class Solution
{
public:
    /**
     * Método que devuelve la distancia mínima de un arreglo al recorrerlo de la esquina superior izquierda hasta la esquina inferior derecha.
     *
     * @param grid la matriz con cada elemento como la distancia que hay entre el anterior superior o izquierdo.
     * @return el valor de la trayectoría de distancia mínima.
     *
     */
    int minPathSum(vector<vector<int>> &grid)
    {
        /* Declaración de variables auxiliares */
        int n = grid.size(), m = grid[0].size();

        /* Índices para recorrer la matriz */
        int i = 1, j = 1;

        while (i < n || j < m)
        {
            if (i < n)
                grid[i][0] += grid[i - 1][0], i++;

            if (j < m)
                grid[0][j] += grid[0][j - 1], j++;
        }

        /* Llenado de la matriz con la suma de distancia de la trayectoria mínima */
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];

        return grid[n - 1][m - 1];
    }
};

int main()
{
    Solution solucion;

    vector<vector<int>> prueba1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    vector<vector<int>> prueba2 = {{1, 2, 3}, {4, 5, 6}};

    int resultado1 = solucion.minPathSum(prueba1);
    int resultado2 = solucion.minPathSum(prueba2);

    cout << "Prueba 1: grid = [[1,3,1],[1,5,1],[4,2,1]]\nResultado: " << resultado1;
    cout << "\nPrueba 2: grid = [[1,2,3],[4,5,6]]\nResultado: " << resultado2;

    return 0;
}

using namespace std;
#include <vector>
#include <iostream>

class Solution
{
public:
    /**
     * Dado un arreglo de enteros sin números negativos, determinar si dando
     * a lo mucho nums[i] saltos, se puede llegar al final del arreglo.
     *
     * @param nums arreglo de enteros sin números negativos
     * @return 1 si es posible recorrer todo el arreglo, 0 en otro caso.
     *
     */
    bool canJump(vector<int> &nums)
    {
        int limite = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (limite < i)
                return false;
            int nuevoLimite = i + nums[i];
            limite = max(limite, nuevoLimite);
            if (limite > nums.size() - 2)
                break;
        }
        return true;
    }
};

int main()
{
    Solution solucion;

    vector<int> prueba1 = {2, 3, 1, 1, 4};
    vector<int> prueba2 = {3, 2, 1, 0, 4};

    bool resultado1 = solucion.canJump(prueba1);
    bool resultado2 = solucion.canJump(prueba2);

    cout << "C++ interpreta a False como 0 y a True como 1:\n";
    cout << "Prueba 1: nums = [2,3,1,1,4]\nResultado: " << resultado1;
    cout << "\nPrueba 2: nums = [3,2,1,0,4]\nResultado: " << resultado2;

    return 0;
}

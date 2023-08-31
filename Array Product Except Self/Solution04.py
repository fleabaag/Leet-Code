class Solution:

    def productExceptSelf(self, nums: list[int]) -> list[int]:

        # Tamaño del arreglo.
        r = len(nums)

        # Índice para iterar sobre los arreglos.
        i = 1

        # Dos arreglos de tamaño r y con elementos neutros multiplicativos para que no haga ruido.
        l1 = [1]*r
        l2 = [1]*r

        # Se llena la primer lista auxiliar con el prodcuto del anterior elemento de nums[i] y anterior elemento del arreglo l1[i].
        while i < r:
            j = i-1
            l1[i] = nums[j]*l1[j]
            i += 1

        # Se actualiza el valor del índice para la segunda iteración.
        i = r-2

        # Se llena la segunda lista auxiliar con el producto del elemento sucesor de nums[i] y elemento sucesor del arreglo l2[i].
        while i >= 0:
            j = i+1
            l2[i] = nums[j]*l2[j]
            i -= 1

        # Se actualiza el valor del índice para la tercera iteración.
        i = 0

        # Se multiplican entrada por entrada los valores de cada elemento de ambos arreglos.
        while i < r:
            l1[i] = l1[i]*l2[i]
            i += 1

        # Lista final que contiene ambos productos.
        return l1


class main:

    # Arreglo para poner a prueba el código.
    l = [2, 4, -6, 8]

    # Objeto de la clase Solution.
    test = Solution()

    # Arreglo esperado de salida.
    answer = test.productExceptSelf(l)

    # Visualización del arreglo original y arreglo de salida.
    print("Original array:\n", l)
    print("\nArray product except self:\n", answer)

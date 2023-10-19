class Solution {

    /**
     * Regresa un arreglo ordenando con elementos del 0 al 2 con Counting Sort.
     * 
     * @param nums el arreglo a ordenar
     */
    public void sortColors(int[] nums) {

        int frec0 = 0, frec1 = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0)
                frec0++;
            else if (nums[i] == 1)
                frec1++;

        for (int i = 0; i < nums.length; i++) {
            if (i < frec0)
                nums[i] = 0;
            else if (i >= frec0 && i < (frec0 + frec1))
                nums[i] = 1;
            else
                nums[i] = 2;

            System.out.println("Índice " + i + ":\n" + verArrelgo(nums) + "\n");
        }
    }

    /**
     * Visualizar el contenido del arreglo de acuerdo a sus colores.
     * 
     * @param nums
     * @return Cadena que representa al arreglo.
     */
    private static String verArrelgo(int[] nums) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String BLUE = "\u001B[44m";
        String WHITE = "\u001B[47m";

        String output = "[ ";

        for (int i : nums) {
            if (i == 0)
                output += RED + "ROJO" + RESET + " ";
            else if (i == 1)
                output += WHITE + "BLANCO" + RESET + " ";
            else
                output += BLUE + "AZUL" + RESET + " ";
        }

        output += "]";

        return output;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] test1 = { 2, 0, 2, 1, 1, 0 }, test2 = { 2, 0, 1 };

        System.out.println("Test 1: [2,0,2,1,1,0]");
        s.sortColors(test1);

        System.out.println("Test 2: [2,0,1]");
        s.sortColors(test2);
    }
}
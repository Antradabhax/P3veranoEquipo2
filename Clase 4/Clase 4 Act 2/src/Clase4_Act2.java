public class Clase4_Act2 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 10, 3, 6, 4, 9, 7, 1, 20};
        int[] result = twoHighestValues(nums, 0, nums.length - 1);

        System.out.println("Los dos valores mayores son: " + result[0] + " y " + result[1]);
    }

    private static int[] twoHighestValues(int[] nums, int ini, int fin) {
        if (ini == fin) {
            return new int[]{nums[ini], Integer.MIN_VALUE};
        }

        int mid = (ini + fin) / 2;
        int[] izq = twoHighestValues(nums, ini, mid);
        int[] der = twoHighestValues(nums, mid + 1, fin);

        //combinamos los resultados para obtener los dos valores más altos
        int[] result = new int[2];
        result[0] = Math.max(izq[0], der[0]);
        result[1] = Math.max(Math.min(izq[0], der[0]), Math.max(izq[1], der[1]));

        return result;
    }
}
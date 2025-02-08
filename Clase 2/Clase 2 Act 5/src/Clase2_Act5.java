public class Clase2_Act5 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println(sumaHastaN(10, sum));
    }

    //T(n) = T(n-1) + O(1)
    //T(n-1) = T(n-2) + O(1)
    //...
    //T(1) = T(0) + O(1)

    //Sumando todas las ecuaciones:
    //T(n) = T(0) + n * O(1)
    //Dado que T(0) = O(1)

    // la complejidad final es:
    //T(n) = O(n)
    public static int sumaHastaN(int n, int sum){
        if (n == 0) {
            return sum;
        }
        sum += n;
        return sumaHastaN(n-1, sum);
    }
}
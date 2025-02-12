package clase2;

public class Actividad1 {
    int [][] mat = {{4,5,6},{7,8,9},{5,6,7}};

    public double calcularPromedio(){
        double cantidadElementos = 0; // 1
        double sumatoriaTotal = 0; // 1

        for (int x = 0; x<mat.length; x++){ // 1 + (n+1)
            for(int y = 0; y<mat[x].length; y++){ // 1 + (n + 1) + n
                sumatoriaTotal = sumatoriaTotal + this.mat[x][y];
                cantidadElementos = cantidadElementos + 1;
            }
        }

        return sumatoriaTotal / cantidadElementos;
    }
}

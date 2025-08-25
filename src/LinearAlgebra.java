import java.util.Arrays;
public class LinearAlgebra {
    public static Matriz transpose(Matriz a) {
        int linhas = a.rows;
        int colunas = a.cols;

        if (a instanceof Vector) {
            Vector v = (Vector) a;
            int dimensao = v.dim;
            int[] valores = new int[dimensao];
            for(int i = 0; i < dimensao; i++){
                valores[i] = v.get(i);
            }
            return new Matriz(dimensao, 1, valores);
        } else {
            // Para matriz geral:
            int[] valores = new int[linhas * colunas];
            int indice = 0;
            for(int j = 0; j < colunas; j++) {        // !!! j primeiro
                for(int i = 0; i < linhas; i++) {
                    valores[indice] = a.get(i, j);
                    indice++;
                }
            }
            return new Matriz(colunas, linhas, valores); // !!! inverte
        }
    }
}
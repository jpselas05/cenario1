import java.util.Arrays;
public class LinearAlgebra {
    public static Matriz transpose(Matriz a) {
        int linhas = a.rows;
        int colunas = a.cols;

        if (a instanceof Vector) {
            Vector v = (Vector) a;
            int dimensao = v.dim;
            double[][] valores = new double[colunas][linhas];
            for(int i = 0; i < dimensao; i++){
                valores[i][1] = v.get(i);
            }
            return new Matriz(colunas, linhas, valores);
        } else {
            // Para matriz geral:
            double[][] valores = new double[colunas][linhas];
            int indice = 0;
            for(int j = 0; j < colunas; j++) {        // !!! j primeiro
                for(int i = 0; i < linhas; i++) {
                    valores[j][i] = a.get(i, j);
                    indice++;
                }
            }
            return new Matriz(colunas, linhas, valores); // !!! inverte
        }
    }
    public static Matriz Gauss(Matriz matriz){
        int linhas = matriz.rows;
        int colunas = matriz.cols;
        int menorDimensao = linhas > colunas ? colunas : linhas;
        double[][] A = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                A[i][j] = matriz.get(i, j);
            }
        }

        for (int j = 0; j < menorDimensao; j++) {
            int pivo = j;
            for (int i = j; i < linhas; i++) {
                if (A[i][j] != 0) {
                    pivo = i;
                    break;
                }
            }

            if (A[pivo][j] == 0) continue;

            if (pivo != j) {
                double[] temp = A[j];
                A[j] = A[pivo];
                A[pivo] = temp;
            }

            for (int i = j + 1; i < linhas; i++) {
                double fator = -A[i][j] / A[j][j];
                for (int k = j; k < colunas; k++) {
                    A[i][k] += fator * A[j][k];
                }
            }
        }

        return new Matriz(linhas, colunas, A);
    };
    public static double[][] GaussForSolve(Matriz matriz) {
        int linhas = matriz.rows;
        int colunas = matriz.cols;
        double[][] A = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                A[i][j] = matriz.get(i, j);
            }
        }

        for (int j = 0; j < Math.min(linhas, colunas); j++) {
            for (int i = j + 1; i < linhas; i++) {
                if (A[j][j] == 0) continue;
                double fator = (double)(-A[i][j] / A[j][j]);
                for (int k = j; k < colunas; k++) {
                    A[i][k] += fator * A[j][k];
                }
            }
        }

        return A;
    };

    public static Matriz Solve(Matriz matriz) {
        int linhas = matriz.rows;
        int colunas = matriz.cols;
        int menorDimensao = Math.min(linhas, colunas);
        double[][] A = GaussForSolve(matriz);

        for (int j = menorDimensao - 1; j >= 0; j--) {
            double pivo = A[j][j];
            if (pivo != 0) {
                for (int k = j; k < colunas; k++) {
                    A[j][k] /= pivo;
                }

                for (int i = j - 1; i >= 0; i--) {
                    double fator = (double)(-A[i][j]);
                    for (int k = j; k < colunas; k++) {
                        A[i][k] += fator * A[j][k];
                    }
                }
            }
        }

        // zera valores muito pequenos
        double EPS = 1e-12;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Math.abs(A[i][j]) < EPS) A[i][j] = 0.0;
            }
        }

        return new Matriz(linhas, colunas, A);
    };
}

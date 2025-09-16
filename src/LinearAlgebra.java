import java.util.Arrays;
public class LinearAlgebra {
    public static Matriz transpose(Matriz a) {
        int linhas = a.rows;
        int colunas = a.cols;

        if (a instanceof Vector) {
            Vector v = (Vector) a;
            int dimensao = v.dim;
            double[] valores = new double[dimensao];
            for(int i = 0; i < dimensao; i++){
                valores[i] = v.get(i);
            }
            return new Matriz(dimensao, 1, valores);
        } else {
            // Para matriz geral:
            double[] valores = new double[linhas * colunas];
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

        for (int j = 0; j < Math.min(linhas, colunas); j++) {
            for (int i = j + 1; i < linhas; i++) {
                if (A[j][j] == 0) continue;
                double fator = (double)(-A[i][j] / A[j][j]);
                for (int k = j; k < colunas; k++) {
                    A[i][k] += fator * A[j][k];
                }
            }
        }
        double[] array = new double[linhas*colunas];
        int indice = 0;
        for (int i = 0; i<linhas;i++){
            for (int j = 0; j<colunas;j++){
                array[indice++] = A[i][j];
            }
        }
        return new Matriz(linhas, colunas, array);
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
        double[][] A = GaussForSolve(matriz);
        double PostoCoeficientes = 0;
        double PostoReduzida = 0;
        for (int i = linhas - 1; i >= 0; i--) {

            int pivotCol = -1;
            for (int j = 0; j < colunas; j++) {
                if (Math.abs(A[i][j]) > 1e-10) {
                    pivotCol = j;
                    break;
                }
            }

            if (pivotCol != -1) {
                double pivoVal = A[i][pivotCol];
                for (int k = pivotCol; k < colunas; k++) {
                    A[i][k] /= pivoVal;
                }

                for (int row_above = i - 1; row_above >= 0; row_above--) {
                    double fator = A[row_above][pivotCol];

                    for (int k = pivotCol; k < colunas; k++) {
                        A[row_above][k] -= fator * A[i][k];
                    }
                }
            }
        }



        double EPS = 1e-12;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Math.abs(A[i][j]) < EPS) A[i][j] = 0.0;
            }
        }
        double[] array = new double[linhas*colunas];

        int indice = 0;
        for (int i = 0; i<linhas;i++){
            for (int j = 0; j<colunas;j++){
                array[indice++] = A[i][j];
            }
        }
        int linhasNaoNulasAmpliada = 0;
        for (int i = 0; i<linhas;i++){
            double somaAmpliadas = 0;
            for (int j = 0; j<colunas;j++){
                somaAmpliadas += A[i][j];
            }
            if(somaAmpliadas != 0) {
                linhasNaoNulasAmpliada++;
            }
        }
        int linhasNaoNulasCoefientes = 0;
        for (int i = 0; i<linhas;i++){
            double somaCoeficientes = 0;
            for (int j = 0; j<colunas-1;j++){
                somaCoeficientes += A[i][j];
            }
            if(somaCoeficientes != 0){
                linhasNaoNulasCoefientes++;
            }
        }
        if(linhasNaoNulasCoefientes == linhasNaoNulasAmpliada) {
            if (linhas + 1 == colunas) {
                if (colunas - 1 == linhasNaoNulasAmpliada) {
                    System.out.println("Sistema possível e determinado");
                } else {
                    System.out.println("Sistema possível e indeterminado");
                }
            }
            return new Matriz(linhas, colunas, array);

        }
        else{
            System.out.println("Sistema impossível");
        }
        return null;
    };
    public static Matriz sum(Matriz a, Matriz b) {
        int linhas = a.rows;
        int colunas = a.cols;

        if (linhas != b.rows || colunas != b.cols) {
            throw new IllegalArgumentException("Dimensões incompatíveis para soma de matrizes.");
        }

        double[] valores = new double[linhas * colunas];
        int indice = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                valores[indice++] = a.get(i, j) + b.get(i, j);
            }
        }
        return new Matriz(linhas, colunas, valores);
    }
    public static Vector sum(Vector a, Vector b) {
        int dimensao = a.dim;

        if (dimensao != b.dim) {
            throw new IllegalArgumentException("Dimensões incompatíveis para soma de vetores.");
        }

        double[] valores = new double[dimensao];
        for (int i = 0; i < dimensao; i++) {
            valores[i] = a.get(i) + b.get(i);
        }
        return new Vector(dimensao, valores);
    }
    public static Matriz times(int escalar, Matriz m) {
        int linhas = m.rows;
        int colunas = m.cols;

        double[] valores = new double[linhas * colunas];
        int indice = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                valores[indice++] = escalar * m.get(i, j);
            }
        }
        return new Matriz(linhas, colunas, valores);
    }
    public static Vector times(int escalar, Vector v) {
        int dimensao = v.dim;

        double[] valores = new double[dimensao];
        for (int i = 0; i < dimensao; i++) {
            valores[i] = escalar * v.get(i);
        }
        return new Vector(dimensao, valores);
    }
    public static Matriz times(Matriz a, Matriz b) {
        int linhas = a.rows;
        int colunas = a.cols;

        if (linhas != b.rows || colunas != b.cols) {
            throw new IllegalArgumentException("Dimensões incompatíveis para multiplicação elemento a elemento de matrizes.");
        }

        double[] valores = new double[linhas * colunas];
        int indice = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                valores[indice++] = a.get(i, j) * b.get(i, j);
            }
        }
        return new Matriz(linhas, colunas, valores);
    }
    public static Vector times(Vector a, Vector b) {
        int dimensao = a.dim;

        if (dimensao != b.dim) {
            throw new IllegalArgumentException("Dimensões incompatíveis para multiplicação elemento a elemento de vetores.");
        }

        double[] valores = new double[dimensao];
        for (int i = 0; i < dimensao; i++) {
            valores[i] = a.get(i) * b.get(i);
        }
        return new Vector(dimensao, valores);
    }
    public static Matriz dot(Matriz a, Matriz b) {
        int linhasA = a.rows;
        int colunasA = a.cols;
        int linhasB = b.rows;
        int colunasB = b.cols;

        if (colunasA != linhasB) {
            throw new IllegalArgumentException("Dimensões incompatíveis para multiplicação de matrizes.");
        }

        double[] valores = new double[linhasA * colunasB];
        int indice = 0;

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                double soma = 0;
                for (int k = 0; k < colunasA; k++) {
                    soma += a.get(i, k) * b.get(k, j);
                }
                valores[indice++] = soma;
            }
        }

        return new Matriz(linhasA, colunasB, valores);
    }
}

// Arquivo: Main.java
public class Main {
    public static void main(String[] args) {
        double[] dadosMatriz = {1,1,2,9,2,4,-3,1,3,6,-5,0};
        double[] dadosMatriz2 = {5, 3, 7, 1, 4, 8, 3, 7, 2,3,4,5};
        Matriz matrizOriginal = new Matriz(3, 4, dadosMatriz);

        double[] dadosVetor = {5, 10, 15};
        Vector meuVetor = new Vector(3, dadosVetor);

        System.out.println("--- Matrizes e Vetores Iniciais ---");
        System.out.println("Matriz Original (A):");
        System.out.println(matrizOriginal);
        System.out.println("Vetor (v):");
        System.out.println(meuVetor + "\n");

        System.out.println("--- 1. Transposição ---");
        Matriz vetorTransposto = LinearAlgebra.transpose(meuVetor);
        System.out.println("Vetor Transposto (v^T):");
        System.out.println(vetorTransposto);
        Matriz matrizTransposta = new Matriz(3, 4, dadosMatriz2);
        System.out.println("Matriz Transposta:");
        System.out.println(matrizTransposta);

        System.out.println("--- 2. Operações Aritméticas ---");
        Matriz matrizSoma = LinearAlgebra.sum(matrizOriginal, matrizTransposta);
        System.out.println("Soma:");
        System.out.println(matrizSoma);

        Matriz matrizVezesEscalar = (Matriz) LinearAlgebra.times(2, matrizOriginal);
        System.out.println("Multiplicação por Escalar (2 * A):");
        System.out.println(matrizVezesEscalar);
        System.out.println("--- 3. Multiplicação de Matrizes (dot) ---");
        System.out.println("Produto Matricial:");

        System.out.println("--- 4. Eliminação Gaussiana ---");
        Matriz matrizGauss = LinearAlgebra.Gauss(matrizOriginal);
        System.out.println("Forma Escalonada (Gauss):");
        System.out.println(matrizGauss);

        System.out.println("--- 5. Resolução (Gauss-Jordan) ---");
        Matriz matrizSolve = LinearAlgebra.Solve(matrizOriginal);
        System.out.println("Forma Escalonada Reduzida (Solve):");
        System.out.println(matrizSolve);
    }
}

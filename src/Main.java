public class Main {
    public static void main(String[] args) {

        System.out.println("1. TESTE DE TRANSPOSIÇÃO:");
        double[] elementos1 = {1, 2, 3, 4, 5, 6};
        Matriz matrizTranspose = new Matriz(2, 3, elementos1);
        System.out.println("Matriz original:");
        System.out.print(matrizTranspose);
        System.out.println("Matriz transposta:");
        Matriz transposta = LinearAlgebra.transpose(matrizTranspose);
        System.out.print(transposta);
        System.out.println();

        System.out.println("2. TESTE DE TRANSPOSIÇÃO DE VETOR:");
        double[] elementosVet1 = {1, 2, 3};
        Vector vetorTranspose = new Vector(3, elementosVet1);
        System.out.println("Vetor original:");
        System.out.println(vetorTranspose);
        System.out.println("Vetor transposto:");
        Matriz vetorTransposto = LinearAlgebra.transpose(vetorTranspose);
        System.out.print(vetorTransposto);
        System.out.println();

        System.out.println("3. TESTE DE ELIMINAÇÃO GAUSSIANA:");
        double[] elementosGauss = {2, -1, 3, 1, 3, -2, 1, -1, 1};
        Matriz matrizGauss = new Matriz(3, 3, elementosGauss);
        System.out.println("Matriz original:");
        System.out.print(matrizGauss);
        System.out.println("Matriz após eliminação gaussiana:");
        Matriz gaussiana = LinearAlgebra.Gauss(matrizGauss);
        System.out.print(gaussiana);
        System.out.println();

        System.out.println("4.1 TESTE DE RESOLUÇÃO DE SISTEMA LINEAR:");
        double[] elementosSistema = {3,-1,2,7,5,7,-3,10,4,-6,7,13};
        Matriz matrizSistema = new Matriz(3, 4, elementosSistema);
        System.out.println("Sistema linear (matriz ampliada):");
        System.out.print(matrizSistema);
        System.out.println("Solução:");
        Matriz solucao = LinearAlgebra.Solve(matrizSistema);
        if (solucao != null) {
            System.out.print(solucao);
        }
        System.out.println();

        System.out.println("4.2 SISTEMA IMPOSSÍVEL:");
        double[] elementosImpossivel = {1, 2, 3, 2, 4, 6, 3, 6, 10};
        Matriz sistemaImpossivel = new Matriz(3, 3, elementosImpossivel);
        System.out.println("Sistema impossível:");
        System.out.print(sistemaImpossivel);
        System.out.println("Tentativa de solução:");
        Matriz solucaoImpossivel = LinearAlgebra.Solve(sistemaImpossivel);
        System.out.println();

        System.out.println("5. TESTE DE SOMA DE MATRIZES:");
        double[] elementosSoma1 = {1, 2, 3, 4};
        double[] elementosSoma2 = {5, 6, 7, 8};
        Matriz matrizSoma1 = new Matriz(2, 2, elementosSoma1);
        Matriz matrizSoma2 = new Matriz(2, 2, elementosSoma2);
        System.out.println("Primeira matriz:");
        System.out.print(matrizSoma1);
        System.out.println("Segunda matriz:");
        System.out.print(matrizSoma2);
        System.out.println("Soma das matrizes:");
        Matriz somaMat = LinearAlgebra.sum(matrizSoma1, matrizSoma2);
        System.out.print(somaMat);
        System.out.println();

        System.out.println("6. TESTE DE SOMA DE VETORES:");
        double[] elementosVetSoma1 = {1, 2, 3};
        double[] elementosVetSoma2 = {4, 5, 6};
        Vector vetorSoma1 = new Vector(3, elementosVetSoma1);
        Vector vetorSoma2 = new Vector(3, elementosVetSoma2);
        System.out.println("Primeiro vetor:");
        System.out.println(vetorSoma1);
        System.out.println("Segundo vetor:");
        System.out.println(vetorSoma2);
        System.out.println("Soma dos vetores:");
        Vector somaVet = LinearAlgebra.sum(vetorSoma1, vetorSoma2);
        System.out.println(somaVet);
        System.out.println();

        System.out.println("7. TESTE DE MULTIPLICAÇÃO POR ESCALAR - MATRIZ:");
        double[] elementosEscalarMat = {1, 2, 3, 4, 5, 6};
        Matriz matrizEscalar = new Matriz(2, 3, elementosEscalarMat);
        int escalar = 3;
        System.out.println("Matriz original:");
        System.out.print(matrizEscalar);
        System.out.println("Multiplicação por escalar " + escalar + ":");
        Matriz multEscalarMat = LinearAlgebra.times(escalar, matrizEscalar);
        System.out.print(multEscalarMat);
        System.out.println();

        System.out.println("8. TESTE DE MULTIPLICAÇÃO POR ESCALAR - VETOR:");
        double[] elementosEscalarVet = {2, 4, 6};
        Vector vetorEscalar = new Vector(3, elementosEscalarVet);
        int escalarVet = 2;
        System.out.println("Vetor original:");
        System.out.println(vetorEscalar);
        System.out.println("Multiplicação por escalar " + escalarVet + ":");
        Vector multEscalarVet = LinearAlgebra.times(escalarVet, vetorEscalar);
        System.out.println(multEscalarVet);
        System.out.println();

        System.out.println("9. TESTE DE MULTIPLICAÇÃO - MATRIZ:");
        double[] elementosMult1 = {1, 2, 3, 4};
        double[] elementosMult2 = {2, 3, 4, 5};
        Matriz matrizMult1 = new Matriz(2, 2, elementosMult1);
        Matriz matrizMult2 = new Matriz(2, 2, elementosMult2);
        System.out.println("Primeira matriz:");
        System.out.print(matrizMult1);
        System.out.println("Segunda matriz:");
        System.out.print(matrizMult2);
        System.out.println("Multiplicação:");
        Matriz multElemento = LinearAlgebra.times(matrizMult1, matrizMult2);
        System.out.print(multElemento);
        System.out.println();

        System.out.println("10. TESTE DE MULTIPLICAÇÃO - VETOR:");
        double[] elementosVetMult1 = {1, 2, 3};
        double[] elementosVetMult2 = {2, 3, 4};
        Vector vetorMult1 = new Vector(3, elementosVetMult1);
        Vector vetorMult2 = new Vector(3, elementosVetMult2);
        System.out.println("Primeiro vetor:");
        System.out.println(vetorMult1);
        System.out.println("Segundo vetor:");
        System.out.println(vetorMult2);
        System.out.println("Multiplicação");
        Vector multVetElemento = LinearAlgebra.times(vetorMult1, vetorMult2);
        System.out.println(multVetElemento);
        System.out.println();

        System.out.println("11. TESTE DE MULTIPLICAÇÃO DE MATRIZES:");
        double[] elementosDot1 = {1, 2, 3, 4, 5, 6};
        double[] elementosDot2 = {7, 8, 9, 10, 11, 12};
        Matriz matrizDot1 = new Matriz(2, 3, elementosDot1);
        Matriz matrizDot2 = new Matriz(3, 2, elementosDot2);
        System.out.println("Primeira matriz:");
        System.out.print(matrizDot1);
        System.out.println("Segunda matriz");
        System.out.print(matrizDot2);
        System.out.println("Produto matricial:");
        Matriz produtoMatricial = LinearAlgebra.dot(matrizDot1, matrizDot2);
        System.out.print(produtoMatricial);
        System.out.println();



        // Cenário 3

        double[] adjacencyData = {
                0, 1, 0, 0, 1, 0, 0, 1, 0, 0,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 1, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                0, 1, 1, 1, 1, 0, 0, 1, 0, 1,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0
        };

        Matriz A = new Matriz(10, 10, adjacencyData);
        double tol = 0.0001;
        HITS.authority(A, tol);

    }
}
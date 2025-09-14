public class Main {
    public static void main(String[] args) {
//        int[] dadosVetor = {1, 2, 3, 4, 5};
//        Vector meuVetor = new Vector(5, dadosVetor);
//        System.out.println("Vetor original:");
//        System.out.println(meuVetor);

//        System.out.println("Vetor transposto:");
//        System.out.println(vetorTransposto);



            double[][] dadosMatriz = {
                    {1, -2, 1, 0},
                    {1, 7, -3, 6},
                    {1, 7, -1, 12}
            };

        Matriz minhaMatriz = new Matriz(3,4,dadosMatriz);
            System.out.println(minhaMatriz);
            Matriz matrizGaussiada = LinearAlgebra.Gauss(minhaMatriz);
        System.out.println("Gauss:");
            System.out.println(matrizGaussiada );
            Matriz vetorTransposto = LinearAlgebra.transpose(minhaMatriz);
        System.out.println("Transposto:");
            System.out.println(vetorTransposto);
            Matriz matrizSolviada = LinearAlgebra.Solve(minhaMatriz);
        System.out.println("Solve: ");
        System.out.println(matrizSolviada);

    }
}
public class Main {
    public static void main(String[] args) {
        int[] dados = {1, 2, 3, 4, 5};
        Vector meuVetor = new Vector(5, dados);

        Matriz vetorTransposto = LinearAlgebra.transpose(meuVetor);

        System.out.println("Vetor original:");
        System.out.println(meuVetor);

        System.out.println("Vetor transposto:");
        System.out.println(vetorTransposto);
    }
}
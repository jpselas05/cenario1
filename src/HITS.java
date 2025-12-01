public class HITS {

    public static Vector authority(Matriz A, double tol) {

        int n = A.rows; // número de linhas = número de sites

        // vetor autoridade inicial a0 = [1,1,1,...]
        double[] a0dados = new double[n];
        for (int i = 0; i < n; i++) {
            a0dados[i] = 1;
        }
        Vector a0 = new Vector(n, a0dados);

        // matriz transposta Aᵀ
        Matriz At = LinearAlgebra.transpose(A);

        Vector an = null;

        for (int iter = 0; iter < 1000; iter++) {

            // a0 é Vector → preciso transformar em coluna (Matrix nx1)
            Matriz a0col = LinearAlgebra.transpose(a0);

            // u = A * a0
            Matriz u = LinearAlgebra.dot(A, a0col);

            // calcular norma de u
            double r = 0;
            for (int i = 0; i < n; i++) {
                r += u.get(i, 0) * u.get(i, 0);
            }
            r = Math.sqrt(r);

            // hn = u / r
            double[] hNdados = new double[n];
            for (int i = 0; i < n; i++) {
                hNdados[i] = u.get(i, 0) / r;
            }
            Vector hn = new Vector(n, hNdados);

            // hn → matriz coluna
            Matriz hncol = LinearAlgebra.transpose(hn);

            // v = Aᵀ * hn
            Matriz v = LinearAlgebra.dot(At, hncol);

            // norma de v
            double s = 0;
            for (int i = 0; i < n; i++) {
                s += v.get(i, 0) * v.get(i, 0);
            }
            s = Math.sqrt(s);

            // an = v / s
            double[] aNdados = new double[n];
            for (int i = 0; i < n; i++) {
                aNdados[i] = v.get(i, 0) / s;
            }
            an = new Vector(n, aNdados);

            // critério de parada
            double maxErro = 0;
            for (int i = 0; i < n; i++) {
                double erro = Math.abs(an.get(i) - a0.get(i));
                if (erro > maxErro) maxErro = erro;
            }

            if (maxErro < tol) break;

            // atualizar
            a0 = an;
        }
        mostrarRankingAutoridade(an);
        return an;
    }


    // Ranking decrescente
    public static void mostrarRankingAutoridade(Vector autoridade) {

        int n = autoridade.dim;

        // tabela: [site, valor]
        double[][] ranking = new double[n][2];

        for (int i = 0; i < n; i++) {
            ranking[i][0] = i + 1;       // número do site
            ranking[i][1] = autoridade.get(i);
        }

        java.util.Arrays.sort(ranking, (a, b) -> Double.compare(b[1], a[1]));

        System.out.println("\nRanking decrescente de autoridade:");
        for (int i = 0; i < n; i++) {
            System.out.printf(
                    "%dº lugar → site %d (%.6f)\n",
                    (i + 1),
                    (int) ranking[i][0],
                    ranking[i][1]
            );
        }
        System.out.println();
    }
}

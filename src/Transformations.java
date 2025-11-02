public class Transformations {

    /**
     * Rotação 2D - Rotaciona um vetor 2D em torno da origem
     * @param vector Vetor 2D em coordenadas cartesianas
     * @param angle Ângulo de rotação em radianos (sentido anti-horário)
     * @return Vetor 2D rotacionado em coordenadas cartesianas
     */
    public static Vector rotation2D(Vector vector, double angle) {
        if (vector.dim != 2) {
            throw new IllegalArgumentException("O vetor deve ter dimensão 2 para rotação 2D");
        }

        // Converter para coordenadas homogêneas (adiciona 1 como terceira coordenada)
        double[] homogeneous = new double[3];
        homogeneous[0] = vector.get(0);
        homogeneous[1] = vector.get(1);
        homogeneous[2] = 1.0;
        Matriz vectorHomogeneo = new Matriz(3, 1, homogeneous);

        // Matriz de rotação 2D em coordenadas homogêneas
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double[] matrizRotacao = new double[] {
                cos,  -sin,  0,
                sin,   cos,  0,
                0,     0,    1
        };
        Matriz rotation = new Matriz(3, 3, matrizRotacao);

        Matriz resultado = LinearAlgebra.dot(rotation, vectorHomogeneo);

        double[] cartesian = new double[2];
        cartesian[0] = resultado.get(0, 0);
        cartesian[1] = resultado.get(1, 0);

        return new Vector(2, cartesian);
    }

    /**
     * Rotação 3D em torno do eixo X
     * @param vector Vetor 3D em coordenadas cartesianas
     * @param angle Ângulo de rotação em radianos (sentido anti-horário olhando do eixo +X)
     * @return Vetor 3D rotacionado em coordenadas cartesianas
     */
    public static Vector rotation3DX(Vector vector, double angle) {
        if (vector.dim != 3) {
            throw new IllegalArgumentException("O vetor deve ter dimensão 3 para rotação 3D");
        }

        // Converter para coordenadas homogêneas
        double[] homogeneous = new double[4];
        homogeneous[0] = vector.get(0);
        homogeneous[1] = vector.get(1);
        homogeneous[2] = vector.get(2);
        homogeneous[3] = 1.0;
        Matriz vectorHomogeneo = new Matriz(4, 1, homogeneous);

        // Matriz de rotação em torno do eixo X
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double[] matrizRotacao = new double[] {
                1,    0,     0,    0,
                0,    cos,  -sin,  0,
                0,    sin,   cos,  0,
                0,    0,     0,    1
        };
        Matriz rotation = new Matriz(4, 4, matrizRotacao);

        Matriz resultado = LinearAlgebra.dot(rotation, vectorHomogeneo);

        double[] cartesian = new double[3];
        cartesian[0] = resultado.get(0, 0);
        cartesian[1] = resultado.get(1, 0);
        cartesian[2] = resultado.get(2, 0);

        return new Vector(3, cartesian);
    }

    /**
     * Rotação 3D em torno do eixo Y
     * @param vector Vetor 3D em coordenadas cartesianas
     * @param angle Ângulo de rotação em radianos (sentido anti-horário olhando do eixo +Y)
     * @return Vetor 3D rotacionado em coordenadas cartesianas
     */
    public static Vector rotation3DY(Vector vector, double angle) {
        if (vector.dim != 3) {
            throw new IllegalArgumentException("O vetor deve ter dimensão 3 para rotação 3D");
        }

        // Converter para coordenadas homogêneas
        double[] homogeneous = new double[4];
        homogeneous[0] = vector.get(0);
        homogeneous[1] = vector.get(1);
        homogeneous[2] = vector.get(2);
        homogeneous[3] = 1.0;
        Matriz vectorHomogeneo = new Matriz(4, 1, homogeneous);

        // Matriz de rotação em torno do eixo Y
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double[] matrizRotacao = new double[] {
                cos,   0,    sin,  0,
                0,     1,    0,    0,
                -sin,  0,    cos,  0,
                0,     0,    0,    1
        };
        Matriz rotation = new Matriz(4, 4, matrizRotacao);

        Matriz resultado = LinearAlgebra.dot(rotation, vectorHomogeneo);

        double[] cartesian = new double[3];
        cartesian[0] = resultado.get(0, 0);
        cartesian[1] = resultado.get(1, 0);
        cartesian[2] = resultado.get(2, 0);

        return new Vector(3, cartesian);
    }

    /**
     * Rotação 3D em torno do eixo Z
     * @param vector Vetor 3D em coordenadas cartesianas
     * @param angle Ângulo de rotação em radianos (sentido anti-horário olhando do eixo +Z)
     * @return Vetor 3D rotacionado em coordenadas cartesianas
     */
    public static Vector rotation3DZ(Vector vector, double angle) {
        if (vector.dim != 3) {
            throw new IllegalArgumentException("O vetor deve ter dimensão 3 para rotação 3D");
        }

        // Converter para coordenadas homogêneas
        double[] homogeneous = new double[4];
        homogeneous[0] = vector.get(0);
        homogeneous[1] = vector.get(1);
        homogeneous[2] = vector.get(2);
        homogeneous[3] = 1.0;
        Matriz vectorHomogeneo = new Matriz(4, 1, homogeneous);

        // Matriz de rotação em torno do eixo Z
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double[] matrizRotacao = new double[] {
                cos,  -sin,  0,    0,
                sin,   cos,  0,    0,
                0,     0,    1,    0,
                0,     0,    0,    1
        };
        Matriz rotation = new Matriz(4, 4, matrizRotacao);

        Matriz resultado = LinearAlgebra.dot(rotation, vectorHomogeneo);

        double[] cartesian = new double[3];
        cartesian[0] = resultado.get(0, 0);
        cartesian[1] = resultado.get(1, 0);
        cartesian[2] = resultado.get(2, 0);

        return new Vector(3, cartesian);
    }
}
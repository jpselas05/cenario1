public class Matriz {
    public final int rows; // linhas
    public final int cols; // colunas
    private final int[][] matriz;
    // !!! constructor
    public Matriz(int rows, int cols, int[] elements) {
        if (elements.length != rows * cols) {
            throw new IllegalArgumentException("Número de elementos (" + elements.length + ") não corresponde ao tamanho da matriz (" + (rows*cols) + ").");
        }
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Dimensões da matriz devem ser positivas.");
        }
        this.rows = rows;
        this.cols = cols;

        matriz = new int[rows][cols];
        int indice = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matriz[i][j] = elements[indice];
                indice++;
            }
        }
    }
    // !!! metodo GET
    public int get(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Índices fora dos limites da matriz");
        }
        return matriz[i][j];
    }
    // !!! metodo SET
    public void set(int i, int j, int value) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Índices fora dos limites da matriz");
        }
        matriz[i][j] = value;
    }
    // !!! metodo MOSTRAR
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz ").append(rows).append("x").append(cols).append(":\n");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sb.append(get(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
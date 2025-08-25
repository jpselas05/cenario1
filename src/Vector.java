import java.util.Arrays;

public class Vector extends Matriz {
    public final int dim;
    // !!! constructor
    public Vector(int dim, int[] elements) {
        super(dim, 1, elements);
        this.dim = dim;
    }
    // !!! metodo GET
    public int get(int i) {
        return super.get(i, 0);
    }
    // !!! metodo SET
    public void set(int i, int value) {
        super.set(i, 0, value);
    }
    // !!! metodo MOSTRAR
    @Override
    public String toString() {
        int[] temp = new int[dim];
        for(int i = 0; i < dim; i++) {
            temp[i] = get(i); // usa o get(i) do Vector
        }
        return "Vector " + Arrays.toString(temp);
    }
}
import java.util.Arrays;

public class Vector extends Matriz {
    public final int dim;
    // !!! constructor
    public Vector(int dim, double[] elements) {
        super(dim, 1, elements);
        this.dim = dim;
    }
    // !!! metodo GET
    public double get(int i) {
        return super.get(i, 0);
    }
    // !!! metodo SET
    public void set(int i, double value) {
        super.set(i, 0, value);
    }
    // !!! metodo MOSTRAR
    @Override
    public String toString() {
        double[] temp = new double[dim];
        for(int i = 0; i < dim; i++) {
            temp[i] = get(i); // usa o get(i) do Vector
        }
        return "Vector " + Arrays.toString(temp);
    }
}
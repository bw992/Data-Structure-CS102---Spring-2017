package hw3;

/**
 * Created by fredf on 2/21/2017.
 */
public interface ISorting<T extends Comparable<? super T>> {
    // Return the result from sorting the input array.
    double[] sort(double[] copyOfx);
    double[] descendingSort(double[] elements);
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class SortTestAdapter
{
    private int[] array;
    
    public abstract int[] test(int[] array);

    public abstract String getName();

    void setTestArray(int[] array)
    {
        this.array = array;
    }
    
    private void validateResult(int[] array, boolean testContent) throws UnsortedArrayException
    {
        int size = array.length;

        if (testContent)
        {
            ArrayList<Integer> list = new ArrayList(Arrays.asList(IntStream.of(this.array).boxed().toArray(Integer[]::new)));

            for (int i = 0; i < size; i++)
            {
                if (!list.remove(Integer.valueOf(array[i])))
                {
                    throw new UnsortedArrayException("Array has new elements!");
                }
            }

            if (list.size() != 0)
            {
                throw new UnsortedArrayException("Array has new elements!");
            }
        }

        size--;
        
        for (int i = 0; i < size; i++)
        {
            if (array[i] > array[i + 1])
            {
                throw new UnsortedArrayException("Array is not sorted!");
            }
        }
    }
    
    long run() throws UnsortedArrayException
    {
        var watch = Stopwatch.startNew();
        int[] result = test(array.clone());
        watch.stop();

        validateResult(result, true);
        
        return watch.millis();
    }
}

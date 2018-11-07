import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortTester
{
    private List<SortTestAdapter> adapters;
    private int[] arraySizes;

    public void setTestAdapters(SortTestAdapter... adapters)
    {
        init(Arrays.asList(adapters));
    }

    public void setTestAdapters(List<SortTestAdapter> adapters)
    {
        init(adapters);
    }

    public SortTester()
    {
        arraySizes = new int[]{10, 100, 1000, 10000};
    }

    private void init(List<SortTestAdapter> adapters)
    {
        this.adapters = adapters;
    }

    public void setArraySizes(int... arraySizes)
    {
        this.arraySizes = arraySizes;
    }

    private int[] generateTestArray(int size)
    {
        var random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++)
        {
            array[i] = random.nextInt();
        }

        return array;
    }

    public void runTest(boolean verbose)
    {
        int[][] testArrays = new int[arraySizes.length][];

        for (int i = 0; i < arraySizes.length; i++)
        {
            testArrays[i] = generateTestArray(arraySizes[i]);
        }

        for (int i = 0; i < adapters.size(); i++)
        {
            var adapter = adapters.get(i);
            if (verbose) System.out.println("--- Testing " + "\"" + adapter.getName() + "\"" + " ---");

            for (int j = 0; j < arraySizes.length; j++)
            {
                adapter.setTestArray(testArrays[j].clone());

                try
                {
                    long time = adapter.run();
                    System.out.println("Array size = " + arraySizes[j] + ": " + time + "ms");
                }
                catch (UnsortedArrayException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}

public class BubbleSortTestAdapter extends SortTestAdapter
{
    @Override
    public int[] test(int[] array)
    {
        boolean sorted = false;
        int size = array.length - 1;

        while (!sorted)
        {
            sorted = true;

            for (int i = 0; i < size; i++)
            {
                if (array[i] > array[i + 1])
                {
                    Utils.swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }

        return array;
    }

    @Override
    public String getName()
    {
         return "Bubble Sort";
    }
}

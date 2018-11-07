public class InsertionSortTestAdapter extends SortTestAdapter
{
    @Override
    public int[] test(int[] array)
    {
        int size = array.length;

        for (int i = 1; i < size; i++)
        {
            int v = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > v)
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = v;
        }

        return array;
    }

    @Override
    public String getName()
    {
        return "Insertion Sort";
    }
}

public class SelectionSortTestAdapter extends SortTestAdapter
{
    @Override
    public int[] test(int[] array)
    {
        int size = array.length;

        for (int i = 0; i < size; i++)
        {
            int min = i;

            for (int j = i + 1; j < size; j++)
            {
                if (array[j] < array[min])
                {
                    min = j;
                }
            }

            if (i != min)
            {
                Utils.swap(array, min, i);
            }
        }

        return array;
    }

    @Override
    public String getName()
    {
        return "Selection Sort";
    }
}

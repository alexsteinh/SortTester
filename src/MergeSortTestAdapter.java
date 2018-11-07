public class MergeSortTestAdapter extends SortTestAdapter
{
    @Override
    public int[] test(int[] array)
    {
        return sort(array);
    }

    private int[] sort(int[] array)
    {
        int size = array.length;
        if (size == 1)
        {
            return array;
        }

        int size_left = size / 2;
        int[] left = new int[size_left];

        for (int i = 0; i < size_left; i++)
        {
            left[i] = array[i];
        }

        int size_right = size - size_left;
        int[] right = new int[size_right];

        for (int i = 0; i < size_right; i++)
        {
            right[i] = array[i + size_left];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right)
    {
        int left_size = left.length;
        int right_size = right.length;
        int[] array = new int[left_size + right_size];
        int i = 0;
        int j = 0;

        while (i < left_size && j < right_size)
        {
            if (left[i] <= right[j])
            {
                array[i + j] = left[i++];
            }
            else
            {
                array[i + j] = right[j++];
            }
        }
        
        while (i < left_size)
        {
            array[i + j] = left[i++];
        }
        
        while (j < right_size)
        {
            array[i + j] = right[j++];
        }
        
        return array;
    }

    @Override
    public String getName()
    {
        return "Merge Sort";
    }
}

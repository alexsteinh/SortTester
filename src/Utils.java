public class Utils
{
    public static void swap(int[] array, int ix1, int ix2)
    {
        int tmp = array[ix1];
        array[ix1] = array[ix2];
        array[ix2] = tmp;
    }
}

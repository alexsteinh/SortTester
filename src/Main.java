public class Main
{
    public static void main(String[] args)
    {
        var tester = new SortTester();
        tester.setTestAdapters(
                new BubbleSortTestAdapter(),
                new SelectionSortTestAdapter(),
                new MergeSortTestAdapter(),
                new InsertionSortTestAdapter()
        );
        tester.setArraySizes(10, 100, 1000, 10000, 20000, 50000);
        tester.runTest(true);
    }
}

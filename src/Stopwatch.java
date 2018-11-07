public class Stopwatch
{
    private long startTime, stopTime;

    public static Stopwatch startNew()
    {
        return new Stopwatch();
    }

    public Stopwatch()
    {
        start();
    }

    public void start()
    {
        startTime = System.currentTimeMillis();
        stopTime = startTime;
    }

    public void stop()
    {
        stopTime = System.currentTimeMillis();
    }

    public long millis()
    {
        return stopTime - startTime;
    }
}

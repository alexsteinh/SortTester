public class Stopwatch
{
    private long startTime, stopTime;
    private boolean isRunning = false;

    public static Stopwatch startNew()
    {
        var watch = new Stopwatch();
        watch.start();
        return watch;
    }

    public void start()
    {
        startTime = System.currentTimeMillis();
        stopTime = startTime;
        isRunning = true;
    }

    public void stop()
    {
        stopTime = System.currentTimeMillis();
        isRunning = false;
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    public long millis()
    {
        if (!isRunning)
        {
            return stopTime - startTime;
        }
        else
        {
            return System.currentTimeMillis() - startTime;
        }
    }
}

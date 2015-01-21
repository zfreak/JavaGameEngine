package staticHelpers;
import java.util.Random;
/**
 * Used to get random numbers
 * Cleans up the code significantly, as only one random object needs to be created
 */
public class StaticRandomNumbers
{
    private static Random random;
    static {
    	random = new Random(System.currentTimeMillis());
    }
    /***
     * Gets a random double between low and high
     * @param low the lower bound
     * @param high the upper bound
     * @return The random double
     */
    public static double getDoubleBetween(double low, double high) { 
        double difference = high - low;
        return (low + (random.nextDouble() * difference));
    }
    /***
     * Gets a random integer between low (inclusive) and high (exclusive)
     * @param low the inclusive lower bound
     * @param high the exclusive higher bound
     * @return The random integer
     */
    public static int getIntBetween(int low, int high) {
        int difference = high - low;
        return random.nextInt(difference) + low;
    }
}

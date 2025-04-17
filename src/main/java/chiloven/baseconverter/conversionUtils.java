package chiloven.baseconverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

public class conversionUtils {
    private static final Logger logger = LogManager.getLogger(conversionUtils.class);

    public static String convertBase(String input, int fromBase, int toBase) {
        try {
            BigInteger bigInt = new BigInteger(input, fromBase);
            return bigInt.toString(toBase).toUpperCase();
        } catch (NumberFormatException e) {
            logger.warn("Invalid number '{}' for base {}", input, fromBase, e);
            return "0";
        }
    }
}

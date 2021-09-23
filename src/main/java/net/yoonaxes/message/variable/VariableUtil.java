package net.yoonaxes.message.variable;

import java.text.DecimalFormat;

public class VariableUtil {

    /**
     * Double Format Pattern
     * DecimalFormat: #00.00
     */
    public static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#00.00");

    /**
     * Method to create replacement variable string with prefix and without prefix
     * Example result with prefix: ${PREFIX-SUFFIX}
     * Example result without prefix: ${SUFFIX}
     * @param prefix Variable prefix
     * @param suffix Variable suffix
     */
    public static String getVariableString(String prefix, String suffix) {
        return ("${" + (prefix == null || prefix.trim().isEmpty() ? "" : prefix + "-") + suffix + "}").toUpperCase();
    }
}

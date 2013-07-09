package org.calrissian.mango.accumulo.types.impl;


import static java.lang.Character.digit;
import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Double.longBitsToDouble;
import static java.lang.Float.floatToIntBits;
import static java.lang.Float.intBitsToFloat;

class EncodingUtils {

    /**
     * Returns the raw bit representation of a string of hex digits.
     *
     * Helper function simply because Long.parseLong(hex,16) does not handle negative numbers that were
     * converted to hex.
     */
    protected static long fromHex(String hex) {
        long value = 0;
        for (int i = 0; i < hex.length(); i++)
            value = (value << 4) | digit(hex.charAt(i), 16);

        return value;
    }

    protected static String encodeULong(long value) {
        return String.format("%016x", value);
    }

    protected static String encodeUInt(int value) {
        return String.format("%08x", value);
    }

    protected static int normalizeFloat(float value) {
        if (value > 0)
            return floatToIntBits(value) ^ Integer.MIN_VALUE;
        else
            return ~floatToIntBits(value);
    }

    protected static float denormalizeFloat(int value) {
        if (value > 0)
            return intBitsToFloat(~value);
        else
            return intBitsToFloat(value ^ Integer.MIN_VALUE);
    }

    protected static long normalizeDouble(double value) {
        if (value > 0)
            return doubleToRawLongBits(value) ^ Long.MIN_VALUE;
        else
            return ~doubleToRawLongBits(value);
    }

    protected static double denormalizeDouble(long value) {
        if (value > 0)
            return longBitsToDouble(~value);
        else
            return longBitsToDouble(value ^ Long.MIN_VALUE);
    }

    protected static byte[] reverse(byte[] bytes) {
        byte[] result = new byte[bytes.length];

        for (int i = 0;i< bytes.length;i++)
            result[i] = (byte) (0xff - (0xff & bytes[i]));

        return result;
    }
}
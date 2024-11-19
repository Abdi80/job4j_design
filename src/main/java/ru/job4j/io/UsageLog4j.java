package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteNumber = 12;
        short shortNumber = 136;
        int intNumber = 33;
        long longNumber = 10000000L;
        float floatNumber = 36.6f;
        double doubleNumber = 45.9995d;
        boolean checked = false;
        char sign = '1';
        LOG.debug("Numbers, byte : {}, short : {}, int : {}, long : {}, float : {}, double : {}",
                byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);
        LOG.info("Some info, boolean : {}, char : {}", checked, sign);
        LOG.trace("trace message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
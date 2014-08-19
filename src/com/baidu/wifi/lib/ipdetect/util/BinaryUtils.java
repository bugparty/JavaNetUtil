package com.baidu.wifi.lib.ipdetect.util;

/**
 * Created by hanbowen on 2014/8/18.
 */
public class BinaryUtils {
    public static final   int byteToUnsignedInt(byte b) {
        return 0x00 << 24 | b & 0xff;
    }
    public static final   int intToUnsignedLong(int int32) {
        return 0x00 << 56 | int32 & 0xffffffff;
    }
}

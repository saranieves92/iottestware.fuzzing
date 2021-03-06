package de.fraunhofer.fokus.fuzzing.nmf.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitHelperTest {

    private byte testByte1 = (byte)0b01100000;
    private byte testByte2 = (byte)0b10000000;
    private byte testByte3 = (byte) (3<<6);
    private byte testByte4 = (byte)0b00000001;
    private byte testByte5 = BitsAndByteHelper.hexStringToByteArray("60")[0];
    private byte testByte6 = BitsAndByteHelper.hexStringToByteArray("40")[0];

    @Test
    void shiftOffset() {
        assertEquals(5,BitsAndByteHelper.shiftOffset(testByte1));
        assertEquals(7,BitsAndByteHelper.shiftOffset(testByte2));
        assertEquals(6,BitsAndByteHelper.shiftOffset(testByte3));
        assertEquals(0,BitsAndByteHelper.shiftOffset(testByte4));
        assertEquals(4,BitsAndByteHelper.shiftOffset((byte) 48));
    }

    @Test
    void getByteIntByMask() {
        byte b = (byte) (0<< BitsAndByteHelper.shiftOffset((byte) 48));
        String s = Integer.toBinaryString(b);
        assertEquals("0",s);
    }

    @Test
    void setByteIntByMask() {
        byte b = BitsAndByteHelper.setByteIntByMask(testByte1, 1, (byte) 192);
        assertEquals(testByte1,b);
        byte b2 = BitsAndByteHelper.setByteIntByMask(testByte1, 2, (byte) 48);
        assertEquals(testByte1,b2);
        String s = Integer.toBinaryString(testByte5);
        String s1 = Integer.toBinaryString(testByte6);
        byte b3 = BitsAndByteHelper.setByteIntByMask(testByte5, 0, (byte) 48);
        String s3 = Integer.toBinaryString(b3);
        assertEquals(testByte6,b3);
    }

    @Test
    void numOfBits() {
        assertEquals(2,BitsAndByteHelper.numOfBits(192,0-0));
        assertEquals(2,BitsAndByteHelper.numOfBits(48,0-0));
        assertEquals(4,BitsAndByteHelper.numOfBits(15,0-0));
    }
}
package com.wf.ssm.base;

import org.junit.Test;

import com.wf.ssm.common.utils.StringUtils;
import com.wf.ssm.utils.ByteUtils;

public class ByteOperationTest {
	@Test
    public void testByte() {
		//ByteUtils.byteToInt(ByteUtils.convertBytes(ByteUtils.hexStringToBytes(wd1)));
		String temp = "a079";
		if(StringUtils.isEmpty(temp) || temp.length() != 4) return;

        byte[] bytes = ByteUtils.convertBytes(ByteUtils.hexStringToBytes(temp));
        int s = (bytes[0] & 0x80);
        if(s != 0) {
        	int num = ByteUtils.byteToInt(bytes) - 1;
        	bytes = ByteUtils.intToBytes(num, 2);
        	System.out.println(ByteUtils.bytesToHexString(bytes));
        	
        	byte tmp;
        	for(int i=0;i<bytes.length;i++) {
        		tmp = bytes[i];
        		bytes[i] = (byte)(~tmp);
        	}
        	System.out.println(ByteUtils.bytesToHexString(bytes));
        }else {
        	System.out.println(ByteUtils.bytesToHexString(bytes));
        }
	}
}

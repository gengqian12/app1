package com.parse;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

import org.springframework.web
public class EncoderHandler {
	
	  /**
	19
	     * encode string
	20
	     *
	21
	     * @param algorithm
	22
	     * @param str
	23
	     * @return String
	24
	     */
	    public static String encode(String algorithm, String str) {
	        if (str == null) {
	            return null;
	        }
	        try {
	            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
	            messageDigest.update(str.getBytes());
	            return getFormattedText(messageDigest.digest());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
	    	            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	    
	    private static String getFormattedText(byte[] bytes) {
	    	        int len = bytes.length;
	    	        StringBuilder buf = new StringBuilder(len * 2);
	    	        // 把密文转换成十六进制的字符串形式
	    	        for (int j = 0; j < len; j++) {          
	    	        	buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
	    	            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
	    	        }
	    	        return buf.toString();
	    	    }


	
	
	  public static void main(String[] args) {
		  DigestUtils.shaHex();
		  
			        System.out.println("111111 SHA1 :"
			                + EncoderHandler.encode("SHA1", "1"));
			    }
}

package com.thoughtworks.duorourou.switcheliminate;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSender {
    private static final String SECRET = "secret";

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println(hmacEncode("x-date: Mon, 15 Oct 2018 18:15:21 GMT", "secret"));
    }

    private static String hmacEncode(String encryptText, String encryptKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] data=encryptKey.getBytes("UTF-8");
               //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
               SecretKey secretKey = new SecretKeySpec(data, "HmacSHA256");
               //生成一个指定 Mac 算法 的 Mac 对象
               Mac mac = Mac.getInstance("HmacSHA256");
               //用给定密钥初始化 Mac 对象
               mac.init(secretKey);

               byte[] text = encryptText.getBytes("UTF-8");
               //完成 Mac 操作
                return Base64.getEncoder().encodeToString(mac.doFinal(text));
    }
}

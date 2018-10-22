package utils.crypt.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.crypt.Algorithm;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by tserj on 08.09.2015.
 */

public class BlowfishAlgorithm implements Algorithm {
    private static final Logger LOG = LoggerFactory.getLogger(BlowfishAlgorithm.class);

    // default Java install uses 8-bytes (64bit) key length maximum
    // use policy.jars from Oracle site to enhance key strength
    private static final String KEY = "l#:!<~65";
    private static final byte[] IV_BYTES = new byte[] { 0x17, 0x46, 0x15, 0x04, 0x31, 0x72, 0x11, 0x01 };

    private static String pad2(String n) {
        return (n.length() < 2) ? "0" + n : n;
    }

    private static String hex(byte[] bytes) {
        String r = "";
        for (byte aByte : bytes) {
            r = r + pad2(Integer.toHexString(aByte + 128));
        }
        return r;
    }

    private static int parseInt2(String s) {
        return (new java.math.BigInteger(s, 16)).intValue();
    }

    private static byte[] fromHex(String enc) {
        byte[] r = new byte[enc.length() / 2];
        for (int i = 0; i < r.length; i++) {
            int n = parseInt2(enc.substring(i * 2, i * 2 + 2)) - 128;
            r[i] = (byte) n;
        }
        return r;
    }

    public String crypt(String text) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes("UTF-8"), "Blowfish");
        IvParameterSpec ivSpec = new IvParameterSpec(IV_BYTES);
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return hex(cipher.doFinal(text.getBytes("UTF-8")));
    }

    public String decrypt(String text) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes("UTF-8"), "Blowfish");
        IvParameterSpec ivSpec = new IvParameterSpec(IV_BYTES);
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        return new String(cipher.doFinal(fromHex(text)), "UTF-8");
    }

}

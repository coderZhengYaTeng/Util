
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wutingyou on 2017/2/22.
 */

public class KeyUtils {
    private static final String TAG = "KeyUtils";

    /**
     * 字符串转16进制
     * 
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        final String str = "0123456789ABCDEF";
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) ((byte) str.indexOf(achar[pos]) << 4 | (byte) str.indexOf(achar[pos + 1]));
        }
        return result;
    }

    /**
     * 字节转16进制字符串
     * 
     * @param bArray
     * @return
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuilder sb = new StringBuilder(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 得到keyPair
     * 
     * @return
     */
    public static KeyPair keyPair() {
        // 使用RSA算法创建KeyPair
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 设置密钥长度
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair;
    }

    /**
     * 获取公钥字符串
     * 
     * @return
     */
    public static String getPublicKeyString() {
        return bytesToHexString(keyPair().getPublic().getEncoded());
    }

    /**
     * 获取私钥字符串
     * 
     * @return
     */
    public static String getPrivateKeyString() {
        return bytesToHexString(keyPair().getPrivate().getEncoded());
    }
}

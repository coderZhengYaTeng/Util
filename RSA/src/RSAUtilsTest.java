/**
 * Created by wutingyou on 2017/2/24.
 */
public class RSAUtilsTest {
    public static final String TAG = "RSAUtilsTest";

    public static void main(String[] args) throws Exception {
        // get();
        String str = "_________";
        String[] split = str.split("___", 6);
        System.out.println(split.length);
    }

    public static void get() {
        String realKey = "J+K/+>*N$/%\"$66F";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDW+wBbwvThS9zGp8F+J2l+Busm4kwlJqIa1lJ8n7J6V72jh293Htpp5WU244SDNQzh7I1JoecX5XUldxxYSLb87CxTBWj1l81MNeWJee0SoC14EKLP4VcA2bAA84AfyElAqG5u1Rgi1pyeNKA9yqOasJ5wU/4VX4xWcf+jyD4eQQIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANb7AFvC9OFL3ManwX4naX4G6ybiTCUmohrWUnyfsnpXvaOHb3ce2mnlZTbjhIM1DOHsjUmh5xfldSV3HFhItvzsLFMFaPWXzUw15Yl57RKgLXgQos/hVwDZsADzgB/ISUCobm7VGCLWnJ40oD3Ko5qwnnBT/hVfjFZx/6PIPh5BAgMBAAECgYAQaUrmtmRRSqRI+gd4ZPPVrhuHdWEQuPlJCTF02BAc7NPKRw2IT2+nA98NKKM2DPe1y4Qhqd1lYpvlx0j/qFVnp5ecw8+iXd6SQLF1QD8NmwAc38+jrBE/lP92sXw9wpOBOJJoFZTKN3KDYAX6KIDBTi7s0HFYJ/NmoJgnzR4XQQJBAPZNo70soWQ0LQeF1MH1YKxu/tUHJUato1O/V/pK3tXo4/6xRS7PKPR834B3r4IHaSnlKYGPK7oEex1A5w3KXikCQQDfca0CUWbNKQ4GoU7N9G2JOVZj9FFuWmC7+PcckcFXA0uep3wIYg81cQLIWi5D9Un9A+7Kv+8oZKyC6S//sJJZAkEA61Bv8Cu0obxrjPViuFALpZKB6trh1S3NjhSQJDPlw662LL4GX9tRwIuRKPav+mXEJl+nkP1NBHKFgQRh+z3tSQJBAKqlQ08I4ez/VLHlkayi5uCtBHhTx7jylvwX2IleG30bjC3/lS9FzH2w8EIY9Up7U2VDEqSPTtPXhxR3iGvK6wkCQC4kJdWbtxD2VkmEumPJNuBk69PdH4WT1YaIHWgCETDzYwRYJyqKvyCCFuVRE54xRh1orFcNJP/YuP6KnkBjeM0=";
        try {
            String data = RSAUtils.encrypt(publicKey, realKey);

            String decryptData = RSAUtils.decrypt(privateKey, data);
            System.out.println(data);
            System.out.println(decryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void put() throws Exception {
        String str = "RSA_公钥加密私钥解密";
        String strEncrypt = null;
        try {
            strEncrypt = RSAUtils
                .encrypt(
                    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDW+wBbwvThS9zGp8F+J2l+Busm4kwlJqIa1lJ8n7J6V72jh293Htpp5WU244SDNQzh7I1JoecX5XUldxxYSLb87CxTBWj1l81MNeWJee0SoC14EKLP4VcA2bAA84AfyElAqG5u1Rgi1pyeNKA9yqOasJ5wU/4VX4xWcf+jyD4eQQIDAQAB",
                    "J+K/+>*N$/%\"$66F");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String strDecrypt = RSAUtils
            .decrypt(
                "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANb7AFvC9OFL3ManwX4naX4G6ybiTCUmohrWUnyfsnpXvaOHb3ce2mnlZTbjhIM1DOHsjUmh5xfldSV3HFhItvzsLFMFaPWXzUw15Yl57RKgLXgQos/hVwDZsADzgB/ISUCobm7VGCLWnJ40oD3Ko5qwnnBT/hVfjFZx/6PIPh5BAgMBAAECgYAQaUrmtmRRSqRI+gd4ZPPVrhuHdWEQuPlJCTF02BAc7NPKRw2IT2+nA98NKKM2DPe1y4Qhqd1lYpvlx0j/qFVnp5ecw8+iXd6SQLF1QD8NmwAc38+jrBE/lP92sXw9wpOBOJJoFZTKN3KDYAX6KIDBTi7s0HFYJ/NmoJgnzR4XQQJBAPZNo70soWQ0LQeF1MH1YKxu/tUHJUato1O/V/pK3tXo4/6xRS7PKPR834B3r4IHaSnlKYGPK7oEex1A5w3KXikCQQDfca0CUWbNKQ4GoU7N9G2JOVZj9FFuWmC7+PcckcFXA0uep3wIYg81cQLIWi5D9Un9A+7Kv+8oZKyC6S//sJJZAkEA61Bv8Cu0obxrjPViuFALpZKB6trh1S3NjhSQJDPlw662LL4GX9tRwIuRKPav+mXEJl+nkP1NBHKFgQRh+z3tSQJBAKqlQ08I4ez/VLHlkayi5uCtBHhTx7jylvwX2IleG30bjC3/lS9FzH2w8EIY9Up7U2VDEqSPTtPXhxR3iGvK6wkCQC4kJdWbtxD2VkmEumPJNuBk69PdH4WT1YaIHWgCETDzYwRYJyqKvyCCFuVRE54xRh1orFcNJP/YuP6KnkBjeM0=",
                "BzCjnMHWsSXXhEd2RXKS/JybAJgcoeB49F5yLr0PLCC8l1E6OWOmZjbx0j+9MuhbNLdHwJ8I5tc1nWKT8kW/qTYvv3etUUrCuUBVVzU94Q2440DBOep1QXJE3Hu06//1CuB3Wc4jmOO3dBUZZcJSPh4lVHzeJLOOQ8vWEqmkT/0=");
        System.out.println(strEncrypt);
        System.out.println(strDecrypt);
    }
}
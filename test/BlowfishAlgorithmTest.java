import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.crypt.impl.BlowfishAlgorithm;
import utils.crypt.impl.Encryption;


/**
 * Created by tserj on 08.09.2015.
 */

public class BlowfishAlgorithmTest {
    private static final Logger LOG = LoggerFactory.getLogger(BlowfishAlgorithmTest.class);

    private static final String TEXT = "This is an example";

    @Test
    public void cryptAndDecrypt() throws Exception {
        Encryption encryption = new Encryption(new BlowfishAlgorithm());
        String cryptedText = encryption.crypt(TEXT);
        LOG.info(cryptedText);
        LOG.info("length: {}", cryptedText.length());
        String decryptedText = encryption.decrypt(cryptedText);
        LOG.info(decryptedText);
    }

    @Test
    public void generateCryptedPass() throws Exception {
        //String pass = "12345678901234567890123456789012345678901234567890";
        //String pass = "lM#Q!vn:Co=)`e=&%pS9!3@4>lx,<~65";
        String pass = "test";
        Encryption encryption = new Encryption(new BlowfishAlgorithm());

        String cryptedPass = encryption.crypt(pass);

        System.out.println(cryptedPass);
        System.out.println("length: " + cryptedPass.length());

        LOG.info(cryptedPass);
        LOG.info("length: {}", cryptedPass.length());
    }

    @Test
    public void showPass() throws Exception {
        String adminPass = "e27ec4b55a7da53d6407de4078e36c6c010084a0f0bc116ce97e2e7c512071a1dfb5e9880864bca5";
        String rootPass = "3e66081bb8df6e5a";
        String testPass = "3e66081bb8df6e5a";
        Encryption encryption = new Encryption(new BlowfishAlgorithm());

        try {
            System.out.println(encryption.decrypt(adminPass));
            System.out.println(encryption.decrypt(rootPass));
            System.out.println(encryption.decrypt(testPass));

            LOG.info(encryption.decrypt(adminPass));
            LOG.info(encryption.decrypt(rootPass));
            LOG.info(encryption.decrypt(testPass));
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

}

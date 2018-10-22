package utils.crypt;

/**
 * Created by tserj on 08.09.2015.
 */
public interface Algorithm {
    String crypt(String text) throws Exception;
    String decrypt(String text) throws Exception;
}

package utils;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.crypt.impl.BlowfishAlgorithm;
import utils.crypt.impl.Encryption;

/**
 * Created by tserj on 11.09.2015.
 */
public class DBHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DBHelper.class);

    public static User getUser(String id) {
        User result = null;
        try {
            result = (User) DBManager.getEntityById(User.class, "User", id);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    public static User getUser(String login, String pass) {
        User result = null;
        try {
            Encryption encryption = new Encryption(new BlowfishAlgorithm());
            String cryptedPass = encryption.crypt(pass);

            result = (User) DBManager.getEntity(User.class, "User", "login='".concat(login).concat("' and password='")
                    .concat(cryptedPass).concat("'"));
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

}

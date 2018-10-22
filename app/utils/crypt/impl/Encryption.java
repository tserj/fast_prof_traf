package utils.crypt.impl;


import utils.crypt.Algorithm;

/**
 * Created by tserj on 08.09.2015.
 */
public class Encryption {
    private Algorithm algorithm;

    public Encryption(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String crypt(String text) throws Exception {
        return algorithm.crypt(text);
    }

    public String decrypt(String text) throws Exception {
        return algorithm.decrypt(text);
    }
}

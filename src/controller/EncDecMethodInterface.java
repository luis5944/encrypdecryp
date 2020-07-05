package controller;

/**
 *
 * @author Luis
 */
public interface EncDecMethodInterface {

    String encrypt(char[] chars, int shift, String alg);

    String decrypt(char[] chars, int shift, String alg);

}

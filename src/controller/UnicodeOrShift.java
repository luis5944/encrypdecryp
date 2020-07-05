/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Luis
 */
public class UnicodeOrShift implements EncDecMethodInterface {

    @Override
    public String encrypt(char[] chars, int shift, String alg) {
        String text = "";
        if (alg.equals("unicode")) {
            for (char item : chars) {
                char shiftItem = (char) (item + shift);
                text += shiftItem;
            }
        } else {
            StringBuilder result = new StringBuilder();
            for (char character : chars) {
                if (character != ' ') {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }
            }
            text = result.toString();
        }
        return text;
    }

    @Override
    public String decrypt(char[] chars, int shift, String alg) {
        String text = "";
        if (alg.equals("unicode")) {
            for (char item : chars) {
                char shiftItem = (char) (item - shift);
                text += shiftItem;
            }
        } else {
            return encrypt(chars, 26 - (shift % 26), "shift");
        }
        return text;
    }
}

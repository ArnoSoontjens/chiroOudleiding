/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.chiro.chiro_namen_en_adressen.exceptions;

/**
 *
 * @author Arno
 */
public class IncompletePersonException extends Exception{

    public IncompletePersonException() {
    }

    public IncompletePersonException(String message) {
        super(message);
    }
    
}

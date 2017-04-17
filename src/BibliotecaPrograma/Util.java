/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaPrograma;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class Util {

    static long pedeLong(String mensagem) {
        long valorDigitado = 0;
        try {
            System.out.println(mensagem);
            valorDigitado = new Scanner(System.in).nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Não deu.");
            valorDigitado = pedeLong(mensagem);
        }
        return valorDigitado;
    }
    
    static long pedeISBN() {
        long isbn;
        do {
            isbn = pedeLong("Digite o ISBN do livro:");
        } while (isbn < 0);
        return isbn;
    }

}

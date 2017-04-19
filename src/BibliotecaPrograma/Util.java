/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class Util {

    static ArrayList<Livro> listaLivro = new ArrayList();

    public static ArrayList<Livro> getListaLivro() {
        return listaLivro;
    }

    public static long pedeLong(String mensagem) {
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

    public static int pedeInt(int min, int max, String msg) {
        int aux = 0;
        do {
            System.out.println(msg);
            aux = new Scanner(System.in).nextInt();
        } while (aux < min || aux > max);

        return aux;
    }

    public static long pedeISBN() {
        long isbn;
        do {
            isbn = pedeLong("Digite o ISBN do livro:");
        } while (isbn < 0);
        return isbn;
    }

    public static int verificaCod(ArrayList<Exemplar> listaExemplar) {
        int cod = 0;
        boolean aux;
        do {
            aux = false;
            cod = randomiza();
            for (Exemplar exemplar : listaExemplar) {
                if (cod == exemplar.cod) {
                    aux = true;
                }
            }
        } while (aux);
        return cod;

    }

    public static int randomiza() {
        Random random = new Random();
        int i = random.nextInt(99999999);
        do {
            i = random.nextInt(99999999);
        } while (i < 10000000);

        return i;
    }

    public static boolean isbnCadastrado(long isbn) {
        for (Livro livro : listaLivro) {
            if (livro.isbn == isbn) {
                return true;
            }
        }
        return false;
    }

    public static long pedeISBNNaoCadastrado() {
        long aux;
        do {
            aux = pedeISBN();
        } while (isbnCadastrado(aux));
        return aux;
    }

    public static long pedeISBNCadastrado() {
        long aux;
        do {
            aux = pedeISBN();
        } while (!isbnCadastrado(aux));
        return aux;
    }

}

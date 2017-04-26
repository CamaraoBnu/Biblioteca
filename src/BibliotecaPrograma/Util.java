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
  
    public static void mostraLivro(){
        Exemplar exemplar = new Exemplar();
        long isbn = pedeISBNCadastrado();
        boolean temExemplar = false;
        for(Livro livro : listaLivro){
            if(livro.isbn == isbn){
                System.out.println("");
                System.out.println(livro.titulo);
                System.out.println("Autor: " + livro.autor);
                System.out.println("Editora: " + livro.editora);
                System.out.println("Ano de publicação: "+ livro.ano);
                System.out.println("Exemplares: ");
                for(Exemplar expl : exemplar.listaExemplar){
                    if(expl.isbn == isbn){
                        System.out.println("-" + expl.cod);
                        temExemplar = true;
                    }
                }
                if(!temExemplar){
                    System.out.println("Este livro não possui exemplares!");
                }
                break;
            }
        }
    }
    
    public static void mostraListaLivros(){
        int cont = 0;
        for(Livro livro : listaLivro){
            cont++;
            System.out.println(cont + "- " + livro.titulo);
        }
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

    public static String pedeCpf() {
        Scanner leia = new Scanner(System.in);
        String cpf;
        char aux1;
        char aux2;
        char traco1;
        boolean erro = false;
        char chara;
        boolean auxboo = false;
        do {
            auxboo = false;
            do {
                System.out.println("Informe o CPF da respectiva pessoa:");
                cpf = leia.nextLine();
                cpf.trim();
            } while (cpf.isEmpty() || (cpf.length() != 14));
            aux1 = cpf.charAt(3);
            aux2 = cpf.charAt(7);
            traco1 = cpf.charAt(11);
            for (int i = 0; i < cpf.length() - 1; i++) {
                chara = cpf.charAt(i);
                if (i == 3 || i == 7 || i == 11) {
                    continue;
                }
                if (chara < 48 || chara > 57) {
                    auxboo = true;
                    System.out.println("apenas numeros");
                    break;
                }
            }
            if (aux1 == ('.') && (aux2 == ('.')) && (traco1 == ('-'))) {
                erro = true;
            } else {
                erro = false;
            }
        } while ((!erro) || (auxboo));
    return cpf;
    }
}

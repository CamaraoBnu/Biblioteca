package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Livro {

    static Livro livro = new Livro();
    static long isbn = 0;
    static String titulo = "";
    static String editora = "";
    static String autor = "";
    static int ano = 0;

    static ArrayList<Livro> listaLivro = new ArrayList();

    public void cadastraLivro() {
        //editora, titulo, ano, autor, código
        Scanner leia = new Scanner(System.in);

        do {
            System.out.println("Informe o ISBN do livro a ser cadastrado: ");
            livro.isbn = leia.nextLong();
        } while ((livro.isbn == 0) || (listaLivro.contains(livro.isbn)));

        do {
           leia = new Scanner(System.in);
            System.out.println("Informe o titulo do livro: ");
            livro.titulo = leia.nextLine().trim();
        } while (livro.titulo.equals(""));

        do {
            System.out.println("Informe o nome do autor do livro:");
            livro.autor = leia.nextLine().trim();
        } while (livro.autor.equals(""));

        do {
            System.out.println("Informe a editora do livro:");
            livro.editora = leia.nextLine().trim();
        } while (livro.editora.equals(""));

        Calendar hoje = Calendar.getInstance();

        do {
            System.out.println("Informe o ano de publicação do livro: ");
            livro.ano = leia.nextInt();

        } while (livro.ano > hoje.get(Calendar.YEAR) || livro.ano < 1);

        listaLivro.add(livro);
        System.out.println("LIVRO CADASTRADO COM SUCESSO");
    }

    public static boolean verificaEspera() {
        boolean x = false;
        return x;
    }
}

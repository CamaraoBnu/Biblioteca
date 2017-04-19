package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Livro {

    long isbn = 0;
    String titulo = "";
    String editora = "";
    String autor = "";
    int ano = 0;

    public void cadastraLivro() {
        //editora, titulo, ano, autor, código
        Scanner leia = new Scanner(System.in);
        
        this.isbn = Util.pedeISBNNaoCadastrado();
        
        do {
            leia = new Scanner(System.in);
            System.out.println("Informe o titulo do livro: ");
            this.titulo = leia.nextLine().trim();
        } while (this.titulo.equals(""));

        do {
            System.out.println("Informe o nome do autor do livro:");
            this.autor = leia.nextLine().trim();
        } while (this.autor.equals(""));

        do {
            System.out.println("Informe a editora do livro:");
            this.editora = leia.nextLine().trim();
        } while (this.editora.equals(""));

        Calendar hoje = Calendar.getInstance();

        do {
            System.out.println("Informe o ano de publicação do livro: ");
            this.ano = leia.nextInt();

        } while (this.ano > hoje.get(Calendar.YEAR) || this.ano < 1);

        Util.listaLivro.add(this);
        System.out.println("LIVRO CADASTRADO COM SUCESSO");
    }

    public static boolean verificaEspera() {
        boolean x = false;
        return x;
    }
}

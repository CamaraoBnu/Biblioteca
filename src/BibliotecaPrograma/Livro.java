package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Livro {

    private long isbn = 0;
    private String titulo = "";
    private String editora = "";
    private String autor = "";
    private int ano = 0;
    private ArrayList<Exemplar> listaExemplar = new ArrayList();

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<Exemplar> getListaExemplar() {
        return listaExemplar;
    }

    public void setListaExemplar(ArrayList<Exemplar> listaExemplar) {
        this.listaExemplar = listaExemplar;
    }

    public Livro(long isbn) {
        this.isbn = isbn;
    }
    
    public void cadastraLivro() {

        Scanner leia = new Scanner(System.in);

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

    public void cadastraExemplar() {
        int numExemplares = Util.pedeInt(1, 10000, "Informe o número de exemplares a serem cadastrados(max = 10000):");
        do {
            Exemplar e = new Exemplar(this);
            e.setCod(Util.verificaCod(listaExemplar));
            e.setDisponivel(true);
            listaExemplar.add(e);
            numExemplares--;
        } while (numExemplares != 0);
         System.out.println("OS EXEMPLARES FORAM CADASTRADOS COM SUCESSO");
    }

}

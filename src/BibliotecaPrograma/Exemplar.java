package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Scanner;

public class Exemplar extends Livro {

    ArrayList<Exemplar> listaExemplar = new ArrayList();
    long isbn = 0;
    int cod = 0;
    boolean disponivel = true;

    public void cadastraExemplar() {
        if (!Util.listaLivro.isEmpty()) {
            isbn = Util.pedeISBNCadastrado();
            int numExemplares = Util.pedeInt(1, 10000, "Informe o número de exemplares a serem cadastrados(max = 10000):");
            do {
                do {
                    cod = Util.verificaCod(listaExemplar);
                } while (listaExemplar.contains(cod));
                disponivel = true;
                listaExemplar.add(this);
                numExemplares--;
            } while (numExemplares != 0);
            System.out.println("OS LIVROS FORAM CADASTRADOS COM SUCESSO");
        } else {
            int resp = Util.pedeInt(1, 2, "Não há nenhum livro cadastrado, se deseja cadastrar um livro digite 1, se não digite 2");
            if (resp == 1) {
                cadastraLivro();
            }
        }
    }
}

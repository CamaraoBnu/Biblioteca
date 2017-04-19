package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Scanner;

public class Exemplar extends Livro {

    ArrayList<Exemplar> listaExemplar = new ArrayList();
    long isbn = 0;
    int cod = 0;

    public void cadastraExemplar() {
        isbn = Util.pedeISBNCadastrado();
        int numExemplares = Util.pedeInt(1, 10000, "Informe o número de exemplares a serem cadastrados(max = 10000):");
        do {
            do {
                cod = Util.verificaCod(listaExemplar);
            } while (listaExemplar.contains(cod));
            listaExemplar.add(this);
            numExemplares--;
        } while (numExemplares != 0);

    }
}

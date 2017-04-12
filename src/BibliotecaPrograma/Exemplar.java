package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Scanner;

public class Exemplar extends Livro {

    static ArrayList<Exemplar> listaExemplar = new ArrayList();
    static Exemplar exemplar = new Exemplar();

    public void cadastraExemplar() {
        Scanner leia = new Scanner(System.in);
        long cod = 0;
        long aux = 0;
        do {
            System.out.println("informe o ISBN do livro a ser cadastrado:");
            aux = leia.nextLong();
        } while (!listaLivro.contains(aux));

        do {
            System.out.println("informe o codigo do exemplar a ser cadastrado:");
            cod = leia.nextLong();
        } while (listaExemplar.contains(cod));

    }
}

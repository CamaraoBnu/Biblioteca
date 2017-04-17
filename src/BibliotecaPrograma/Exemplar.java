package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Scanner;

public class Exemplar extends Livro {

     ArrayList<Exemplar> listaExemplar = new ArrayList();
   Exemplar exemplar = new Exemplar();

public void cadastraExemplar() {

        Scanner leia = new Scanner(System.in);
        long cod = 0;
        long aux = 0;
        do {           
            aux = Util.pedeISBN();
        } while (livroCadastrado(listaLivro, this.isbn));

        do {
            System.out.println("informe o codigo do exemplar a ser cadastrado:");
            cod = leia.nextLong();
        } while (listaExemplar.contains(cod));

    }
}

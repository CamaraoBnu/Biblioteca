package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

public class Usuario {

    static Usuario usuario = new Usuario();
    static String nomeUsuario;
    static int numCadastro;
    static String cpfUsuario;
    static String email;
    static int phone;

    static ArrayList<String> listaUsuario = new ArrayList();

    public static int randomiza() {
        Random random = new Random();
        int i = random.nextInt(99999999);
        do {
            i = random.nextInt(99999999);
        } while (i < 10000000);

        return i;
    }

    public static void cadastraUsuario() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe o nome da pessoa a ser cadastrada:");
        usuario.nomeUsuario = leia.nextLine();
        MaskFormatter formato = new MaskFormatter();
        //do{
            System.out.println("Informe o CPF da respectiva pessoa:");
       // }while();
        usuario.numCadastro = randomiza();
        System.out.println(numCadastro);
    }

}

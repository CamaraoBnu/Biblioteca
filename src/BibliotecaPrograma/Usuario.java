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
        String aux;
        char aux1;
        char aux2;
        char traco1;
        boolean erro = false;
        do {
            do {
                System.out.println("Informe o CPF da respectiva pessoa:");
                aux = leia.nextLine();
                aux.trim();
            } while (aux.isEmpty() || (aux.length() != 14));
            aux1 = aux.charAt(3);
            aux2 = aux.charAt(7);
            traco1 = aux.charAt(11);

            if (aux1 == ('.') && (aux2 == ('.')) && (traco1 == ('-'))) {
                erro = true;
            } else {
                erro = false;
            }

        } while (!erro);
        String phone;

        do {
            System.out.println("Informe o seu numero de seu celular(ex:(DDD)91234-5678)");
            phone = leia.nextLine();
            if(phone.length()== 15){
             aux1 = phone.charAt(0);
            aux2 = phone.charAt(4);
            traco1 = phone.charAt(10);   
            erro = false;
            }else{erro = true;}
            
        } while (!((aux1 == '(') && (aux2 == (')')) && (traco1 == ('-')))|| erro);

        System.out.println(aux);

        usuario.numCadastro = randomiza();
        System.out.println(numCadastro);
    }

}

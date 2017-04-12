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
    static String phone;

    static ArrayList<Usuario> listaUsuario = new ArrayList();

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
        String phone;

        do {
            do {
                auxboo = false;
                System.out.println("Informe o seu numero de seu celular(ex:(DDD)91234-5678)");
                phone = leia.nextLine();
                if (phone.length() == 15) {
                    aux1 = phone.charAt(0);
                    aux2 = phone.charAt(4);
                    traco1 = phone.charAt(10);
                    erro = false;
                } else {
                    erro = true;
                }

            } while (!((aux1 == '(') && (aux2 == (')')) && (traco1 == ('-'))) || erro);

            for (int i = 0; i < phone.length() - 1; i++) {
                chara = phone.charAt(i);
                if (i == 0 || i == 4 || i == 10) {
                    continue;
                }
                if (chara < 48 || chara > 57) {
                    auxboo = true;
                    System.out.println("apenas numeros");
                    break;
                }
            }
        } while (auxboo);

        do {
            System.out.println("digite o email");
            usuario.email = leia.nextLine();
        } while (usuario.email.equals("") || !usuario.email.contains("@"));

        usuario.cpfUsuario = cpf;
        usuario.phone = phone;
        usuario.numCadastro = randomiza();

        listaUsuario.add(usuario);
        
        System.out.print("seu número de cadastro é: ");
        System.out.println(numCadastro);
        System.out.println("USUÁRIO CADASTRADO COM SUCESSO");
    }

}

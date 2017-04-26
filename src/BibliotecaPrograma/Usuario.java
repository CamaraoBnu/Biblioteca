package BibliotecaPrograma;
 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

public class Usuario {

    String nomeUsuario;
    int numCadastro;
    String cpfUsuario;
    String email;
    String phone;
    //variável débito vai conter as "dívidas" da pessoa referente aos atrasos;
    float debito;
    int[] aluguelLivroAtual = new int[10];

    ArrayList<Usuario> listaUsuario = new ArrayList();

    public void cadastraUsuario() {
        
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe o nome da pessoa a ser cadastrada:");
        this.nomeUsuario = leia.nextLine();
         this.cpfUsuario = Util.pedeCpf();
        char aux1 = 0;
        char aux2 = 0;
        char traco1 = 0;
        boolean erro = false;
        char chara;
        boolean auxboo = false;        
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
            this.email = leia.nextLine();
        } while (this.email.equals("") || !this.email.contains("@"));

        this.debito = 0.0f;
        this.phone = phone;
        this.numCadastro = Util.randomiza();

        listaUsuario.add(this);

        System.out.print("seu número de cadastro é: ");
        System.out.println(this.numCadastro);
        System.out.println("USUÁRIO CADASTRADO COM SUCESSO");
    }

}

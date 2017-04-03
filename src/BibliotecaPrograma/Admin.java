package BibliotecaPrograma;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    public static void alugaLivro() {

    }

    public static void cadastraAdmin(String nome, String senha) {
        Scanner leia = new Scanner(System.in);
        String nomenovo = "";
        do {
            System.out.println("Informe o nome do novo admin");
            nomenovo = leia.nextLine();
        } while (listaAdmin.contains(nomenovo));
        String senhanovo = "";
        String senhanovoaux = "";
        do {
            do {
                System.out.println("Informe a senha do novo admin");
                senhanovo = leia.nextLine();
            } while (senhanovo == "");
            do {
                System.out.println("Confirme a senha do novo admin");
                senhanovoaux = leia.nextLine();
            } while (senhanovoaux == "");
        } while (!senhanovo.equals(senhanovoaux));
        do {
            System.out.println("Informe o nome do admin atual");
            nome = leia.nextLine();
            System.out.println("Informe a senha do admin atual");
            senha = leia.nextLine();
        } while (verificaSenha(nome, senha) == false);
        listaAdmin.add(nomenovo);
        senhaAdmin.add(senhanovo);
        principal();

    }

    public static boolean verificaSenha(String nome, String senha) {
        if (listaAdmin.contains(nome)) {
            if (listaAdmin.indexOf(nome) == senhaAdmin.indexOf(senha)) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<String> listaAdmin = new ArrayList();
    static ArrayList senhaAdmin = new ArrayList();

    public static void main(String[] args) {
        System.out.println("BEM VINDO");
        principal();

    }

    public static void menu() {
        Scanner leia = new Scanner(System.in);
        int resp = 0;
        System.out.println("");
        System.out.println("1-Emprestimo");
        System.out.println("2-Devolução");
        System.out.println("3-Reserva");
        System.out.println("4-Cadastrar Exemplar");
        System.out.println("5-Cadastrar Livro");
        System.out.println("6-Cadastrar Usuário");
        System.out.println("7-Cadastrar Admin");
        System.out.println("8-Sair");
        System.out.println("");
        do {
            System.out.println("Escolha a opção desejada");
            resp = leia.nextInt();
        } while (resp < 1 || resp > 8);
        switch (resp) {
            case 1:
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.fazEmprestimo();
                break;
            case 2:
                Devolucao devolucao = new Devolucao();
                devolucao.fazDevolucao();
                break;
            case 3:
                Reserva reserva = new Reserva();
                reserva.addUsuarioLista();
                break;
            case 4:
                Exemplar exemplar = new Exemplar();
                exemplar.cadastraExemplar();
                break;
            case 5:
                Livro livro = new Livro();
                livro.cadastraLivro();
                break;
            case 6:
                Usuario usuario = new Usuario();
                usuario.cadastraUsuario();
                break;
            case 7:
                cadastraAdmin(nome, senha);
                break;
            case 8:
                System.out.println("bye bye");
                System.exit(0);
                break;
        }
    }
    static String nome = "";
    static String senha = "";

    public static void principal() {
        listaAdmin.add("juca");
        senhaAdmin.add("1234");
        Scanner leia = new Scanner(System.in);
        System.out.println("Sistema de biblioteca");
        int aux = 0;
        do {
            System.out.println("Se deseja fazer login digite 1, se deseja fazer o cadastro de um novo admin digite 2");
            aux = leia.nextInt();
        } while ((aux != 1) && (aux != 2));
        String nome = "";
        String senha = "";
        if (aux == 1) {
            leia = new Scanner(System.in);

            do {
                System.out.println("Informe o nome do admin");
                nome = leia.nextLine();
                System.out.println("Informe a senha");
                senha = leia.nextLine();

            } while (verificaSenha(nome, senha) == false);

        } else {
            cadastraAdmin(nome, senha);
        }

        menu();
    }

}

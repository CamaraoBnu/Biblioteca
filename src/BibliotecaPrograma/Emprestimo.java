package BibliotecaPrograma;

import java.util.Calendar; 

public class Emprestimo {

    //salvar data de devolução
    public void fazEmprestimo() {
        Usuario usuario = new Usuario();
        String cpf = Util.pedeCpf();
        boolean existe = false;
        for (Usuario usu : usuario.listaUsuario) {
            if (usu.cpfUsuario.equals(cpf)) {
                usuario = usu;
                existe = true;
                break;
            }
        }
        if (existe) {
            if (usuario.debito >= 10) {
                System.out.println("O usuário não pode alugar o livro. Sua multa atual é de: R$" + usuario.debito);
            } else {
                int pos = -1;
                for (int i = 0; i <= 10; i++) {
                    if (usuario.aluguelLivroAtual[i] == 0) {
                        pos = i;
                        break;
                    }
                }
                if (pos == -1) {
                    System.out.println("O usuário não pode alugar o livro pois já possui 10 livros alugados.");
                } else {
                    int cod = Util.pedeInt(100000000, 99999999, "Digite o código do exemplar");
                    usuario.aluguelLivroAtual[pos] = cod;
                    if (mudaStatusLivro(cod)) {
                        System.out.println("O livro foi emprestado com sucesso!");
                        calculaDevolucao();
                    } else {
                        System.out.println("O exemplar não foi encontrado! Não foi possível concluir o empréstimo.");
                    }
                }
            }
        } else {
            System.out.println("O usuário não existe no cadastro! Não foi possível concluir o empréstimo.");
        }

    }

    public static void calculaDevolucao() {
        Calendar hoje = Calendar.getInstance();
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int mes = hoje.get(Calendar.MONTH);
        int ano = hoje.get(Calendar.YEAR);
        int qntDiasMes = 0;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            qntDiasMes = 31;
        } else {
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                qntDiasMes = 30;
            } else {

                if (mes == 2 && ((ano - 2016) % 4) == 0) {
                    qntDiasMes = 29;
                } else {
                    qntDiasMes = 28;
                }
            }
        }
        dia = dia + 15;
        if (dia > qntDiasMes) {
            dia = dia - qntDiasMes;
            if (mes == 12) {
                mes = 0;
                ano++;
            }
            mes++;
        }
        System.out.println("A data de devolução é " + dia + "/" + mes + "/" + ano);
    }

    public static boolean verificaData() {
        boolean x = false;
        return x;
    }

    public static boolean verificaCadastro() {
        boolean x = false;
        return x;
    }

    public static boolean VerificaDebito() {
        boolean x = false;

        return x;
    }

    public static boolean mudaStatusLivro(int codigo) {
        boolean mudado = false;
        Exemplar exemplar = new Exemplar();
        for (Exemplar expl : exemplar.listaExemplar) {
            if (expl.cod == codigo) {
                exemplar.listaExemplar.remove(expl);
                expl.disponivel = false;
                exemplar.listaExemplar.add(expl);
                mudado = true;
                break;
            }
        }
        return mudado;
    }

}

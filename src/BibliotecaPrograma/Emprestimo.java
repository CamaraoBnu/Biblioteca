package BibliotecaPrograma;

import java.util.Calendar; 

public class Emprestimo {

    //salvar data de devolução
    public void fazEmprestimo() {
        Usuario usuario = new Usuario();
        //o cpf do usuario que está prestes a fazer um emprestimo é pedido:
        String cpf = Util.pedeCpf();
        //a boolean existe é responsável por verificar se o usuário exite na lista de usuários
        boolean existe = false;
        for (Usuario usu : usuario.listaUsuario) {
            if (usu.cpfUsuario.equals(cpf)) {
                usuario = usu;
                existe = true;
                break;
            }
        }
        //o if a seguir garante que somente usuários cadastrados possam fazer um emprestimo
        if (existe) {
            //o usuário não pode fazer um emprestimo se sua multa é maior ou igual a dez
            //ainda precisa ser feita uma opção para mudar o valor da mensalidade a pagra qnd o usuario tiver pago
            if (usuario.debito >= 10) {
                System.out.println("O usuário não pode alugar o livro. Sua multa atual é de: R$" + usuario.debito);
            //se não houver multa:...
            } else {
                //variável receberá a posição livre do array
                int pos = -1;
                //verifica a posição livre no array para colocar o livro a ser emprestado:
                for (int i = 0; i <= 10; i++) {
                    if (usuario.aluguelLivroAtual[i] == 0) {
                        pos = i;
                        break;
                    }
                }
                //se a posição continuar com -1 significa que não foi achado lugar livre no array e o usuário já tem 10 livros emprestados
                if (pos == -1) {
                    System.out.println("O usuário não pode alugar o livro pois já possui 10 livros alugados.");
                } else {
                    //então, o usuário poderá fazer o emprestimo
                    //pede codigo do exemplar a ser emprestado
                    int cod = Util.pedeInt(100000000, 99999999, "Digite o código do exemplar");
                    //mudaStatusLivro retorna true quando consegue encontrar o exemplar e mudou o status
                    if (mudaStatusLivro(cod)) {
                        System.out.println("O livro foi emprestado com sucesso!"); 
                        //codigo do exemplar é posto no array de livros alugados, na posição livre
                        usuario.aluguelLivroAtual[pos] = cod;
                        //então é calculada a data para a devolução do livro que ocorrerá em 15 dias;
                        //ainda não foi criado outro array para armazenar a data de devolução
                        calculaDevolucao();
                    } else {
                        //se o exemplar não foi encontrado, uma mensagem é transmitida e o emprétimo não é concluido
                        System.out.println("O exemplar não foi encontrado! Não foi possível concluir o empréstimo.");
                    }
                }
            }
        //se o usuário não está cadastrado uma mensagem é transmitida e o vcadastro não é concluido
        } else {
            System.out.println("O usuário não existe no cadastro! Não foi possível concluir o empréstimo.");
        }

    }

    public static void calculaDevolucao() {
        //método que calcula a data de devolução para o livro em um  prazo de 15 dias;
        Calendar hoje = Calendar.getInstance();
        //é armazenado o dia, mes e ano em que o emprestimo está sendo realizado, pegando tais informações do sistema
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int mes = hoje.get(Calendar.MONTH);
        int ano = hoje.get(Calendar.YEAR);
        int qntDiasMes = 0;
        //a qntDiasMes armazenará a qnt de dias do respectivo que entrará no calculo da data de devolução
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            //qnd o mes possui 31 dias
            qntDiasMes = 31;
        } else {
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                //qnd o mes possui 30 dias
                qntDiasMes = 30;
            } else {

                if (mes == 2 && ((ano - 2016) % 4) == 0) {
                    // se é mês de fevereiro e ano bissexto a qnt de dias será 29
                    qntDiasMes = 29;
                } else {
                    //senão, se for fevereiro, mas não ano bissexto, a qnt de dias será 28
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
        Livro livro = new Livro(0);
        for (Exemplar expl : livro.getListaExemplar()) {
            if (expl.getCod() == codigo) {
                livro.getListaExemplar().remove(expl);
                expl.setDisponivel(false);
                livro.getListaExemplar().add(expl);
                mudado = true;
            }
        }
        return mudado;
    }

}

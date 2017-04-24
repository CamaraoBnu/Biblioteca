package BibliotecaPrograma;

import java.util.Calendar;

public class Emprestimo {

    public void fazEmprestimo() {
        Usuario usuario = new Usuario();
        usuario.aluguelLivroAtual[1]=3;
        String cpf = Util.pedeCpf();
        
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
        dia = dia+15;
        if(dia> qntDiasMes){
            dia = dia-qntDiasMes;
            if(mes==12){
                mes=0;
                ano++;
            }
            mes++;
        }
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

    public static boolean MudaStatusLivro() {
        boolean x = false;
        return x;
    }

}

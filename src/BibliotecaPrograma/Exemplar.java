package BibliotecaPrograma;

public class Exemplar {
    
    private Livro livro;
    private int cod = 0;
    private boolean disponivel = true;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public Exemplar(Livro livro) {
        this.livro = livro;
    }
}
public class Livro extends Obra {
    private int edicao;
    private int numeroDeFolhas;
    private boolean emprestimo;

    public Livro(String titulo, String autores, String area, String editora, int ano, int edicao, int numeroDeFolhas) {
        super(titulo, autores, area, editora, ano);
        this.edicao = edicao;
        this.numeroDeFolhas = numeroDeFolhas;
        this.emprestimo = false;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumeroDeFolhas() {
        return numeroDeFolhas;
    }

    public void setNumeroDeFolhas(int numeroDeFolhas) {
        this.numeroDeFolhas = numeroDeFolhas;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void abrirLivro() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fecharLivro() {
        System.out.println("O livro está fechado para leitura.");
    }
}

public class Estudante extends Usuario {
    private String curso;
    private int emprestimosAtuais;

    public Estudante(String nome, int idade, String sexo, String telefone, String curso) {
        super(nome, idade, sexo, telefone);
        this.curso = curso;
        this.emprestimosAtuais = 0;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public void incrementarEmprestimos() {
        this.emprestimosAtuais++;
    }

    public void decrementarEmprestimos() {
        this.emprestimosAtuais--;
    }
}

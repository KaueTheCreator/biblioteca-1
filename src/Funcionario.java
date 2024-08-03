public class Funcionario extends Usuario {
    private String matricula;

    public Funcionario(String nome, int idade, String sexo, String telefone, String matricula) {
        super(nome, idade, sexo, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

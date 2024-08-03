public class Fotografia extends Obra {
    public Fotografia(String titulo, String autores, String area, String editora, int ano) {
        super(titulo, autores, area, editora, ano);
    }

    public void visualizar() {
        System.out.println("Visualizando fotografia.");
    }
}

public class MidiaAudio extends Obra {
    public MidiaAudio(String titulo, String autores, String area, String editora, int ano) {
        super(titulo, autores, area, editora, ano);
    }

    public void ouvir() {
        System.out.println("Ouvindo mídia de áudio.");
    }
}

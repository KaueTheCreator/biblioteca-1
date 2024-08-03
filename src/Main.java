import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("\n1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Listar todos os empréstimos");
            System.out.println("0. Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner);
                    break;
                case 2:
                    cadastrarUsuario(scanner);
                    break;
                case 3:
                    realizarEmprestimo(scanner);
                    break;
                case 4:
                    realizarDevolucao(scanner);
                    break;
                case 5:
                    listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarLivro(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autores: ");
        String autores = scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();
        System.out.print("Número de folhas: ");
        int numeroDeFolhas = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        Livro livro = new Livro(titulo, autores, area, editora, ano, edicao, numeroDeFolhas);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Usuario usuario = new Usuario(nome, idade, sexo, telefone);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private static void realizarEmprestimo(Scanner scanner) {
        System.out.print("Índice do livro: ");
        int indiceLivro = scanner.nextInt();
        System.out.print("Índice do usuário: ");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha
    
        if (indiceLivro < 0 || indiceLivro >= livros.size() || indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Índice inválido.");
            return;
        }
    
        Livro livro = livros.get(indiceLivro);
        Usuario usuario = usuarios.get(indiceUsuario);
    
        if (usuario instanceof Estudante) {
            Estudante estudante = (Estudante) usuario;
            if (estudante.getEmprestimosAtuais() >= 3) {
                System.out.println("Estudante já possui o número máximo de empréstimos.");
                return;
            }
            estudante.incrementarEmprestimos();
        }
    
        Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalTime.now(), livro, usuario);
        emprestimos.add(emprestimo);
        livro.setEmprestimo(true);
        System.out.println("Empréstimo realizado com sucesso.");
    }
    

    private static void realizarDevolucao(Scanner scanner) {
        System.out.print("Índice do empréstimo: ");
        int indiceEmprestimo = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        if (indiceEmprestimo < 0 || indiceEmprestimo >= emprestimos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Emprestimo emprestimo = emprestimos.get(indiceEmprestimo);
        emprestimo.devolverLivro();
        emprestimos.remove(indiceEmprestimo);
        System.out.println("Devolução realizada com sucesso.");
    }

    private static void listarEmprestimos() {
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emprestimo = emprestimos.get(i);
            System.out.println("Empréstimo " + (i + 1) + ":");
            System.out.println("  Livro: " + emprestimo.getLivro().getTitulo());
            System.out.println("  Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("  Data: " + emprestimo.getDataEmprestimo());
            System.out.println("  Hora: " + emprestimo.getHoraEmprestimo());
        }
    }
}

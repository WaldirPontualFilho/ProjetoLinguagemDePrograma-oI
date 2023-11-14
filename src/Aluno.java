import java.util.ArrayList;
import java.util.List;
class Aluno extends Pessoa {
    private int matricula;
    private List<Double> notas;
    private RegistroFaltas registroFaltas;

    public Aluno(String nome, int matricula) {
        super(nome);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
        this.registroFaltas = new RegistroFaltas();
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }

        return soma / notas.size();
    }

    public void registrarFalta() {
        registroFaltas.registrarFalta();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluno: " + nome + ", Matrícula: " + matricula + ", Média: " + calcularMedia());
    }
}

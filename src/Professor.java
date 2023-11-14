import java.util.ArrayList;
import java.util.List;
class Professor extends Pessoa {
    private String disciplina;
    private double valorHoraAula;
    private List<Avaliacao> avaliacoes;

    public Professor(String nome, String disciplina, double valorHoraAula) {
        super(nome);
        this.disciplina = disciplina;
        this.valorHoraAula = valorHoraAula;
        this.avaliacoes = new ArrayList<>();
    }

    public double calcularSalario(int horasAula) {
        return horasAula * valorHoraAula;
    }

    public void receberAvaliacao(Aluno aluno, int nota) {
        Avaliacao avaliacao = new Avaliacao(aluno, this, nota);
        avaliacoes.add(avaliacao);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Professor: " + nome + ", Disciplina: " + disciplina + ", Valor Hora-Aula: " + valorHoraAula);
    }
}
import java.util.ArrayList;
import java.util.List;
class CursoGraduacao extends Curso {
    private Professor professorResponsavel;
    private List<Aluno> alunosMatriculados;

    public CursoGraduacao(String nome, Professor professorResponsavel) {
        super(nome);
        this.professorResponsavel = professorResponsavel;
        this.alunosMatriculados = new ArrayList<>();
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }
    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public double calcularMediaGeral() {
        if (alunosMatriculados.isEmpty()) {
            return 0.0; // Retorna 0 se não houver alunos matriculados
        }

        double somaMedias = 0;
        for (Aluno aluno : alunosMatriculados) {
            somaMedias += aluno.calcularMedia();
        }

        return somaMedias / alunosMatriculados.size();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Curso de Graduação: " + nome);
        System.out.println("Professor Responsável: " + professorResponsavel.nome);
        System.out.println("Alunos Matriculados:");
        for (Aluno aluno : alunosMatriculados) {
            aluno.exibirDetalhes();
        }
        System.out.println("Média Geral do Curso: " + calcularMediaGeral());
    }
}
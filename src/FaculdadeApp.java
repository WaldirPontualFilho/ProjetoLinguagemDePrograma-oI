import java.util.Scanner;

public class FaculdadeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Professor professor = null;
        Aluno aluno = null;
        CursoGraduacao curso = null;

        while (true) {
            System.out.println("O que deseja realizar?");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Matricular Aluno no Curso de Graduação");
            System.out.println("4. Adicionar Nota ao Aluno");
            System.out.println("5. Registrar Falta do Aluno");
            System.out.println("6. Receber Avaliação do Aluno pelo Professor");
            System.out.println("7. Exibir Detalhes do Curso");
            System.out.println("8. Calcular Salário do Professor");
            System.out.println("9. Calcular Média do Aluno");
            System.out.println("10. Exibir Alunos Matriculados");
            System.out.println("11. Exibir Professores");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    // Cadastrar Professor
                    System.out.println("Informe o nome do professor:");
                    String nomeProfessor = scanner.nextLine();

                    System.out.println("Informe a disciplina:");
                    String disciplina = scanner.nextLine();

                    System.out.println("Informe o valor da hora-aula:");
                    double valorHoraAula = scanner.nextDouble();

                    professor = new Professor(nomeProfessor, disciplina, valorHoraAula);
                    professor.exibirDetalhes();
                    break;

                case 2:
                    // Cadastrar Aluno
                    System.out.println("Informe o nome do aluno:");
                    String nomeAluno = scanner.nextLine();

                    System.out.println("Informe a matrícula:");
                    int matricula = scanner.nextInt();

                    aluno = new Aluno(nomeAluno, matricula);
                    aluno.exibirDetalhes();
                    break;

                case 3:
                    // Matricular Aluno no Curso de Graduação
                    if (professor != null && aluno != null) {
                        if (curso == null) {
                            System.out.println("Informe o nome do curso de graduação:");
                            String nomeCurso = scanner.nextLine();
                            curso = new CursoGraduacao(nomeCurso, professor);
                        }

                        curso.matricularAluno(aluno);
                        System.out.println("Aluno matriculado no curso com sucesso!");
                    } else {
                        System.out.println("Cadastrar um professor e um aluno antes de matricular no curso.");
                    }
                    break;

                case 4:
                    // Adicionar Nota ao Aluno
                    if (aluno != null) {
                        System.out.println("Informe a nota do aluno:");
                        double nota = scanner.nextDouble();
                        aluno.adicionarNota(nota);
                        System.out.println("Nota adicionada com sucesso!");
                    } else {
                        System.out.println("Cadastrar um aluno antes de adicionar nota.");
                    }
                    break;

                case 5:
                    // Registrar Falta do Aluno
                    if (aluno != null) {
                        aluno.registrarFalta();
                        System.out.println("Falta registrada com sucesso!");
                    } else {
                        System.out.println("Cadastrar um aluno antes de registrar falta.");
                    }
                    break;

                case 6:
                    // Receber Avaliação do Aluno pelo Professor
                    if (professor != null && aluno != null) {
                        System.out.println("Informe a nota da avaliação:");
                        int notaAvaliacao = scanner.nextInt();
                        professor.receberAvaliacao(aluno, notaAvaliacao);
                        System.out.println("Avaliação recebida com sucesso!");
                    } else {
                        System.out.println("Cadastrar um professor e um aluno antes de receber avaliação.");
                    }
                    break;

                case 7:
                    // Exibir Detalhes do Curso
                    if (curso != null) {
                        curso.exibirDetalhes();
                    } else {
                        System.out.println("Matricular pelo menos um aluno no curso antes de exibir detalhes.");
                    }
                    break;

                case 8:
                    // Calcular Salário do Professor
                    if (professor != null) {
                        System.out.println("Informe o número de horas aula ministradas:");
                        int horasAula = scanner.nextInt();
                        double salario = professor.calcularSalario(horasAula);
                        System.out.println("O salário do professor é: " + salario);
                    } else {
                        System.out.println("Cadastrar um professor antes de calcular salário.");
                    }
                    break;

                case 9:
                    // Calcular Média do Aluno
                    if (aluno != null) {
                        double media = aluno.calcularMedia();
                        System.out.println("A média do aluno é: " + media);
                    } else {
                        System.out.println("Cadastrar um aluno antes de calcular média.");
                    }
                    break;

                case 10:
                    // Exibir Alunos Matriculados
                    if (curso != null) {
                        System.out.println("Alunos Matriculados:");
                        for (Aluno alunoMatriculado : curso.getAlunosMatriculados()) {
                            alunoMatriculado.exibirDetalhes();
                        }
                    } else {
                        System.out.println("Matricular pelo menos um aluno no curso antes de exibir detalhes.");
                    }
                    break;

                case 11:
                    // Exibir Professores
                    if (professor != null) {
                        System.out.println("Professores:");
                        professor.exibirDetalhes();
                    } else {
                        System.out.println("Cadastrar pelo menos um professor antes de exibir detalhes.");
                    }
                    break;

                case 0:
                    // Sair
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }
}


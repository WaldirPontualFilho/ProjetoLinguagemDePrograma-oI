abstract class Curso implements Exibivel {
    protected String nome;

    public Curso(String nome) {
        this.nome = nome;
    }

    public abstract void exibirDetalhes();
}
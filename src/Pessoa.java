abstract class Pessoa implements Exibivel {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public abstract void exibirDetalhes();
}

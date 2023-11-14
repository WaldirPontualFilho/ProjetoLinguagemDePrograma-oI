// Classe para registrar as faltas dos alunos
class RegistroFaltas {
    private int faltas;

    public RegistroFaltas() {
        this.faltas = 0;
    }

    public void registrarFalta() {
        faltas++;
    }

    public int getFaltas() {
        return faltas;
    }
}
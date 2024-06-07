import java.util.Objects;

class Medico extends Pessoa {
    private String especialidade;

    public Medico(String nome, String genero, String telemovel, String especialidade) {
        super(nome, genero, telemovel);
        this.especialidade = especialidade;
    }

    public Medico() {}

    public Medico(Medico outroMedico) {
        super(outroMedico);
        this.especialidade = outroMedico.especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Médico - " + super.toString() + ", Especialidade: " + especialidade;
    }

    @Override
    public void print() {
        System.out.println("Médico: " + getNome());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Telemóvel: " + getTelemovel());
        System.out.println("Especialidade: " + especialidade);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Medico medico = (Medico) obj;
        return Objects.equals(especialidade, medico.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidade);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

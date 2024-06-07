import java.text.SimpleDateFormat;
import java.util.Objects;

abstract class Pessoa {
    private String nome;
    private String genero;
    private String telemovel;

    public Pessoa(String nome, String genero, String telemovel) {
        this.nome = nome;
        this.genero = genero;
        this.telemovel = telemovel;
    }

    public Pessoa() {
    }

    public Pessoa(Pessoa outraPessoa) {
        this.nome = outraPessoa.nome;
        this.genero = outraPessoa.genero;
        this.telemovel = outraPessoa.telemovel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Genero: " + genero + ", Telemovel: " + telemovel;
    }

    public void print() {
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Telemóvel: " + telemovel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(genero, pessoa.genero) && Objects.equals(telemovel, pessoa.telemovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, telemovel);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

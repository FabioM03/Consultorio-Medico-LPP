import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Paciente extends Pessoa {
    private String morada;
    private Date dataNascimento;

    public Paciente(String nome, String genero, String telemovel, String morada, String dataNascimentoStr) throws ParseException {
        super(nome, genero, telemovel);
        this.morada = morada;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataNascimento = sdf.parse(dataNascimentoStr);
    }

    // Construtor de cópia
    public Paciente(Paciente paciente) {
        super(paciente);
        this.morada = paciente.morada;
        this.dataNascimento = (Date) paciente.dataNascimento.clone();
    }

    // Construtor sem parâmetros
    public Paciente() {
        super();
        this.morada = "";
        this.dataNascimento = new Date();
    }

    // Getters e setters

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método print para imprimir os atributos
    @Override
    public void print() {
        super.print();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Morada: " + morada);
        System.out.println("Data de Nascimento: " + sdf.format(dataNascimento));
    }

    // Método toString() para representação em string do objeto
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + ", Morada: " + morada + ", Data de Nascimento: " + sdf.format(dataNascimento);
    }

    // Método equals para comparação de objetos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Paciente paciente = (Paciente) obj;
        return Objects.equals(morada, paciente.morada) &&
                Objects.equals(dataNascimento, paciente.dataNascimento);
    }

    // Método clone para clonar objetos
    @Override
    protected Object clone() {
        return new Paciente(this);
    }
}

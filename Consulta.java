
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta implements Cloneable {
    private Paciente paciente;
    private Medico medico;
    private Date data;

    // Construtores
    public Consulta(Paciente paciente, Medico medico, Date data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }

    public Consulta() {
        this.paciente = new Paciente();
        this.medico = new Medico();
        this.data = new Date();
    }

    public Consulta(Consulta outraConsulta) {
        this.paciente = new Paciente(outraConsulta.getPaciente());
        this.medico = new Medico(outraConsulta.getMedico());
        this.data = new Date(outraConsulta.getData().getTime());
    }

    // Métodos
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Consulta{" +
                "paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                ", data=" + sdf.format(data) +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Consulta clonedConsulta = (Consulta) super.clone();
        clonedConsulta.setPaciente((Paciente) this.paciente.clone());
        clonedConsulta.setMedico((Medico) this.medico.clone());
        clonedConsulta.setData((Date) this.data.clone());
        return clonedConsulta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consulta consulta = (Consulta) o;

        if (!paciente.equals(consulta.paciente)) return false;
        if (!medico.equals(consulta.medico)) return false;
        return data.equals(consulta.data);
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

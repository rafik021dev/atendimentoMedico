public class Atendimento {

	private Paciente paciente;
	private Medico medico;
    private LocalDateTime horarioAtendimento;
    private String descricao;
    private int tempoAtendimento;

    public Atendimento(Paciente paciente, Medico medico, LocalDateTime horarioAtendimento, String descricao, int tempoAtendimento) {
        this.paciente = paciente;
        this.medico = medico;
        this.horarioAtendimento = horarioAtendimento;
        this.descricao = descricao;
        this.tempoAtendimento = tempoAtendimento;
    }

    //getters e setters

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

    public LocalDateTime getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento ;
    }

    public void setTempoAtendimento(int tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public String toString() {
        return "Atendimento:\n" +
                "Paciente: " + paciente.getNome() + "\n" +
                "Médico: " + medico.getNome() + "\n" +
                "Horário: " + horarioAtendimento + "\n" +
                "Descrição: " + descricao + "\n" +
                "Tempo: " + tempoAtendimento + " minutos\n";
    }

}

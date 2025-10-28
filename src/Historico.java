import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Historico {
	private Fila pacientesEspera;
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

	public Historico(Fila pacientesEspera) {
		this.pacientesEspera = pacientesEspera;
	}

	public void registrarAtendimento(Paciente paciente, Medico medico, String descricao, int tempoAtendimento) {
	    LocalDateTime horarioAtendimento = LocalDateTime.now();
	    paciente.setHorarioAtendimento(horarioAtendimento);
	    Atendimento atendimento = new Atendimento(paciente, medico, horarioAtendimento, descricao, tempoAtendimento);
	    atendimentos.add(atendimento);
	}

	public String mostrarHistorico() {
		StringBuilder builder = new StringBuilder();
		//builder.append(pacientesEspera.listaCompleta());
		//retirei essa parte pois talvez não seja necessário mostrar a lista de espera no histórico de atendimento

		builder.append("\nLista de Atendidos:\n");
		if (atendimentos.isEmpty()) {
			builder.append("Nenhum atendimento registrado.\n");
		} else {
			for (Atendimento atendimento : atendimentos) {
				builder.append("[ ");
				builder.append("\n" + atendimento.toString());
				builder.append(" ]\n");
			}
		}
		return builder.toString();
	}
}

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Historico {
	protected Fila pacientes_espera;
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	public Historico(Fila pacientes_espera) {
		this.pacientes_espera = pacientes_espera;
	}
	
	
	public void registrarAtendimento(Paciente paciente, Medico medico) {
	    paciente.setHorarioAtendimento(LocalDateTime.now());
	    Atendimento atendimento = new Atendimento(paciente,medico);
	    atendimentos.add(atendimento);
	}

	public String mostrarHistorico() {
		StringBuilder builder = new StringBuilder();
		builder.append(pacientes_espera.toString());
		
		builder.append("\nLista de Atendidos:\n");
		for (Atendimento atendimento : atendimentos) {
			builder.append("[ ");
			builder.append(atendimento.toString());
			builder.append(" ]\n");
		}
		
	    return builder.toString();
	}
}

import java.util.List;
import java.util.ArrayList;

public class Fila {
	private List<Paciente> fila = new ArrayList<Paciente>();
	private int[] qtd_classificacao = {0,0,0,0}; // vermelho, amarelo, verde, azul
	
	public void addPaciente(Paciente paciente) {
		int posicao = 0;
		
		for (int i = 0; i <= paciente.prioridadeCor(); i++) {
			posicao += qtd_classificacao[i];
		}
		qtd_classificacao[paciente.prioridadeCor()]++;
		fila.add(posicao,paciente);
	}
	
	public Paciente removerPaciente() {
		return fila.remove(0);
	}
	
	public String listaCompleta() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\nLista de Espera:\n");
		for (Paciente paciente : fila) {
			builder.append("[ ");
			builder.append(paciente.toString());
			builder.append(" ]\n");
		}
		
		return builder.toString();
	}
}

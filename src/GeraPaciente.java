import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeraPaciente {

	private static final String[] NOMES = {
	    "João", "Maria", "Vinicius", "Rafael", "Rômulo", "Carlos", "Lucas",
	    "Juliana", "Ricardo", "Patrícia", "Felipe", "Amanda", "Gabriel",   
	    "Eduardo", "Rodrigo", "Beatriz", "Paulo", "Larissa", "Gustavo", "Mariana"
	};
	
	private static final String[] CORES = {"vermelho", "amarelo", "verde", "azul"};
	
	private static final Random random = new Random();
	
	public static Paciente gerarPaciente() {
	    String nome = NOMES[random.nextInt(NOMES.length)];
	    int idade = random.nextInt(80) + 1;
	    String cor = CORES[random.nextInt(CORES.length)];
	
	    Paciente paciente = new Paciente(nome, idade, cor);
	    return paciente;
	}
	
	public static List<Paciente> gerarListaPacientes(int quantidade) {
	    List<Paciente> lista = new ArrayList<>();
	    for (int i = 0; i < quantidade; i++) {
	        lista.add(gerarPaciente());
	    }
	    return lista;
	}
}
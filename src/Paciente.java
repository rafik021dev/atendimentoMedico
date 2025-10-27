import java.time.LocalDateTime;

public class Paciente {
	private String nome;
	private int idade;
	private String corPrioridade;
	private LocalDateTime horarioChegada;
	private LocalDateTime horarioAtendimento;

	public Paciente(String nome, int idade, String corPrioridade) {
	    this.nome = nome;
	    this.idade = idade;
	    this.corPrioridade = corPrioridade;
	    this.horarioChegada = LocalDateTime.now();
	}

	
	public int prioridadeCor() {
	    switch (corPrioridade) {
	        case "vermelho": return 0;
	        case "amarelo": return 1;
	        case "verde": return 2;
	        case "azul": return 3;
	        default: return 3;
	    }
	}

	
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public String getCorPrioridade() {
		return corPrioridade;
	}
	public LocalDateTime getHorarioChegada() {
		return horarioChegada;
	}
	public LocalDateTime getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setCorPrioridade(String corPrioridade) {
		this.corPrioridade = corPrioridade;
	}
	public void setHorarioChegada(LocalDateTime horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
	public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente: [nome: ");
		builder.append(nome);
		builder.append("][idade: ");
		builder.append(idade);
		builder.append("][Prioridade: ");
		builder.append(corPrioridade);
		builder.append("][horarioChegada: ");
		builder.append(horarioChegada);
		builder.append("][horarioAtendimento: ");
		builder.append(horarioAtendimento);
		builder.append("]");
		return builder.toString();
	}
}

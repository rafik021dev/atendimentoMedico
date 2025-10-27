
public class Medico {
	private int id;
	private String nome;
	private int idade;

	public Medico(String nome, int idade) {
	    this.nome = nome;
	    this.idade = idade;
	}

	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}

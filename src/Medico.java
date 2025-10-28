public class Medico {
	private int crm;
	private String nome;
	private int idade;

	public Medico(int crm, String nome, int idade) {
		this.crm = crm;
	    this.nome = nome;
	    this.idade = idade;
	}

	public int getCrm() {
		return crm;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}

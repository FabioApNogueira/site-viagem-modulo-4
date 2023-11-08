package modelo;

public class Cliente {

	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	private String cpf;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String email, String telefone, String cep, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.cpf = cpf;
	}

	public Cliente(int id, String nome, String email, String telefone, String cep, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void mostrar() {
		System.out.println("==========================================================");
		System.out.println("ID: "+this.id);
		System.out.println("Nome: "+this.nome);
		System.out.println("Email: "+this.email);
		System.out.println("Telefone: "+this.telefone);
		System.out.println("Cep: "+this.cep);
		System.out.println("Cpf: "+this.cpf);
		System.out.println("==========================================================");
	}
}

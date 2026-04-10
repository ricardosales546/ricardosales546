package hemocentro;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Doador {
	// Atributos
	private String nomeCompleto;
	private LocalDate dataNascimento; 
	private Sexo sexo;
	private TipoSanguineo tipoSanguineo;
	private String cpf;
	private String numeroCelular;
	private String cep;
	private double peso; 

	public enum Sexo { 
		Masculino, Feminino
	}
	
	public enum TipoSanguineo {
		A_POSITIVO, A_NEGATIVO, B_POSITIVO, B_NEGATIVO, 
		AB_POSITIVO, AB_NEGATIVO, O_POSITIVO, O_NEGATIVO
	}

	
	public Doador(String nome, LocalDate data, Sexo s, TipoSanguineo tipo, 
			String cpf, String num, String cep, double peso) {
		this.nomeCompleto = nome;
		this.dataNascimento = data;
		this.sexo = s;
		this.tipoSanguineo = tipo;
		this.cpf = cpf;
		this.numeroCelular = num;
		this.cep = cep;
		this.peso = peso;
	}

	public Doador() { // Construtor vazio
		
	}

	// Gets e Sets
	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoSanguineo getTipoSanguineo() {
		return this.tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCelular() {
		return this.numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		if (this.dataNascimento == null) return 0;
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String dataParaExibir = (this.dataNascimento != null) 
								? this.dataNascimento.format(formatoBR) 
								: "Não informada";

		return "=== FICHA DO DOADOR ===\n" +
			   "Nome: " + this.nomeCompleto + "\n" +
			   "Idade: " + getIdade() + " anos\n" +
			   "Data de Nascimento: " + dataParaExibir + "\n" +
			   "Sexo: " + this.sexo + "\n" +
			   "Tipo Sanguíneo: " + this.tipoSanguineo + "\n" +
			   "Peso: " + this.peso + " kg\n" +
			   "CPF: " + this.cpf + "\n" +
			   "Celular: " + this.numeroCelular + "\n" +
			   "CEP: " + this.cep + "\n" +
			   "=======================";
	}
}
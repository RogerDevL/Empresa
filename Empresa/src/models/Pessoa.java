package models;

public class Pessoa {

	private String nome;
	private double salarioBruto;
	private int numeroDependentes;
	private boolean vr;
	private boolean va;
	private boolean vt;
	private String planoDeSaude;

	// Construtor da classe
	public Pessoa(String nome, double salarioBruto, int numeroDependentes, boolean vr, boolean va, boolean vt,
			String planoDeSaude) {
		super();
		// Inicializa os atributos da classe
		this.nome = nome;
		this.salarioBruto = salarioBruto;
		this.numeroDependentes = numeroDependentes;
		this.vr = vr;
		this.va = va;
		this.vt = vt;
		this.planoDeSaude = planoDeSaude;
	}

	// Métodos getters e setters para acessar e modificar os atributos da classe
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public boolean isVr() {
		return vr;
	}

	public void setVr(boolean vr) {
		this.vr = vr;
	}

	public boolean isVa() {
		return va;
	}

	public void setVa(boolean va) {
		this.va = va;
	}

	public boolean isVt() {
		return vt;
	}

	public void setVt(boolean vt) {
		this.vt = vt;
	}

	public String getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	// Método para calcular o salário líquido do funcionário
	public double calcularSalarioLiquido() {
		// Implementação do cálculo do salário líquido
		double salarioLiquido = salarioBruto;
		salarioLiquido -= calcularDescontoINSS();
		salarioLiquido -= calcularDescontoIRRF();

		if (isVr() == true) {
			salarioLiquido -= salarioBruto * 0.03;
		}
		if (isVa() == true) {
			salarioLiquido -= salarioBruto * 0.05;
		}
		if (isVt() == true) {
			salarioLiquido -= salarioBruto * 0.06;
		}

		salarioLiquido -= numeroDependentes * 50.0;

		if (planoDeSaude.equals("Basico")) {
			salarioLiquido -= 100.0;
		} else if (planoDeSaude.equals("Premium")) {
			salarioLiquido -= 250.0;
		} else if (planoDeSaude.equals("Platinum Premium Plus")) {
			salarioLiquido -= 500.0;
		}
		return salarioLiquido;
	}

	// Métodos privados auxiliares para calcular descontos
	private double calcularDescontoINSS() {
		return salarioBruto * 0.11;
	}

	private double calcularDescontoIRRF() {
		return salarioBruto * 0.15;
	}
}

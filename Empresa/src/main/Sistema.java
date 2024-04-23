package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.Pessoa;

public class Sistema {
	// Método para exibir o menu do sistema
	static public void menu() {
		System.out.println("########################");
		System.out.println("1 - Cadastrar Funcionario");
		System.out.println("2 - Listar Funcionarios");
		System.out.println("3 - Atualizar Funcionario");
		System.out.println("4 - Delete Funcionario");
		System.out.println("5 - Listar Funcionario em especifico");
		System.out.println("6 - Calcular Salario");
		System.out.println("9 - Sai do Sistema");
		System.out.println("########################");

	}

	// Método para exibir opções de plano de convênio
	static public void convenio() {
		System.out.println("1 - Básico");
		System.out.println("2 - Premium");
		System.out.println("3 - Platinum Premium Plus");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Pessoa> Func = new ArrayList<Pessoa>();
		boolean sistema = true;
		// Loop principal do sistema
		do {
			// Exibe o menu
			menu();
			// Lê a opção do usuário
			int opcao = sc.nextInt();
			// Switch para tratar a opção escolhida
			switch (opcao) {
			case 1: {
				Pessoa FuncNovo = new Pessoa("", 0, 0, true, true, true, "");
				// Preenche os dados do novo funcionário
				System.out.println("Qual o nome?");
				FuncNovo.setNome(sc.next());
				System.out.println("Qual o salario Bruto?");
				FuncNovo.setSalarioBruto(sc.nextDouble());
				System.out.println("Qual a quantidade de dependentes?");
				FuncNovo.setNumeroDependentes(sc.nextInt());
				// Preenche se o funcionário possui VR, VA e VT
				System.out.println("Você possui VR? (true/false)");
				boolean vr = false;
				while (true) {

					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						vr = Boolean.parseBoolean(input);
						FuncNovo.setVr(vr);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				System.out.println("Você possui Va? (true/false)");
				boolean va = false;
				// Loop para garantir que o usuário insira um valor booleano válido
				while (true) {

					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						va = Boolean.parseBoolean(input);
						FuncNovo.setVa(va);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				// Repetição similar para VA e VT
				// Preenche o tipo de convênio
				System.out.println("Você possui Vt? (true/false)");
				boolean vt = false;
				while (true) {
					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						vt = Boolean.parseBoolean(input);
						FuncNovo.setVt(vt);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				System.out.println("Tipo de convênio:");
				convenio();
				int escolhaConvenio = sc.nextInt();
				switch (escolhaConvenio) {
				case 1: {
					FuncNovo.setPlanoDeSaude("Basico");
					break;
				}
				case 2: {
					FuncNovo.setPlanoDeSaude("Premium");
					break;
				}
				case 3: {
					FuncNovo.setPlanoDeSaude("Platinum Premium Plus");
					break;
				}
				}
				// Adiciona o novo funcionário à lista
				Func.add(FuncNovo);
				System.out.println("##################################");
				System.out.println("Usuario cadastrado com sucesso!!!");
				continue;
			}
			case 2: {
				// Listar Funcionários
				// Itera sobre a lista de funcionários e exibe suas informações
				Func.forEach(FuncNovo -> {// Exibe outras informações do funcionário
					System.out.println("o Funcionario " + FuncNovo.getNome() + " Possui essas informações:");
					System.out.println("esse é o salario do colaborador: " + FuncNovo.getSalarioBruto());
					System.out.println("esse é a quantidade de dependentes: " + FuncNovo.getNumeroDependentes());

					if (FuncNovo.isVr() == true) {
						System.out.println("Possui Vr");
					} else {
						System.out.println("Ele não possui Vr");
					}
					if (FuncNovo.isVa() == true) {
						System.out.println("Possui Va");
					} else {
						System.out.println("Ele não possui Va");
					}
					if (FuncNovo.isVt() == true) {
						System.out.println("Possui Vt");
					} else {
						System.out.println("Ele não possui Vt");
					}
					System.out.println("esse é o Plano de Saude " + FuncNovo.getPlanoDeSaude());

				});
				continue;
			}
			case 3: {
			}
				Func.forEach(FuncNovo -> {
					// Atualizar Funcionário
					// Implementação da atualização de funcionário
					System.out.println("Esse o funcionario numero: " + Func.indexOf(FuncNovo));
					System.out.println(FuncNovo.getNome());
					System.out.println(FuncNovo.getSalarioBruto());
					System.out.println(FuncNovo.getNumeroDependentes());
					System.out.println(FuncNovo.isVr());
					System.out.println(FuncNovo.isVa());
					System.out.println(FuncNovo.isVt());
					System.out.println(FuncNovo.getPlanoDeSaude());
				});
				Pessoa FuncNovo = new Pessoa("", 0, 0, true, true, true, "");
				System.out.println("Qual vaga voce deseja atualizar?");
				int opcaoAtt = sc.nextInt();
				do {
					try {

						Func.set(opcaoAtt, FuncNovo);

					} catch (Exception e) {

						while (opcaoAtt > Func.size() || opcaoAtt < 0) {
							System.out.println("Vagas nn existem...");
							System.out.println("digite novamente: ");
							opcaoAtt = sc.nextInt();
						}
					}
				} while (opcaoAtt > Func.size() || opcaoAtt < 0);
				System.out.println("Qual o nome?");
				FuncNovo.setNome(sc.next());
				System.out.println("digite o salario: ");
				FuncNovo.setSalarioBruto(sc.nextDouble());
				while (FuncNovo.getSalarioBruto() <= 0) {
					System.out.println("seu salario bruto está errado, digite novamente...");
					FuncNovo.setSalarioBruto(sc.nextDouble());
				}
				System.out.println("Digite a quantidade de dependentes?");
				FuncNovo.setNumeroDependentes(sc.nextInt());
				while (FuncNovo.getNumeroDependentes() < 0) {
					System.out.println("seu salario bruto está errado, digite novamente...");
					FuncNovo.setNumeroDependentes(sc.nextInt());

				}
				System.out.println("Você possui VR? (true/false)");
				boolean vr = false;
				while (true) {
					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						vr = Boolean.parseBoolean(input);
						FuncNovo.setVr(vr);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				System.out.println("Você possui Va? (true/false)");
				boolean va = false;
				while (true) {
					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						va = Boolean.parseBoolean(input);
						FuncNovo.setVa(va);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				System.out.println("Você possui Vt? (true/false)");
				boolean vt = false;
				while (true) {
					String input = sc.next();
					if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
						vt = Boolean.parseBoolean(input);
						FuncNovo.setVt(vt);
						break;
					} else {
						System.out.println("Você digitou errado! Por favor, insira 'true' ou 'false':");
					}
				}
				System.out.println("Tipo de convênio:");
				convenio();
				int escolhaConvenio = sc.nextInt();
				switch (escolhaConvenio) {
				case 1: {
					FuncNovo.setPlanoDeSaude("Básico");
					break;
				}
				case 2: {
					FuncNovo.setPlanoDeSaude("Premium");
					break;
				}
				case 3: {
					FuncNovo.setPlanoDeSaude("Platinum Premium Plus");
					break;
				}
				}
				continue;
			case 4: {
				// Implementação da opção demitir
				Func.forEach(func -> {
					System.out.println("Id:" + Func.indexOf(func));
					System.out.println("funcionario: " + func.getNome());
					System.out.println("R$ " + func.getSalarioBruto());
					System.out.println(func.getNumeroDependentes() + " dependentes");
					if (func.isVa() == true) {
						System.out.println("Possui va");
					} else if (func.isVa() == false) {
						System.out.println("Não possui va");
					}
					if (func.isVr() == true) {
						System.out.println("Possui vale-refeição");
					} else if (func.isVr() == false) {
						System.out.println("Não possui vr");
					}
					if (func.isVt() == true) {
						System.out.println("Possui vt");
					} else if (func.isVt() == false) {
						System.out.println("Não possui vt");
					}
					System.out.println("Plano de saúde: " + func.getPlanoDeSaude());
					System.out.println("---------------------------");
				});
				Pessoa func = new Pessoa(null, 0.0, 0, false, false, false, null);
				System.out.println("Qual funcionário demitir?");
				int deletar = sc.nextInt();
				do {
					try {
						Func.set(deletar, func);
					} catch (Exception e) {
						while (deletar > Func.size() || deletar < 0) {
							System.out.println("Você digitou errado");
							System.out.println("Qual funcionário demitir?");
							deletar = sc.nextInt();
						}
					}
				} while (deletar > Func.size() || deletar < 0);
				System.out.println("FUNCIONÁRIO DEMITIDO COM SUCESSO :(");
				System.out.println("-----------------------------------------");
				continue;
			}

			case 5: {
				// Implementação da vizualização do funcionario
				System.out.println("Digite o ID da pessoa que vc quer vizualizar:  ");
				int id = sc.nextInt();
				while (id > Func.size() || id < 0) {
					System.out.println("ID invalido");
					System.out.println("Por favor digite novamente: ");
					id = sc.nextInt();
				}
				Pessoa vizu = Func.get(id);
				System.out.println(vizu.getNome());
				System.out.println(vizu.getSalarioBruto());
				System.out.println(vizu.getNumeroDependentes());
				System.out.println(vizu.isVr());
				System.out.println(vizu.isVa());
				System.out.println(vizu.isVt());
				System.out.println(vizu.getPlanoDeSaude());

				continue;
			}
			case 6: {// Implementação do calculo do funcionario em especifico
				int id = 0;
				try {
					System.out.println("O id da pessoa que quer calcular: ");
					id = sc.nextInt();
				} catch (Exception JavaIndexOutOfBoundsException) {
					while (id > Func.size() || id < 0) {
						System.out.println("ID invalido,(valido somente para numeros)");
						System.out.println("Por favor digite novamente: ");
						id = sc.nextInt();
					}
				}
				Pessoa calc = Func.get(id);
				System.out.println("Este é o salario liquido do Funcionario: " + calc.getNome());
				System.out.println(calc.calcularSalarioLiquido());
				continue;
			}
			case 9: {
				// finalizando sistema
				System.out.println("O sistema foi finalizado!!!");
				sistema = false;
				break;
			}

			default:

			}
		} while (sistema != false);

	}

}
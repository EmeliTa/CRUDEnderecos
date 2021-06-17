package View;

import java.util.List;
import java.util.Scanner;

import DAO.EnderecosDao;
import Entidade.Enderecos;

public class TelaPrincipal {

	Scanner in = new Scanner(System.in);
	public String menuListaEndereco() {
		return lerDados("Escolha a ação que deseja realizar!    \n"
				+ "1 - Cadastro de endereço;    \n"
				+ "2 - Atualizar endereço;    \n"
				+ "3 - Excluir endereço;    \n"
				+ "4 - Listar endereço;    \n"
				+ "5 - Sair;");	
	}
	
	public void cadastrarEndereco() {
		Enderecos endereco = new Enderecos();
		EnderecosDao dao = new EnderecosDao();
		endereco.setRua(lerDados("Informe a rua: "));
		endereco.setNumero(lerDados("Informe o número: "));
		endereco.setBairro(lerDados("Informe o bairro: "));
		endereco.setComplemento(lerDados("Informe o complemento: "));
		endereco.setCidade(lerDados("Informe a cidade: "));
		endereco.setEstado(lerDados("Informe o Estado: "));
		endereco.setPais(lerDados("Informe o pais: "));
		endereco.setCep(lerDados("Informe o CEP: "));
		
		dao.cadastraEnderecos(endereco);
		System.out.println("Endereço cadastrado com sucesso!");
	}

	public void atualizarEndereco() {
		Enderecos endereco = new Enderecos();
		EnderecosDao dao = new EnderecosDao();
		endereco.setId(Integer.parseInt(lerDados("Informe o ID para alterar: ")));
		endereco.setRua(lerDados("Informe a rua para alterar: "));
		endereco.setNumero(lerDados("Informe o número: "));
		endereco.setBairro(lerDados("Informe o bairro: "));
		endereco.setComplemento(lerDados("Informe o complemento"));
		endereco.setCidade(lerDados("Informe a cidade: "));
		endereco.setEstado(lerDados("Informe o Estado: "));
		endereco.setPais(lerDados("Informe o pais: "));
		endereco.setCep(lerDados("Informe o CEP: "));
		
		dao.alterarEndereco(endereco);
		System.out.println("Endereço alterado com sucesso!!");
	
	}
	
	public void deletarEndereco() {
		Enderecos endereco = new Enderecos();
		EnderecosDao dao = new EnderecosDao();
		endereco.setId(Integer.parseInt(lerDados("Informe o ID do endereço para deletar: ")));
		dao.deletaEndereco(endereco);
		System.out.println("Endereco deletado com sucesso!!");	
		}
	
	public void listarEndereco() {
		EnderecosDao dao = new EnderecosDao();
		
		List<Enderecos> listEnderecos = dao.getList();
		for(int i = 0; i < listEnderecos.size(); i++) {
		System.out.println("====================================");
		System.out.println("ID: "+ listEnderecos.get(i).getId());
		System.out.println("Nome da Rua: " + listEnderecos.get(i).getRua());
		System.out.println("Numero: "+ listEnderecos.get(i).getNumero());
		System.out.println("Bairro: "+ listEnderecos.get(i).getBairro());
		System.out.println("Complemento: "+ listEnderecos.get(i).getComplemento());
		System.out.println("Cidade: " + listEnderecos.get(i).getCidade());
		System.out.println("Estado: "+ listEnderecos.get(i).getEstado());
		System.out.println("Pais: "+ listEnderecos.get(i).getPais());
		System.out.println("CEP: "+ listEnderecos.get(i).getCep());

		System.out.println("====================================");
		}
	}
	
	private String lerDados(String string) {
		System.out.println(string);
		return in.nextLine();
	}
	
}

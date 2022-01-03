package program;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import DAO.ProdutoDAO;
import factory.JPAFactory;
import model.Produto;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nov;

		do {
			EntityManager em = new JPAFactory().getEntityManager();
			ProdutoDAO produtoDao = new ProdutoDAO(em);

			System.out.print("1 INSERIR/ATUALIZAR == 2 DELETAR == 3 LISTAR: ");
			int op = sc.nextInt();

			if (op == 1) {

				System.out.println("\nDigite os dados e depois escolha se deseja INSERIR OU ATUALIZAR");

				System.out.print("\nDigite o nome do produto: ");
				String nome = sc.next();

				System.out.print("Digite a descricao do produto: ");
				sc.nextLine();
				String descricao = sc.nextLine();

				System.out.print("Digite o preco do produto: ");
				Double preco = sc.nextDouble();

				Produto produto = new Produto(nome, descricao, preco);

				System.out.print("1 ISERIR == 2 ATUALIZAR: ");
				int aux = sc.nextInt();

				if (aux == 1) {
					produtoDao.inserir(produto);
				} else if (aux == 2) {

					System.out.print("Digite o ID de quem deseja ATUALIZAR: ");
					Integer id = sc.nextInt();

					produtoDao.atualizar(nome, descricao, preco, id);
				}

			} else if (op == 2) {

				List<Produto> listar = produtoDao.listar();
				listar.forEach(p -> System.out.println(p));

				System.out.print("\nDigite o ID que deseja deletar: ");
				Integer id = sc.nextInt();

				produtoDao.deletar(id);

			} else if (op == 3) {

				List<Produto> listar = produtoDao.listar();
				listar.forEach(p -> System.out.println(p));

			} else
				System.out.print("OPERAÇAO NAO EXISTENTE");

			System.out.println("\nProcesso realizada com SUCESSO");
			System.out.println("Deseja realizar outro PROCESSO ?");
			System.out.print("1 = SIM  0 = NAO: ");
			nov = sc.nextInt();

		} while (nov == 1);
	}
}
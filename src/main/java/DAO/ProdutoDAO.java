package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO() {
	}

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void inserir(Produto produto) {
		em.getTransaction().begin();
		this.em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void deletar(Integer id) {
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		this.em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}

	public List<Produto> listar() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();

	}

	public void atualizar(String nome, String descricao, Double preco, Integer id) {
		em.getTransaction().begin();

		Produto produto = em.find(Produto.class, id);
		if (produto.getId() == id) {

			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setPreco(preco);
		}
		em.getTransaction().commit();
		em.close();
	}
}
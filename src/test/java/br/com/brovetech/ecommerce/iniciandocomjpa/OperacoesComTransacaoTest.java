package br.com.brovetech.ecommerce.iniciandocomjpa;

import br.com.brovetech.ecommerce.EntityManagerTest;
import br.com.brovetech.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import javax.lang.model.type.PrimitiveType;
import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void inserirProduto(){
        var produto = new Produto();
        produto.setId(2);
        produto.setDescricao("Teste do Naidion");
        produto.setPreco(BigDecimal.valueOf(2.99));
        produto.setNome("Carrinho");
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        var produtoFinded = entityManager.find(Produto.class, 2);
        Assert.assertNotNull(produtoFinded);
    }

    @Test
    public void removerObjecto(){
        var produto = entityManager.find(Produto.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        var produtoFinded = entityManager.find(Produto.class, 1);
        Assert.assertNull(produtoFinded);
    }

    @Test
    public void atualizarObjecto(){
        var produto = new Produto();
        produto.setId(1);
        produto.setNome("OutroTeste2");
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        produto = entityManager.find(Produto.class, 1);

        Assert.assertEquals("OutroTeste2", produto.getNome());
    }

    @Test
    public void atualizarObjectoGerenciado(){
        var produto = entityManager.find(Produto.class, 1);
        entityManager.getTransaction().begin();
        produto.setNome("OutroTeste");
        entityManager.getTransaction().commit();
        entityManager.clear();

        produto = entityManager.find(Produto.class, 1);

        Assert.assertEquals("OutroTeste", produto.getNome());
    }

    @Test
    public void removerGerenciamentoDeObjetos(){
        var produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);
        entityManager.getTransaction().begin();
        produto.setNome("OutroTeste2");
        entityManager.getTransaction().commit();
        entityManager.clear();

        produto = entityManager.find(Produto.class, 1);

        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void inserirProdutoComMerge(){
        var produto = new Produto();
        produto.setId(4);
        produto.setDescricao("Teste com Merge");
        produto.setPreco(BigDecimal.valueOf(2.99));
        produto.setNome("Carrinho");
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        var produtoFinded = entityManager.find(Produto.class, 4);
        Assert.assertNotNull(produtoFinded);
    }
}

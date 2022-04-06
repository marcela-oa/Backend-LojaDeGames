package com.generation.lojadegames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojadegames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List <Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	@Query(value = "select * from tb_produtos where preco between :menor and :maior", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("menor") BigDecimal menor, @Param("maior") BigDecimal maior);
}

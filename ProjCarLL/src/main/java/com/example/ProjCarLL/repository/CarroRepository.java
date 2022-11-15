package com.example.ProjCarLL.repository;

import com.example.ProjCarLL.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository <CarroModel,Integer> {

    public List<CarroModel> findByDesc (String descricao);

    public List<CarroModel> findByMarca (String marca);

    public List<CarroModel> findByPreco (double preco);

    @Query(value = "select c from CarroModel c where c.descricao like ?1%")
    public List<CarroModel> findByDInicial (String descricao);

    @Query(value = "select c from CarroModel c where c.marca like ?1%")
    public List<CarroModel> findByMInicial (String marca);

    @Query (value = "select c from CarroModel c where c.preco > ?1")
    public List<CarroModel> findByPrecoMaior (double preco);

    @Query (value = "select c from CarroModel c where c.preco < ?1")
    public List<CarroModel> findByPrecoMenor (double preco);

    @Query (value = "select c from CarroModel where c.nome like ?1% and c.email like ?2%")
    public List<String> findByNomeEmail (String nome, String email);

    @Query (value = "select c from CarroModel where c.descricao like %?1% and c.marca like %?2%")
    public List<String> findByDescMarca (String descricao, String marca);

    @Query (value = "select c from CarroModel where c.descricao like %?1% and c.preco < ?2")
    public List<String> findByDescPreco (String descricao, double preco);
}

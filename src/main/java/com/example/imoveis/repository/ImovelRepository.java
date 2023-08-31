package com.example.imoveis.repository;

import com.example.imoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
    List<Imovel> findByTipo(String tipo);
}

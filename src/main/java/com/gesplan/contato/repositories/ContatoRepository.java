package com.gesplan.contato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesplan.contato.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
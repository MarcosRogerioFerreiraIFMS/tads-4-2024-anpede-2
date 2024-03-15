package com.anpede.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anpede.entities.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}

package br.com.fiap.abctechapi.repository;

import br.com.fiap.abctechapi.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Assistance,Long> {

}

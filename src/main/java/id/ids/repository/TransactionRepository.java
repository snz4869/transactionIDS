package id.ids.repository;

import id.ids.model.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @EntityGraph(attributePaths = {"product", "customer", "status"})
    Optional<Transaction> findTransactionById(Integer id);
}

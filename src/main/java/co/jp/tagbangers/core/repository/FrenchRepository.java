package co.jp.tagbangers.core.repository;

import co.jp.tagbangers.core.entity.French;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrenchRepository extends JpaRepository<French,Long> {
}

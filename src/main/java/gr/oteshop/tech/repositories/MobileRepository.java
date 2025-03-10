package gr.oteshop.tech.repositories;

import gr.oteshop.tech.models.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {

    List<Mobile> findMobileByModelContainingIgnoreCase(String model);

}

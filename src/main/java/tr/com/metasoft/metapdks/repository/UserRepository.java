package tr.com.metasoft.metapdks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tr.com.metasoft.metapdks.model.Company;
import tr.com.metasoft.metapdks.model.User;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "FROM User u WHERE u.device_id = ?1")
    User findUserByDeviceId(String unique_id);

}

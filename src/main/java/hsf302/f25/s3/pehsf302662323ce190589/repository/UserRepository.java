package hsf302.f25.s3.pehsf302662323ce190589.repository;

import hsf302.f25.s3.pehsf302662323ce190589.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}

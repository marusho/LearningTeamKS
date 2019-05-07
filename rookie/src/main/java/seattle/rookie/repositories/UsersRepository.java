package seattle.rookie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Long>{

	public UsersEntity findByUserId(long userId);

}
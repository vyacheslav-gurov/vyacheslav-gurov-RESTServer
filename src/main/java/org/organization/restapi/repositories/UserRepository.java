package org.organization.restapi.repositories;

import org.organization.restapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);
    User findByUsername(String user);
}

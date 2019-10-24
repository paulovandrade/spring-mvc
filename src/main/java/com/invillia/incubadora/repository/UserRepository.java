package com.invillia.incubadora.repository;

import com.invillia.incubadora.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author s2it_pandrade
 * @version : $<br/>
 * : $
 * @since 24/10/19 14:36
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}

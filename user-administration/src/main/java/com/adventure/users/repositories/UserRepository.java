package com.adventure.users.repositories;

import com.adventure.users.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Long> {

}

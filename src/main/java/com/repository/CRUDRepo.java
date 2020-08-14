package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("CRUDRepo")
public interface CRUDRepo extends CrudRepository<User, Integer>{

}

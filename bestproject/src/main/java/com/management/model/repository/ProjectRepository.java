package com.management.model.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.management.model.ProjectEntity;


@Repository
public interface ProjectRepository 
			extends CrudRepository<ProjectEntity, Long> {

}

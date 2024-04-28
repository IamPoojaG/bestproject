package com.management.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.bestproject.RecordNotFoundException;
import com.management.model.ProjectEntity;
import com.management.model.repository.ProjectRepository;


@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository repository;
	
	public List<ProjectEntity> getAllEmployees()
	{
		System.out.println("getAllProjects");
		List<ProjectEntity> result = (List<ProjectEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<ProjectEntity>();
		}
	}

	
	public ProjectEntity getProjectById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getProjectById");
		Optional<ProjectEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No project record exist for given id");
		}
	}
	
	public ProjectEntity createOrUpdateProject(ProjectEntity entity) 
	{
		System.out.println("createOrUpdateProject");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<ProjectEntity> project = repository.findById(entity.getId());
			
			if(project.isPresent()) 
			{
				ProjectEntity newEntity = project.get();
				newEntity.setStartDate(entity.getStartDate(null));
				newEntity.setEndDate(entity.getEndDate(null));
				newEntity.setProjectName(entity.getProjectName());
				newEntity.setDescription(entity.getDescription());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteProjectById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteProjectById");
		
		Optional<ProjectEntity> project = repository.findById(id);
		
		if(project.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No project record exist for given id");
		}
	}


  public List<ProjectEntity> getAllProjects() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllProjects'");
  } 
}

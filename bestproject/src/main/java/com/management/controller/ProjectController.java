package com.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.management.bestproject.RecordNotFoundException;
import com.management.model.ProjectEntity;
import com.management.service.ProjectService;

@Controller
@RequestMapping("/")
public class ProjectController 
{
	@Autowired
	ProjectService service;

	@RequestMapping
	public String getAllProjects(Model model) 
	{	
		System.out.println("getProjects");
		
		List<ProjectEntity> list = service.getAllProjects();

		model.addAttribute("projects", list);
		
		return "list-projects";
	}

	
	
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editProjectById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editProjectById" + id);
		if (id.isPresent()) {
			ProjectEntity entity = service.getProjectById(id.get());
			model.addAttribute("project", entity);
		} else {
			model.addAttribute("project", new ProjectEntity());
		}
		
		
		return "add-edit-project";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteProjectById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("deleteProjectById" + id);
		
		service.deleteProjectById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createProject", method = RequestMethod.POST)
	public String createOrUpdateProject(ProjectEntity project) 
	{
		System.out.println("createOrUpdateProject ");
		
		service.createOrUpdateProject(project);
		
		return "redirect:/";
	}
}

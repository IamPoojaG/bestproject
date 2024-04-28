package com.management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_PROJECTS")
public class ProjectEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="project_name")
    private String projectName;
    
    @Column(name="description")
    private String description;
    
    @Column(name="startDate")
    private LocalDate  startDate;

    @Column(name="endDate")
    private LocalDate endDate;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate(LocalDate startDate) {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

  public LocalDate getEndDate(LocalDate endDate) {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", projectName=" + projectName + 
                ", description=" + description + ", startDate=" + startDate   + ", endDate=" + endDate + "]";
    }
}
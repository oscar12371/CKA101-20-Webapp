package com.coursecategories.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_categories")

public class CourseCategoriesVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "course_cat_id")
	private Integer courseCatId;
	
	@Column(name = "course_cat_name")
	private String courseCatName;

	public Integer getCourseCatId() {
		return courseCatId;
	}

	public void setCourseCatId(Integer courseCatId) {
		this.courseCatId = courseCatId;
	}

	public String getCourseCatName() {
		return courseCatName;
	}

	public void setCourseCatName(String courseCatName) {
		this.courseCatName = courseCatName;
	}
}
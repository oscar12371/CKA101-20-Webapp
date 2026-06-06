package com.coursecategories.model;

import java.util.List;

public interface CourseCategories_interface {
	

    public void insert(CourseCategoriesVO CourseCategoriesVO);

    public void update(CourseCategoriesVO CourseCategoriesVO);

    public void delete(Integer course_cat_id);

    public CourseCategoriesVO findByPrimaryKey(Integer course_cat_id);

    public List<CourseCategoriesVO> getAll();

	
	
	
}

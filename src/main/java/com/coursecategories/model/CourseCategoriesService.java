package com.coursecategories.model;

import java.util.List;

public class CourseCategoriesService {

    private CourseCategories_interface dao;

    public CourseCategoriesService() {
        dao = new CourseCategoriesJDBCDAO();
    }

    public List<CourseCategoriesVO> getAll() {
        return dao.getAll();
    }

    public CourseCategoriesVO getOneCourseCategory(Integer courseCatId) {
        return dao.findByPrimaryKey(courseCatId);
    }
    public CourseCategoriesVO addCourseCategory(String courseCatName) {

        CourseCategoriesVO courseCategoriesVO =
                new CourseCategoriesVO();

        courseCategoriesVO.setCourseCatName(courseCatName);

        dao.insert(courseCategoriesVO);

        return courseCategoriesVO;
    }
    public void deleteCourseCategory(Integer courseCatId) {
        dao.delete(courseCatId);
    }
}

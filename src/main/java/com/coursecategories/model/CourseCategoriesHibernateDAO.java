package com.coursecategories.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.coursecategories.util.HibernateUtil;

public class CourseCategoriesHibernateDAO implements CourseCategories_interface {

    // SessionFactory 為 thread-safe，可共用
    private SessionFactory factory;

    public CourseCategoriesHibernateDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    // 每次操作資料庫都取得一個 Session
    private Session getSession() {
        return factory.getCurrentSession();
    }
    
    

    @Override
    public void insert(CourseCategoriesVO courseCategoriesVO) {
 
    	    getSession().persist(courseCategoriesVO);
    	
    }

    @Override
    public void update(CourseCategoriesVO courseCategoriesVO) {
    	getSession().merge(courseCategoriesVO);
    }

    @Override
    public void delete(Integer courseCatId) {
    	 CourseCategoriesVO courseCategoriesVO =
    	            getSession().find(CourseCategoriesVO.class, courseCatId);

    	    if (courseCategoriesVO != null) {
    	        getSession().remove(courseCategoriesVO);
    	    }
    }

    @Override
    public CourseCategoriesVO findByPrimaryKey(Integer courseCatId) {
        return getSession().find(CourseCategoriesVO.class, courseCatId);
    }

    @Override
    public List<CourseCategoriesVO> getAll() {
        return getSession()
                .createQuery("from CourseCategoriesVO", CourseCategoriesVO.class)
                .getResultList();
    }
    
}

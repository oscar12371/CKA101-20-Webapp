package com.coursecategories.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.coursecategories.model.CourseCategoriesService;
import com.coursecategories.model.CourseCategoriesVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coursecategories/coursecategories.do")
public class CourseCategoriesServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("getOne_For_Display".equals(action)) {
        	String str = req.getParameter("courseCatId");
        	
        	List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
        	
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入課程分類編號");
			}
			Integer coursecategoriesId = null;
			try {
				coursecategoriesId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/coursecategories/coursecategories.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			CourseCategoriesService courCtService = new CourseCategoriesService();
			CourseCategoriesVO courseCategoriesVO = courCtService.getOneCourseCategory(coursecategoriesId);
			
			if (courseCategoriesVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/coursecategories/coursecategories.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			req.setAttribute("courseCategoriesVO", courseCategoriesVO);         
			String url = "/coursecategories/listOneCourse_CourseCategories.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
        }
        if ("getAll".equals(action)) {
        	CourseCategoriesService courCtService = new CourseCategoriesService();
        	List<CourseCategoriesVO> list = courCtService.getAll();
        	req.setAttribute("list", list);
        	RequestDispatcher successView =
        	req.getRequestDispatcher(
        	"/coursecategories/listAll_CourseCategories.jsp");
        	successView.forward(req, res);
        }
        
        if ("insert".equals(action)) {
        	

        	    List<String> errorMsgs = new LinkedList<String>();
        	    req.setAttribute("errorMsgs", errorMsgs);

        	    String courseCatName = req.getParameter("courseCatName");

        	    if (courseCatName == null || courseCatName.trim().length() == 0) {
        	        errorMsgs.add("課程分類名稱請勿空白");
        	    }

        	    if (!errorMsgs.isEmpty()) {
        	        RequestDispatcher failureView =
        	                req.getRequestDispatcher("/coursecategories/addCourseCategory.jsp");
        	        failureView.forward(req, res);
        	        return;
        	    }

        	    CourseCategoriesService courCtService =
        	            new CourseCategoriesService();

        	    // 這裡等等會呼叫新增方法
        	    courCtService.addCourseCategory(courseCatName);

        	    String url =
        	            "/coursecategories/coursecategories.do?action=getAll";

        	    res.sendRedirect(req.getContextPath() + url);
        	}
        
        if ("delete".equals(action)) {

            Integer courseCatId =
                    Integer.valueOf(req.getParameter("courseCatId"));

            CourseCategoriesService courCtService =
                    new CourseCategoriesService();

            courCtService.deleteCourseCategory(courseCatId);

            String url =
                    "/coursecategories/coursecategories.do?action=getAll";

            res.sendRedirect(req.getContextPath() + url);
        }
        if ("update".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);

            Integer courseCatId =
                    Integer.valueOf(req.getParameter("courseCatId"));

            String courseCatName =
                    req.getParameter("courseCatName");

            if (courseCatName == null ||
                courseCatName.trim().length() == 0) {

                errorMsgs.add("課程分類名稱請勿空白");
            }

            CourseCategoriesVO courseCategoriesVO =
                    new CourseCategoriesVO();

            courseCategoriesVO.setCourseCatId(courseCatId);
            courseCategoriesVO.setCourseCatName(courseCatName);

            if (!errorMsgs.isEmpty()) {

                req.setAttribute("courseCategoriesVO",
                                 courseCategoriesVO);

                RequestDispatcher failureView =
                        req.getRequestDispatcher(
                        "/coursecategories/updateCourseCategory.jsp");

                failureView.forward(req, res);

                return;
            }

            CourseCategoriesService courCtService =
                    new CourseCategoriesService();

            courseCategoriesVO =
                    courCtService.updateCourseCategory(
                            courseCatId,
                            courseCatName);

            req.setAttribute("courseCategoriesVO",
                             courseCategoriesVO);

            String url =
                    "/coursecategories/listOneCourse_CourseCategories.jsp";

            RequestDispatcher successView =
                    req.getRequestDispatcher(url);

            successView.forward(req, res);
        }
        if ("getOne_For_Update".equals(action)) {

            Integer courseCatId =
                    Integer.valueOf(req.getParameter("courseCatId"));

            CourseCategoriesService courCtService =
                    new CourseCategoriesService();

            CourseCategoriesVO courseCategoriesVO =
                    courCtService.getOneCourseCategory(courseCatId);

            req.setAttribute("courseCategoriesVO",
                             courseCategoriesVO);

            String url =
                    "/coursecategories/updateCourseCategory.jsp";

            RequestDispatcher successView =
                    req.getRequestDispatcher(url);

            successView.forward(req, res);
        }
    } 
}
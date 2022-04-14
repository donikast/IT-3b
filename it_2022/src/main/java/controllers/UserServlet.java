package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repositories.Repository;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository collection;
	public void init(ServletConfig config) throws ServletException {
		collection=Repository.getInstance();
	}

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		User updatedUser = collection.getUserById(id);
		
		updatedUser.setPersonalName(request.getParameter("personal-name"));
		updatedUser.setJobTitle(request.getParameter("job-title"));
		updatedUser.setDescription(request.getParameter("description"));
		updatedUser.setPhone(request.getParameter("phone"));
		updatedUser.setEmail(request.getParameter("email"));
		updatedUser.getAddress().setCity(request.getParameter("city"));
		updatedUser.getAddress().setStreet(request.getParameter("street"));
		
		for(int i=0; i<updatedUser.getProffesionalSkills().size();i++) {
			String skillName = request.getParameter("prof-skill-name"+i);
			updatedUser.getProffesionalSkills().get(i).setSkillName(skillName);
			
			String skillValue = request.getParameter("prof-skill-value"+i);
			updatedUser.getProffesionalSkills().get(i).setSkillValue(skillValue);
		}
		
		for(int j=0; j<updatedUser.getPersonalSkills().size();j++) {
			String skillName = request.getParameter("personal-skill-name"+j);
			updatedUser.getPersonalSkills().get(j).setSkillName(skillName);
			
			String skillValue = request.getParameter("personal-skill-value"+j);
			updatedUser.getPersonalSkills().get(j).setSkillValue(skillValue);
		}
		
			request.setAttribute("loggedUser", updatedUser);
			RequestDispatcher rd = request.getRequestDispatcher("ProfilePage.jsp");
			rd.forward(request, response);

	}
	

}
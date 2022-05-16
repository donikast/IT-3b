package filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebFilter("/user")
public class ProfilePagesAccess extends HttpFilter {
        
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		User sessionUser = (session!=null)?(User)session.getAttribute("loggedUser"):null;

		int id=Integer.parseInt(request.getParameter("id"));
		
		String action = request.getParameter("action");
		
		if(sessionUser == null) {
			res.sendRedirect("login");
		}
		else if(sessionUser.getId()!=id && action!=null && action.equals("edit")) {
			res.sendRedirect("user?id="+sessionUser.getId());
		}
			else {
				chain.doFilter(request, response);
			}}
	}

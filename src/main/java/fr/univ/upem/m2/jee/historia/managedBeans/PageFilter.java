/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.m2.jee.historia.managedBeans;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "PageFilter", urlPatterns = { "*.xhtml" })
public class PageFilter implements Filter {

	public PageFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			if (reqURI.contains("/jsf/index.xhtml")
					|| (ses != null && ses.getAttribute("user") != null)
					|| reqURI.contains("/jsf/user/")
					|| reqURI.contains("javax.faces.resource")){
                            chain.doFilter(request, response);
                          
                        }else{
                            resp.sendRedirect(reqt.getContextPath() + "/jsf/index.xhtml");

                        }
		} catch (IOException | ServletException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}

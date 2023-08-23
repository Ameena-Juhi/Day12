package com.learning.hello;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CardGameServlet")
public class CardGameServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	
	@Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String inp = req.getParameter("card");
		System.out.println(inp);
		var out = resp.getWriter();
		final IWebExchange webExchange = 
		        this.application.buildExchange(req, resp);
		    final WebContext ctx = new WebContext(webExchange);
		    ctx.setVariable("reading", inp );  
		    templateEngine.process("Mankatha", ctx, out);
		
	}
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("Mankatha", ctx, resp.getWriter());
	  }
}
	


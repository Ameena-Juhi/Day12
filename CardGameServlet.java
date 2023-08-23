package com.learning.hello;

import java.io.IOException;

import com.learning.hello.controller.CardGame;

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
	
	private CardGame game;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	
	@Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    game = new CardGame();
	    
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
		String input = req.getParameter("card");
		String Pile = req.getParameter("pile");
		String pileName = "";
			if(Pile.equals("in")) {
				pileName = "InPile";
			}
			else if(Pile.equals("out")){
				pileName = "OutPile";
			}
			
		System.out.println(input);
		System.out.println(pileName);
		
		var out = resp.getWriter();
		final IWebExchange webExchange = 
		        this.application.buildExchange(req, resp);
		    final WebContext ctx = new WebContext(webExchange);
		    
		    
		    String list = game.distributeCards();
		    System.out.println(list);
		    //out.println(list);
		    ctx.setVariable("reading",game.verifyCardPosition(input, pileName) );  
		    ctx.setVariable("inpile",game.getInPile() );  
		    ctx.setVariable("outpile",game.getOutPile());  
		    templateEngine.process("Mankatha", ctx, out);
		    resp.sendRedirect(req.getServletPath());
	}
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("Mankatha", ctx, resp.getWriter());
	  }
}
	


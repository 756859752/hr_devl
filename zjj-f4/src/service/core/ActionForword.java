package service.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public  class ActionForword {
     public String path=null;  //Ҫ��ת��ҳ�棻
     public boolean redirect=false; //�Ƿ��ض���
     
    public ActionForword(String path) {
		
    this(path,false);
    	// TODO Auto-generated constructor stub
	}

	public ActionForword(String path, boolean redirect) {
		
		this.path = path;
		this.redirect = redirect;
	}
	
	public void forword(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		Properties config=(Properties)request.getSession().getServletContext().getAttribute("config");
		if (redirect) {
			response.sendRedirect(config.getProperty(path));//Ҫ�þ���·�� ��Ϊ���ﲻ��servlet;Ҫ�������ļ��Ӷ�Ӧ����ת��
		}
		else {
			request.getRequestDispatcher(config.getProperty(path)).forward(request, response);
		}
		
		
		
	}

	
}

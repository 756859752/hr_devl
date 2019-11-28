package service.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mvc_servlet extends HttpServlet {
	Map<String, String[]> map=null;
	/**
	 * Constructor of the object.
	 */
	public Mvc_servlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//�ӳ�ʼ�����õ�map������Ϣ �Լ����ã�
	Properties  map=(Properties)	  this.getServletContext().getAttribute("action");
	Properties  config=(Properties)	  this.getServletContext().getAttribute("config");
	
	//�����Ŀ֮���·��
		    String uri  = request.getRequestURI();
		    //�����ַ����Ĳ�֣��õ���ת������
		    int begin= uri.lastIndexOf("/");
		     int end=uri.indexOf(".");
		     if (begin!=-1&&end!=-1&&end>begin) {
				
		    uri=  uri.substring(begin+1, end);
			}
		    //����ת������ƴ�ӳ���Ҫ���������
		      String  classFormPath=uri+"Form";
		      System.out.println(classFormPath);
		      System.out.println(config);
		      String  classform=  config.getProperty(classFormPath);
		      //���ظ���
		      Class class1;
		      ActionForm af = null;
			try {
				class1 = Class.forName(classform);
				 af=   (ActionForm)class1.newInstance();
				  System.out.println(request.getParameter("value"));
			// �õ�request������ֵ ��ֵ�����actionform 
			Set<Map.Entry<String, String[]>>	set=   request.getParameterMap().entrySet();
				
			for (Map.Entry<String, String[]> entry : set) {
				                        String fuc = entry.getKey();
				  Method m=  class1.getDeclaredMethod("set"+fuc.substring(0,1).toUpperCase()+fuc.substring(1), String.class);
				      m.invoke(af, entry.getValue()[0]);
			}
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     //��request.response �Լ�Ҫ�õ�ֵ�� ���ݵ�ʵ����תҳ�档
		 String classForName=   config.getProperty(uri);
		   Class o;
		try {
			o = Class.forName(classForName);
			Action action=(Action) o.newInstance();
			action.execute(request, response,af);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("dsadsa");
		//׼��һ����ʵ����MAP����
		Properties action=new Properties();
//		    String configpath= this.getServletConfig().getInitParameter("configLocaltion");
//		    System.out.println(configpath+"1111111111111111111111");
		    String path=this.getServletContext().                                                                                    b("/")+"/WEB-INF/config.properties";
		    
		    Properties config=new Properties();
		    try {
				config.load(new FileInputStream(path));
				
				this.getServletContext().setAttribute("action", action);
				this.getServletContext().setAttribute("config", config);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	}

}

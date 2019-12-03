package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KQXfilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// ǿת��HTTPЭ��
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// ���session���Ƿ���ֵ
		HttpSession session = request.getSession();
		// ���������õ���ǰ���ʵ�goods_id����Ʒ��ţ�
		String goods_id = (String) request.getAttribute("goods_id");
		if (goods_id!=null) {
			request.setAttribute("goods", goods_id);
		}
		//��ȡ������ҳ���uri������request��
		String uri = request.getRequestURI();
		int begin= uri.lastIndexOf("/");
		uri = uri.substring(begin+1);
		request.setAttribute("uri", uri);
		// ��session���õ���ǰ���˺�
		Object obj = session.getAttribute("userlogininfo");
		if (obj == null) {
			// ���û�е�¼����ת����ע���¼ҳ�棬���ѵ�ǰgoods_id����Ʒ��ţ�����ȥ
			request.getRequestDispatcher("/wkr-zhuce.jsp").forward(request, response);
		} else {
			// ��Ϊ�ձ�ʾ��¼������ת��xiangqingAction.java�н��в���
			arg2.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
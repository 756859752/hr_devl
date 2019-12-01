package service.kqx.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Order;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.kqx.form.dingdanform;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Orderdaoimpl;

public class dingdanAction extends Action {

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		List<Order> orderlist = new ArrayList<Order>();
		// ����������е�userid
		HttpSession session = request.getSession();
		dingdanform form = (dingdanform) actionForm;
		Object obj = session.getAttribute("userlogininfo");
		// ���������õ���ƷID
		String Order_id = form.getOrder_id();
		System.out.println(Order_id);
		// �жϣ�û�о���ת����¼ע��ҳ��
		// if (obj == null) {
		// return new ActionForword("zhuce.do");
		// } else {
		// �������ݿ�
		Orderdaoimpl Ordersimpl = DaoimplFactory.getOrderdaoimpl();
		if (Order_id != null) {
			try {
				orderlist = Ordersimpl.selectOderByUserId(Integer
						.parseInt(Order_id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("orderlist", orderlist);
		}
		// }
		return new ActionForword("kqx-dingdan");
	}
}

package service.kqx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Goods;
import dao.daoimpl.Adressdaoimpl;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;

public class dingdanAction extends Action {

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		Goods goods = new Goods();
		// ����������е�userid
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userid");
		// �жϣ�û�о���ת����¼ע��ҳ��
		if (obj == null) {
			return new ActionForword("zhuce.do");
		} else {
			// ���������õ���ַadress_id
			Object goods_id = request.getAttribute("adress_id");
			// �������ݿ�
			Adressdaoimpl Goodsimpl = DaoimplFactory.getAdressdaoimpl();
			if (goods_id != null) {
				try {
					goods = Goodsimpl.selectByGoodsId(Integer
							.parseInt((String) goods_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("goods", goods);
			}
		}
		return new ActionForword("kqx-xiangqing");
	}
	}



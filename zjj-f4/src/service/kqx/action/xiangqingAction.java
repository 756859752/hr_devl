package service.kqx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Goods;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.kqx.form.xiangqingForm;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;

public class xiangqingAction extends Action {

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		Goods goods = new Goods();
		// ����������е�userid
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userlogininfo");
		// ��form���õ���ƷID
		xiangqingForm form = (xiangqingForm) actionForm;
		String goods_id = form.goods_id;
		System.out.println(goods_id);
		// �жϣ�û�о���ת����¼ע��ҳ��
		if (obj == null) {
			return new ActionForword("zhuce.do");
		} else {
			// �������ݿ�
			Goodsdaoimpl Goodsimpl = DaoimplFactory.getGoodsdaoimpl();
			if (goods_id != null) {
				try {
					goods = Goodsimpl.selectByGoodsId(Integer
							.parseInt(goods_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("goods", goods);
			}
		}
		return new ActionForword("kqx-xiangqing");
	}
}

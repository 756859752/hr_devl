package service.kqx.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Adress;
import pojo.Goods;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.kqx.form.dingdanForm;
import dao.daoimpl.Adressdaoimpl;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;
import dto.UserLoginInfo;

public class dingdanAction extends Action {

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		Map<Goods, String> map = new HashMap<Goods, String>();
		Goodsdaoimpl goodsimpl = DaoimplFactory.getGoodsdaoimpl();
		Adressdaoimpl adressimpl = DaoimplFactory.getAdressdaoimpl();
		HttpSession session = request.getSession();
		dingdanForm form = (dingdanForm) actionForm;
		// ��session���õ�dto��UserLoginInfo����
		Object obj = session.getAttribute("userlogininfo");
		UserLoginInfo userinfo = (UserLoginInfo) obj;
		// ��UserLoginInfo�������õ�userid
		int userid = userinfo.getUserid();
		Adress adress = new Adress();
		try {// ����userid�鵽��Ӧ�ĵ�ַ
			adress = adressimpl.selectAdressById(userid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// ��form���õ�����������(�õ������ݸ�ʽΪid-num������1-5,2-8)
		String Order_mes = form.getOrder_mes();
		// �жϣ�û�о���ת����¼ע��ҳ��
		if (obj == null) {
			return new ActionForword("zhuce.do");
		} else {
			if (Order_mes != null) {
				// ����,�ŷָ��ַ���
				String[] mes = Order_mes.split(",");
				for (String mesgString : mes) {
					String goods_id = mesgString.split("-")[0];
					String number = mesgString.split("-")[1];
					try {
						// �õ���goods_id�������ݿ��ѯ�õ�Goods����
						Goods goods = goodsimpl.selectByGoodsId(Integer
								.parseInt(goods_id));
						String price = goods.getGoodsprice().replace(",", "");
						goods.setGoodsprice(price);
						// �õ���Goods������goodslist������
						map.put(goods, number);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				request.setAttribute("map", map);
				request.setAttribute("adress", adress);
				request.setAttribute("Order_mes", Order_mes);
			}
		}
		// ת��������ҳ
		return new ActionForword("kqx-dingdan");
	}
}

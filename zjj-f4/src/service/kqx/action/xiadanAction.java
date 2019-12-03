package service.kqx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.kqx.form.xiadanForm;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;
import dao.daoimpl.Userdaoimpl;
import dto.UserLoginInfo;

public class xiadanAction extends Action {

	/**
	 * ����һ���µ��߼�
	 */
	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("xiadan");
		xiadanForm form = (xiadanForm) actionForm;
		UserLoginInfo uslf = (UserLoginInfo) request.getSession().getAttribute(
				"userlogininfo");
		Userdaoimpl usim = DaoimplFactory.getUserdaoimpl();
		Goodsdaoimpl goodim = DaoimplFactory.getGoodsdaoimpl();
		PrintWriter out = response.getWriter();
		if (uslf == null) {// ���û�е�¼
			System.out.println("������û��¼");
			out.print("unlogin");
			out.flush();
			return null;
		}

		User us;
		try {
			us = usim.selectByUserId(uslf.getUserid());
			String status = form.getStatus(); // �õ���һ��ҳ�洫����״̬
			String goods = form.getGoods_id();// �õ���һ��ҳ�洫����goods_id����
			// ���
			StringTokenizer stt = new StringTokenizer(goods, "-");
			String goodsid = stt.nextToken();
			StringTokenizer shopping = new StringTokenizer(
					us.getUsershopping(), "-");
			if ("go".equals(status)) {
				return new ActionForword("gouwudai.do", true);
			}
			if ("addcart".equals(status)) {
				while (shopping.hasMoreTokens()) {// �����Ʒ�Ѿ������ڹ��ﳵ���� ��ֱ��ȥ���ﳵ
					if (shopping.nextToken().equals(goodsid)) {
						out.print("false");
						out.flush();
						return null;
					}
				}
				out.print("true");
				out.flush();//
			}
			if ("buy".equals(status)) {
				while (shopping.hasMoreTokens()) {// �����Ʒ�Ѿ������ڹ��ﳵ���� ��ֱ��ȥ���ﳵ
					if (shopping.nextToken().equals(goodsid)) {
						out.print("true");
						out.flush();
						return null;
					}
				}
				out.print("true");
				out.flush();//
			}

			System.out.println(us.getUsershopping() + "+�µ���������id+" + goodsid);
				us.setUsershopping("-"+goodsid + us.getUsershopping());// ���빺�ﳵ����
				usim.updateUser(us);// �����º���û���Ϣ����

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

package service.kqx.action;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;
import dao.daoimpl.Userdaoimpl;
import dto.UserLoginInfo;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.kqx.form.xiadanForm;

public class xiadanAction extends Action{

		/**
		 * ����һ���µ��߼�ҳ��
		 */
	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		xiadanForm form= (xiadanForm)actionForm;
		UserLoginInfo uslf = (UserLoginInfo) request.getSession().getAttribute("userlogininfo");
		Userdaoimpl usim = DaoimplFactory.getUserdaoimpl();
		Goodsdaoimpl goodim = DaoimplFactory.getGoodsdaoimpl();
		User us;
		try {
			us = usim.selectByUserId(uslf.getUserid());
			String status=form.getStatus();//�õ���һ��ҳ�洫����״̬
			String goods=form.getGoods_id();//�õ���һ��ҳ�洫����goods_id����
			
			//����õ�goods_id
			StringTokenizer stt=new StringTokenizer(goods,"-");
			String goodsid=stt.nextToken();
			
					System.out.println("��������Ʒ�µ�");
			StringTokenizer shopping=new StringTokenizer(us.getUsershopping(),"-");
			while(shopping.hasMoreTokens()){//�����Ʒ�Ѿ������ڹ��ﳵ���� ��ֱ��ȥ���ﳵ
				if(shopping.nextToken().equals(goodsid)){
					System.out.println("��Ʒ�Ѵ���");
					return new ActionForword("kqx-xiangqing",true);
				}
			}
			System.out.println(us.getUsershopping()+"+�µ���������id+"+goodsid);
			us.setUsershopping(goodsid+"-"+us.getUsershopping());//���빺�ﳵ����
			usim.updateUser(us);//�����º���û���Ϣ����
			if("addCart".equals(status)){
				return new ActionForword("kqx-xiangqing",true);
			}
			if("buy".equals(status)){
				System.out.println("��������������"+goodsid);
				return new ActionForword("gouwudai.do",true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

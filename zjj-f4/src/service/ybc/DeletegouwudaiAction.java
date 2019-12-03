package service.ybc;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import dao.daoimpl.Userdaoimpl;
import dto.UserLoginInfo;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;

public class DeletegouwudaiAction extends Action{

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ҵ���ǰ�û�
		UserLoginInfo uslf=	(UserLoginInfo)request.getSession().getAttribute("userlogininfo");
		Userdaoimpl usim= new Userdaoimpl();
		User us=null;
		try {
		us=	usim.selectByUserId(uslf.getUserid());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ó�Ҫɾ������Ʒid
		DeletegouwudaiForm form=(DeletegouwudaiForm)actionForm;
		String goodsid=form.getGoods_id();
		System.out.println(goodsid);
		//�ó��û��Ĺ��ﳵ
		String reg="(-[";
		for (int i = 0; i < goodsid.length(); i++) {
			if(i!=goodsid.length()-1){
				reg=reg+goodsid.charAt(i)+"][";
			}else{
				reg=reg+goodsid.charAt(i)+"])";
			}
			
		}
		response.getWriter().write("true");
		System.out.println("������ʽΪ"+reg);
		us.setUsershopping(us.getUsershopping().replaceAll(reg, ""));
		try {
			usim.updateUser(us);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

package service.wkr.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import dao.daoimpl.Userdaoimpl;
import dto.UserLoginInfo;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;
import service.wkr.form.LoginActionForm;

public class LoginAction extends Action {

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		//��ת��
		ActionForword afor = null;
		
		//����
		LoginActionForm af = (LoginActionForm)actionForm;
		System.out.println(af);
		//userlogininfo��
		UserLoginInfo userlogininfo = new UserLoginInfo();
		//userdaoimpl��
		Userdaoimpl userdao = new Userdaoimpl();
		User user = null;
		try {
			//�����ֻ��Ų���user����userlogininfo������userid��username
			if (af.getLoginShoujihao()==null) {
				afor = new ActionForword("wkr-zhuce", true);
				return afor;
			}
			user = userdao.selectByUserName(af.getLoginShoujihao());
			if (user==null) {
				System.out.println("û������˺���");
				user = userdao.selectByUserPhone(af.getLoginShoujihao());
				if (user==null) {
					System.out.println("û������û�");
					return null;
				}
			}
			if (!user.getUserpass().equals(af.getLoginPassword())) {
				System.out.println("�������");
				return null;
			}
			userlogininfo.setUserid(user.getUserid());
			userlogininfo.setUsername(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//��userlogininfo������ip��ַ��ʱ��
		userlogininfo.setIp(request.getLocalAddr());
		userlogininfo.setLogindate(new Date());
		
		//��userlogininfo����session��
		HttpSession session = request.getSession();
		session.setAttribute("userlogininfo", userlogininfo);
		
		//��ù�����ҳ��
		String uri = (String)session.getAttribute("nowPage");
		System.out.println("uri�ǣ�"+uri);
		//����Ǵ�����ҳ������
		Integer goods_id = (Integer)session.getAttribute("goods");
		if (goods_id!=null) {
			afor = new ActionForword(uri+"?goods_id="+goods_id, true);
			return afor;
		}
		//����Ǵ���ͨ����Ҫ��¼��ҳ�������
		afor = new ActionForword(uri,true);
		return afor;
		// TODO Auto-generated method stub
		
	}

}

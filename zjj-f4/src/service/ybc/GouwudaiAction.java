package service.ybc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Goods;
import pojo.User;
import dao.daoimpl.DaoimplFactory;
import dao.daoimpl.Goodsdaoimpl;
import dao.daoimpl.Userdaoimpl;
import dto.UserLoginInfo;
import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;

public class GouwudaiAction extends Action{

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		// ����������е�userid
		request.getParameter("goods_id");
		HttpSession session =request.getSession();
		Object obj=session.getAttribute("userlogininfo");
		if(obj==null){
			//���û�е�¼ ����ת��ע��ҳ��
			return new ActionForword("zhuce.do",true);
		}else{
			//�����½��,�Ͳ�����ﳵ�ڵ���Ʒ��Ϣ
			UserLoginInfo uslf=	(UserLoginInfo)obj;
			Userdaoimpl usim=DaoimplFactory.getUserdaoimpl();
			Goodsdaoimpl goodim=DaoimplFactory.getGoodsdaoimpl();
			try {
				List<Goods> list=new ArrayList<Goods>();
				User us=usim.selectByUserId(uslf.getUserid());
				//��Ϊ�û��Ĺ����ǰ��� id-id-id... �����е� ����������ָ�һ��
				StringTokenizer st=new StringTokenizer(us.getShopping(),"-");
				while(st.hasMoreTokens()){
					int goodsid=Integer.parseInt(st.nextToken());
					list.add(goodim.selectByGoodsId(goodsid));
				}
				request.setAttribute("shoppinglist", list);
				return new ActionForword("ybc-gouwudai");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}

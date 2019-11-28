package web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import dto.UserLoginInfo;

public class YbcSessionListener implements HttpSessionAttributeListener{
	
	Map<Integer , HttpSession> map=new HashMap();
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//��õ�ǰ��ӵ�������
		String attrname=arg0.getName();
		//����ǵ�½����
		if(attrname.equals("userlogininfo")){
			System.out.println("���˼����¼�");
			//��õ�ǰ��½��Ϣ
			UserLoginInfo userlogininfo =(UserLoginInfo)arg0.getValue();
			//����������ط���½����
			if(map.get(userlogininfo.getUserid())!=null){
				//�ó��ɵ�session
				System.out.println("�жϳ��ظ���½��");
				HttpSession session=map.get(userlogininfo.getUserid());
				//�Ƴ��ɵ�½״̬����ʾ
				session.removeAttribute("userlogininfo");	
				String msg ="�����˺���"+userlogininfo.getIp()+" "+userlogininfo.getLogindate().getDate()+"��½";
				session.setAttribute("msg", msg);
			}
			//����ǰ��½��Ϣ������ 
			map.put(userlogininfo.getUserid(), arg0.getSession());
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//�������Ա��Ƴ�ʱ��һ���ǲ���userlogininfo
		String attrname=arg0.getName();
		if(attrname.equals("userlogininfo")){
			UserLoginInfo userlogininfo =(UserLoginInfo)arg0.getValue();
			map.remove(userlogininfo.getUserid());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//�ó����滻����������һ���ǲ���userlogininfo
		String attrname=arg0.getName();
		if(attrname.equals("userlogininfo")){
			System.err.println("�������Ƴ��¼�");
			//�ȰѾɵ��Ƴ�
			UserLoginInfo olduserlogininfo =(UserLoginInfo)arg0.getValue();
			map.remove(olduserlogininfo.getUserid());
			//����µĵ�½��Ϣ
			UserLoginInfo	userlogininfo=(UserLoginInfo)arg0.getSession().getAttribute("userlogininfo");
			//�ٿ����µ���û���������ط���½��
			if(map.get(userlogininfo.getUserid())!=null){
				//�����
				//�ó������ط���½��session
				HttpSession session=map.get(userlogininfo.getUserid());
				//�Ƴ������ط���½״̬����ʾ
				session.removeAttribute("userlogininfo");	
				String msg ="�����˺���"+userlogininfo.getIp()+" "+userlogininfo.getLogindate().getDate()+"��½";
				session.setAttribute("msg", msg);
			}
			map.put(userlogininfo.getUserid(), arg0.getSession());
		}
	}

}

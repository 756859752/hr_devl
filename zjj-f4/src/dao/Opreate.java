package dao;

import java.util.List;

import pojo.Goods;
import pojo.User;

public interface Opreate {
	
	/***
	 * ��ϸ����
	 */
    //��ҳ������Ʒ��Ϣ
	public List<Goods> goodsShow(int page, int pagesize);
	
	//��ҳ�����շ�����������Ʒ��Ϣ
	public List<Goods> cateShow(int cate_id, int page, int pagesize);
	
	//��֤��¼��Ϣ
	public boolean login(String name, String password);
	
	//��֤ע���˺��Ƿ����
	public boolean register_compare(String name);
	
	//����ע���˺�
	public boolean insertUser(User user) ;
	
	//���빺�ﳵ����Ʒ��ID
	public boolean insert_shopid(int user_id, int shop_id);
	
	//�����û��Ĺ��ﳵ����Ʒ��id
	public int[] select_shopid(int user_id);
	
	//���ݹ��ﳵ����Ʒ��id��������Ʒ
	public Goods selectGoods_shopid(int shop_id);
	
	//���ݹؼ��֣�������
	public List<Goods> search(String name);
	
	/***
	 * ��ͳ��ɾ�Ĳ� user ��
	 */
	public boolean insert_User(User user);
	public boolean delete_User(User user);
	public boolean update_User(User user);
	public User select_User(User user);
	public List<User> selectALL_User(User user);
	
	/***
	 * ��ͳ��ɾ�Ĳ� goods ��
	 */
	public boolean insert_Goods(Goods user);
	public boolean delete_Goods(Goods user);
	public boolean update_Goods(Goods user);
	public User select_Goods(Goods user);
	public List<User> selectALL_Goods(Goods user);
	
	
	
}

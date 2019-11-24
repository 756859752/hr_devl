package dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Goods;
import pojo.User;
import dao.Opreate;
import db.Load_sql;

public class Sql_opreate implements Opreate {

	@Override
	public List<Goods> goodsShow(int page, int pagesize) {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<>();
	   Connection  cc=Load_sql.jiazai();
	      String sql="select * from //? limit ?,? ";
	      try {
	    	  PreparedStatement pp;
			pp = cc.prepareStatement(sql);
			pp.setInt(1, page*pagesize);
			pp.setInt(2, pagesize);
		ResultSet rSet= 	pp.executeQuery();
		 while (rSet.next()) {
			Goods goods=new Goods();
			//goodsset
			list.add(goods);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     finally{
					 Load_sql.myclose(cc);
	     }
	   return list;
	}

	@Override
	public List<Goods> cateShow(int cate_id, int page, int pagesize) {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<>();
		   Connection  cc=Load_sql.jiazai();
		      String sql="select * from //? where cate_id=? limit ?,? ";
		      try {
		    	  PreparedStatement pp;
				pp = cc.prepareStatement(sql);
				pp.setInt(1, cate_id);
				pp.setInt(2, page*pagesize);
				pp.setInt(3, pagesize);
			ResultSet rSet= 	pp.executeQuery();
			 while (rSet.next()) {
				Goods goods=new Goods();
				//goodsset
				list.add(goods);
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     finally{
						 Load_sql.myclose(cc);
		     }
		   return list;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		Connection  cc=Load_sql.jiazai();
	      String sql="select * from //? where name=? password=?";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setString(1, name);
				pp.setString(2, password);
				
				ResultSet rSet= 	pp.executeQuery();
				if (rSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return false;
	}

	@Override
	public boolean register_compare(String name) {
		// TODO Auto-generated method stub
		Connection  cc=Load_sql.jiazai();
	      String sql="select * from //? where name=? ";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setString(1, name);
				
				
				ResultSet rSet= 	pp.executeQuery();
				if (rSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return false;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		Connection  cc=Load_sql.jiazai();
	      String sql="insert into //?(name,pass....) value(?,?,?,?...)";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setObject(1, user);
				pp.setObject(1, user);
				pp.setObject(1, user);
				pp.setObject(1, user);
				pp.setObject(1, user);
				
				
				int i= 	pp.executeUpdate();
				if (i<=0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return false;
	}

	@Override
	public boolean insert_shopid(int user_id, int shop_id) {
		// TODO Auto-generated method stub
		Connection  cc=Load_sql.jiazai();
	      String sql="insert into //?(shop_id) value(?) where id=?";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setObject(1, user_id);
				pp.setObject(2,shop_id );
				
				
				
				int i= 	pp.executeUpdate();
				if (i<=0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return false;
	}

	@Override
	public int[] select_shopid(int user_id) {
		// TODO Auto-generated method stub
		int [] id = null;
		Connection  cc=Load_sql.jiazai();
	      String sql="select *shop_id* from //? where user_id=? ";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setInt(1, user_id);
				ResultSet rSet= 	pp.executeQuery();
				if (rSet.next()) {
				String oldString=	 rSet.getString("shop_id");
				   if (oldString.indexOf(",")!=-1) {
					String [] news=  oldString.split(",");
					for (int i = 0; i < news.length; i++) {
						id[i]=Integer.valueOf(news[i]) ;
					}
				   }
				   else {
					id[0]=Integer.valueOf(oldString);
				   }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return id;
	}
	

	@Override
	public Goods selectGoods_shopid(int shop_id) {
		// TODO Auto-generated method stub
		Goods  goods=new Goods();
		Connection  cc=Load_sql.jiazai();
	      String sql="select * from //? where shop_id=? ";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setInt(1, shop_id);
				 
				
				ResultSet rSet= 	pp.executeQuery();
				if (rSet.next()) {
					//goods set���ԣ�
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return goods;
		
	}

	@Override
	public List<Goods> search(String name) {
		// TODO Auto-generated method stub
		List<Goods> list =new ArrayList<>();
		Connection  cc=Load_sql.jiazai();
	      String sql="select * from //? where desc(����) like %?% ";
	     
	    	  PreparedStatement pp;
			try {
				pp = cc.prepareStatement(sql);
				pp.setString(1, name);
				 
				
				ResultSet rSet= 	pp.executeQuery();
				while(rSet.next()) {
				Goods goods=new Goods();
				//good set����
				list.add(goods);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Load_sql.myclose(cc);
			}
			return list;
	
	}

	@Override
	public boolean insert_User(User user) {
		// TODO Auto-generated method stub		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="insert into user_imformation(�˺�,����,�Ա�,����,��������,���˼���) values(?,?,?,?,?,?)";
	      try {
		PreparedStatement ppst=	ccConnection.prepareStatement(sql);
		
		ppst.setString(1, user.getZhanghao());
		ppst.setString(2, user.getMima());
		ppst.setString(3, user.getSex());
		ppst.setString(4, user.getAihao());
		ppst.setDate(5, user.getBirth());
		ppst.setString(6, user.getGerenjianli());
		
	int n=	ppst.executeUpdate();
	if (n>0) {
		return true;
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
	    


			
		
		return false;
	}

	@Override
	public boolean delete_User(User user) {
		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="delete from user_imformation where id=?";
		PreparedStatement ppst;
		try {
			ppst = ccConnection.prepareStatement(sql);
			ppst.setInt(1, user.getId());
			
			int n=	ppst.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		return false;
	}

	@Override
	public boolean update_User(User user) {
		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="update user_imformation set  �˺�=? ����=? �Ա�=? ����=? ��������=? ���˼���=? where id=?";
	      try {
		PreparedStatement ppst=	ccConnection.prepareStatement(sql);
		
		ppst.setString(1, user.getZhanghao());
		ppst.setString(2, user.getMima());
		ppst.setString(3, user.getSex());
		ppst.setString(4, user.getAihao());
		ppst.setDate(5, user.getBirth());
		ppst.setString(6, user.getGerenjianli());
		ppst.setInt(7, user.getId());
	int n=	ppst.executeUpdate();
	if (n>0) {
		return true;
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		return false;
		
	}

	@Override
	public User select_User(User user) {
		// TODO Auto-generated method stub
		 User aUser=new User();
		Connection ccConnection=Load_sql.jiazai();
	    String sql="select *from user_imformation where id=?";
		PreparedStatement ppst;
		try {
			ppst = ccConnection.prepareStatement(sql);
			ppst.setInt(1,user.getUserid());
			ResultSet aResultSet=	ppst.executeQuery();
			if (aResultSet.next()) {
				
				aUser.setId(aResultSet.getInt("id"));
				aUser.setZhanghao(aResultSet.getString("�˺�"));
				aUser.setMima(aResultSet.getString("����"));
				aUser.setSex(aResultSet.getString("�Ա�"));
				aUser.setAihao(aResultSet.getString("����"));
				aUser.setBirth(aResultSet.getDate("��������"));
				aUser.setGerenjianli(aResultSet.getString("���˼���"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		
		return aUser;
	}

	@Override
	public List<User> selectALL_User(User user) {
		// TODO Auto-generated method stub
		 List<User> list=new ArrayList<>();
			Connection ccConnection=Load_sql.jiazai();
		    String sql="select *from user_imformation where id=?";
			PreparedStatement ppst;
			try {
				ppst = ccConnection.prepareStatement(sql);
				ppst.setInt(1,user.getUserid());
				ResultSet aResultSet=	ppst.executeQuery();
				if (aResultSet.next()) {
					 User aUser=new User();
					aUser.setId(aResultSet.getInt("id"));
					aUser.setZhanghao(aResultSet.getString("�˺�"));
					aUser.setMima(aResultSet.getString("����"));
					aUser.setSex(aResultSet.getString("�Ա�"));
					aUser.setAihao(aResultSet.getString("����"));
					aUser.setBirth(aResultSet.getDate("��������"));
					aUser.setGerenjianli(aResultSet.getString("���˼���"));
					list.add(aUser);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
		    	  Load_sql.myclose(ccConnection);
		    	  
		      }
			
			return list;
	}

	@Override
	public boolean insert_Goods(Goods user) {
		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="insert into user_imformation(�˺�,����,�Ա�,����,��������,���˼���) values(?,?,?,?,?,?)";
	      try {
		PreparedStatement ppst=	ccConnection.prepareStatement(sql);
		
		ppst.setString(1, user.getZhanghao());
		ppst.setString(2, user.getMima());
		ppst.setString(3, user.getSex());
		ppst.setString(4, user.getAihao());
		ppst.setDate(5, user.getBirth());
		ppst.setString(6, user.getGerenjianli());
		
	int n=	ppst.executeUpdate();
	if (n>0) {
		return true;
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
	    


			
		return false;
	}

	@Override
	public boolean delete_Goods(Goods user) {
		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="delete from user_imformation where id=?";
		PreparedStatement ppst;
		try {
			ppst = ccConnection.prepareStatement(sql);
			ppst.setInt(1, user.getId());
			
			int n=	ppst.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		return false;
	}

	@Override
	public boolean update_Goods(Goods user) {
		// TODO Auto-generated method stub
		Connection ccConnection=Load_sql.jiazai();
	    String sql="update user_imformation set  �˺�=? ����=? �Ա�=? ����=? ��������=? ���˼���=? where id=?";
	      try {
		PreparedStatement ppst=	ccConnection.prepareStatement(sql);
		
		ppst.setString(1, user.getZhanghao());
		ppst.setString(2, user.getMima());
		ppst.setString(3, user.getSex());
		ppst.setString(4, user.getAihao());
		ppst.setDate(5, user.getBirth());
		ppst.setString(6, user.getGerenjianli());
		ppst.setInt(7, user.getId());
	int n=	ppst.executeUpdate();
	if (n>0) {
		return true;
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		return false;
	}

	@Override
	public User select_Goods(Goods user) {
		 User aUser=new User();
			Connection ccConnection=Load_sql.jiazai();
		    String sql="select *from user_imformation where id=?";
			PreparedStatement ppst;
			try {
				ppst = ccConnection.prepareStatement(sql);
				ppst.setInt(1,user.getUserid());
				ResultSet aResultSet=	ppst.executeQuery();
				if (aResultSet.next()) {
					
					aUser.setId(aResultSet.getInt("id"));
					aUser.setZhanghao(aResultSet.getString("�˺�"));
					aUser.setMima(aResultSet.getString("����"));
					aUser.setSex(aResultSet.getString("�Ա�"));
					aUser.setAihao(aResultSet.getString("����"));
					aUser.setBirth(aResultSet.getDate("��������"));
					aUser.setGerenjianli(aResultSet.getString("���˼���"));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
		    	  Load_sql.myclose(ccConnection);
		    	  
		      }
			
			return aUser;
	}

	@Override
	public List<User> selectALL_Goods(Goods user) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<>();
		Connection ccConnection=Load_sql.jiazai();
	    String sql="select *from user_imformation where id=?";
		PreparedStatement ppst;
		try {
			ppst = ccConnection.prepareStatement(sql);
			ppst.setInt(1,user.getUserid());
			ResultSet aResultSet=	ppst.executeQuery();
			if (aResultSet.next()) {
				 User aUser=new User();
				aUser.setId(aResultSet.getInt("id"));
				aUser.setZhanghao(aResultSet.getString("�˺�"));
				aUser.setMima(aResultSet.getString("����"));
				aUser.setSex(aResultSet.getString("�Ա�"));
				aUser.setAihao(aResultSet.getString("����"));
				aUser.setBirth(aResultSet.getDate("��������"));
				aUser.setGerenjianli(aResultSet.getString("���˼���"));
				list.add(aUser);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
	    	  Load_sql.myclose(ccConnection);
	    	  
	      }
		
		return list;
	}

}

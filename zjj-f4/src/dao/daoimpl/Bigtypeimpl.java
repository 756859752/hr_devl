package dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Bigtype;
import pojo.Goods;
import dao.Bigtypedao;
import db.ConnectionPool;

public class Bigtypeimpl implements Bigtypedao {

	@Override
	public List<Bigtype> selectALL_bigtype() {
		// TODO Auto-generated method stub
		List<Bigtype> list=new ArrayList<>();
		Connection  cc=   ConnectionPool.getConnection();
		String sql="select *from bigtype";
		PreparedStatement pp=null;
		 try {
		pp=	cc.prepareStatement(sql);
		 ResultSet rs=  pp.executeQuery();
		while (rs.next()) {
			Bigtype by=new Bigtype();
			by.setGoods_bigtype(rs.getInt("goods_bigtype"));
			by.setTypename(rs.getString("typename"));
			list.add(by);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ConnectionPool.closeConnection(cc);
		
		return list;
	}

	@Override
	public List<Goods> nameSelect(String name) {
		// TODO Auto-generated method stub
		List<Goods> list =new ArrayList<>();
		Connection cc=ConnectionPool.getConnection();
		  String sql="select *from  goods where 1=1 ";
		  
		 char [] aa=  name.toCharArray();
		 StringBuffer bbBuffer=new StringBuffer(sql);
		 for (int i = 0; i < aa.length; i++) {
			bbBuffer.append(" and goods_name like '%"+aa[i]+"%' ");
		}
		 System.out.println(bbBuffer.toString());
		    try {
			PreparedStatement pp=	cc.prepareStatement(bbBuffer.toString());
	ResultSet  rs=	  pp.executeQuery();
	while(rs.next()){
		Goods good = new Goods();
		good.setGoodsid(rs.getInt("goods_id"));
		good.setGoodsname(rs.getString("goods_name"));
		good.setGoodsimg(rs.getString("goods_img"));
		good.setGoodsprice(rs.getString("goods_price"));
		good.setGoodstype(rs.getString("goods_type"));
		good.setGoodsdesc(rs.getString("goods_desc"));
		good.setGoodsbigtype(rs.getInt("goods_bigtype"));
		good.setGoodssmalltype(rs.getInt("goods_smalltype"));
		good.setGoodscolor(rs.getInt("goods_color"));
		good.setGoodsmaterial(rs.getInt("goods_material"));
		list.add(good);
	}
	return list;
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		return null;
	}

}
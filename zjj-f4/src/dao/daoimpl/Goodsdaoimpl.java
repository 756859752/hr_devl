package dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojo.Color;
import pojo.Goods;
import pojo.Material;
import pojo.Smalltype;
import dao.Goodsdao;
import db.ConnectionPool;

public class Goodsdaoimpl implements Goodsdao {

	@Override
	public void insert(Goods good) throws Exception {
		// TODO Auto-generated method stub
		// Connection conn =ConnectionPool.getConnection();
		// String sql="insert into goods(goods_name,goods_img,goods_price)"
	}

	@Override
	public void delete(Goods good) throws Exception {
		// TODO Auto-generated method stub
		// Connection conn =ConnectionPool.getConnection();
		// String sql="insert into goods(goods_name,goods_img,goods_price)"

	}

	@Override
	public void update(Goods good) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Goods selectByGoodsId(int id) throws Exception {// ����Ʒid��ѯ
		// TODO Auto-generated method stub
		Goods good = null;
		Connection conn = ConnectionPool.getConnection();
		String sql = "select * from goods where goods_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			rs.next();
			good = new Goods();
			good.setGoodsid(id);
			good.setGoodsname(rs.getString("goods_name"));
			good.setGoodsimg(rs.getString("goods_img"));
			good.setGoodsprice(rs.getString("goods_price"));
			good.setGoodstype(rs.getString("goods_type"));
			good.setGoodsdesc(rs.getString("goods_desc"));
			good.setGoodsbigtype(rs.getInt("goods_bigtype"));
			good.setGoodssmalltype(rs.getInt("goods_smalltype"));
			good.setGoodscolor(rs.getInt("goods_color"));
			good.setGoodsmaterial(rs.getInt("goods_material"));
		}
		ConnectionPool.closeConnection(conn);
		return good;
	}

	@Override
	public List<Goods> selectByGoodsBigtype(int type) throws Exception {// �������Ͳ�ѯ
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = ConnectionPool.getConnection();
		String sql = "select * from goods where goods_bigtype=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, type);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
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
		}
		ConnectionPool.closeConnection(conn);
		return list;
	}

	@Override
	public List<Goods> selectByGoodsSmalltype(int type) throws Exception {// ��С���Ͳ�ѯ
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = ConnectionPool.getConnection();
		String sql = "select * from goods where goods_smalltype=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, type);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
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
		}
		ConnectionPool.closeConnection(conn);
		return list;
	}

	@Override
	public List<Goods> selectAll(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> selectByGoodsDesc(String desc, int num)throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = ConnectionPool.getConnection();
		
		//׼��sql���
		String sql = "select * from goods where 1=1 ";
		
		//�ó����ʷ���
		Materialdaoimpl matim=new Materialdaoimpl();
		 List<Material> matims= matim.selectAll();
		 Iterator<Material> itmat= matims.iterator();
		 while(itmat.hasNext()){
			 Material mat= itmat.next();
			 if(desc.indexOf(mat.getMaterialname())>=0){
				 String st=" and goods_material="+mat.getMaterialid();
					sql+=st;
			 }
		 }
		 //�ó���ɫ����
		 Colordaoimpl colorim=new Colordaoimpl();
		 List<Color> colors= colorim.selectAll();
		 Iterator<Color> itcolor= colors.iterator();
		 while(itcolor.hasNext()){
			 Color color= itcolor.next();
			 if(desc.indexOf(color.getColor_name())>=0){
				 String st=" and goods_color="+color.getColor_id();
					sql+=st;
			 }
		 }
		//�ó���Ʒ�ַ���
		
		Smalltypeimpl smim=new Smalltypeimpl();
		List<Smalltype> sms=smim.selectAll();
		Iterator<Smalltype> it=sms.iterator();
		while(it.hasNext()){
			Smalltype sm=it.next();
			if(desc.indexOf(sm.getSmalltypename())>=0){//�������ؼ���
				String st=" and goods_smalltype="+sm.getSmalltypeid();
				sql+=st;
			}
		}
		//����� �����Ů��
		int flagman=0;
		int flagwoman=0;
		if(desc.indexOf("��")>=0){
			 flagman++;
			sql+=" and goods_bigtype=2 ";
		}
		if(desc.indexOf("Ů")>=0){
			 flagwoman++;
			sql+=" and goods_bigtype=1 ";
		}
		if(flagman==1&&flagwoman==1){//�����Ů���� �Ͷ�ȥ��
			sql.replace(" and goods_bigtype=2 ", "");
			sql.replace(" and goods_bigtype=1 ", "");
		}
		System.out.println(sql);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
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
	}

}

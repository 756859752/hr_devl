package dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import JSON.paixuOBJ;
import pojo.Color;
import pojo.Goods;
import pojo.Liebie;
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

	public paixuOBJ selectByGoodsSmalltype(int bigtype, int smalltype,int page,int pagesize)
			throws Exception {
		Connection conn = ConnectionPool.getConnection();
		
		List<Goods> list1=new ArrayList<>();
		String sql1 = "select * from goods where  goods_bigtype=?  and goods_smalltype=?  ";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		ps1.setInt(1, bigtype);
		ps1.setInt(2, smalltype);
		ps1.setInt(3, page*pagesize);
		ps1.setInt(4, pagesize);
		ResultSet rs1 = ps1.executeQuery();
		if (rs1 != null) {
			while (rs1.next()) {
				Goods good = new Goods();
				good.setGoodsid(rs1.getInt("goods_id"));
				good.setGoodsname(rs1.getString("goods_name"));
				good.setGoodsimg(rs1.getString("goods_img"));
				good.setGoodsprice(rs1.getString("goods_price"));
				good.setGoodstype(rs1.getString("goods_type"));
				good.setGoodsdesc(rs1.getString("goods_desc"));
				good.setGoodsbigtype(rs1.getInt("goods_bigtype"));
				good.setGoodssmalltype(rs1.getInt("goods_smalltype"));
				good.setGoodscolor(rs1.getInt("goods_color"));
				good.setGoodsmaterial(rs1.getInt("goods_material"));
				list1.add(good);
			}
		}
		List<String> cm=new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getGoodsmaterial()==1) {
				cm.add("m-1");
	}
			if (list1.get(i).getGoodsmaterial()==2) {
				cm.add("m-2");
			}
			if (list1.get(i).getGoodsmaterial()==3) {
				cm.add("m-3");
			}
			if (list1.get(i).getGoodsmaterial()==4) {
				cm.add("m-4");
			}
			if (list1.get(i).getGoodsmaterial()==5) {
				cm.add("m-5");
			}
			if (list1.get(i).getGoodsmaterial()==6) {
				cm.add("m-6");
			}
			if (list1.get(i).getGoodsmaterial()==7) {
				cm.add("m-7");
			}
			if (list1.get(i).getGoodsmaterial()==8) {
				cm.add("m-8");
			}
			if (list1.get(i).getGoodsmaterial()==9) {
				cm.add("m-8");
			}
			if (list1.get(i).getGoodsmaterial()==10) {
				cm.add("m-10");
			}
			if (list1.get(i).getGoodsmaterial()==11) {
				cm.add("m-11");
			}
			if (list1.get(i).getGoodscolor()==1) {
				cm.add("c-1");
			}
			if (list1.get(i).getGoodscolor()==2) {
				cm.add("c-2");
			}
			
			if (list1.get(i).getGoodscolor()==3) {
				cm.add("c-3");
			}
			if (list1.get(i).getGoodscolor()==4) {
				cm.add("c-4");
			}
			
			if (list1.get(i).getGoodscolor()==5) {
				cm.add("c-5");
			}
			if (list1.get(i).getGoodscolor()==6) {
				cm.add("c-6");
			}
			
			if (list1.get(i).getGoodscolor()==7) {
				cm.add("c-7");
			}
			if (list1.get(i).getGoodscolor()==8) {
				cm.add("c-8");
			}
			
			if (list1.get(i).getGoodscolor()==9) {
				cm.add("c-9");
			}
			if (list1.get(i).getGoodscolor()==10) {
				cm.add("c-10");
			}
			
			if (list1.get(i).getGoodscolor()==11) {
				cm.add("c-11");
			}
			if (list1.get(i).getGoodscolor()==12) {
				cm.add("c-12");
			}
			
			if (list1.get(i).getGoodscolor()==13) {
				cm.add("c-13");
			}
			if (list1.get(i).getGoodscolor()==14) {
				cm.add("c-14");
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		List<Goods> list = new ArrayList<Goods>();
		
		String sql = "select * from goods where  goods_bigtype=?  and goods_smalltype=? limit ?,? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bigtype);
		ps.setInt(2, smalltype);
		ps.setInt(3, page*pagesize);
		ps.setInt(4, pagesize);
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
		paixuOBJ obj=new paixuOBJ();
		obj.setCm(cm);
		obj.setList(list);
		return obj;
	}

	@Override
	public List<Goods> selectByGoodsSmalltype(int bigtype, int smalltype,
			int page, int pagesize, String[] list) throws Exception {
		int count_color=0;
		int count_type=0;
		
		StringBuffer aBuffer=new StringBuffer("select * from goods where  goods_bigtype=?  and goods_smalltype=?  ");
		StringBuffer colorBuffer=new StringBuffer("(");
		StringBuffer typeBuffer=new StringBuffer("("); 
		for (String string : list) {
			  int i= string.indexOf("-");
			String hear=   string.substring(0,i);
			String tail= string.substring(i+1);
			if ("15".equals(hear)) {
				count_color++;
				colorBuffer.append(" goods_color="+tail+" or");
				
			}
			if("12".equals(hear))
			{
				count_type++;
			typeBuffer.append(" goods_material="+tail+" or");
				
				
			}
		} 
		
		
		if (count_color!=0) {
		String color=	colorBuffer.toString().substring(0,colorBuffer.toString().length()-3);
			aBuffer.append(" and "+color+")");
		}
		if (count_type!=0) {
			String type=	typeBuffer.toString().substring(0,typeBuffer.toString().length()-3);
			aBuffer.append(" and "+type+")");
		}
		aBuffer.append(" limit ?,?");
		System.out.println(aBuffer.toString());
		List<Goods> lists = new ArrayList<Goods>();
		Connection conn = ConnectionPool.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(aBuffer.toString());
		ps.setInt(1, bigtype);
		ps.setInt(2, smalltype);
		ps.setInt(3, page*pagesize);
		ps.setInt(4, pagesize);
		ResultSet rs = ps.executeQuery();
		
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
				lists.add(good);
			}
	
		ConnectionPool.closeConnection(conn);
		return lists;
		
	}

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
		//��ɫ
		
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

	@Override
	public List<Goods> selectByGoodsDesc(String desc, int num, String[] list)
			throws Exception {
		List<Goods> lists = new ArrayList<Goods>();
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
		
		//��ɫ�Ͳ��ʲ�ѯ
		int count_color=0;
		int count_type=0;
		
		StringBuffer aBuffer=new StringBuffer(sql);
		StringBuffer colorBuffer=new StringBuffer("(");
		StringBuffer typeBuffer=new StringBuffer("("); 
		for (String string : list) {
			  int i= string.indexOf("-");
			String hear=   string.substring(0,i);
			String tail= string.substring(i+1);
			if ("15".equals(hear)) {
				count_color++;
				colorBuffer.append(" goods_color="+tail+" or");
				
			}
			if("12".equals(hear))
			{
				count_type++;
			typeBuffer.append(" goods_material="+tail+" or");
				
				
			}
		} 
		
		
		if (count_color!=0) {
		String color=	colorBuffer.toString().substring(0,colorBuffer.toString().length()-3);
			aBuffer.append(" and "+color+")");
		}
		if (count_type!=0) {
			String type=	typeBuffer.toString().substring(0,typeBuffer.toString().length()-3);
			aBuffer.append(" and "+type+")");
		}
		
		System.out.println(aBuffer.toString());
		
		PreparedStatement ps = conn.prepareStatement(aBuffer.toString());
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
			lists.add(good);
		}
		
		return lists;

	}

	@Override
	public List<Liebie> selectByGoodsSmalltype(int bigtype, int smalltype)
			throws Exception {
		List<Liebie> list = new ArrayList<Liebie>();
		Connection conn = ConnectionPool.getConnection();
		String sql = "select * from liebie where  goods_bigtype=?  and goods_smalltype=?  ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bigtype);
		ps.setInt(2, smalltype);
		
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Liebie lb = new Liebie();
				lb.setLb_id(rs.getInt("lb_id"));
				lb.setGoods_bigtype(rs.getInt("goods_bigtype"));
				lb.setGoods_smalltype(rs.getInt("goods_smalltype"));
				lb.setGoods_liebie_name(rs.getString("goods_leibie_name"));
				list.add(lb);
			}
		}
		ConnectionPool.closeConnection(conn);
		return list;
		
	}

}
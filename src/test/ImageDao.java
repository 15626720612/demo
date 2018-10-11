package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pub.db.Database;

public class ImageDao {
	public List<Image> query(){
		try{
			List<Image> result=new ArrayList<Image>();
			Connection con=Database.getConnection();
			String sql="select * from imgtest";

			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String name = rs.getString("name");
				String url = rs.getString("url");
				Image img = new Image();
				img.setName(name);
				img.setUrl(url);
				result.add(img);
			}
			con.close();
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList<Image>();
	}
	
	public boolean insert(Image image){
		try{
			Connection con=Database.getConnection();
			Statement stmt=con.createStatement();
			String sql="insert into imgtest (name,url) values('"+image.getName()+"','"+image.getUrl()+"')";
			stmt.execute(sql);
			con.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
/*	public static void main(String[] args) {
		Image img = new Image();
		img.setName("1.png");
		img.setUrl("/upload/1.png");
		ImageDao dao = new ImageDao();
//		dao.insert(img);
//		System.out.println(dao.query());
		List<Image> imgs = dao.query();
		System.out.println(imgs.get(imgs.size()-1).getUrl());
		
	}*/
}

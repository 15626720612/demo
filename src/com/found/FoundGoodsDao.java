package com.found;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pub.db.Database;

public class FoundGoodsDao {
	/* 查询 */
	public List<FoundGoods> query() {
		try {
			List<FoundGoods> result = new ArrayList<FoundGoods>();
			Connection con = Database.getConnection();
			String sql = "select * from found";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				String goodsName = rs.getString("goods_name");
				String goodsCategory = rs.getString("goods_category");
				String lostTime = rs.getString("lost_time");
				String lostAddress = rs.getString("lost_address");
				String userName = rs.getString("user_name");
				String userNumber = rs.getString("user_number");
				String goodsImgUrl = rs.getString("goods_imgUrl");
				String goodsDetails = rs.getString("goods_details");

				FoundGoods foundGoods = new FoundGoods();
				foundGoods.setLostAddress(lostAddress);
				foundGoods.setLostTime(lostTime);
				foundGoods.setGoodsCategory(goodsCategory);
				foundGoods.setGoodsDetails(goodsDetails);
				foundGoods.setGoodsName(goodsName);
				foundGoods.setUserName(userName);
				foundGoods.setUserNumber(userNumber);
				foundGoods.setGoodsImgUrl(goodsImgUrl);

				result.add(foundGoods);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<FoundGoods>();
	}
	public static void main(String[] args) {
		FoundGoodsDao dao = new FoundGoodsDao();
		List<FoundGoods> foundGoodss = dao.query();
		for(FoundGoods fg:foundGoodss){
			System.out.println(fg.getGoodsName());
		}
	}
}

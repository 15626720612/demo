package com.lost;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pub.db.Database;
import test.Image;

public class LostGoodsDao {

	/* 查询 */
	public List<LostGoods> query() {
		try {
			List<LostGoods> result = new ArrayList<LostGoods>();
			Connection con = Database.getConnection();
			String sql = "select * from lost";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				String goodsName = rs.getString("goods_name");
				String goodsCategory = rs.getString("goods_category");
				String foundTime = rs.getString("found_time");
				String foundAddress = rs.getString("found_address");
				String userName = rs.getString("user_name");
				String userNumber = rs.getString("user_number");
				String goodsImageUrl = rs.getString("goods_imgUrl");
				String goodsDetails = rs.getString("goods_details");

				LostGoods lostGoods = new LostGoods();
				lostGoods.setFoundAddress(foundAddress);
				lostGoods.setFoundTime(foundTime);
				lostGoods.setGoodsCategory(goodsCategory);
				lostGoods.setGoodsDetails(goodsDetails);
				lostGoods.setGoodsName(goodsName);
				lostGoods.setUserName(userName);
				lostGoods.setUserNumber(userNumber);
				lostGoods.setGoodsImageUrl(goodsImageUrl);

				result.add(lostGoods);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<LostGoods>();
	}

	/* 插入 */
	public boolean insert(LostGoods lostGoods) {
		try {
			Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			String sql = "insert into lost (goods_name," + "goods_category,"
					+ "found_time," + "found_address," + "user_name,"
					+ "user_number," + "goods_imgeUrl," + "goods_details)"
					+ "value('" + lostGoods.getGoodsName() + "','"
					+ lostGoods.getGoodsCategory() + "','"
					+ lostGoods.getFoundTime() + "','"
					+ lostGoods.getFoundAddress() + "','"
					+ lostGoods.getUserName() + "','"
					+ lostGoods.getUserNumber() + "','"
					+ lostGoods.getGoodsImageUrl() + "','"
					+ lostGoods.getGoodsDetails() + "')";
			stmt.execute(sql);
			con.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		LostGoodsDao dao = new LostGoodsDao();
		List<LostGoods> lostGoodss = dao.query();
//		LostGoods lostGoods= new LostGoods();
		for(LostGoods lg:lostGoodss){
			System.out.println(lg.getGoodsName());
		}
	}
}

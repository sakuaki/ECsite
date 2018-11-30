package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();
	public String execute() throws SQLException{
		System.out.println("id" + session.get("id").toString());
		System.out.println("login_user_id" + session.get("login_user_id").toString());
		System.out.println("total_price" + session.get("total_price").toString());
		System.out.println("count" + session.get("count").toString());
		System.out.println("pay" + session.get("pay").toString());


		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());
		String result=SUCCESS;
		return result;
}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
package controllers.order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import library.seat.manage.dto.DeskInfo;
import library.seat.manage.dto.OrdersInfo;
import library.seat.manage.dto.PageInfo;
import library.seat.manage.dto.UserInfo;
import library.seat.manage.exception.BusinessException;
import library.seat.manage.exception.DataAccessException;
import library.seat.manage.service.IDeskService;
import library.seat.manage.service.IOrderService;
import library.seat.manage.service.IUserService;
import controllers.BaseController;

/**
 * 
 * @author mahs
 * @version 1.0
 * @created 1-1-2013 22:50:00
 */
public class Order extends BaseController {
	
	@Inject
	private static IOrderService orderService;
	
	@Inject
	private static IDeskService deskService;
	
	public static void order(int user_id, int floor, String block, int desk_num, int seat_num) {
		String result = "";
		Timestamp now = new Timestamp(new Date().getTime());
		OrdersInfo order = new OrdersInfo();
		order.setUserId(user_id);

		order.setSeatNum(seat_num);
		order.setReserveBeginTime(now);
		order.setReserveEndTime(now);
		order.setReserveType("whole day");
		try {
			int desk_id = deskService.getDeskId(floor, block, desk_num);
			order.setDeskId(desk_id);
			orderService.order(order);
		} catch (BusinessException e) {
			result = "fail, because " + e.getMessage();
			e.printStackTrace();
		}
		renderText(result);
	}

	public static void orderList(PageInfo<OrdersInfo> pageInfo, 
			String userNum, String name, String dept) {
		if(pageInfo == null ) {
			pageInfo = new PageInfo<OrdersInfo>();
		}
		//pageInfo = orderService.queryByConditon();
		List<DeskInfo> desksList = new ArrayList<DeskInfo>();
		renderTemplate("user/users.html", pageInfo, userNum, name, dept);
	}
	
	
	public static void deleteUser(int userId) {
		String result = "";
		try{
			//userService.deleteUser(userId);
			result = "ok";
		}catch (BusinessException e) {
			result = "fail, because " + e.getMessage();
			e.printStackTrace();
		}
		renderText(result);
	}
	
	public static void updateUser(int userId, String userNum, String password,
			String name, String dept, int reserveTimes, int breakTimes) { 
		String result = "";
		
		try{
			UserInfo user = new UserInfo();
			user.setUserId(userId);
			user.setUserNum(userNum);
			user.setName(name);
			user.setPassword(password);
			user.setDept(dept);
			user.setReserveTimes(reserveTimes);
			user.setBreakTimes(breakTimes);
			//userService.updateUser(user);
			result = "ok";
		}catch (BusinessException e) {
			result = "fail, because " + e.getMessage();
			e.printStackTrace();
		}
		renderText(result);
		
	}
	
	public static void addUser(String userNum, String password, 
			String name, String dept) {
		String result="";
		int userId=0;
		UserInfo user = new UserInfo();
		user.setUserNum(userNum);
		user.setName(name);
		user.setPassword(password);
		user.setDept(dept);
		user.setReserveTimes(0);
		user.setBreakTimes(0);
		try{
			//userId = userService.addUser(user);
			result = "" + userId;
		}catch (BusinessException e) {
			result = "fail, because " + e.getMessage();
			e.printStackTrace();
		}
		renderText(result);
	}

	public static IOrderService getOrderService() {
		return orderService;
	}
	
	
	public static void setOrderService(IOrderService orderService) {
		Order.orderService = orderService;
	}

	public static IDeskService getDeskService() {
		return deskService;
	}

	public static void setDeskService(IDeskService deskService) {
		Order.deskService = deskService;
	}
	
}

package com.project.serviceManagement.service;

import java.util.List;

import com.project.serviceManagement.model.ServiceOrder;

public interface OrderService  {

	public ServiceOrder addBookOrder(ServiceOrder BookOrder) ;
	public ServiceOrder updateBookOrderStatus(ServiceOrder BookOrder, Integer id);
//	public void deleteBookOrder(Integer id);
	public List<ServiceOrder> viewAllOrders();
	public ServiceOrder getBookOrder(Integer id);
	public List<ServiceOrder> viewAllOrdersForUser(Integer id);

}

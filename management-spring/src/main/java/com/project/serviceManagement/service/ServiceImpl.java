package com.project.serviceManagement.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.serviceManagement.dao.AddressDao;
import com.project.serviceManagement.dao.AdminDao;
import com.project.serviceManagement.dao.ServiceDao;
import com.project.serviceManagement.dao.CategoryDao;
import com.project.serviceManagement.dao.CustomerDao;
import com.project.serviceManagement.dao.OrderDao;
import com.project.serviceManagement.dao.RatingsDao;
import com.project.serviceManagement.model.Address;
import com.project.serviceManagement.model.Admin;
import com.project.serviceManagement.model.ServiceOrder;
import com.project.serviceManagement.model.Service;
import com.project.serviceManagement.model.Category;
import com.project.serviceManagement.model.Customer;
import com.project.serviceManagement.model.Ratings;
import com.project.serviceManagement.model.StatsHolder;

@org.springframework.stereotype.Service
public class ServiceImpl implements AdminService,
CategoryService, allService,CustomerService,AddressService
, OrderService,RatingService{
	
	@Autowired
	AdminDao admindao;
	
	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	ServiceDao booksDao;

	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	RatingsDao ratingsDao;
	
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.save(admin);
	}

	@Override
	public Admin updteAdmin(Admin admin,Integer id) {
		// TODO Auto-generated method stub
		admin.setId(id);
		return admindao.save(admin);
	}

	@Override
	public void deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		admindao.deleteById(id);
		
	}

	@Override
	public List<Admin> viewAdmins() {
		// TODO Auto-generated method stub
		return admindao.findAll();
	}

	@Override
	public Admin getAdmin(Integer id) {
		// TODO Auto-generated method stub
		return admindao.findById(id).get() ;
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categorydao.save(category);
	}

	@Override
	public Category updteCategory(Category category, Integer id) {
		// TODO Auto-generated method stub
		category.setId(id);
		return categorydao.save(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		categorydao.deleteById(id);
		
	}
	
	@Override
	public List<Category> viewCategories() {
		// TODO Auto-generated method stub
		return categorydao.findAll();
	}

	@Override
	public Category getCategory(Integer id) {
		// TODO Auto-generated method stub
		return categorydao.findById(id).get();
	}

	@Override
	public Service addBook(Service books) {
//		// TODO Auto-generated method stub
		Category category = categorydao.findByName(books.getCategoryName());
				books.setCategory(category);
		return booksDao.save(books);
	}

	@Override
	public void deleteBook(Integer id) {
		booksDao.deleteById(id);
		
	}

	@Override
	public List<Service> viewBooks() {
		// TODO Auto-generated method stub
		return booksDao.findAll();
	}

	@Override
	public Service getBook(Integer id) {
		// TODO Auto-generated method stub
		return booksDao.findById(id).get();
	}

	@Override
	public Service updateBook(Service book, Integer id) {
		// TODO Auto-generated method stub
		book.setBid(id);
		return booksDao.save(book);
	}

	@Override
	public List<Service> getBookByCategory(String id) {
		// TODO Auto-generated method stub
		Category category = categorydao.findByName(id);
		return booksDao.findAllByCategory(category);
	}
	

	@Override
	public Customer addAddressToCustomer(Address address, String cid) {
		// TODO Auto-generated method stub
		
		Customer customer = getCustomer(Integer.parseInt(cid));
		customer.getAddress().add(address);
				return addCustomer(customer);
	}
	
	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		Address address2 = addressDao.save(address);
			 addAddressToCustomer(address2, address.getCustomerId());
		
		return  address;
	}

	@Override
	public Address updteAddress(Address address, Integer id) {
		// TODO Auto-generated method stub
		address.setAid(id);
		return addressDao.save(address);

	}

	@Override
	public void deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		addressDao.deleteById(id);
	}

	@Override
	public Address getAddress(Integer id) {
		// TODO Auto-generated method stub
		return addressDao.findById(id).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.save(customer);
	}

	@Override
	public Customer updteCustomer(Customer customer, Integer id) {
		// TODO Auto-generated method stub
		customer.setCid(id);
		return customerDao.save(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteById(id);
	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id).get();
	}

	@Override
	public List<Customer> viewCustomers() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public List<Address> viewAddress() {
		// TODO Auto-generated method stub
		return addressDao.findAll();
	}
	

	@Override
	public ServiceOrder addBookOrder(ServiceOrder order) {
		Customer customer = getCustomer(Integer.parseInt(order.getCustomerId()));
		Address address = getAddress(Integer.parseInt(order.getAddressId()));
		order.setCustomer(customer);
		order.setAddress(address);
		Iterator<String> iterator = order.getBookId().iterator();
		while (iterator.hasNext()) {
			String bookId = (String) iterator.next();
			order.getBooks().add(getBook(Integer.parseInt(bookId)));
		}
		return orderDao.save(order);
	}

	
	@Override
	public List<ServiceOrder> viewAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public ServiceOrder getBookOrder(Integer id) {
		return orderDao.getById(id);
	}

	@Override
	public Customer getCustomerByPhone(String id) {
		// TODO Auto-generated method stub
		return customerDao.findByPhoneNumber(id);
	}

	@Override
	public ServiceOrder updateBookOrderStatus(ServiceOrder uorder, Integer id) {
		
		ServiceOrder order = getBookOrder(id);
		order.setStatus(uorder.getStatus());
		order.setStatusMsg(uorder.getStatusMsg());
	 	return orderDao.save(order);
	}

	@Override
	public List<Address> getAddressByCustomerId(Integer id) {
		// TODO Auto-generated method stub
		return (List<Address>) getCustomer(id).getAddress();
	}

	@Override
	public List<ServiceOrder> viewAllOrdersForUser(Integer id) {
		Customer customer = getCustomer(id);
		return orderDao.findByCustomer(customer);
	}

	public StatsHolder getStats() {
		StatsHolder holder = new StatsHolder();
		holder.setBooks(booksDao.count());
		holder.setCategories(categorydao.count());
		holder.setCustomers(customerDao.count());
		holder.setOrders(orderDao.count());

		return holder;
	}

	
	
	public void saveRatingToBook(Service book, Ratings ratings) {
		book.getRatings().add(ratings);
		booksDao.save(book);
	}
	
	@Override
	public Ratings addRatings(Ratings rating) {
		Service book = getBook(Integer.parseInt(rating.getMbid()));
		ratingsDao.save(rating);
		saveRatingToBook(book, rating);
		return rating;
	}

	@Override
	public Ratings updteRatings(Ratings rating, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ratings> viewRatings() {
		// TODO Auto-generated method stub
		return ratingsDao.findAll();
	}

	@Override
	public Ratings getRatings(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}

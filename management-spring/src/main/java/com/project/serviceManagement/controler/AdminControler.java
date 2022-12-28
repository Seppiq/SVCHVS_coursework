package com.project.serviceManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.serviceManagement.model.Address;
import com.project.serviceManagement.model.Admin;
import com.project.serviceManagement.model.ServiceOrder;
import com.project.serviceManagement.model.Service;
import com.project.serviceManagement.model.Category;
import com.project.serviceManagement.model.Customer;
import com.project.serviceManagement.model.StatsHolder;
import com.project.serviceManagement.service.ServiceImpl;


@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AdminControler {
    @Autowired
    ServiceImpl adminServiceImpl;

    @GetMapping("/admin")
    public List<Admin> getAdmins() {
        return adminServiceImpl.viewAdmins();
    }


    @GetMapping("/admin/{id}")
    public Admin getAdmin(@PathVariable Integer id) {
        return adminServiceImpl.getAdmin(id);
    }

    @PostMapping("/admin/add")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminServiceImpl.addAdmin(admin);
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable Integer id) {
        return ResponseEntity.ok().body(adminServiceImpl.updteAdmin(admin, id));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Integer id) {
        adminServiceImpl.deleteAdmin(id);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/category")
    public List<Category> getCategories() {
        return adminServiceImpl.viewCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return adminServiceImpl.getCategory(id);
    }

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody Category category) {
        return adminServiceImpl.addCategory(category);
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        return ResponseEntity.ok().body(adminServiceImpl.updteCategory(category, id));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        adminServiceImpl.deleteCategory(id);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/books")
    public List<Service> getBooks() {
        return adminServiceImpl.viewBooks();
    }

    @GetMapping("/books/{id}")
    public Service getBook(@PathVariable Integer id) {
        return adminServiceImpl.getBook(id);
    }

    @GetMapping("/books/c/{id}")
    public List<Service> getBookByCategory(@PathVariable String id) {
        return adminServiceImpl.getBookByCategory(id);
    }

    @PostMapping("/books/add")
    public ResponseEntity<?> addBook(@RequestBody Service book) {
        return ResponseEntity.ok().body(adminServiceImpl.addBook(book));
    }

    @PutMapping("/books/update/{id}")
    public ResponseEntity<Service> updateBook(@RequestBody Service book, @PathVariable Integer id) {
        return ResponseEntity.ok().body(adminServiceImpl.updateBook(book, id));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        adminServiceImpl.deleteBook(id);
        return ResponseEntity.ok(null);
    }


//	address

    @GetMapping("/address")
    public List<Address> getAddresses() {
        return adminServiceImpl.viewAddress();
    }

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return adminServiceImpl.getAddress(id);
    }

    @PostMapping("/address/add")
    public Address addAddress(@RequestBody Address Address) {
        return adminServiceImpl.addAddress(Address);
    }

    @PutMapping("/address/update/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address Address, @PathVariable Integer id) {
        return ResponseEntity.ok().body(adminServiceImpl.updteAddress(Address, id));
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        adminServiceImpl.deleteAddress(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/address/cus/{id}")
    public List<Address> getAddressOfCustomer(@PathVariable Integer id) {
        return adminServiceImpl.getAddressByCustomerId(id);
    }


    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return adminServiceImpl.viewCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return adminServiceImpl.getCustomer(id);
    }

    @GetMapping("/customer/phone/{id}")
    public Customer getCustomerByPhone(@PathVariable String id) {
        return adminServiceImpl.getCustomerByPhone(id);
    }

    @PostMapping("/customer/add")
    public Customer addCustomer(@RequestBody Customer Customer) {
        return adminServiceImpl.addCustomer(Customer);
    }

    @PutMapping("/customer/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer Customer, @PathVariable Integer id) {
        return ResponseEntity.ok().body(adminServiceImpl.updteCustomer(Customer, id));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        adminServiceImpl.deleteCustomer(id);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/order")
    public List<ServiceOrder> getAllOrders() {
        return adminServiceImpl.viewAllOrders();
    }

    @GetMapping("/order/u/{id}")
    public List<ServiceOrder> getAllOrdersForUser(@PathVariable Integer id) {
        return adminServiceImpl.viewAllOrdersForUser(id);
    }


    @PostMapping("/order/add")
    public ServiceOrder addOrder(@RequestBody ServiceOrder order) {
        return adminServiceImpl.addBookOrder(order);
    }

    @PutMapping("/order/change/{id}")
    public ResponseEntity<?>
    updateOrderStatus(@RequestBody ServiceOrder order,
                      @PathVariable Integer id) {

        return ResponseEntity.ok()
                .body(adminServiceImpl
                        .updateBookOrderStatus(order, id));
    }


    @GetMapping("/stats")
    public ResponseEntity<StatsHolder> getStats() {
        return ResponseEntity.ok().body(adminServiceImpl.getStats());
    }


}

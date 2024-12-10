package com.example.billing_service.web;

import com.example.billing_service.entities.Bill;
import com.example.billing_service.repositories.BillRepository;
import com.example.billing_service.repositories.ProductItemRepository;
import com.example.billing_service.services.CustomerServiceClient;
import com.example.billing_service.services.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class billRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private InventoryServiceClient inventoryServiceClient;



    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(p->p.setProduct(inventoryServiceClient.findProductById(p.getProductID())));
        return bill;

    }

}

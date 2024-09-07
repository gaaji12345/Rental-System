package services;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.CustomDTO;
import dtos.CustomerDTO;
import dtos.meta.CustomerMetaDTO;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    ArrayList<CustomerMetaDTO> getAllCustomers();

    CustomDTO customerIdGenerate();

    CustomerDTO getCusDetail(String userName);
}

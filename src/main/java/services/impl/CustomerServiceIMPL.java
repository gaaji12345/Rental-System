package services.impl;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.CustomDTO;
import dtos.CustomerDTO;
import dtos.meta.CustomerMetaDTO;
import entity.Customer;
import entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import repo.CustomerRepo;
import services.CustomerService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        map.setUser(new User(dto.getUser().getUserName(),dto.getUser().getPassword(),"customer"));
        MultipartFile img_front = dto.getFrontImage();
        MultipartFile img_back = dto.getBackImage();


        System.out.println(map);

        try {

            String projectPath = System.getProperty("user.dir");
            Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Renal-System/front");


            File uploadsDir = new File(sourceCodePath + "/uploads");
            System.out.println(sourceCodePath);
            uploadsDir.mkdir();




            dto.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
            dto.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackImage().getOriginalFilename()));

            map.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
            map.setBackImage("uploads/" + dto.getBackImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map);
        customerRepo.save(map);
    }






    @Override
    public ArrayList<CustomerMetaDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerMetaDTO>>() {
        }.getType());
    }

    @Override
    public CustomDTO customerIdGenerate() {
        return new CustomDTO(customerRepo.getLastIndex());
    }

    @Override
    public CustomerDTO getCusDetail(String userName) {
        Customer customerDTO= customerRepo.customerDetail(userName);
        return mapper.map(customerDTO,CustomerDTO.class );
    }

}

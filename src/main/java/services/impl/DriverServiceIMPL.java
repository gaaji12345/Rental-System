package services.impl;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.DriverDTO;
import entity.Driver;
import entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.DriverRepo;
import services.DriverService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceIMPL implements DriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addDriver(DriverDTO driverDTO) {
        Driver map =mapper.map(driverDTO,Driver.class);
        map.setUser(new User(driverDTO.getUser().getUserName(),driverDTO.getUser().getPassword(),"driver"));

        try {

            String projectPath = System.getProperty("user.dir");
            Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Rental-System/front");

//            String projectPath = System.getProperty("user.dir");
//            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(sourceCodePath + "/uploads");
            System.out.println(sourceCodePath);
            uploadsDir.mkdir();

            driverDTO.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getFrontImage().getOriginalFilename()));
            driverDTO.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getBackImage().getOriginalFilename()));

            map.setFrontImage("uploads/" + driverDTO.getFrontImage().getOriginalFilename());
            map.setBackImage("uploads/" + driverDTO.getBackImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);

        driverRepo.save(map);

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public Driver searchDriver(String id) {
        return mapper.map(driverRepo.findById(id).get(), Driver.class);
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        Driver map =mapper.map(driverDTO,Driver.class);
        map.setUser(new User(driverDTO.getUser().getUserName(),driverDTO.getUser().getPassword(),"driver"));

        try {

            String projectPath = System.getProperty("user.dir");
            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            driverDTO.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getFrontImage().getOriginalFilename()));
            driverDTO.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + driverDTO.getBackImage().getOriginalFilename()));

            map.setFrontImage("uploads/" + driverDTO.getFrontImage().getOriginalFilename());
            map.setBackImage("uploads/" + driverDTO.getBackImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);

        driverRepo.save(map);
    }

    @Override
    public void deleteDriver(String id) {
        driverRepo.deleteById(id);
    }
}

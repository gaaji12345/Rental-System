package services.impl;/*  gaajiCode
    99
    08/09/2024
    */

import dtos.PaymentDTO;
import dtos.meta.PaymentMetaDTO;
import entity.Payment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.PaymentRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceIMPL implements services.PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addPayment(PaymentDTO paymentDTO) {
        Payment map =mapper.map(paymentDTO,Payment.class);

        try {
            System.out.println("Try Catch");

            String projectPath = System.getProperty("user.dir");
            Path sourceCodePath = Paths.get(projectPath).getParent().getParent().resolve("Renal-System/front");

//
            File uploadsDir = new File(sourceCodePath + "/uploads");
            System.out.println(sourceCodePath);
            uploadsDir.mkdir();

            paymentDTO.getWaiverSlip().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + paymentDTO.getWaiverSlip().getOriginalFilename()));

            map.setWaiverSlip("uploads/" + paymentDTO.getWaiverSlip().getName());
            System.out.println("uploads/" + paymentDTO.getWaiverSlip().getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        paymentRepo.save(map);

    }

    @Override
    public ArrayList<PaymentMetaDTO> getAllPayments() {
        List<Payment> all = paymentRepo.findAll();
        return mapper.map(all, new TypeToken<List<PaymentMetaDTO>>() {
        }.getType());
    }

    @Override
    public void updatePayment(String paymentID, String total) {
        Payment payment = paymentRepo.findById(paymentID).get();
        Payment map =mapper.map(payment,Payment.class);
        map.setExtraMileagePayment(Double.parseDouble(total));
        paymentRepo.save(map);

    }
}

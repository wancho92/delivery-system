package deliverysystem.infra;
import deliverysystem.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/pays")
@Transactional
public class PayController {
    @Autowired
    PayRepository payRepository;


    @RequestMapping(
        value = "pays/{id}/pay",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Pay pay(
        @PathVariable(value = "id") Long id,
        @RequestBody Pay pay,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /Pays/pay called #####");
    
        //여기는 결재에 실패했을때 로직 구현 필요
        /*Optional<Pay> optionalPay = pay.findByOrderId(
            id
        );

        optionalPay.orElseThrow(() -> new Exception("No Entity Found"));
        Pay pay = optionalPay.get();
        pay.decreaseStock(decreaseStockCommand);

        inventoryRepository.save(inventory);
        */
        return null;
    }

}

package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String price;
    private Long foodId;
    private Integer qty;
    private List<String> option;
    private String name;
    private Integer tel;
    private Integer price;
    private String addr;
    private Long storeId;

    public OrderPlaced(Order aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}

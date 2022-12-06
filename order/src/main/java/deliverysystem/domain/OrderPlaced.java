package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

	private Long id;
    private Long foodId;
    private Integer qty;
    private Object option;
    private String name;
    private Integer tel;
    private Integer price;
    private String addr;
    private Long storeId;
}

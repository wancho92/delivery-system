package deliverysystem.domain;

import deliverysystem.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cook_table")
@Data

public class Cook  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    private String status;
    private Long foodId;
    private Long orderId;
    private String option;
    private Long storeId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}


    @PostPersist
    public void onPostPersist(){
    }

    public static CookRepository repository(){
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(CookRepository.class);
        return cookRepository;
    }



    public void acceptCook(){
        CookAccepted cookAccepted = new CookAccepted(this);
        cookAccepted.publishAfterCommit();
        //setStatus("주문수락");
        //cookAccepted.setStatus("주문수락");
    }
    public void cancelCook(){
        CookCanceled cookCanceled = new CookCanceled(this);
        cookCanceled.publishAfterCommit();
        //setStatus("주문거절");
        //cookAccepted.setStatus("주문수락");
    }
    public void finishCook(){
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }
    public void startCook(){
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

    }

    public static void registerOrder(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        Cook cook = new Cook();
        cook.setStatus("미결재");
        cook.setOrderId(orderPlaced.getId());
        cook.setFoodId(orderPlaced.getFoodId());
        //cook.setOption(orderPlaced.getOption());
        cook.setStoreId(orderPlaced.getStoreId());
        repository().save(cook);
        
        /** Example 2:  finding and process
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            cook // do something
            repository().save(cook);
         });
        */
    }

    public static void updateStatus(Paid paid){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);
        */

        /** Example 2:  finding and process*/
        repository().findByOrderId(paid.getOrderId()).ifPresent(cook->{
            cook.setStatus("결재됨");
            repository().save(cook);
         });
    }
    public static void updateStatus(PayCanceled payCanceled){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCanceled.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }


}

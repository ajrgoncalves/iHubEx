package i.ub.antonio.goncalves.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderModel_id")
    private OrderModel orderModel;

    private Boolean deleted;
}

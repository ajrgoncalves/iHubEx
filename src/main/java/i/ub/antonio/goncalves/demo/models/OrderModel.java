package i.ub.antonio.goncalves.demo.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orderModel")
//Next Annotation allow to just show Orders delected = false on findAll method
//@Where(clause = "deleted = false")
public class OrderModel {

    @Id
    @GeneratedValue
//    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    private String buyerEmail;

    private Date creationDate;

    private Boolean deleted;

}

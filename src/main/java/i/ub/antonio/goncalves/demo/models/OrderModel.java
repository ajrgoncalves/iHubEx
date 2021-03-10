package i.ub.antonio.goncalves.demo.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orderModel")
@EqualsAndHashCode
//Next Annotation allow to just show Orders delected = false on findAll method
//@Where(clause = "deleted = false")
public class OrderModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name="ORDERMODEL_PRODUCT",
            joinColumns = @JoinColumn(
                    name = "orderModel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id")
    )
    @Builder.Default
    private Set<Product> products = new HashSet<>();

    private String buyerEmail;

    private Date creationDate;

    private Boolean active;

}

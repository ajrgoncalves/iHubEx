package i.ub.antonio.goncalves.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ORDERMODEL_PRODUCT",
            joinColumns = @JoinColumn(
                    name = "orderModel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id")
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    private String buyerEmail;

    private Date creationDate;

    private Boolean active;

}

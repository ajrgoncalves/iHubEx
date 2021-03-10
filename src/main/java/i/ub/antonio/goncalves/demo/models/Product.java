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
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    private Date creationDate;

    @ManyToMany(mappedBy = "products")
    private Set<OrderModel> orders = new HashSet<>();

    private Boolean active;
}

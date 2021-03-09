package iHubAntonioGoncalves.Demo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderModel {

    @Id
    @GeneratedValue
//    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    private String buyerEmail;

    private Date creationDate;

}

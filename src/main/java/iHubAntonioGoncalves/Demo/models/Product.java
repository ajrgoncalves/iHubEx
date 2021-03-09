package iHubAntonioGoncalves.Demo.models;

import lombok.*;

import javax.persistence.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
//    @Column(name = "id")
    private Long id;

    private String name;

    private Integer price;

    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderModel_id")
    private OrderModel orderModel;
}

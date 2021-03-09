package i.ub.antonio.goncalves.demo.modelsDto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {

    private Long id;

    private String name;

    private Integer price;

    private Date creationDate;

    private Long orderModelId;

    private Boolean deleted;
}

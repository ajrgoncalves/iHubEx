package i.ub.antonio.goncalves.demo.modelsDto;

import lombok.*;

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

    private String creationDate;

    private Long orderModelId;
}

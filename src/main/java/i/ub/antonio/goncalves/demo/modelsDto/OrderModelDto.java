package i.ub.antonio.goncalves.demo.modelsDto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderModelDto {

    @Id
    @GeneratedValue
    private Long id;

    private String buyerEmail;

    private Date creationDate;

    private Boolean deleted;
}

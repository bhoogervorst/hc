package nl.hoogervorst.hc.domain.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Builder
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QualityOverviewView {

    @Id
    private UUID qualityOverviewId;
    private int totalAmountOfModels;

}

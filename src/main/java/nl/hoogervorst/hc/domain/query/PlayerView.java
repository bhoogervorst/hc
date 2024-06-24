package nl.hoogervorst.hc.domain.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Component
@Entity
public class PlayerView {

    @Id
    private UUID playerId;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate dateOfBirth;
}

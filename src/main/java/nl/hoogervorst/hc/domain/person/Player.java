package nl.hoogervorst.hc.domain.person;

import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Setter
public class Player {

    private UUID playerId;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate dateOfBirth;
}

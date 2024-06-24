package nl.hoogervorst.hc.adapter.rest.incoming.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlayerInput {

    private String firstName;
    private String lastName;
    @NotNull @NotBlank
    private String userName;
    @NotNull private LocalDate dateOfBirth;
}

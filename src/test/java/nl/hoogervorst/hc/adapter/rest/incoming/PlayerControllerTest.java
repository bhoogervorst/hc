package nl.hoogervorst.hc.adapter.rest.incoming;

import nl.hoogervorst.hc.adapter.rest.incoming.input.PlayerInput;
import nl.hoogervorst.hc.application.PlayerService;
import nl.hoogervorst.hc.domain.query.PlayerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ExtendWith(MockitoExtension.class)
class PlayerControllerTest {

    public static final String FIRST_NAME = "Boi";
    public static final String LAST_NAME = "Hoogervorst";
    public static final String USER_NAME = "thaboike";
    public static final LocalDate DATE_OF_BIRTH = LocalDate.parse("1982-05-18");
    private PlayerController playerController;

    @Mock
    PlayerService playerService;

    @BeforeEach
    void setUp(){
        playerController = new PlayerController(playerService);
    }

    @Test
    void whenUsernameIsBlank_expectABadRequestError(){

        ResponseEntity responseEntity = playerController.createNewPlayer(playerInputBuilder());

        assertThat(responseEntity.getStatusCode()).isEqualTo(ACCEPTED);
    }

    public static PlayerInput playerInputBuilder(){

        return PlayerInput.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .userName(USER_NAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .build();
    }
}
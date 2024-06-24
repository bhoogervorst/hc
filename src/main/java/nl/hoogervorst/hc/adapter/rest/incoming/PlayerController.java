package nl.hoogervorst.hc.adapter.rest.incoming;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hoogervorst.hc.adapter.rest.incoming.input.PlayerInput;
import nl.hoogervorst.hc.application.PlayerService;
import nl.hoogervorst.hc.domain.query.PlayerView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

@PostMapping("/player")
public ResponseEntity createNewPlayer(@Valid @RequestBody PlayerInput playerInput){

    log.info("Do i get the input: {}", playerInput.getLastName());
    playerService.createNewPlayer(playerInput);


    return ResponseEntity.accepted().build();
}

@GetMapping("/player/{playerId}")
    public ResponseEntity<PlayerView> getPlayerByid(@PathVariable UUID playerId){

   return ResponseEntity.ok(playerService.getPlayerById(playerId));

}
}

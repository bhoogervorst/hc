package nl.hoogervorst.hc.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hoogervorst.hc.adapter.rest.incoming.input.PlayerInput;
import nl.hoogervorst.hc.domain.query.PlayerView;
import nl.hoogervorst.hc.domain.query.PlayerViewRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerViewRepository playerViewRepository;
    private final PlayerMapper playerMapper;

    public void createNewPlayer(PlayerInput playerInput){

        PlayerView player = playerMapper.map(playerInput);
        player.setPlayerId(UUID.randomUUID());

        playerViewRepository.save(player);
    }

    public PlayerView getPlayerById(UUID playerId) {

       return playerViewRepository.findPlayerViewByPlayerId(playerId)
                .orElseGet(() -> {
                    log.info("No player found with id {}", playerId);
                    return null;
                });
    }


    @Mapper
    interface PlayerMapper {
        PlayerView map(PlayerInput playerInput);

    }
}

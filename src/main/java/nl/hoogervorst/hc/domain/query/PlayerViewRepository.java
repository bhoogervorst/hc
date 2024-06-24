package nl.hoogervorst.hc.domain.query;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerViewRepository extends PagingAndSortingRepository<PlayerView, UUID>, ListCrudRepository<PlayerView, UUID> {

    Optional<PlayerView> findPlayerViewByPlayerId(UUID playerId);
}

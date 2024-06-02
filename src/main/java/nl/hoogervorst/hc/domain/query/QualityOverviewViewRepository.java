package nl.hoogervorst.hc.domain.query;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface QualityOverviewViewRepository extends PagingAndSortingRepository<QualityOverviewView, UUID>, ListCrudRepository<QualityOverviewView, UUID> {
Optional<QualityOverviewView> findByQualityOverviewId(UUID qualityOverviewId);
}

package nl.hoogervorst.hc.application;

import nl.hoogervorst.hc.application.mapper.QualityOverviewViewMapper;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import nl.hoogervorst.hc.domain.query.QualityOverviewViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.domain.Pageable.unpaged;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class QualityOverviewServiceIT{

    @SpyBean
    private QualityOverviewViewRepository qualityOverviewViewRepository;

    @Autowired
    private TestEntityManager entityManager;

    private QualityOverviewService qualityOverviewService;

    @Autowired
    private QualityOverviewViewMapper qualityOverviewViewMapper;

    @BeforeEach
    void setUp() {
        qualityOverviewService = new QualityOverviewService(qualityOverviewViewRepository, qualityOverviewViewMapper);
    }

    @Test
    void givenNoDatabaseRecordPresent_giveEmptyResult(){
        Page<QualityOverviewView> qualityOverviewView = qualityOverviewService.getAllQualityOverview(unpaged());
        assertThat(qualityOverviewView).isEmpty();

    }
}
package nl.hoogervorst.hc.adapter.rest.incoming;

import jakarta.validation.constraints.NotNull;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.application.QualityOverviewService;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import nl.hoogervorst.hc.domain.query.QualityOverviewViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import static java.util.List.of;
import static nl.hoogervorst.hc.utils.TestDataFactory.QUALITY_OVERVIEW_IDENTIFIER;
import static nl.hoogervorst.hc.utils.TestDataFactory.TOTAL_AMOUNT_OF_MODELS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class QualityOverviewControllerTest {

    private QualityOverviewController qualityOverviewController;

    @Mock
    private QualityOverviewViewRepository qualityOverviewViewRepository;

    @Mock
    private QualityOverviewService qualityOverviewService;

    @BeforeEach
    void setUp(){
        qualityOverviewController = new QualityOverviewController(qualityOverviewService);
    }
    @Test
    void givenQualityOverviewExists_whenGetQualityOverviewInvoked_expectServiceToBeInvokedAndResultToBeCorrectlyMapped() {

    }

    @Test
    void getAllQualityOverview() {
        when(qualityOverviewService.getAllQualityOverview(any())).thenReturn(pageOfQualityOverviewView());

        Pageable pageable = Pageable.unpaged();
        ResponseEntity<Page<QualityOverviewView>> responseEntity = qualityOverviewController.getAllQualityOverview(pageable);

        verify(qualityOverviewService).getAllQualityOverview(pageable);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        Page<QualityOverviewView> body = responseEntity.getBody();

        assertThat(body).isNotNull();

        assertThat(body.getContent())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(qualityOverviewView());

    }

    @Test
    void whenSaveInvoked_expectArgumentsToMatch() {

        ResponseEntity responseEntity = qualityOverviewController.setQualityOverview(qualityOverviewInput());

        ArgumentCaptor<QualityOverviewInput> captor = ArgumentCaptor.forClass(QualityOverviewInput.class);

        verify(qualityOverviewService).saveQualityOverview(captor.capture());

        assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(qualityOverviewInput());

        //assertThat(responseEntity.getStatusCode()).isEqualTo(ACCEPTED);
    }
    @NotNull
    private static PageImpl<QualityOverviewView> pageOfQualityOverviewView() {
        return new PageImpl<>(of(
                QualityOverviewView.builder()
                        .qualityOverviewId(QUALITY_OVERVIEW_IDENTIFIER)
                        .totalAmountOfModels(TOTAL_AMOUNT_OF_MODELS)
                        .build()
        ));
    }

    private static QualityOverviewView qualityOverviewView() {

        return QualityOverviewView.builder()
                .qualityOverviewId(QUALITY_OVERVIEW_IDENTIFIER)
                .totalAmountOfModels(TOTAL_AMOUNT_OF_MODELS)
                .build();

    }
    private static QualityOverviewInput qualityOverviewInput(){

        return QualityOverviewInput.builder()
                .qualityOverviewId(QUALITY_OVERVIEW_IDENTIFIER)
                .totalAmountOfModels(TOTAL_AMOUNT_OF_MODELS)
                .build();
    }
}
package nl.hoogervorst.hc.application;

import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.application.mapper.QualityOverviewViewMapper;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import nl.hoogervorst.hc.domain.query.QualityOverviewViewRepository;
import nl.hoogervorst.hc.utils.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QualityOverviewServiceTest {

    private QualityOverviewService qualityOverviewService;
    @Mock
    QualityOverviewViewRepository qualityOverviewViewRepository;

    @Mock
    QualityOverviewViewMapper qualityOverviewViewMapper;
    @BeforeEach
    void setup() {
        qualityOverviewService = new QualityOverviewService(qualityOverviewViewRepository, qualityOverviewViewMapper);
    }

    @Test
    void whenSaveMethodIsInvoked_expectSaveExactlyOnce(){

        QualityOverviewInput qualityOverviewInput = null;
        qualityOverviewService.saveQualityOverview(qualityOverviewInput);
        verify(qualityOverviewViewRepository, times(1)).save(any());
    }

    @Test
    void whenSaveMethodIsInvoked_expectCaptorToMatch(){

        QualityOverviewInput qualityOverviewInput = TestDataFactory.qualityOverviewInputBuilder().build();

        QualityOverviewView qualityOverviewView = QualityOverviewView.builder()
                        .qualityOverviewId(UUID.fromString("ea83361b-f54b-4aa0-9717-026d8d307de1"))
                        .totalAmountOfModels(100)
                        .build();

        when(qualityOverviewViewMapper.map(any(QualityOverviewInput.class))).thenReturn(qualityOverviewView);

        qualityOverviewService.saveQualityOverview(qualityOverviewInput);

        ArgumentCaptor<QualityOverviewView> captor = ArgumentCaptor.forClass(QualityOverviewView.class);

        verify(qualityOverviewViewRepository).save(captor.capture());
        assertEquals(qualityOverviewInput.getQualityOverviewId(), captor.getValue().getQualityOverviewId());
    }
}
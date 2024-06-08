package nl.hoogervorst.hc.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.application.mapper.QualityOverviewViewMapper;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import nl.hoogervorst.hc.domain.query.QualityOverviewViewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class QualityOverviewService {

    private final QualityOverviewViewRepository qualityOverviewViewRepository;

    private final QualityOverviewViewMapper qualityOverviewViewMapper;

    public void saveQualityOverview(QualityOverviewInput qualityOverviewInput){

        qualityOverviewViewRepository.save(qualityOverviewViewMapper.map(qualityOverviewInput));
    }

    public Page<QualityOverviewView> getAllQualityOverview(Pageable pageable){
        return qualityOverviewViewRepository.findAll(pageable);
    }

    public QualityOverviewView getQualityOverview(UUID qualityOverviewViewId) {

        Optional<QualityOverviewView> optionalQualityOverviewView = qualityOverviewViewRepository.findByQualityOverviewId(qualityOverviewViewId);

        return optionalQualityOverviewView.orElse(null);
    }
}


package nl.hoogervorst.hc.application;

import lombok.RequiredArgsConstructor;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.application.mapper.QualityOverviewViewMapper;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import nl.hoogervorst.hc.domain.query.QualityOverviewViewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
@Transactional(readOnly = true)
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

        if (qualityOverviewViewRepository.findByQualityOverviewId(qualityOverviewViewId).isPresent()) {
            return qualityOverviewViewRepository.findByQualityOverviewId(qualityOverviewViewId).get();
        } else {
            return null;
        }
    }
}

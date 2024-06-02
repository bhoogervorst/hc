package nl.hoogervorst.hc.application.mapper;

import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface QualityOverviewViewMapper {
    QualityOverviewView map(QualityOverviewInput qualityOverviewInput);
}

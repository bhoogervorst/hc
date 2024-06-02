package nl.hoogervorst.hc.adapter.rest.incoming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QualityOverviewInput {
    private UUID qualityOverviewId;
    private int totalAmountOfModels;
    private int totalAmountOfConcepts;
    private int totalAmountOfTriples;
    private int totalAmountOfInstruments;
}

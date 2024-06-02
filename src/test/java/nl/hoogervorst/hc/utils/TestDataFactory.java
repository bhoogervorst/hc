package nl.hoogervorst.hc.utils;

import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput.QualityOverviewInputBuilder;

import java.util.UUID;

import static java.util.UUID.fromString;

public class TestDataFactory {

    public static UUID QUALITY_OVERVIEW_IDENTIFIER = fromString("ea83361b-f54b-4aa0-9717-026d8d307de1");
    public static int TOTAL_AMOUNT_OF_MODELS = 100;
    public static QualityOverviewInputBuilder qualityOverviewInputBuilder(){
        return QualityOverviewInput.builder()
                .qualityOverviewId(QUALITY_OVERVIEW_IDENTIFIER)
                .totalAmountOfModels(TOTAL_AMOUNT_OF_MODELS);
    }
}

package nl.hoogervorst.hc.utils;

import nl.hoogervorst.hc.adapter.rest.incoming.input.PlayerInput;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput.QualityOverviewInputBuilder;

import nl.hoogervorst.hc.adapter.rest.incoming.input.PlayerInput.PlayerInputBuilder;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.UUID.fromString;

public class TestDataFactory {

    public static UUID QUALITY_OVERVIEW_IDENTIFIER = fromString("ea83361b-f54b-4aa0-9717-026d8d307de1");
    public static final int TOTAL_AMOUNT_OF_MODELS = 100;
    private static final int TOTAL_AMOUNT_OF_CONCEPTS = 200;
    private static final int TOTAL_AMOUNT_OF_TRIPLES = 300;
    private static final int TOTAL_AMOUNT_OF_INSTRUMENTS = 10;
    public static QualityOverviewInputBuilder qualityOverviewInputBuilder(){
        return QualityOverviewInput.builder()
                .qualityOverviewId(QUALITY_OVERVIEW_IDENTIFIER)
                .totalAmountOfModels(TOTAL_AMOUNT_OF_MODELS)
                .totalAmountOfConcepts(TOTAL_AMOUNT_OF_CONCEPTS)
                .totalAmountOfTriples(TOTAL_AMOUNT_OF_TRIPLES)
                .totalAmountOfInstruments(TOTAL_AMOUNT_OF_INSTRUMENTS);
    }
}

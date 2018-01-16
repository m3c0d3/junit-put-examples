package com.practicalunittesting.chp05.raceresults;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by m3c0d3 on 1/16/2018.
 */
public class RaceResultsWithCategoriesTest {

    RaceResultsService raceResults = new RaceResultsService();
    private Message horseRaceMessage = mock(Message.class);
    private Message f1RaceMessage = mock(Message.class);
    private Message boatRaceMessage = mock(Message.class);
    private Client clientRegisteredToHorseRaces = mock(Client.class);

    @Before
    public void setUp() {
        when(horseRaceMessage.getCategory()).thenReturn(ResultCategory.HORSE_RACE);
        when(f1RaceMessage.getCategory()).thenReturn(ResultCategory.F1_RACE);
        when(boatRaceMessage.getCategory()).thenReturn(ResultCategory.BOAT_RACE);
        when(clientRegisteredToHorseRaces.getCategories()).thenReturn(Arrays.asList(ResultCategory.HORSE_RACE));
    }

    @Test
    public void subscribersShouldReceiveOnlySelectedCategories() {
        raceResults.addSubscriber(clientRegisteredToHorseRaces);

        raceResults.send(horseRaceMessage);
        raceResults.send(f1RaceMessage);
        raceResults.send(boatRaceMessage);

        verify(clientRegisteredToHorseRaces).receive(horseRaceMessage);
        verify(clientRegisteredToHorseRaces, never()).receive(f1RaceMessage);
        verify(clientRegisteredToHorseRaces, never()).receive(boatRaceMessage);
    }
}

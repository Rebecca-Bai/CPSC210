package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Unit tests for Arrival
 * Created by q8h0b on 21/10/2015.
 */
public class ArrivalTest {

    private Arrival arrival;
    private int timeToStation;
    private String platform;
    private String destination;


    @Test
    public void testGetTravelDirn(){

    this.platform="   Westbound - Platform 1   ";
        arrival=new Arrival(timeToStation,destination,platform);
        String DIRECTION=arrival.getTravelDirn();
        assertEquals("Westbound",DIRECTION);
    }

    @Test
    public void testGetPlatformName(){

        this.platform="Westbound - Platform 1";
        arrival=new Arrival(timeToStation,destination,platform);
        String PLATFORM=arrival.getPlatformName();
        assertEquals("Platform 1",PLATFORM);
    }

    @Test
    public void testGetTimeToStationInMins(){

        this.timeToStation=0;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME0=arrival.getTimeToStationInMins();
        assertEquals(0,TIME0);

        this.timeToStation=20;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME1=arrival.getTimeToStationInMins();
        assertEquals(1,TIME1);

        this.timeToStation=60;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME2=arrival.getTimeToStationInMins();
        assertEquals(1,TIME2);

        this.timeToStation=61;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME4=arrival.getTimeToStationInMins();
        assertEquals(2,TIME4);

        this.timeToStation=90;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME3=arrival.getTimeToStationInMins();
        assertEquals(2,TIME3);

        this.timeToStation=120;
        arrival=new Arrival(timeToStation,destination,platform);
        int TIME5=arrival.getTimeToStationInMins();
        assertEquals(2,TIME5);
    }

    @Test
    public void testGetDestination(){

        this.destination="Ealing Broadway Underground Station";
        arrival=new Arrival(timeToStation,destination,platform);
        String DESTINATION=arrival.getDestination();
        assertEquals("Ealing Broadway Underground Station",DESTINATION);
    }

    @Test
    public void testGetPlateform(){

        this.platform="Westbound - Platform 1";
        arrival=new Arrival(timeToStation,destination,platform);
        String PLATFORM=arrival.getPlatform();
        assertEquals("Westbound - Platform 1",PLATFORM);
    }
}


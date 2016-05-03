package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;
import ca.ubc.cs.cpsc210.mindthegap.model.StationManager;
import ca.ubc.cs.cpsc210.mindthegap.model.exception.StationException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import ca.ubc.cs.cpsc210.mindthegap.util.SphericalGeometry;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Unit tests for StationManager
 */
public class StationManagerTest {
    private StationManager stnManager;
    public static final int RADIUS = 10000;
    private Set<Station> stns;
    private Station selectedStation;
    private Station station;
    private LatLon latLon;
    private Line line;
    private LineResourceData lmd;
    @Before
    public void setUp() {
        stnManager = StationManager.getInstance();
        stnManager.clearSelectedStation();
        stnManager.clearStations();
        station=new Station("","",latLon);
        line=new Line(lmd,"","");
    }

    @Test
    public void testStationManagerConstructor() {
        assertEquals(stnManager.getSelected(), null);
    }

    // You will need to add more tests!
    @Test
    public void testGetSelected()  {
    assertEquals(null, stnManager.getSelected());
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        try {
            stnManager.setSelected(station);
        } catch (StationException e) {
            System.out.println("do not have station");
        }
        assertEquals(station, stnManager.getSelected());
    }

    @Test
    public  void testClearSelectedStation()  {
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        try {
            stnManager.setSelected(station);
        } catch (StationException e) {
            System.out.println("do not have station");
        }
        stnManager.clearSelectedStation();
        assertEquals(null, stnManager.getSelected());
    }

    @Test
    public void testAddStationOnLine(){
    assertFalse(line.hasStation(station));
        assertEquals(null, stnManager.getStationWithId(""));
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        assertEquals(station, stnManager.getStationWithId(""));
        assertEquals(null, stnManager.getStationWithId("id"));
    }

    @Test
    public void testGetStationWithId(){
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        Station s=stnManager.getStationWithId("");
        assertEquals(station,s);
    }

    @Test (expected=StationException.class)
    public void testSetSelected() throws StationException {

            stnManager.setSelected(station);
        fail("StationException should have been throw");

    }

    @Test
    public void testGetNumStations(){
        assertEquals(0, stnManager.getNumStations());
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        assertEquals(1, stnManager.getNumStations());
        Station s=new Station("1","2",latLon);
        line.addStation(s);
        stnManager.addStationsOnLine(line);
        assertEquals(2, stnManager.getNumStations());
        stnManager.addStationsOnLine(line);
        assertEquals(2, stnManager.getNumStations());
        stnManager.clearStations();
        assertEquals(0, stnManager.getNumStations());
    }

    @Test
    public void testFindNearestTo(){
        LatLon latLon0=new LatLon(0,0);
        latLon=new LatLon(0.01,0.01);
        LatLon latLon1=new LatLon(0.05,0.05);
        Double d=SphericalGeometry.distanceBetween(latLon0, latLon1);
        LatLon latLon2=new LatLon(10000,10000);
        station=new Station("","",latLon);
        Station station1=new Station("1","1",latLon1);
        Station station2=new Station("2","1",latLon2);
        assertEquals(null,stnManager.findNearestTo(latLon0));
        line.addStation(station2);
        stnManager.addStationsOnLine(line);
        assertEquals(null, stnManager.findNearestTo(latLon0));
        line.addStation(station1);
        stnManager.addStationsOnLine(line);
        assertEquals(station1, stnManager.findNearestTo(latLon0));
        line.addStation(station);
        stnManager.addStationsOnLine(line);
        assertEquals(station, stnManager.findNearestTo(latLon0));
    }

}
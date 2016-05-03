package ca.ubc.cs.cpsc210.mindthegap.tests.model;
import ca.ubc.cs.cpsc210.mindthegap.model.*;
import ca.ubc.cs.cpsc210.mindthegap.parsers.BranchStringParser;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.BindingType;
import java.util.*;

import static org.junit.Assert.*;
/**
 * Created by Mengyu on 2015/10/26.
 */
public class TestStation {
    private List<ArrivalBoard> arrivalBoards;
    private String id;
    private String name;
    private LatLon locn;
    private Set<Line> lines;
    private List<Arrival> arrivals;
    private Station station;
    private List<Station> stns;
    private LatLon latlon;
    private Line line;
    private Arrival arrival;
    private ArrivalBoard ab1;
    private LineResourceData lmd;


        @Before
    public void setUp(){
            station=new Station("940GZZLUBLG","Bethnal Green Underground Station",latlon);
            lines=new HashSet<>();
            arrivals=new ArrayList<>();
            arrival=new Arrival(5,"","");
            arrivalBoards=new ArrayList<>();
            ab1=new ArrivalBoard(line,"");
            arrivalBoards.add(ab1);
            stns =new ArrayList<>();
            line=new Line(lmd.CENTRAL,id,name);

        }

    @Test
    public void testGetName(){
        assertEquals("Bethnal Green Underground Station", station.getName());
    }
    @Test
    public void testGetLocn(){
        assertEquals(latlon,station.getLocn());
    }
    @Test
    public void testGetID(){
        assertEquals("940GZZLUBLG",station.getID());
    }
    @Test
    public void testGetLines(){
        assertEquals(lines,station.getLines());
    }
    @Test
    public void testNumArrivalBoards(){
        assertEquals(0, station.getNumArrivalBoards());
        station.addArrival(line,arrival);
        assertEquals(1, station.getNumArrivalBoards());
    }
    @Test
    public void testAddLine(){
        Line l=new Line(lmd,"","ww");
        l.addStation(station);
        assertEquals("",station.getLines().iterator().next().getId());
    }

    @Test
    public void testAddArrival(){
        Line l=new Line(lmd,"","ww");
        Line l1=new Line(lmd,"1","ww");
        Arrival arrival1=new Arrival(4,"","");
        station.addArrival(l, arrival);
       List<ArrivalBoard> it= station.getArrivalBoards();

        ArrivalBoard first=it.get(0);
        assertEquals("", first.getLine().getId());
        LatLon latlon1=new LatLon(1.1,2.2);
        station.addArrival(l1, arrival1);
        ArrivalBoard second=it.get(1);
        assertEquals("1",second.getLine().getId());
    }

    @Test
    public void testRemoveLine(){
        Line l=new Line(lmd,"","ww");
        l.addStation(station);
        assertEquals("", station.getLines().iterator().next().getId());
        station.removeLine(l);
        assertEquals(0,station.getLines().size());
    }

    @Test
     public void testHasLine(){
        Line l=new Line(lmd,"","ww");
        l.addStation(station);
        assertEquals("", station.getLines().iterator().next().getId());
        assertTrue(station.hasLine(l));
    }

    @Test
    public void testClearArrivalBoards(){
        Line l=new Line(lmd,"","ww");
        l.addStation(station);
        assertEquals("", station.getLines().iterator().next().getId());
        station.clearArrivalBoards();
        assertEquals(0, station.getNumArrivalBoards());
    }

    @Test
    public void testEqual(){
        Line l=new Line(lmd,"","ww");
        Line l1=new Line(lmd,"1","ww");
        station.addLine(l1);
        assertTrue(station.hasLine(l1));
        l.addStation(station);
        assertEquals("", station.getLines().iterator().next().getId());
        LatLon latlon1=new LatLon(1.1,2.2);
        Station station1=new Station("940GZZLUBLG","abc",latlon1);
        assertEquals(station,station1);
    }

}

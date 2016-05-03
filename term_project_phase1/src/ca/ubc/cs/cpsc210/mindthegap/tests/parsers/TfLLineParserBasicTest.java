package ca.ubc.cs.cpsc210.mindthegap.tests.parsers;

import ca.ubc.cs.cpsc210.mindthegap.TfL.DataProvider;
import ca.ubc.cs.cpsc210.mindthegap.TfL.FileDataProvider;
import ca.ubc.cs.cpsc210.mindthegap.model.Branch;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.parsers.TfLLineParser;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLLineDataMissingException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Unit test for TfLLineParser
 */
public class TfLLineParserBasicTest {
    private String lineData;

    @Before
    public void setUp() throws Exception {
        DataProvider dataProvider = new FileDataProvider("./res/raw/central_inbound.json");
        lineData = dataProvider.dataSourceToString();
    }

    @Test
    public void testBasicLineParsing() {
        try {
            TfLLineParser.parseLine(LineResourceData.CENTRAL, lineData);
        } catch (JSONException e) {
            fail("JSONException should not have been thrown while parsing data in central_inbound.json");
        } catch (TfLLineDataMissingException e) {
            fail("TfLLineDataMissingException should not have been thrown while parsing data in central_inbound.json");
        }
    }

    @Test
    public void testTfLineParser() {
        TfLLineParser tfLLineParser=new TfLLineParser();
        try {

            Line line=tfLLineParser.parseLine(LineResourceData.CENTRAL, lineData);
            assertEquals("central",line.getId());
            assertEquals("Central",line.getName());
            assertEquals(0xFFDC241F,line.getColour());
            LatLon latlon =new LatLon(51.6037,0.093493);
            LatLon latlon1 =new LatLon(51.5697,-0.437875);

            List<Branch> braches=new ArrayList<>();
            for (Branch branch:line.getBranches()){
                braches.add(branch);
            }
            LatLon latlon4=new LatLon(51.6037,0.093493);
            assertEquals(latlon4,braches.get(1).getPoints().get(0));
            List<LatLon> points = line.getBranches().iterator().next().getPoints();
            assertEquals(latlon, points.get(0));


            String id=line.getStations().get(0).getID();
            String name=line.getStations().get(0).getName();
            LatLon latlon3=line.getStations().get(0).getLocn();
            LatLon latlon2=new LatLon(51.603665,0.09349300000000001);
            assertEquals(id,"940GZZLUHLT");
            assertEquals(name,"Hainault");
            assertEquals(latlon3,latlon2);

            LatLon latlon30=new LatLon(51.606906,0.03398);
            String id1=line.getStations().get(48).getID();
            String name1=line.getStations().get(48).getName();
            LatLon latlon31=line.getStations().get(48).getLocn();

           // assertEquals(id1,"940GZZLUWOF");
            //assertEquals(name1,"Woodford");
           // assertEquals(latlon31,latlon30);


        } catch (JSONException e) {
            System.out.println("JSON data doesn't have expected format.");
            e.printStackTrace();
        } catch (TfLLineDataMissingException e) {
            e.printStackTrace();
        }

    }

    // The single test above is very basic - it simply checks that your parser
    // doesn't throw an exception.
}
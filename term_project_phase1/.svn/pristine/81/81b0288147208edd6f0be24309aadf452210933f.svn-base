package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Branch;
import ca.ubc.cs.cpsc210.mindthegap.parsers.BranchStringParser;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.BindingType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Mengyu on 2015/10/26.
 */
public class BranchTest {

    private List<LatLon> pts;
    private String linestring;
    private String linestring2;
    private Branch branch;
    private Branch branch2;

    @Before
    public void setUp()  {
        linestring="[[[0.093493,51.6037],[0.091015,51.5956],[0.088596,51.5857]]]";
        linestring2="[[[0.093493,51.6037]]]";
        branch=new Branch(linestring);
        branch2=new Branch(linestring2);
    }

    @Test
    public void testGetPoints()  {
        LatLon latlon =new LatLon(51.6037,0.093493);
         assertEquals(latlon, branch.getPoints().get(0));
        assertEquals(latlon, branch2.getPoints().get(0));
    }

}

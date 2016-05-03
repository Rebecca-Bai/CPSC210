package ca.ubc.cs.cpsc210.mindthegap.TfL;

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    private Station stn;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    /**
     * Produces URL used to query TfL web service for expected arrivals at
     * station specified in call to constructor.
     *
     * @returns URL to query TfL web service for arrival data
     */
    protected URL getURL() throws MalformedURLException {
        String request = "";
        String stoppointid=stn.getID();
        String id;
        String ids="";
                for (Line line:stn.getLines()){
                    id=line.getId();
                    ids=ids+","+id;
                }
        request="https://api.tfl.gov.uk/Line/"+ids+"/Arrivals?stopPointId="+stoppointid+"&app_id=&app_key=";
        return new URL(request);
    }
}

package ca.ubc.cs.cpsc210.mindthegap.parsers;


import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Parser for route strings in TfL line data
 */
public class BranchStringParser {

    /**
     * Parse a branch string obtained from TFL
     *
     * @param branch  branch string
     * @return       list of lat/lon points parsed from branch string
     */
    public static List<LatLon> parseBranch(String branch) {
        List<LatLon> latLonList=new ArrayList<LatLon>();
        try {
            JSONArray branchJsonObject = new JSONArray(branch);
            JSONArray listOfLatLonJSONArray1 = branchJsonObject.getJSONArray(0);
            for (int i = 0; i < listOfLatLonJSONArray1.length(); i++) {
                JSONArray latLon0 = listOfLatLonJSONArray1.getJSONArray(i);
                Double lat=latLon0.getDouble(1);
                Double lon=latLon0.getDouble(0);
                LatLon latLon2 = new LatLon(lat, lon);
                latLonList.add(latLon2);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return latLonList;
    }
}

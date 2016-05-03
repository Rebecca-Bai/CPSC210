package ca.ubc.cs.cpsc210.mindthegap.tests.parsers;

import ca.ubc.cs.cpsc210.mindthegap.TfL.DataProvider;
import ca.ubc.cs.cpsc210.mindthegap.TfL.FileDataProvider;
import ca.ubc.cs.cpsc210.mindthegap.model.*;
import ca.ubc.cs.cpsc210.mindthegap.parsers.TfLArrivalsParser;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLArrivalsDataMissingException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for TFL Arrivals parser
 */
public class AbstractTfLArrivalsParserTest {
    protected Station stn;

    protected int countArrivals(String lineId) {
        int countArrivals = 0;

        for (ArrivalBoard next : stn) {
            if (next.getLine().getId().equals(lineId)) {
                countArrivals += next.getNumArrivals();
            }
        }
        return countArrivals;
    }

    protected int countArrivalsInDirection(String lineId, String compassDirn) {
        int countArrivals = 0;

        for(ArrivalBoard ab : stn) {
            if(ab.getLine().getId().equals(lineId) && ab.getTravelDirn().equals(compassDirn)) {
                for(Arrival arr : ab) {
                    countArrivals++;
                }
            }
        }

        return countArrivals;
    }

    protected Arrival getFirstArrivalInDirection(String lineId, String compassDirn) {
        for(ArrivalBoard ab : stn) {
            if(ab.getLine().getId().equals(lineId) && ab.getTravelDirn().equals(compassDirn)) {
                Iterator<Arrival> itr = ab.iterator();
                return itr.next();
            }
        }

        return null;
    }

    protected Arrival getLastArrivalInDirection(String lineId, String compassDirn) {
        for (ArrivalBoard ab : stn) {
            if (ab.getLine().getId().equals(lineId) && ab.getTravelDirn().equals(compassDirn)) {
                Iterator<Arrival> itr = ab.iterator();
                Arrival next = null;

                while (itr.hasNext())
                    next = itr.next();

                return next;
            }
        }
        return null;
    }
    }


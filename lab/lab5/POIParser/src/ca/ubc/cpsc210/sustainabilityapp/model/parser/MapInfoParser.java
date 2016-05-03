package ca.ubc.cpsc210.sustainabilityapp.model.parser;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;

public class MapInfoParser extends DefaultHandler {
	
	private List<PointOfInterest> pointsOfInterest;
	private StringBuffer accumulator;
private PointOfInterest e;

	private Double latitude;
	private Double longitude;
	private LatLong latLong;
	private List<Feature> lof;

    // Constructor
    // EFFECTS: this parsers list of points of interest get the list passed as a parameter
	public MapInfoParser(List<PointOfInterest> pointsOfInterest) {

		this.pointsOfInterest = pointsOfInterest;
	}

	@Override
	public void startDocument(){
		accumulator = new StringBuffer();
	}

	@Override
	public void startElement(String namespaceURI, String localName,
							 String qName, Attributes atts) {

		if (qName.equals("POI")) {
			lof= new ArrayList<Feature>();
			String id= atts.getValue("Id");
			String displayName=atts.getValue("DisplayName");
			this.e = new PointOfInterest(id, displayName);
		}
	}
	public void characters(char[] temp, int start, int length) {

		accumulator.append(temp, start, length);
	}


	public void endElement(String uri, String localName, String qName) {
		String data = accumulator.toString().trim();


		if (qName.equals("Address")){
			e.setAddress(data);
		}
		else if (qName.equals("Lat")){
			latitude= Double.parseDouble(accumulator.toString());

		}
		else if (qName.equals("Long")){
			longitude= Double.parseDouble(accumulator.toString());

		this.latLong=new LatLong(latitude, longitude);
			e.setLatLong(latLong);
		}
		else if (qName.equals("Description")){
			e.setDescription(data);
		}
		else if (qName.equals("Feature")){
			Feature f = Feature.parseFeature(data);
			lof.add(f);
		}
		else if (qName.equals("POI")){
			e.setFeatures(lof);
			pointsOfInterest.add(e);

		}
		accumulator.setLength(0);
	}



}

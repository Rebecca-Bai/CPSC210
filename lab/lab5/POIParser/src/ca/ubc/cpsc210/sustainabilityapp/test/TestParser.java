package ca.ubc.cpsc210.sustainabilityapp.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;
import ca.ubc.cpsc210.sustainabilityapp.model.parser.MapInfoParser;

public class TestParser {
	private static final double DELTA = 1.0e-6;   // for testing doubles
	private List<PointOfInterest> pointsOfInterest;
	private PointOfInterest first;
	private PointOfInterest last;
	private Feature f;
	
	@Before
	public void setUp() {
		pointsOfInterest = new ArrayList<PointOfInterest>();
		
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new MapInfoParser(pointsOfInterest));
			reader.parse("UBC-Sustainability-MapInfo.xml");
			
			first = pointsOfInterest.get(0);
			last = pointsOfInterest.get(pointsOfInterest.size() - 1);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNumPOIs() {
		assertEquals(7, pointsOfInterest.size());
	}
	
	@Test
	public void testIdFirst() {
		assertEquals("Law", first.getId());
	}

	@Test
	public void testdisplayNameFirst() {
		assertEquals("Law Building",first.getDisplayName());
	}

	@Test
	public void testaddressFirst() {
		assertEquals("1822 East Mall, Vancouver, BC",first.getAddress());
	}
	@Test
	public void testLatLongFirst() {
		assertEquals(49.269041, first.getLatLong().getLatitude(),DELTA);
		assertEquals(-123.25319, first.getLatLong().getLongitude(),DELTA);
	}
	@Test
	public void testDescriptionFirst() {
		assertEquals("LEED Gold certification. Renovating the old building would have cost four-fifths the amount to construct a new building. In contrast to the Chemistry Centre, UBC decided to construct a new law building instead of renovating -- each project is evaluated individually to determine what is best environmentally, economically and socially. The Faculty of Law outgrew the old building so now they will enjoy state-of-the-art teaching and research spaces that promote legal discussions and student engagement.",first.getDescription());
	}
	@Test
	public void testFeatureFirst() {

		assertEquals("LEED Certification", first.getFeatures().get(0).getDisplayName());
		assertEquals("Wastewater Treatment", first.getFeatures().get(1).getDisplayName());
	}
	
	@Test
	public void testIdLast() {
		assertEquals("LSC", last.getId());
	}
	@Test
	public void testdisplayNamelast() {
		assertEquals("Law Building",first.getDisplayName());
	}

	@Test
	public void testaddresslast() {
		assertEquals("1822 East Mall, Vancouver, BC",first.getAddress());
	}
	@Test
	public void testLatLonglast() {
		assertEquals(49.269041, first.getLatLong().getLatitude(),DELTA);
		assertEquals(-123.25319, first.getLatLong().getLongitude(),DELTA);
	}
	@Test
	public void testDescriptionLast() {
		assertEquals("LEED Gold certification. Renovating the old building would have cost four-fifths the amount to construct a new building. In contrast to the Chemistry Centre, UBC decided to construct a new law building instead of renovating -- each project is evaluated individually to determine what is best environmentally, economically and socially. The Faculty of Law outgrew the old building so now they will enjoy state-of-the-art teaching and research spaces that promote legal discussions and student engagement.",first.getDescription());
	}
	@Test
	public void testFeatureLast() {

		assertEquals("LEED Certification", first.getFeatures().get(0).getDisplayName());
		assertEquals("Wastewater Treatment", first.getFeatures().get(1).getDisplayName());
	}

}

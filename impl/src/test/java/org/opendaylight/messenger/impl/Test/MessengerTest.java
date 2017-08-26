/*
 * Copyright © 2016 SC and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl.Test;

import org.junit.Test;
import org.opendaylight.messenger.impl.Element;
import org.opendaylight.messenger.impl.MessengerProvider;
import org.opendaylight.messenger.impl.PeriodicTable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;


public class MessengerTest {
	private static final String INPUT_CSV_FILE_NAME = "src\\main\\resources\\Periodic Table of Elements.csv";
	private static final String OUTPUT_JASON_FILE_NAME = "src\\main\\resources\\PeriodicTable.json";
	private static final String OUTPUT_XML_FILE_NAME = "src\\main\\resources\\PeriodicTable.xml";
	

	MessengerProvider messengerProvider = new MessengerProvider(null) ;
	
	@Before public void initialize() {
		 
		String fileName = "src\\main\\resources\\Periodic Table of Elements.csv";
		messengerProvider.setPeriodicTable(new PeriodicTable(fileName));
	}
	
	@Test
	public void testInit()
	{
		

		messengerProvider.init();
		

		assertTrue(!(messengerProvider.getPeriodicTable().getElements()).isEmpty());

	}
	
	@Test
	public void getElementByNameTest()
	{
		
		Element elementInfo = messengerProvider.getPeriodicTable().getElementInfo("Tellurium");
		System.out.println(elementInfo.toString());
		assertTrue(elementInfo.getElementName().equals("Tellurium"));
		assertTrue(elementInfo.getSymbol().equals("Te"));
	}
	
	
	@Test
	public void exportToJSONTest()
	{
		
		messengerProvider.exportToJson();
				
		ObjectMapper mapper = new ObjectMapper();
		try {
			PeriodicTable periodicTableJSON = mapper.readValue(new File(OUTPUT_JASON_FILE_NAME), PeriodicTable.class);
			
			assertTrue(compareObjects(periodicTableJSON));
					
		} catch (JsonParseException e) {
						
			assertFalse("can't parse JSON objet", true);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			assertFalse("can't map JSON objet", true);
			e.printStackTrace();
		} catch (IOException e) {
			assertFalse("can't open the file", true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void exportToXMLTest()
	{
		
		File file = new File(OUTPUT_XML_FILE_NAME);
		JAXBContext jaxbContext;
	
		try {
		
			jaxbContext = JAXBContext.newInstance(PeriodicTable.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PeriodicTable periodicTableXML = (PeriodicTable) jaxbUnmarshaller.unmarshal(file);
			assertTrue(compareObjects(periodicTableXML));
		} catch (JAXBException e) {
			assertFalse("something went wrong with JAXB", true);
			e.printStackTrace();
		}

		
	
	}

	
	private Boolean compareObjects( PeriodicTable periodicTableactual) {
		for ( Element element : periodicTableactual.getElements()) {
			
			String elementName  = element.getElementName();
			Element actual = messengerProvider.getPeriodicTable().getElementInfo(elementName);
			Element expected = periodicTableactual.getElementInfo(elementName);
			
			if(!actual.getElementName().equals(expected.getElementName()))
			{
				return false;
			}
		}
		return true;
	}

}

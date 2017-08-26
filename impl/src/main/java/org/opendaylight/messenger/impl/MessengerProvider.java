/*
 * Copyright © 2016 you/me/whatever and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import  org.opendaylight.messenger.impl.PeriodicTable;


import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MessengerProvider {

    
	private static final String INPUT_CSV_FILE_NAME = "src\\main\\resources\\Periodic Table of Elements.csv";
	private static final String OUTPUT_JASON_FILE_NAME = "src\\main\\resources\\PeriodicTable.json";
	private static final String OUTPUT_XML_FILE_NAME = "src\\main\\resources\\PeriodicTable.xml";
	private static final Logger LOG = LoggerFactory.getLogger(MessengerProvider.class);
    
    private PeriodicTable periodicTable;
    
    private final DataBroker dataBroker;
    public MessengerProvider(final DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("MessengerProvider Session Initiated");
        String fileName = INPUT_CSV_FILE_NAME;
        setPeriodicTable(new PeriodicTable(fileName));
        printToLog();
        exportToXML();
        exportToJson();
     
    }

    /**
     * export the periodic table to JSON using Jackson 
     */
	public void exportToJson() {
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	try {
			mapper.writeValue(new File(OUTPUT_JASON_FILE_NAME), this.periodicTable);
			//System.out.println(mapper.writeValueAsString(this.periodicTable));*/
		} catch (IOException e) {
			LOG.error("Unable to export periodic table to JSON",  e);
		}
		
	}

	
	/**
	 * exports the periodic table to excel using JAXB 
	 */
	public void exportToXML()  {
		File file = new File(OUTPUT_XML_FILE_NAME);
        
        try {
        	JAXBContext jaxbContext = JAXBContext.newInstance(PeriodicTable.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
           			jaxbMarshaller.marshal(periodicTable, file);
		} catch (JAXBException e) {
			LOG.error("Unable to export periodic table to XML",  e);
		}
        
		
	}

	/**
	 * prints to log
	 */
	public void printToLog() {
		
		for (Element element : periodicTable.getElements()) {
		LOG.info(element.toString());
	}
		
		
	}

	/**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("MessengerProvider Closed");
    }

	public PeriodicTable getPeriodicTable() {
		return periodicTable;
	}

	public void setPeriodicTable(PeriodicTable periodicTable) {
		this.periodicTable = periodicTable;
	}
}
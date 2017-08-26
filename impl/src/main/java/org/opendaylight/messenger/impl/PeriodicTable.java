/*
 * Copyright (c) 2016 <Company or Individual>.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PeriodicTable {
	@XmlElementWrapper(name = "elements")
	@XmlElement(name = "element")
	private List<Element> elements = new ArrayList<Element>();

	public PeriodicTable() {
		// TODO Auto-generated constructor stub
	}
	
	public PeriodicTable(String fileName) {
		
		String headerLine;
		String dataLine;
		
		String comma =",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			if((headerLine = br.readLine()) !=null)
			{
				//String[] headerToElement = headerLine.split(comma);
				while ((dataLine=br.readLine())!=null)
				{
					String[] dataToElement = dataLine.split(comma);
					Element element = new Element(dataToElement[0],dataToElement[1],dataToElement[2],dataToElement[3],dataToElement[4],dataToElement[5],dataToElement[6],dataToElement[7],dataToElement[8],dataToElement[9],dataToElement[10],dataToElement[11],dataToElement[12],dataToElement[13],dataToElement[14],dataToElement[15],dataToElement[16],dataToElement[17],dataToElement[18],dataToElement[19],dataToElement[20],dataToElement[21]);
					this.elements.add(element);
					}
			}
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}

		// TODO Auto-generated constructor stub
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public Element getElementInfo (String elementName)
	{
		
		 for (Element element : elements) {
			 if (element.getElementName().equals(elementName))
			 {
				 return element;
			 }
						
		}
		
		return null;

	}
}

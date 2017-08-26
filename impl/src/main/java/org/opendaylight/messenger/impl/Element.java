/*
 * Copyright (c) 2016 <Company or Individual>.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Element {

	//POJO element to represent a row in the csv file, i used POJO to make JSON and XML export easier. also wanted a quick solution rather than one that will take me more time.

	@XmlElement
	private String atomicNumber;
	@XmlElement
	private String elementName;
	@XmlElement
	private String symbol;
	@XmlElement
	private String atomicWeight;
	@XmlElement
	private String period; 
	@XmlElement
	private String group;
	@XmlElement
	private String phase;
	@XmlElement
	private String mostStableCrystal;
	@XmlElement
	private String type; 
	@XmlElement
	private String tonicRadius; 
	@XmlElement
	private String atomiRadius;
	@XmlElement
	private String electronegativity;	 
	@XmlElement
	private String firstIonizationPotential;
	@XmlElement
	private String densityMeltingPointK;
	@XmlElement
	private String boilingPointK; 
	@XmlElement
	private String isotopes; 
	@XmlElement
	private String discoverer; 
	@XmlElement
	private String yearOfDiscovery; 
	@XmlElement
	private String specificHeatCapacity; 
	@XmlElement 
	private String electronConfiguration; 
	@XmlElement
	private String displayRow;
	@XmlElement
	private String displayColumn;


public Element() {
	// TODO Auto-generated constructor stub
}
	
	
	
	public Element(String atomicNumber,String elementName,String symbol,String atomicWeight, String period, String group, String phase, String mostStableCrystal, String type, String tonicRadius, 
			String atomiRadius, String electronegativity, String firstIonizationPotential, String densityMeltingPointK, String boilingPointK,String isotopes, String discoverer,
			String yearOfDiscovery,String specificHeatCapacity, String electronConfiguration,String displayRow, String displayColumn) {

				this.setAtomicNumber(atomicNumber);
				this.setElementName(elementName);
				this.setSymbol(symbol);
				this.setAtomicWeight(atomicWeight);
				this.setPeriod(period);
				this.setGroup(group);
				this.setPhase(phase);
				this.setMostStableCrystal(mostStableCrystal);
				this.setType(type);
				this.setTonicRadius(tonicRadius);
				this.setAtomiRadius(atomiRadius);
				this.setElectronegativity(electronegativity);
				this.setFirstIonizationPotential(firstIonizationPotential);
				this.setDensityMeltingPointK(densityMeltingPointK);
				this.setBoilingPointK(boilingPointK);
				this.setIsotopes(isotopes);
				this.setDiscoverer(discoverer);
				this.setYearOfDiscovery(yearOfDiscovery);
				this.setSpecificHeatCapacity(specificHeatCapacity);
				this.setElectronConfiguration(electronConfiguration);
				this.setDisplayRow(displayRow);
				this.setDisplayColumn(displayColumn);
				
		}
				
	
	
	@Override
	public String toString() {
		
		return  ToStringBuilder.reflectionToString(this);
	}




	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public String getAtomicWeight() {
		return atomicWeight;
	}



	public void setAtomicWeight(String atomicWeight) {
		this.atomicWeight = atomicWeight;
	}



	public String getPeriod() {
		return period;
	}



	public void setPeriod(String period) {
		this.period = period;
	}



	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public String getPhase() {
		return phase;
	}



	public void setPhase(String phase) {
		this.phase = phase;
	}



	public String getMostStableCrystal() {
		return mostStableCrystal;
	}



	public void setMostStableCrystal(String mostStableCrystal) {
		this.mostStableCrystal = mostStableCrystal;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getTonicRadius() {
		return tonicRadius;
	}



	public void setTonicRadius(String tonicRadius) {
		this.tonicRadius = tonicRadius;
	}



	public String getAtomiRadius() {
		return atomiRadius;
	}



	public void setAtomiRadius(String atomiRadius) {
		this.atomiRadius = atomiRadius;
	}



	public String getElectronegativity() {
		return electronegativity;
	}



	public void setElectronegativity(String electronegativity) {
		this.electronegativity = electronegativity;
	}



	public String getFirstIonizationPotential() {
		return firstIonizationPotential;
	}



	public void setFirstIonizationPotential(String firstIonizationPotential) {
		this.firstIonizationPotential = firstIonizationPotential;
	}



	public String getDensityMeltingPointK() {
		return densityMeltingPointK;
	}



	public void setDensityMeltingPointK(String densityMeltingPointK) {
		this.densityMeltingPointK = densityMeltingPointK;
	}



	public String getBoilingPointK() {
		return boilingPointK;
	}



	public void setBoilingPointK(String boilingPointK) {
		this.boilingPointK = boilingPointK;
	}



	public String getIsotopes() {
		return isotopes;
	}



	public void setIsotopes(String isotopes) {
		this.isotopes = isotopes;
	}



	public String getDiscoverer() {
		return discoverer;
	}



	public void setDiscoverer(String discoverer) {
		this.discoverer = discoverer;
	}



	public String getYearOfDiscovery() {
		return yearOfDiscovery;
	}



	public void setYearOfDiscovery(String yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}



	public String getSpecificHeatCapacity() {
		return specificHeatCapacity;
	}



	public void setSpecificHeatCapacity(String specificHeatCapacity) {
		this.specificHeatCapacity = specificHeatCapacity;
	}



	public String getElectronConfiguration() {
		return electronConfiguration;
	}



	public void setElectronConfiguration(String electronConfiguration) {
		this.electronConfiguration = electronConfiguration;
	}



	public String getDisplayColumn() {
		return displayColumn;
	}



	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}



	public String getDisplayRow() {
		return displayRow;
	}



	public void setDisplayRow(String displayRow) {
		this.displayRow = displayRow;
	}



	public String getElementName() {
		return elementName;
	}



	public void setElementName(String elementName) {
		this.elementName = elementName;
	}



	public String getAtomicNumber() {
		return atomicNumber;
	}



	public void setAtomicNumber(String atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	

}

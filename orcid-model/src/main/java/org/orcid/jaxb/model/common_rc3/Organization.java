/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.05 at 03:27:53 PM GMT 
//

package org.orcid.jaxb.model.common_rc3;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "name", "address", "disambiguatedOrganization" })
@XmlRootElement(name = "organization", namespace = "http://www.orcid.org/ns/common")
public class Organization implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, namespace = "http://www.orcid.org/ns/common")
    protected String name;
    @XmlElement(required = true, namespace = "http://www.orcid.org/ns/common")
    protected OrganizationAddress address;
    @XmlElement(namespace = "http://www.orcid.org/ns/common", name = "disambiguated-organization")
    protected DisambiguatedOrganization disambiguatedOrganization;

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return possible object is {@link OrganizationAddress }
     * 
     */
    public OrganizationAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *            allowed object is {@link OrganizationAddress }
     * 
     */
    public void setAddress(OrganizationAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the disambiguatedOrganization property.
     * 
     * @return possible object is {@link DisambiguatedOrganization }
     * 
     */
    public DisambiguatedOrganization getDisambiguatedOrganization() {
        return disambiguatedOrganization;
    }

    /**
     * Sets the value of the disambiguatedOrganization property.
     * 
     * @param value
     *            allowed object is {@link DisambiguatedOrganization }
     * 
     */
    public void setDisambiguatedOrganization(DisambiguatedOrganization value) {
        this.disambiguatedOrganization = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((disambiguatedOrganization == null) ? 0 : disambiguatedOrganization.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Organization other = (Organization) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (disambiguatedOrganization == null) {
            if (other.disambiguatedOrganization != null)
                return false;
        } else if (!disambiguatedOrganization.equals(other.disambiguatedOrganization))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}

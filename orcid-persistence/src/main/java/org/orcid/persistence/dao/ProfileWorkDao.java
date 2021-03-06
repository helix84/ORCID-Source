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
package org.orcid.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.orcid.jaxb.model.message.Visibility;
import org.orcid.persistence.jpa.entities.ProfileWorkEntity;
import org.orcid.persistence.jpa.entities.keys.ProfileWorkEntityPk;

public interface ProfileWorkDao extends GenericDao<ProfileWorkEntity, ProfileWorkEntityPk> {

    /**
     * Removes the relationship that exists between a work and a profile.
     * 
     * @param workId
     *            The id of the work that will be removed from the client
     *            profile
     * @param clientOrcid
     *            The client orcid
     * @return true if the relationship was deleted
     * */
    boolean removeWork(String clientOrcid, String workId);

    /**
     * Removes the relationship that exists between a work and a profile.
     * 
     * @param workId
     *            The id of the work that will be removed from the client
     *            profile
     * @param clientOrcid
     *            The client orcid
     * @return true if the relationship was deleted
     * */
    boolean removeWorks(String clientOrcid, ArrayList<Long> workIds);

    
    /**
     * Updates the visibility of an existing profile work relationship
     * @param orcid users orcid
     * @param workIds
     *            The id of the work that will be updated
     * @param visibility
     *            The new visibility value for the profile work relationship
     * @return true if the relationship was updated
     * */
    boolean updateVisibility(String orcid, String workId, Visibility visibility);

    /**
     * Updates the visibility of an existing profile work relationship
     * @param orcid users orcid
     * @param workIds
     *            The id of the work that will be updated
     * @param visibility
     *            The new visibility value for the profile work relationship
     * @return true if the relationship was updated
     * */
    boolean updateVisibilities(String orcid, ArrayList<Long> workIds, Visibility visibility);

    
    /**
     * Get the profile work associated with the client orcid and the workId
     * 
     * @param clientOrcid
     *            The client orcid
     * 
     * @param workId
     *            The id of the work that will be updated
     * 
     * @return the profileWork object
     * */
    ProfileWorkEntity getProfileWork(String clientOrcid, String workId);

    /**
     * Creates a new profile entity relationship between the provided work and
     * the given profile.
     * 
     * @param orcid
     *            The profile id
     * 
     * @param workId
     *            The work id
     * 
     * @param visibility
     *            The work visibility
     * 
     * @return true if the profile work relationship was created
     * */
    boolean addProfileWork(String clientOrcid, long workId, Visibility visibility, String sourceOrcid);

    /**
     * Find the list of orcids where at least one of his works have contributors
     * but the credit name is null
     * 
     * @param chunkSize
     *            the number of orcids to fetch
     * @return A list of orcid's where at least one of his works have
     *         contributors but the credit name is null
     * */
    List<String> findOrcidsWhereWorkContributorCreditNameIsNull(int chunkSize);
    
    /**
     * Make the given work have the maxDisplay value, higher the value
     * equals how likely this work should be displayed before another 
     * work (or work version)
     * 
     * @param orcid
     * @param workId
     * @return
     */
    boolean updateToMaxDisplay(String orcid, String workId);
    
    void removeWorksByClientSourceId(String clientSourceId);

}

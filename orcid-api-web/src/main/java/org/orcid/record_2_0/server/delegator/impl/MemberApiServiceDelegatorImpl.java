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
package org.orcid.record_2_0.server.delegator.impl;

import static org.orcid.api.common.OrcidApiConstants.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.orcid.api.common.delegator.impl.OrcidApiServiceDelegatorImpl;
import org.orcid.api.common.exception.OrcidBadRequestException;
import org.orcid.api.common.exception.OrcidForbiddenException;
import org.orcid.api.common.exception.OrcidNotFoundException;
import org.orcid.api.t2.server.delegator.T2OrcidApiServiceDelegator;
import org.orcid.core.manager.ClientDetailsManager;
import org.orcid.core.manager.OrcidProfileManager;
import org.orcid.core.manager.ProfileEntityManager;
import org.orcid.core.security.visibility.aop.AccessControl;
import org.orcid.jaxb.model.message.CreationMethod;
import org.orcid.jaxb.model.message.ExternalIdentifier;
import org.orcid.jaxb.model.message.ExternalIdentifiers;
import org.orcid.jaxb.model.message.OrcidHistory;
import org.orcid.jaxb.model.message.OrcidMessage;
import org.orcid.jaxb.model.message.OrcidProfile;
import org.orcid.jaxb.model.message.ScopePathType;
import org.orcid.jaxb.model.message.Source;
import org.orcid.jaxb.model.message.SourceClientId;
import org.orcid.jaxb.model.message.SourceName;
import org.orcid.jaxb.model.message.SourceOrcid;
import org.orcid.jaxb.model.message.SubmissionDate;
import org.orcid.persistence.dao.ProfileDao;
import org.orcid.persistence.dao.WebhookDao;
import org.orcid.persistence.jpa.entities.ClientDetailsEntity;
import org.orcid.persistence.jpa.entities.ProfileEntity;
import org.orcid.persistence.jpa.entities.WebhookEntity;
import org.orcid.persistence.jpa.entities.keys.WebhookEntityPk;
import org.orcid.record_2_0.server.delegator.MemberApiServiceDelegator;
import org.orcid.utils.DateUtils;
import org.orcid.utils.NullUtils;
import org.orcid.utils.OrcidStringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * The delegator for the tier 2 API.
 * <p/>
 * The T2 delegator is responsible for the validation, retrieving results and
 * passing of objects to be from the core
 * 
 * @author Declan Newman (declan) Date: 07/03/2012
 */
@Component("orcidT2ServiceDelegator")
public class MemberApiServiceDelegatorImpl implements MemberApiServiceDelegator {

//    @Resource(name = "orcidProfileManager")
//    private OrcidProfileManager orcidProfileManager;

    @Resource
    private ClientDetailsManager clientDetailsManager;

    @Resource
    private ProfileEntityManager profileEntityManager;

    @Resource
    private WebhookDao webhookDao;

    @Resource
    private ProfileDao profileDao;

    @Override
    public Response viewStatusText() {
        return Response.ok(STATUS_OK_MESSAGE).build();
    }

    /**
     * finds and returns the {@link org.orcid.jaxb.model.message.OrcidMessage}
     * wrapped in a {@link javax.xml.ws.Response} with only the profile's bio
     * details
     * 
     * @param orcid
     *            the ORCID to be used to identify the record
     * @return the {@link javax.xml.ws.Response} with the
     *         {@link org.orcid.jaxb.model.message.OrcidMessage} within it
     */
    @Override
    @AccessControl(requiredScope = ScopePathType.ACTIVITIES_UPDATE)
    public Response viewActivities(String orcid) {
        profileEntityManager.findByOrcid(orcid);
        
       // OrcidProfile profile = orcidProfileManager.retrieveClaimedOrcidBio(orcid);
        
        return null;
    }

}
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
package org.orcid.api.memberV2.server.delegator;

import javax.ws.rs.core.Response;

import org.orcid.jaxb.model.groupid.GroupIdRecord;
import org.orcid.jaxb.model.record_rc1.Education;
import org.orcid.jaxb.model.record_rc1.Employment;
import org.orcid.jaxb.model.record_rc1.Funding;
import org.orcid.jaxb.model.record_rc1.PeerReview;
import org.orcid.jaxb.model.record_rc1.Work;
import org.orcid.jaxb.model.record_rc2.Address;
import org.orcid.jaxb.model.record_rc2.ExternalIdentifier;
import org.orcid.jaxb.model.record_rc2.Keyword;
import org.orcid.jaxb.model.record_rc2.OtherName;
import org.orcid.jaxb.model.record_rc2.ResearcherUrl;

/**
 * 
 * @author Will Simpson
 * 
 */
public interface MemberV2ApiServiceDelegator {

    Response viewStatusText();

    Response viewActivities(String orcid);

    Response viewWork(String orcid, Long putCode);

    Response viewWorkSummary(String orcid, Long putCode);

    Response createWork(String orcid, Work work);

    Response updateWork(String orcid, Long putCode, Work work);

    Response deleteWork(String orcid, Long putCode);

    Response viewFunding(String orcid, Long putCode);

    Response viewFundingSummary(String orcid, Long putCode);

    Response createFunding(String orcid, Funding funding);

    Response updateFunding(String orcid, Long putCode, Funding funding);

    Response deleteFunding(String orcid, Long putCode);

    Response viewEducation(String orcid, Long putCode);

    Response viewEducationSummary(String orcid, Long putCode);

    Response createEducation(String orcid, Education education);

    Response updateEducation(String orcid, Long putCode, Education education);

    Response viewEmployment(String orcid, Long putCode);

    Response viewEmploymentSummary(String orcid, Long putCode);

    Response createEmployment(String orcid, Employment employment);

    Response updateEmployment(String orcid, Long putCode, Employment employment);

    Response deleteAffiliation(String orcid, Long putCode);

    Response viewPeerReview(String orcid, Long putCode);

    Response viewPeerReviewSummary(String orcid, Long putCode);

    Response createPeerReview(String orcid, PeerReview peerReview);

    Response updatePeerReview(String orcid, Long putCode, PeerReview peerReview);

    Response deletePeerReview(String orcid, Long putCode);

    Response viewGroupIdRecord(Long putCode);

    Response createGroupIdRecord(GroupIdRecord groupIdRecord);

    Response updateGroupIdRecord(GroupIdRecord groupIdRecord, Long putCode);

    Response deleteGroupIdRecord(Long putCode);

    Response viewGroupIdRecords(String pageSize, String pageNum);

    Response viewResearcherUrls(String orcid);

    Response viewResearcherUrl(String orcid, Long putCode);

    Response updateResearcherUrl(String orcid, Long putCode, ResearcherUrl researcherUrl);

    Response createResearcherUrl(String orcid, ResearcherUrl researcherUrl);

    Response deleteResearcherUrl(String orcid, Long putCode);

    Response viewEmails(String orcid);

    Response viewOtherNames(String orcid);

    Response viewOtherName(String orcid, Long putCode);

    Response createOtherName(String orcid, OtherName otherName);

    Response updateOtherName(String orcid, Long putCode, OtherName otherName);

    Response deleteOtherName(String orcid, Long putCode);

    Response viewPersonalDetails(String orcid);
    
    Response viewExternalIdentifiers(String orcid);

    Response viewExternalIdentifier(String orcid, Long putCode);

    Response updateExternalIdentifier(String orcid, Long putCode, ExternalIdentifier externalIdentifier);

    Response createExternalIdentifier(String orcid, ExternalIdentifier externalIdentifier);

    Response deleteExternalIdentifier(String orcid, Long putCode);
    
    Response viewBiography(String orcid);
    
    Response viewKeywords(String orcid);

    Response viewKeyword(String orcid, Long putCode);

    Response createKeyword(String orcid, Keyword keyword);

    Response updateKeyword(String orcid, Long putCode, Keyword keyword);

    Response deleteKeyword(String orcid, Long putCode);
            
    Response viewAddresses(String orcid);

    Response viewAddress(String orcid, Long putCode);

    Response createAddress(String orcid, Address address);

    Response updateAddress(String orcid, Long putCode, Address address);

    Response deleteAddress(String orcid, Long putCode);
    
    Response viewPerson(String orcid);
}

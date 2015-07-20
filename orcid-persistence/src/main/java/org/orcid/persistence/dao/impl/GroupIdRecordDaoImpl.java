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
package org.orcid.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.orcid.persistence.dao.GroupIdRecordDao;
import org.orcid.persistence.jpa.entities.GroupIdRecordEntity;

public class GroupIdRecordDaoImpl extends GenericDaoImpl<GroupIdRecordEntity, Long> implements GroupIdRecordDao {

	
	public GroupIdRecordDaoImpl() {
		super(GroupIdRecordEntity.class);
	}

	@Override
	public List<GroupIdRecordEntity> getGroupIdRecords(int pageSize, int page) {
        TypedQuery<GroupIdRecordEntity> query = entityManager.createQuery("from GroupIdRecordEntity order by dateCreated", GroupIdRecordEntity.class);
        query.setFirstResult(pageSize * (page - 1));
        query.setMaxResults(pageSize);
        return query.getResultList();
	}
}
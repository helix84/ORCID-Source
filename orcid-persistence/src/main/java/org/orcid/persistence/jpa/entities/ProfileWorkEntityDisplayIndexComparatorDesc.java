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
package org.orcid.persistence.jpa.entities;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * Comparator that compares OrcidEntity objects based on their ID.
 * 
 * Spring Sort annotation didn't seem to have descending function.
 * Sort by index and then compare value
 * 
 * @author rcpeters
 * 
 */
public class ProfileWorkEntityDisplayIndexComparatorDesc<T> implements Comparator<ProfileWorkEntity>, Serializable {

    private static final long serialVersionUID = 1L;
    @Override
    public int compare(ProfileWorkEntity o1, ProfileWorkEntity o2) {
        Long index = o1.getDisplayIndex();
        Long otherIndex = o2.getDisplayIndex();
        if (index == otherIndex) return o2.compareTo(o1);
        if (index == null) return 1;
        if (otherIndex == null) return -1;
        return otherIndex.compareTo(index);
    }
}
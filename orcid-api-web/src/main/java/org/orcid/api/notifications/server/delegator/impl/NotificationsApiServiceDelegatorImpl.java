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
package org.orcid.api.notifications.server.delegator.impl;

import static org.orcid.api.common.OrcidApiConstants.STATUS_OK_MESSAGE;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.orcid.api.notifications.server.delegator.NotificationsApiServiceDelegator;
import org.orcid.core.manager.NotificationManager;
import org.orcid.jaxb.model.notification.Notification;
import org.orcid.jaxb.model.notification.addactivities.NotificationAddActivities;

import com.sun.jersey.api.Responses;

/**
 * 
 * @author Will Simpson
 *
 */
public class NotificationsApiServiceDelegatorImpl implements NotificationsApiServiceDelegator {

    @Resource
    private NotificationManager notificationManager;

    @Override
    public Response viewStatusText() {
        return Response.ok(STATUS_OK_MESSAGE).build();
    }

    @Override
    public Response findAddActivitiesNotifications(String orcid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response findAddActivitiesNotification(String orcid, Long id) {
        Notification notification = notificationManager.findByOrcidAndId(orcid, id);
        if (notification != null) {
            return Response.ok(notification).build();
        } else {
            return Responses.notFound().build();
        }
    }

    @Override
    public Response addAddActivitiesNotification(UriInfo uriInfo, String orcid, NotificationAddActivities notification) {
        Notification createdNotification = notificationManager.createNotification(orcid, notification);
        try {
            return Response.created(new URI(uriInfo.getAbsolutePath() + "/" + createdNotification.getPutCode().getPath())).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error constructing URI for add activities notification", e);
        }
    }

}
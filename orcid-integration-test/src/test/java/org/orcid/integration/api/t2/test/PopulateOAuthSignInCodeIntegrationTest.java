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
package org.orcid.integration.api.t2.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.transaction.annotation.Transactional;


public class PopulateOAuthSignInCodeIntegrationTest {

        private WebDriver webDriver;


    @Before
    @Transactional
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void emailPrePopulate() throws JSONException, InterruptedException {
        // test populating form with email that doesn't exist
        String url = "http://ci.orcid.org:8080/signin";
        webDriver.get(url);
        assertTrue(webDriver.findElements(By.xpath("//input[@name='userId']")).size() != 0);
        assertTrue(webDriver.findElements(By.xpath("//input[@name='userId2']")).size() == 0);
    }        
}

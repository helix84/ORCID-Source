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
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-oauth-orcid-api-client-context.xml" })
public class PopulateOAuthSignInCodeIntegrationTest {

    private WebDriver webDriver;

    @Value("${org.orcid.core.baseUri:http://localhost:8080/orcid-web}")
    private String webBaseUrl;
    

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
        System.out.println("-------------------------------------------------");
        System.out.println(webBaseUrl);
        System.out.println("-------------------------------------------------");
        
        Thread.sleep(20);
        
        // test populating form with email that doesn't exist
        String url = webBaseUrl;
        if(!webBaseUrl.endsWith("/"))
            url += "/";
        
        url += "signin";
        webDriver.get(url);
        assertTrue(webDriver.findElements(By.xpath("//input[@name='userId']")).size() != 0);
        assertTrue(webDriver.findElements(By.xpath("//input[@name='userId2']")).size() == 0);
    }         
}

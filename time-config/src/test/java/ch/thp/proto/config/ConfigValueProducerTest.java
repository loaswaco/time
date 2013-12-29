/*
 * Copyright 2013 Thierry.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.thp.proto.config;

import ch.thp.proto.config.domain.ConfigEntry;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Thierry
 */
@RunWith(Arquillian.class)
public class ConfigValueProducerTest {

    @Inject
    @ConfigValue("key.one")
    private String value;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackage(ConfigValueProducer.class.getPackage())
                .addClass(ConfigEntry.class)
                .addClass(ConfigTestSupportBean.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource("log4j.properties", "log4j.properties")
                .addAsManifestResource(
                        new ByteArrayAsset("<beans/>".getBytes()),
                        ArchivePaths.create("beans.xml"));

    }

    @Test
    public void testConfigAsString() {
        Assert.assertEquals("value.one", value);
    }

}

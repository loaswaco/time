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
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thierry
 */
@Singleton
@Startup
@LocalBean
public class ConfigTestSupportBean {
    
    @PersistenceContext
    private EntityManager em; 

    @PostConstruct
    public void initTest() {
        ConfigEntry configString = new ConfigEntry("1111-2222-3333-4444","key.one", "value.one", "desc.one");
        em.persist(configString);
    }

}

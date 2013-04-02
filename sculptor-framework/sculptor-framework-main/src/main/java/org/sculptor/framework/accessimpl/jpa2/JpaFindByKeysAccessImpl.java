/*
 * Copyright 2007 The Fornax Project Team, including the original
 * author or authors.
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

package org.sculptor.framework.accessimpl.jpa2;

import org.sculptor.framework.accessapi.FindByKeysAccess;


/**
 * <p>
 * Find all entities with matching keys. Implementation of Access command
 * FindByKeysAccess.
 * </p>
 * <p>
 * Command design pattern.
 * </p>
 */
public class JpaFindByKeysAccessImpl<T>
    extends JpaFindByKeysAccessImplGeneric<T,T>
    implements FindByKeysAccess<T> {

    public JpaFindByKeysAccessImpl() {
        super();
    }

    public JpaFindByKeysAccessImpl(Class<T> type) {
        super(type);
    }

    public void setPersistentClass(Class<? extends T> persistentClass) {
    	super.setPersistentClass(persistentClass);
    }
}
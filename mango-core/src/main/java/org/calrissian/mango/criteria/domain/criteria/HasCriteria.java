/*
 * Copyright (C) 2016 The Calrissian Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.calrissian.mango.criteria.domain.criteria;


import org.calrissian.mango.domain.Attribute;
import org.calrissian.mango.domain.AttributeStore;

import java.util.Collection;

public class HasCriteria<T> extends TermCriteria {

    private final Class<T> clazz;

    public HasCriteria(String term, Class<T> clazz, ParentCriteria parentCriteria) {
        super(term, parentCriteria);
        this.clazz = clazz;
    }

    public HasCriteria(String term, ParentCriteria parentCriteria) {
        this(term, null, parentCriteria);
    }

    @Override
    public boolean apply(AttributeStore obj) {
        if(obj.get(getTerm()) == null)
            return false;

        Collection<Attribute> attributes = obj.getAttributes(getTerm());
        if(attributes.size() > 0 && clazz == null)
            return true;

        for(Attribute attribute : attributes) {
            if(attribute.getValue().getClass().equals(clazz))
                return true;
        }

        return false;
    }

    @Override
    public Criteria clone(ParentCriteria parentCriteria) {
        return new HasCriteria<>(getTerm(), clazz, parentCriteria);
    }

    @Override
    public String toString() {
        return "hasTerm('" + getTerm() + "')";
    }
}

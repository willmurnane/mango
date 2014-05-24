/*
 * Copyright (C) 2013 The Calrissian Authors
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


import org.calrissian.mango.domain.TupleStore;

public class HasNotCriteria extends KeyValueLeafCriteria {
    public HasNotCriteria(String key, ParentCriteria parentCriteria) {
        super(key, null, parentCriteria);
    }

    @Override
    public boolean apply(TupleStore obj) {
        return obj.get(key) == null;
    }

  @Override
  public Criteria clone(ParentCriteria parentCriteria) {
    return new HasNotCriteria(key, parentCriteria);
  }


}

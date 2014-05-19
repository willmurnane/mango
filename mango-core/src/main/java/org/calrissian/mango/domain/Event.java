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
package org.calrissian.mango.domain;

import java.io.Serializable;

/**
 * An entry acts as a useful common business object for representing different types of models. An optional time
 * dimension can be set directly or left untouched (defaulting in current time).
 */
public interface Event extends TupleStore, Serializable {

    /**
     * Accessor for Id
     */
    String getId();

    /**
     * Accessor for timestamp
     */
    long getTimestamp();
}

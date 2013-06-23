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
package org.calrissian.mango.collect;

import org.junit.Test;

import java.io.IOException;

public class AbstractCloseableIteratorTest {

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrowsUnsupportedOperationException() {
        AbstractCloseableIterator iterator = testIterator();
        iterator.remove();
    }

    private <T> AbstractCloseableIterator<T> testIterator() {
        return new AbstractCloseableIterator<T>() {
            @Override
            protected T computeNext() {
                throw new RuntimeException();
            }

            @Override
            public void close() throws IOException {
                //do nothing.
            }
        };
    }
}
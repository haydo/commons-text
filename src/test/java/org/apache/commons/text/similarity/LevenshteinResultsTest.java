/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.text.similarity;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LevenshteinResultsTest {

    @Test
    public void testEqualsReturningFalse() {
        final Integer integerOne = new Integer(1662);
        final Integer integerTwo = new Integer(1164);
        final LevenshteinResults levenshteinResults = new LevenshteinResults(integerOne, integerOne, integerOne, integerOne);
        final LevenshteinResults levenshteinResultsTwo = new LevenshteinResults(integerOne, integerOne, integerTwo, integerTwo);

        assertFalse(levenshteinResults.equals(levenshteinResultsTwo));
    }

    @Test
    public void testEqualsWithNonNull() {
        final Integer integer = new Integer(1);
        final LevenshteinResults levenshteinResults = new LevenshteinResults(null, integer, integer, null);
        final LevenshteinResults levenshteinResultsTwo = new LevenshteinResults(null, null, null, null);

        assertFalse(levenshteinResults.equals(levenshteinResultsTwo));
    }

    @Test
    public void testEqualsWithNull() {
        final Integer integer = new Integer((-647));
        final LevenshteinResults levenshteinResults = new LevenshteinResults(integer, null, null, integer);

        assertFalse(levenshteinResults.equals(null));
    }

    @Test
    public void testEqualsDifferenceInSubstitutionCount() {
        final Integer integer = new Integer(1662);
        final LevenshteinResults levenshteinResults = new LevenshteinResults(integer, integer, integer, integer);
        final LevenshteinResults levenshteinResultsTwo = new LevenshteinResults(integer, integer, integer, null);

        assertFalse(levenshteinResults.equals(levenshteinResultsTwo));
    }

    @Test
    public void testEqualsSameObject() {
        final Integer integer = new Integer(1662);
        final LevenshteinResults levenshteinResults = new LevenshteinResults(integer, integer, integer, null);

        assertTrue(levenshteinResults.equals(levenshteinResults));
    }

}
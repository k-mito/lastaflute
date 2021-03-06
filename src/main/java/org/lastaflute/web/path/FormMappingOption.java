/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.lastaflute.web.path;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.dbflute.optional.OptionalThing;
import org.dbflute.util.DfTypeUtil;
import org.lastaflute.web.LastaWebKey;
import org.lastaflute.web.ruts.process.populate.FormSimpleTextParameterFilter;

// package is a little strange (path!? near adjustment provider...)
// but no change for compatible
/**
 * @author jflute
 */
public class FormMappingOption {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected boolean keepEmptyStringParameter;
    protected OptionalThing<FormSimpleTextParameterFilter> simpleTextParameterFilter = OptionalThing.empty();
    protected boolean undefinedParameterError;
    protected Set<String> indefinableParameterSet; // null allowed

    // ===================================================================================
    //                                                                              Facade
    //                                                                              ======
    // -----------------------------------------------------
    //                                          Empty String
    //                                          ------------
    public FormMappingOption asKeepEmptyStringParameter() {
        keepEmptyStringParameter = true;
        return this;
    }

    // -----------------------------------------------------
    //                                           Simple Text
    //                                           -----------
    public FormMappingOption filterSimpleTextParameter(FormSimpleTextParameterFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The argument 'filter' should not be null.");
        }
        this.simpleTextParameterFilter = OptionalThing.of(filter);
        return this;
    }

    // -----------------------------------------------------
    //                                   Undefined Parameter
    //                                   -------------------
    public FormMappingOption asUndefinedParameterError() {
        undefinedParameterError = true;
        return this;
    }

    public FormMappingOption indefinableParameters(String... indefinableParameters) {
        indefinableParameterSet = createIndefinableParameterSet(indefinableParameters);
        return this;
    }

    protected Set<String> createIndefinableParameterSet(String... indefinableParameters) {
        final Set<String> specifiedSet = new HashSet<String>(Arrays.asList(indefinableParameters));
        setupDefaultIndefinableParameter(specifiedSet);
        return Collections.unmodifiableSet(specifiedSet);
    }

    protected void setupDefaultIndefinableParameter(Set<String> specifiedSet) {
        specifiedSet.add(LastaWebKey.TRANSACTION_TOKEN_KEY);
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        final String title = DfTypeUtil.toClassTitle(this);
        return title + ":{" + keepEmptyStringParameter + ", " + simpleTextParameterFilter + ", " + undefinedParameterError + ", "
                + indefinableParameterSet + "}";
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                          Empty String
    //                                          ------------
    public boolean isKeepEmptyStringParameter() {
        return keepEmptyStringParameter;
    }

    // -----------------------------------------------------
    //                                           Simple Text
    //                                           -----------
    public OptionalThing<FormSimpleTextParameterFilter> getSimpleTextParameterFilter() { // not null
        return simpleTextParameterFilter;
    }

    // -----------------------------------------------------
    //                                   Undefined Parameter
    //                                   -------------------
    public boolean isUndefinedParameterError() {
        return undefinedParameterError;
    }

    public Set<String> getIndefinableParameterSet() { // not null
        return indefinableParameterSet != null ? indefinableParameterSet : Collections.emptySet();
    }
}

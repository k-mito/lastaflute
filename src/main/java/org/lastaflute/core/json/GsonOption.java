/*
 * Copyright 2014-2015 the original author or authors.
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
package org.lastaflute.core.json;

/**
 * @author jflute
 */
public class GsonOption {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected boolean emptyToNullReading;
    protected boolean nullToEmptyWriting;
    protected boolean everywhereQuoteWriting;

    // ===================================================================================
    //                                                                      Option Setting
    //                                                                      ==============
    public GsonOption asEmptyToNullReading() {
        emptyToNullReading = true;
        return this;
    }

    public GsonOption asNullToEmptyWriting() {
        nullToEmptyWriting = true;
        return this;
    }

    public GsonOption asEverywhereQuoteWriting() {
        everywhereQuoteWriting = true;
        return this;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public boolean isEmptyToNullReading() {
        return emptyToNullReading;
    }

    public boolean isNullToEmptyWriting() {
        return nullToEmptyWriting;
    }

    public boolean isEverywhereQuoteWriting() {
        return everywhereQuoteWriting;
    }
}
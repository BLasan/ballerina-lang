/*
 * Copyright (c) 2019, WSO2 Inc. (http://wso2.com) All Rights Reserved.
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
package org.ballerinalang.docgen.generator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represent documentation for an Object.
 */
public class Object extends Construct {

    public List<DefaultableVarible> fields = new ArrayList<>();
    public List<Function> methods = new ArrayList<>();
    public Function initMethod;
    public List<Function> otherMethods = new ArrayList<>();

    public Object(String name, String description, List<DefaultableVarible> fields, List<Function> methods) {
        super(name, description);
        this.fields = fields;
        this.methods = methods;
        Optional<Function> initMethod = getInitMethod(methods);
        this.initMethod = initMethod.isPresent() ? getInitMethod(methods).get() : null;
        this.otherMethods = getOtherMethods(methods);
    }

    public Optional<Function> getInitMethod(List<Function> methods) {
        return methods.stream()
                .filter(function -> function.name.equals("__init"))
                .findFirst();
    }

    public List<Function> getOtherMethods(List<Function> methods) {
        return methods.stream()
                .filter(function -> !function.name.equals("__init"))
                .collect(Collectors.toList());
    }

}

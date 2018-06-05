/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.model.types;

import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.util.codegen.RecordTypeInfo;
import org.ballerinalang.util.codegen.TypeInfo;

/**
 * {@code BRecordType} represents a user defined record type in Ballerina.
 *
 * @since 0.971.0
 */
public class BRecordType extends BStructureType {

    public RecordTypeInfo recordTypeInfo;

    /**
     * Create a {@code BStructType} which represents the user defined struct type.
     *
     * @param typeName string name of the type
     * @param pkgPath  package of the struct
     */
    public BRecordType(RecordTypeInfo recordTypeInfo, String typeName, String pkgPath, int flags) {
        super(typeName, pkgPath, flags, BStruct.class);
        this.recordTypeInfo = recordTypeInfo;
    }

    public TypeInfo getTypeInfo() {
        return recordTypeInfo;
    }

    @Override
    public <V extends BValue> V getZeroValue() {
        return null;
    }

    @Override
    public <V extends BValue> V getEmptyValue() {
        return (V) new BStruct(this);
    }

    @Override
    public TypeSignature getSig() {
        String packagePath = (pkgPath == null) ? "." : pkgPath;
        return new TypeSignature(TypeSignature.SIG_STRUCT, packagePath, typeName);
    }

    @Override
    public int getTag() {
        return TypeTags.RECORD_TYPE_TAG;
    }
}


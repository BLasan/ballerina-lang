/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.ballerinalang.plugins.idea.psi;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import org.antlr.jetbrains.adaptor.psi.IdentifierDefSubtree;
import org.ballerinalang.plugins.idea.BallerinaIcons;
import org.ballerinalang.plugins.idea.BallerinaParserDefinition;
import org.ballerinalang.plugins.idea.psi.impl.BallerinaItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ConstantDefinitionNode extends IdentifierDefSubtree {

    public ConstantDefinitionNode(@NotNull ASTNode node) {
        super(node, BallerinaParserDefinition.ID);
    }

    @Override
    public ItemPresentation getPresentation() {
        return new BallerinaItemPresentation(getNameIdentifier()) {

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return BallerinaIcons.CONSTANT;
            }
        };
    }
}

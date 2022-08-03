package org.exist.altid;

import org.exist.dom.QName;
import org.exist.xquery.*;
import org.exist.xquery.value.FunctionParameterSequenceType;
import org.exist.xquery.value.FunctionReturnSequenceType;

import java.util.List;
import java.util.Map;

import static org.exist.xquery.FunctionDSL.functionDefs;

/**
 * An XQuery Library Module for generting unique identifiers implemented
 * in Java.
 */
public class AltIDModule extends AbstractInternalModule {

    public static final String NAMESPACE_URI = "https://exist-db.org/xquery/altid";
    public static final String PREFIX = "altid";
    public static final String RELEASED_IN_VERSION = "eXist-6.0.0";

    // register the functions of the module
    public static final FunctionDef[] functions = functionDefs(
        functionDefs(AltIDFunctions.class,
                AltIDFunctions.FS_SECURE_RANDOM,
                AltIDFunctions.FS_ULID
        )
    );

    public AltIDModule(final Map<String, List<? extends Object>> parameters) {
        super(functions, parameters);
    }

    @Override
    public String getNamespaceURI() {
        return NAMESPACE_URI;
    }

    @Override
    public String getDefaultPrefix() {
        return PREFIX;
    }

    @Override
    public String getDescription() {
        return "Library module for alternate UUIDs";
    }

    @Override
    public String getReleaseVersion() {
        return RELEASED_IN_VERSION;
    }

    static FunctionSignature functionSignature(final String name, final String description,
            final FunctionReturnSequenceType returnType, final FunctionParameterSequenceType... paramTypes) {
        return FunctionDSL.functionSignature(new QName(name, NAMESPACE_URI), description, returnType, paramTypes);
    }

    static FunctionSignature[] functionSignatures(final String name, final String description,
            final FunctionReturnSequenceType returnType, final FunctionParameterSequenceType[][] variableParamTypes) {
        return FunctionDSL.functionSignatures(new QName(name, NAMESPACE_URI), description, returnType, variableParamTypes);
    }

    static class ExpathUUIDModuleErrorCode extends ErrorCodes.ErrorCode {
        private ExpathUUIDModuleErrorCode(final String code, final String description) {
            super(new QName(code, NAMESPACE_URI, PREFIX), description);
        }
    }
}

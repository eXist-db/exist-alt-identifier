package org.exist.uuid;

import com.github.f4b6a3.ulid.*;

import org.exist.xquery.BasicFunction;
import org.exist.xquery.FunctionSignature;
import org.exist.xquery.XPathException;
import org.exist.xquery.XQueryContext;
import org.exist.xquery.value.Sequence;
import org.exist.xquery.value.StringValue;
import org.exist.xquery.value.Type;

import java.security.SecureRandom;
import java.util.Base64;

import static org.exist.xquery.FunctionDSL.*;
import static org.exist.uuid.UUIDModule.functionSignature;

/**
 * Some very simple XQuery example functions implemented
 * in Java.
 */
public class UUIDFunctions extends BasicFunction {

    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    private static final String FS_SECURE_RANDOM_NAME = "secure-random";
    static final FunctionSignature FS_SECURE_RANDOM = functionSignature(
        FS_SECURE_RANDOM_NAME,
        "Generates a 160-bit (20 byte) random value that is then URL-safe base64-encoded.",
        returns(Type.STRING),
        null
    );

    private static final String FS_ULID_NAME = "ulid";
    static final FunctionSignature FS_ULID = functionSignature(
            FS_ULID_NAME,
            "Generates a Universally Unique Lexicographically Sortable Identifier (ULID).",
            returns(Type.STRING),
            null
    );

    public UUIDFunctions(XQueryContext context, FunctionSignature signature) {
        super(context, signature);
    }

    @Override
    public Sequence eval(final Sequence[] args, final Sequence contextSequence) throws XPathException {
        switch (getName().getLocalPart()) {

            case FS_SECURE_RANDOM_NAME:
                return secureRandom();

            case FS_ULID_NAME:
                return ulid();

            default:
                throw new XPathException(this, "No function: " + getName() + "#" + getSignature().getArgumentCount());
        }
    }

    /**
     * Generates a 160-bit (20 byte) random value that is then URL-safe base64-encoded.
     *
     * @return A unique identifier string
     */
    private StringValue secureRandom() {
        byte[] buffer = new byte[20];
        random.nextBytes(buffer);
        String returnValue = encoder.encodeToString(buffer);
        return new StringValue(returnValue);
    }

    /**
     * Generates a 160-bit (20 byte) random value that is then URL-safe base64-encoded.
     *
     * @return A unique identifier string
     */
    private StringValue ulid() {
        Ulid ulid = UlidCreator.getUlid();
        String ulidString = ulid.toString();
        return new StringValue(ulidString);
    }
}


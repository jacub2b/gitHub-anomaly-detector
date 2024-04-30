package secure.legit.exception;

import java.security.GeneralSecurityException;

public class SecurityValidationException extends GeneralSecurityException {
    public SecurityValidationException() {
        super("Could not validate identity");
    }
}

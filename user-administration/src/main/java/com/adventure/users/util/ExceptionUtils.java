package com.adventure.users.util;

import com.adventure.users.model.BaseModel;
import org.springframework.util.StringUtils;

public class ExceptionUtils {

    /**
     * Checks if the string is not null and not blank.
     *
     * @param string           - the string which needs to be checked.
     * @param exceptionMessage
     * @return true if not empty, otherwise throws
     */
    public static boolean isNotEmpty(String string, String exceptionMessage)
            throws RuntimeException {
        if (isNotEmpty(string)) {
            return true;
        }
        throw getValidationException(exceptionMessage);
    }

    /**
     * Checks if the string is not null and not blank.
     *
     * @param string - the string which needs to be checked.
     * @return true if not empty, otherwise false.
     */
    public static boolean isNotEmpty(String string) {
        return isNotNull(string) && string.length() > 0;
    }

    /**
     * Checks if the domain is persisted or not.
     *
     * @param domain           - the domain which needs to be checked for persistence.
     * @param exceptionMessage
     * @return boolean true if persisted, otherwise throws
     * {@link RuntimeException}.
     * @throws RuntimeException
     */
    public static boolean isPersisted(BaseModel domain, String exceptionMessage)
            throws RuntimeException {
        if (isPersisted(domain)) {
            return true;
        }
        throw getValidationException(exceptionMessage);
    }

    /**
     * Checks if the domain is persisted or not.
     *
     * @param domain - the domain which needs to be checked for persistence.
     * @return true if persisted, otherwise false.
     */
    public static boolean isPersisted(BaseModel domain) {
        return isNotNull(domain.getId());
    }

    /**
     * Checks if the object is not null.
     *
     * @param object           - the object which needs to be checked for not null.
     * @param exceptionMessage
     * @return boolean true if null, otherwise throws
     * {@link RuntimeException}.
     * @throws RuntimeException
     */
    public static boolean isNotNull(Object object, String exceptionMessage)
            throws RuntimeException {
        if (isNotNull(object)) {
            return true;
        }
        throw getValidationException(exceptionMessage);
    }

    /**
     * Checks if the object is not null.
     *
     * @param object - the object which needs to be checked for not null.
     * @return true if null, otherwise false.
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * Checks if the object is null or not.
     *
     * @param object           - the object which needs to be checked for null.
     * @param exceptionMessage
     * @return boolean true if null, otherwise throws
     * {@link RuntimeException}.
     * @throws RuntimeException
     */
    public static boolean isNull(Object object, String exceptionMessage)
            throws RuntimeException {
        if (isNull(object)) {
            return true;
        }
        throw getValidationException(exceptionMessage);
    }

    /**
     * Checks if the object is null or not.
     *
     * @param object - the object which needs to be checked for null.
     * @return true if null, otherwise false.
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    private static RuntimeException getValidationException(
            String exceptionMessage) throws RuntimeException {
        if (!StringUtils.isEmpty(exceptionMessage)) {
            return new RuntimeException();
        } else {
            return new RuntimeException(exceptionMessage);
        }
    }

}
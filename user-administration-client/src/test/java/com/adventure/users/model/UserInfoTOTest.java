package com.adventure.users.model;

import com.adventure.users.model.util.Create;
import com.adventure.users.model.util.Update;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashSet;
import java.util.Set;

public class UserInfoTOTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whileCreatingUserWithoutTenant() {
        UserInfoTO userInfoTO = buildBasicUserForCreation();
        userInfoTO.setTenant("");
        Set<ConstraintViolation<UserInfoTO>> violations = validator.validate(userInfoTO, Default.class, Create.class);
        printViolations(violations);
        Assertions.assertEquals(1, violations.size());

        violations.forEach(violation -> {
            Assertions.assertEquals("must not be blank", violation.getMessage());
            Assertions.assertEquals("tenant", violation.getPropertyPath().toString());
        });
    }

    @Test
    public void whileCreatingUserWithoutAuthorities() {
        UserInfoTO userInfoTO = buildBasicUserForCreation();
        userInfoTO.setAuthorities(new HashSet<>());
        Set<ConstraintViolation<UserInfoTO>> violations = validator.validate(userInfoTO, Default.class, Create.class);
        printViolations(violations);
        Assertions.assertEquals(1, violations.size());

        violations.forEach(violation -> {
            Assertions.assertEquals("must not be empty", violation.getMessage());
            Assertions.assertEquals("authorities", violation.getPropertyPath().toString());
        });
    }

    @Test
    public void whileCreatingUser() {
        UserInfoTO userInfoTO = buildBasicUserForCreation();
        Set<ConstraintViolation<UserInfoTO>> violations = validator.validate(userInfoTO, Default.class, Create.class);
        printViolations(violations);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void whileUpdatingUserWithPassword() {
        UserInfoTO userInfoTO = buildBasicUserForCreation();
        Set<ConstraintViolation<UserInfoTO>> violations = validator.validate(userInfoTO, Default.class, Update.class);
        printViolations(violations);
        Assertions.assertEquals(1, violations.size());

        violations.forEach(violation -> {
            Assertions.assertEquals("must be null", violation.getMessage());
            Assertions.assertEquals("password", violation.getPropertyPath().toString());
        });
    }

    @Test
    public void whileUpdatingUser() {
        UserInfoTO userInfoTO = buildBasicUserForCreation();
        userInfoTO.setId((long) 10);
        Set<ConstraintViolation<UserInfoTO>> violations = validator.validate(userInfoTO, Default.class);
        printViolations(violations);
        Assertions.assertEquals(0, violations.size());
    }

    private UserInfoTO buildBasicUserForCreation() {
        Set<String> authorities = new HashSet<>();
        authorities.add("ADMIN");
        UserInfoTO userInfoTO = new UserInfoTO("Test@123", "apurve", authorities,
                true, true, true, true);
        userInfoTO.setTenant("moxtain");
        return userInfoTO;
    }

    private void printViolations(Set<ConstraintViolation<UserInfoTO>> violations) {
        /*violations.forEach( violation -> System.out.println(violation.getPropertyPath().toString()
                + " : " + violation.getMessage()));*/

    }

}

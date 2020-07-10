package com.adventure.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(value = {"serialVersionUID", "ERROR_KEY"})
public abstract class BaseTO implements Serializable {

    private static final long serialVersionUID = 6052759431581348370L;

    private Long id;

    @NotBlank
    private String tenant;

    private boolean error;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> errorMessages;

    public transient final static String ERROR_KEY = "error";

    public BaseTO() {
        super();
    }

    public BaseTO(Long id) {
        super();
        this.id = id;
    }

    public BaseTO(Long id, String tenant) {
        super();
        this.id = id;
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public boolean isError() {
        return error;
    }

    public boolean hasError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @JsonIgnore
    public String getErrorMessage() {
        return errorMessages != null ? errorMessages.get(ERROR_KEY) : null;
    }

    public void populateError(String message) {
        this.error = true;
        if(errorMessages == null) {
            errorMessages = new HashMap<String, String>();
        }
        errorMessages.put(ERROR_KEY, message);
    }

}

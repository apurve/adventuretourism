package com.adventure.users.util;

public class ThreadLocalStorage {

    public static ThreadLocal<String> tenant = new ThreadLocal<>();

    public static ThreadLocal<String> getTenant() {
        return tenant;
    }

    public static void setTenant(ThreadLocal<String> tenant) {
        ThreadLocalStorage.tenant = tenant;
    }

}

package com.francos.restaurant.config;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final int LOGIN_LENGTH = 50;

    /**
     * use this create insulation against changing databases from posgress but
     * still support the database default for certain Not Null integers to 1
     *
     * DB = Database INT = integer NN=NotNull DEF1=Default to 1
     */
    public static final String DB_INT_NN_DEF1 = "integer NOT NULL DEFAULT 1";
}

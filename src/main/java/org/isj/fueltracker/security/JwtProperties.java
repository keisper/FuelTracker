package org.isj.fueltracker.security;

/**
 * classe utilisée pour définir des constantes pour JWT
 */
public class JwtProperties {
    public static final String SECRET = "FuelTrackerOrgIsj2020";
    public static final int DATE_EXPIRATION = 432000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}

package com.fishbread101.entity;

public enum UserRole {

    TUTEE(Authority.TUTEE),  // 튜티 권한
    TUTOR(Authority.TUTOR), // 튜터 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한
    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority(){
        return authority;
    }

    public static class Authority{
        public static final String TUTEE = "ROLE_TUTEE";
        public static final String TUTOR = "ROLE_TUTOR";
        public static final String ADMIN = "ROLE_ADMIN";
    }

}

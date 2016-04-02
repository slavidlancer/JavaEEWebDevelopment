package com.jeewd.cars.entities.user;

public class UserAuthority {
    private AutoUser user;
    private Authority authority;
    
    public AutoUser getUser() {
        return user;
    }
    
    public void setUser(AutoUser user) {
        this.user = user;
    }
    
    public Authority getAuthority() {
        return authority;
    }
    
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}

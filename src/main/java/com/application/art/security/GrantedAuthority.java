package com.application.art.security;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {

    String getAuthority();
}

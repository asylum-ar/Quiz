package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

public interface AccountService  {
  public AppUser saveUser(String username, String password, String confirmedPassword);
  public AppUser LoadUserByUsername(String username);
  public void addRoleToUser(String username, String rolename);
  public AppRole save(AppRole role);



  
}

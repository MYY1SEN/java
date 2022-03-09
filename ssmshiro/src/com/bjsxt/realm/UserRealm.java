package com.bjsxt.realm;

import com.bjsxt.pojo.Admin;
import com.bjsxt.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRealm extends AuthorizingRealm {


        @Autowired
        AdminService  adminService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        Admin admin = adminService.findPwd(authenticationToken.getPrincipal().toString());

        if(admin!=null){

            SimpleAuthenticationInfo  info=new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()),"userRealm");

            return   info;

        }

        return null;
    }



     //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}

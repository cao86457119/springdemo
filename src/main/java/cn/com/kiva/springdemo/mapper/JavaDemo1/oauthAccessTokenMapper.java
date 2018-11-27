package cn.com.kiva.springdemo.mapper.JavaDemo1;

import cn.com.kiva.springdemo.model.JavaDemo1.oauthAccessToken;
import cn.com.kiva.springdemo.model.JavaDemo1.oauthAccessTokenWithBLOBs;

public interface oauthAccessTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(oauthAccessTokenWithBLOBs record);

    int insertSelective(oauthAccessTokenWithBLOBs record);

    oauthAccessTokenWithBLOBs selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(oauthAccessTokenWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(oauthAccessTokenWithBLOBs record);

    int updateByPrimaryKey(oauthAccessToken record);
}
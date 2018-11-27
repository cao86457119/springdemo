package cn.com.kiva.springdemo.mapper.JavaDemo1;

import cn.com.kiva.springdemo.model.JavaDemo1.oauthClientDetails;

public interface oauthClientDetailsMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(oauthClientDetails record);

    int insertSelective(oauthClientDetails record);

    oauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(oauthClientDetails record);

    int updateByPrimaryKey(oauthClientDetails record);
}
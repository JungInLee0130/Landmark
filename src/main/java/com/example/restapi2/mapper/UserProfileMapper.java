package com.example.restapi2.mapper;

import com.example.restapi2.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserProfileMapper {
    @Select("SELECT * from UserProfile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * from UserProfile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") String id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("address") String address);

    @Delete("DELETE from UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}

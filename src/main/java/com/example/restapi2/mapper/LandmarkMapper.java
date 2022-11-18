package com.example.restapi2.mapper;

import com.example.restapi2.model.Landmark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LandmarkMapper {
    @Select("SELECT * from Landmark WHERE id=#{id}")
    Landmark getLandmarkInfo(@Param("id") String id);

    @Select("SELECT * from Landmark")
    List<Landmark> getLandmarkList();

    @Insert("INSERT INTO Landmark VALUES(#{id}, #{name}, #{picture})")
    int insertLandmark(@Param("id") String id,
                       @Param("name") String name,
                       @Param("picture") String picture);

    @Update("UPDATE Landmark SET name=#{name}, picture=#{picture} WHERE id=#{id}")
    int updateLandmark(@Param("id") String id,
                       @Param("name") String name,
                       @Param("picture") String picture);

    @Delete("DELETE FROM Landmark WHERE id=#{id}")
    int deleteLandmark(@Param("id") String id);
}

package com.example.restapi2;

import com.example.restapi2.mapper.LandmarkMapper;
import com.example.restapi2.model.Landmark;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LandmarkController {

    private LandmarkMapper mapper;

    public LandmarkController(LandmarkMapper mapper) {
        this.mapper = mapper;
    }

    //private Map<String, Landmark> landmarkMap;

    /*@PostConstruct
    public void init() {
        landmarkMap = new HashMap<>();
        landmarkMap.put("1", new Landmark("1", "어린이대공원 동물원", "동물원 사진"));
        landmarkMap.put("2", new Landmark("2", "어린이대공원 식물원", "식물원 사진"));
    }*/

    @GetMapping("/landmark/{id}")
    public Landmark getLandmarkInfo(@PathVariable("id") String id) {
        return mapper.getLandmarkInfo(id);
    }

    @GetMapping("/landmark/all")
    public List<Landmark> getLandmarkList() {
        return mapper.getLandmarkList();
    }

    @PostMapping("/landmark/{id}")
    public void postLandmark(@PathVariable("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("picture") String picture) {
        mapper.insertLandmark(id, name, picture);
    }

    @PutMapping("/landmark/{id}")
    public void putLandmark(@PathVariable("id") String id,
                            @RequestParam("name") String name,
                            @RequestParam("picture") String picture)
    {
        mapper.updateLandmark(id, name, picture);
    }

    @DeleteMapping("/landmark/{id}")
    public void deleteLandmark(@PathVariable("id") String id)
    {
        mapper.deleteLandmark(id);
    }
}

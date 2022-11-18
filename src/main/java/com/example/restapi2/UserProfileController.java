package com.example.restapi2;

import com.example.restapi2.mapper.UserProfileMapper;
import com.example.restapi2.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {
    //private Map<String, UserProfile> userMap;

    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    /*@PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
        userMap.put("2", new UserProfile("2", "홍길지", "111-1112", "서울시 강남구 대치2동"));
        userMap.put("3", new UserProfile("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
    }*/

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name")
                                String name, @RequestParam("phone") String phone,
                                @RequestParam("address") String address)
    {
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               @RequestParam("address") String address)
    {
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id)
    {
        mapper.deleteUserProfile(id);
    }
}

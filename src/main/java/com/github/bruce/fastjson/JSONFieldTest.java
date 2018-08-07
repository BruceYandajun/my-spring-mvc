package com.github.bruce.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

public class JSONFieldTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Bruce");
        user.setPassword("123456");

        String jsonStr = user.toString();
        System.out.println("Bean to json:" + jsonStr);

        User user1 = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), User.class);
        System.out.println("Json to bean:" + user1.toString());

    }

}

@Setter
@Getter
class User {

    @JSONField(name="new_username")
    private String username;
    @JSONField(name="new_password")
    private String password;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

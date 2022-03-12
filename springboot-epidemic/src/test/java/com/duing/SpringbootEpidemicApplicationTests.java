package com.duing;

import com.duing.domain.DataBean;
import com.duing.service.DataService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootEpidemicApplicationTests {
    @Autowired
    private DataService dataService;
    @Test
    void contextLoads() {
        List<DataBean> list = dataService.list();
        JsonArray arr = new JsonArray();

        for (DataBean bean:
                list) {
            JsonObject obj = new JsonObject();
            obj.addProperty("name",bean.getArea());
            obj.addProperty("count",bean.getConfirm());
            arr.add(obj);
        }
        System.out.println(arr);
    }

}

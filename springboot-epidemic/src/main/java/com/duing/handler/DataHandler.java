package com.duing.handler;

import com.duing.domain.DataBean;
import com.duing.service.DataService;
import com.duing.util.HttpConnectionUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataHandler {

    @Autowired
    private DataService dataService;


    @PostConstruct
    private void saveData(){
        List<DataBean> list = getDataForHttp();
        dataService.remove(null);
        dataService.saveBatch(list);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    private void updateData(){
        List<DataBean> list = getDataForHttp();
        dataService.remove(null);
        dataService.saveBatch(list);
    }

    public static List<DataBean> getData() {
        List<DataBean> result = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader("temp.txt");

            char[] buf = new char[1024];
            int cRead = 0;
            StringBuilder builder = new StringBuilder();
            while ((cRead = fr.read(buf)) > 0) {
                builder.append(new String(buf, 0, cRead));
            }
            fr.close();

            Gson gson = new Gson();
            Map map = gson.fromJson(builder.toString(), Map.class);

            ArrayList areaTree = (ArrayList) map.get("areaTree");
            Map dataMap = (Map) areaTree.get(0);
            ArrayList children = (ArrayList) dataMap.get("children");
            for (int i = 0; i < children.size(); i++) {
                Map childrenMap = (Map) children.get(i);
                String name = (String) childrenMap.get("name");
                Map totalMap = (Map) childrenMap.get("total");
                double nowConfirm = (Double) totalMap.get("nowConfirm");
                double confirm = (Double) totalMap.get("confirm");
                double heal = (Double) totalMap.get("heal");
                double dead = (Double) totalMap.get("dead");
                DataBean dataBean = new DataBean(0,name, (int) nowConfirm, (int) confirm, (int) heal, (int) dead);
                result.add(dataBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<DataBean> getDataForHttp() {
        List<DataBean> result = new ArrayList<>();
        String url = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        try {
            String str = HttpConnectionUtil.getData(url);
            Gson gson = new Gson();
            Map mapStr = gson.fromJson(str, Map.class);
            String data = (String) mapStr.get("data");
            Map map = gson.fromJson(data,Map.class);
            ArrayList areaTree = (ArrayList) map.get("areaTree");
            Map dataMap = (Map) areaTree.get(0);
            ArrayList children = (ArrayList) dataMap.get("children");
            for (int i = 0; i < children.size(); i++) {
                Map childrenMap = (Map) children.get(i);
                String name = (String) childrenMap.get("name");
                Map totalMap = (Map) childrenMap.get("total");
                double nowConfirm = (Double) totalMap.get("nowConfirm");
                double confirm = (Double) totalMap.get("confirm");
                double heal = (Double) totalMap.get("heal");
                double dead = (Double) totalMap.get("dead");
                DataBean dataBean = new DataBean(0,name, (int) nowConfirm, (int) confirm, (int) heal, (int) dead);
                result.add(dataBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

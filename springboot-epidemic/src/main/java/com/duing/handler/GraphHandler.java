package com.duing.handler;

import com.duing.domain.DataBean;
import com.duing.domain.Graph;
import com.duing.service.GraphService;
import com.duing.util.HttpConnectionUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GraphHandler {
    @Autowired
    private GraphService graphService;
    @PostConstruct
    private void saveData(){
        List<Graph> list = getGraphForHttp();
        graphService.remove(null);
        graphService.saveBatch(list);
    }

    private static List<Graph> getGraphForHttp(){
        String url = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=chinaDayList,chinaDayAddList,nowConfirmStatis,provinceCompare";
        String graphStr = HttpConnectionUtil.getData(url);
        ArrayList<Graph> graphList = new ArrayList<>();
        Gson gson = new Gson();
        Map map = gson.fromJson(graphStr, Map.class);
        Map dataMap = (Map) map.get("data");
        ArrayList chinaDayAddList = (ArrayList) dataMap.get("chinaDayAddList");
        for (int i = 0; i < chinaDayAddList.size(); i++) {
             Map graphMap = (Map) chinaDayAddList.get(i);
             Graph graph = new Graph(0,(String) graphMap.get("date"),(int)(double)graphMap.get("confirm"),(int)(double)graphMap.get("suspect"));
             graphList.add(graph);
        }
        return graphList;
    }

    public static void main(String[] args) {
        getGraphForHttp();

    }
}

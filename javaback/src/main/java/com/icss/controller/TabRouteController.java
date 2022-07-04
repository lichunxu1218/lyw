package com.icss.controller;

import com.github.pagehelper.PageInfo;
import com.icss.service.TabRouteService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class TabRouteController {
    @Autowired
    private TabRouteService tabRouteService;

    @RequestMapping("/getAll")
    public ResResult<PageInfo> getAll(int cid, int page) {
        PageInfo pageInfo = tabRouteService.selectByCid(cid, page);
        ResResult rr = null;
        if (pageInfo != null) {
            rr = new ResResult(1, "ok", pageInfo);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }
}
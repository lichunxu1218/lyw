package com.icss.controller;

import com.icss.bean.TabFavorite;
import com.icss.service.TabFavoriteService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/favorite")
public class TabFavoriteControler {

    @Autowired
    private TabFavoriteService tabFavoriteService;

    @RequestMapping("/select")
    public ResResult<TabFavorite> select(Integer rid, Integer uid) {
        TabFavorite tabFavorite = tabFavoriteService.selectByPrimaryKey(rid, uid);
        ResResult rr = null;
        if (tabFavorite != null) {
            rr = new ResResult(1, "ok", tabFavorite);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

    @RequestMapping("/addCount")
    public ResResult addCount(Integer rid, Integer uid, Integer rcount) {
        int i = tabFavoriteService.insertForUser(rid, uid, rcount);
        ResResult rr = new ResResult(0, "ok", i);

        return rr;
    }

    @RequestMapping("/subCount")
    public ResResult subCount(Integer rid, Integer uid, Integer rcount) {
        int i = tabFavoriteService.deleteForUser(rid, uid, rcount);
        ResResult rr = new ResResult(1, "ok", i);

        return rr;
    }
}
package com.play.game.controller;

import com.play.game.code.BizException;
import com.play.game.code.ExceptionCode;
import com.play.game.entity.GameInfo;
import com.play.game.service.GameInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
@RestController
@RequestMapping(value = "/v0.1")
public class GameInfoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GameInfoService gameInfoService;

    /**
     * 保存游戏信息
     *
     * @param gameInfo
     */
    @PostMapping(value = "game/save", produces = {"application/json;charset=UTF-8"})
    public void save(@RequestBody GameInfo gameInfo) {
        if (ObjectUtils.isEmpty(gameInfo)) {
            throw new BizException(ExceptionCode.ADMIN_ARGUMENT_REQUIRED, "游戏信息不能为空！！");
        }
        gameInfoService.save(gameInfo);
    }

    /**
     * 查询游戏信息
     *
     * @param offset
     * @param limit
     * @param count
     * @param filter
     * @return
     */
    @GetMapping(value = "game/query", produces = {"application/json;charset=UTF-8"})
    public Object query(@RequestParam(value = "$offset", required = false, defaultValue = "0") Integer offset,
                        @RequestParam(value = "$limit", required = false, defaultValue = "10") Integer limit,
                        @RequestParam(value = "$count", required = false, defaultValue = "true") Boolean count,
                        @RequestParam(value = "$filter", required = false) String filter) {
        if (offset < 0) {
            offset = 0;
        }
        if (limit < 1) {
            limit = 20;
        }

        return gameInfoService.query(offset, limit, count, filter);
    }
}

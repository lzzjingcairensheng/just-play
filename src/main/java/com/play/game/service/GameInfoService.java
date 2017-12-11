package com.play.game.service;

import com.play.game.entity.GameInfo;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
public interface GameInfoService {
    void save(GameInfo gameInfo);

    Map<String, Object> query(Integer offset, Integer limit, Boolean count, String filter);
}

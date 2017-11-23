package com.play.game.service.impl;

import com.play.game.code.BizException;
import com.play.game.code.ExceptionCode;
import com.play.game.entity.GameInfo;
import com.play.game.repository.mysql.criteria.GameInfoCriteria;
import com.play.game.repository.mysql.mapper.GameInfoMapper;
import com.play.game.service.GameInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22 0022.
 */
@Service
public class GameInfoServiceImpl implements GameInfoService {
    @Resource
    private GameInfoMapper gameInfoMapper;

    @Override
    public void save(GameInfo gameInfo) {
        gameInfoMapper.insert(gameInfo);
    }

    @Override
    public Map<String, Object> query(Integer offset, Integer limit, Boolean count, String filter) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        GameInfoCriteria example = createCriteria(filter);
        if (count) {
            resultMap.put("count", gameInfoMapper.countByExample(example));
        }
        example.setLimitStart(offset);
        example.setLimitEnd(limit);
        // 添加时间排序：createAt排序
        example.setOrderByClause("create_time DESC");
        List<GameInfo> items = gameInfoMapper.selectByExample(example);
        resultMap.put("items", items);
        return resultMap;
    }

    private GameInfoCriteria createCriteria(String filter) {
        GameInfoCriteria example = new GameInfoCriteria();
        GameInfoCriteria.Criteria cri = example.createCriteria();
        if (filter != null) {
            String[] filters = filter.split(",");
            for (String filterStr : filters) {
                String[] criteria = filterStr.split(" ");
                if (criteria.length != 3) {
                    throw new BizException(ExceptionCode.ARGUMENT_INVALID, "filter不合法");
                }
                if (criteria[0].equals("game_type") && criteria[1].equals("eq")) {
                    cri.andGameTypeEqualTo(Integer.parseInt(criteria[2]));
                }
                if (criteria[0].equals("game_name") && criteria[1].equals("eq")) {
                    cri.andGameNameEqualTo(criteria[2].replace("'", ""));
                }
                if (criteria[0].equals("push_name") && criteria[1].equals("like")) {

                    cri.andGameNameLike("%" + criteria[2].replace("'", "") + "%");
                }
            }
        }

        return example;
    }
}

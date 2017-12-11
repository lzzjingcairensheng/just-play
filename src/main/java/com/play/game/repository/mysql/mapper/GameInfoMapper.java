package com.play.game.repository.mysql.mapper;

import com.play.game.entity.GameInfo;
import com.play.game.repository.mysql.criteria.GameInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GameInfoMapper {
    long countByExample(GameInfoCriteria example);

    int deleteByExample(GameInfoCriteria example);

    int deleteByPrimaryKey(Integer gameId);

    int insert(GameInfo record);

    int insertSelective(GameInfo record);

    List<GameInfo> selectByExampleWithRowbounds(GameInfoCriteria example, RowBounds rowBounds);

    List<GameInfo> selectByExample(GameInfoCriteria example);

    GameInfo selectByPrimaryKey(Integer gameId);

    int updateByExampleSelective(@Param("record") GameInfo record, @Param("example") GameInfoCriteria example);

    int updateByExample(@Param("record") GameInfo record, @Param("example") GameInfoCriteria example);

    int updateByPrimaryKeySelective(GameInfo record);

    int updateByPrimaryKey(GameInfo record);

    void batchInsert(@Param("items") List<GameInfo> items);
}
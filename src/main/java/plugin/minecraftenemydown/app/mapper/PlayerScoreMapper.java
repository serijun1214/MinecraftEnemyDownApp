package plugin.minecraftenemydown.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.minecraftenemydown.app.mapper.data.PlayerScore;

@Mapper
public interface PlayerScoreMapper {

  @Select("SELECT * FROM player_score order by id asc")
  List<PlayerScore> selectPlayerScoreList();
}

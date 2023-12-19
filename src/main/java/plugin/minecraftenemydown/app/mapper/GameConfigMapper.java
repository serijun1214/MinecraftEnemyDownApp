package plugin.minecraftenemydown.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import plugin.minecraftenemydown.app.mapper.data.GameConfig;
import plugin.minecraftenemydown.app.mapper.data.PlayerScore;
import plugin.minecraftenemydown.app.mapper.data.SpawnEnemy;

@Mapper
public interface GameConfigMapper {

  @Select("SELECT * FROM game_config order by id asc")
  List<GameConfig> selectConfigList();

  @Select("SELECT * FROM game_config WHERE difficulty = #{difficulty} order by id asc")
  GameConfig selectConfig(String difficulty);

  @Select("SELECT * FROM spawn_enemy inner join game_config on spawn_enemy.difficulty = game_config.difficulty WHERE spawn_enemy.difficulty = #{difficulty} order by spawn_enemy.id asc")
  List<SpawnEnemy> selectSpawnEnemyList(String difficulty);

  @Insert("INSERT game_config(game_time, difficulty) values(#{gameTime}, #{difficulty})")
  int insertConfig(GameConfig config);

  @Update("UPDATE spawn_enemy SET score = #{score} WHERE enemy_name = #{enemyName} and difficulty = #{difficulty}")
  int updateEnemyScore(SpawnEnemy enemy);
}

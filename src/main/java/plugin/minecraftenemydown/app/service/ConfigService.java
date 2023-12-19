package plugin.minecraftenemydown.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import plugin.minecraftenemydown.app.mapper.GameConfigMapper;
import plugin.minecraftenemydown.app.mapper.data.GameConfig;
import plugin.minecraftenemydown.app.mapper.data.SpawnEnemy;

@Service
public class ConfigService {

  private final GameConfigMapper mapper;

  public ConfigService(GameConfigMapper mapper) {
    this.mapper = mapper;
  }

  public List<GameConfig> searchConfigList() {
    return mapper.selectConfigList();
  }

  public GameConfig searchConfig(String difficulty) {
    return mapper.selectConfig(difficulty);
  }

  public List<SpawnEnemy> searchSpwanEnemyList(String difficulty) {
    return mapper.selectSpawnEnemyList(difficulty);
  }

  public GameConfig registerConfig(GameConfig config) {
    mapper.insertConfig(config);
    return mapper.selectConfig(config.getDifficulty());
  }

  public List<SpawnEnemy> updateEnemyScore(SpawnEnemy enemy) {
    mapper.updateEnemyScore(enemy);
    return mapper.selectSpawnEnemyList(enemy.getDifficulty());
  }
}

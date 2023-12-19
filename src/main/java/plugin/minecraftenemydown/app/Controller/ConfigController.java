package plugin.minecraftenemydown.app.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plugin.minecraftenemydown.app.mapper.data.GameConfig;
import plugin.minecraftenemydown.app.mapper.data.SpawnEnemy;
import plugin.minecraftenemydown.app.service.ConfigService;

@RestController
public class ConfigController {
  private final ConfigService service;

  public ConfigController(ConfigService configService) {
    this.service = configService;
  }

  @RequestMapping(value = "/configList", method = RequestMethod.GET)
  public List<GameConfig> configList() {
    return service.searchConfigList();
  }

  @RequestMapping(value = "/config", method = RequestMethod.GET)
  public GameConfig config(@RequestParam String difficulty) {
    return service.searchConfig(difficulty);
  }

  @RequestMapping(value = "/spawnEnemyList", method = RequestMethod.GET)
  public List<SpawnEnemy> spawnEnemyList(@RequestParam String difficulty) {
    return service.searchSpwanEnemyList(difficulty);
  }
}

package plugin.minecraftenemydown.app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plugin.minecraftenemydown.app.mapper.data.GameConfig;
import plugin.minecraftenemydown.app.mapper.data.PlayerScore;
import plugin.minecraftenemydown.app.service.PlayerScoreService;

@RestController
public class PlayerScoreController {

  private final PlayerScoreService service;

  public PlayerScoreController(PlayerScoreService service) {
    this.service = service;
  }

  @RequestMapping(value = "/playerScoreList", method = RequestMethod.GET)
  public List<PlayerScore> playerScoreList() {
    return service.searchPlayerScoreList();
  }
}

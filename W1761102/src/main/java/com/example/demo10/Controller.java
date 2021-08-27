package com.example.demo10;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class Controller {
    private PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private Application cw = new Application();

    @GetMapping("/tablepoints")
    public List getOrderPoints(){
        return premierLeagueManager.getTablePointSort();
    }

    @GetMapping("/tablewins")
    public List getOrderWins(){
        return premierLeagueManager.getTableWinsSort();
    }

    @GetMapping("/tablegoals")
    public List getOrderGoal(){
        return premierLeagueManager.getTableGoalSort();
    }

    @GetMapping("/matchlist")
    public List getMatchList(){
        return premierLeagueManager.getMatch();

    }

    @GetMapping("/genmatch")
    public List PlayedMatch(){
        premierLeagueManager.playMatch();
        return premierLeagueManager.getPlayMatch();
    }


    @PostMapping("/findClub")
    public List<AddMatch> findClub(@RequestBody Date date){
       return premierLeagueManager.FindMatch(date);
    }

}

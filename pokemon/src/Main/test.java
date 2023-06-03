package Main;

import Main.*;
import Player.*;
import Player.Item.*;
import Pokemon.*;
import SaveLoad.*;

public class test {

    public static void main(String[] args) {
        Save save = new Save();
        Load load = new Load();

        // load.loadData();

        Main my = new Main();
        Player player = my.gameStartSetting();
        Pokemon pokemon1 = new Pokemon(1);
        Pokemon pokemon = new Pokemon(2);
        Item monster = new MonsterBall("몬스터볼");
        Item potion = new Potion();
        player.addPokemonToPlayerPokemonArrayList(pokemon);
        player.addPokemonToPlayerPokemonArrayList(pokemon1);

        player.showBag();
        player.addItemBag(monster, 1);
        player.showBag();
        player.addItemBag(monster, 3);
        player.showBag();
        player.addItemBag(potion, 3);
        player.showBag();
        player.useItemBag(0).use(player, pokemon);
        player.showPlayerPokemon();
        save.savaData(player);
    }
}

package Pokemon;

public class LevelPokemon {

    public LevelPokemon() {}

    //player pokemon list에 add할 때 호출
    public void setLevel(Pokemon pokemon){
        
        pokemon.level = 1;
        pokemon.currentExp = 0;
        pokemon.maxExp = 8;

    }

    //AI, 야생 포켓몬 생성 시 사용
    public void setLevel(Pokemon pokemon, int num){
        
        pokemon.level = num;

    }

    public void giveExp(Pokemon pokemon, int exp ){
        /*********************************************************************************
         * exp = battleType:(wild:1, Ai:1.5) * other pokemon level * baseExp:10 * item effect
        **********************************************************************************/
        pokemon.currentExp += exp; 
        levelUp(pokemon);

    }

    public void levelUp(Pokemon pokemon){
        /*****************
         * maxExp
         * 1 level -> 2 level = 8 ...
         * (n - 1) level -> n level = n ^ 3
        ******************/

        while(pokemon.currentExp >= pokemon.maxExp){

            pokemon.level++;
            pokemon.increaseStat();
            pokemon.maxExp = (int) Math.pow(pokemon.level + 1,3);
        
        }

        if(canEvolution(pokemon)) pokemon = evolutionPokemon(pokemon);
    }

    public boolean canEvolution(Pokemon pokemon){
        if(pokemon.evolution && pokemon.level >= pokemon.evolutionLevel) 
            return true;
        else 
            return false; 
    }

    public Pokemon evolutionPokemon(Pokemon pokemon){

        Pokemon evolutionPokemon = new Pokemon(pokemon.evolutionNo);
        evolutionPokemon.unlock = true;
        evolutionPokemon.level = pokemon.level;
        evolutionPokemon.currentExp = pokemon.currentExp;
        evolutionPokemon.maxExp = pokemon.maxExp;

        return evolutionPokemon;
    }
}

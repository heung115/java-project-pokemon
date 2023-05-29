package Pokemon;

public class LevelPokemon {
    
    public LevelPokemon() {}

    private int levelExp(int num){
        return (int)Math.pow(num, 3);
    }

    //player pokemon list에 add할 때 호출
    public void setLevel(Pokemon pokemon){
        
        pokemon.level = 1;
        pokemon.currentExp = 0;
        pokemon.maxExp = 8;

    }

    //야생 포켓몬 생성, 사탕 사용, etc.
    //필드에서 Pokemon(int num) 호출 시 rand한 num으로 같이 호출하기
    public void giveLevel(Pokemon pokemon, int num){
        
        giveExp(pokemon, levelExp(num));

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
            pokemon.maxExp = levelExp(pokemon.level+1);
        
        }

        if(canEvolution(pokemon)) pokemon = evolutionPokemon(pokemon);
    }

    public boolean canEvolution(Pokemon pokemon){
        if(pokemon.getEvolution() && pokemon.level >= pokemon.getEvolutionLevel()) 
            return true;
        else 
            return false; 
    }

    public Pokemon evolutionPokemon(Pokemon pokemon){

        Pokemon evolutionPokemon = evolutionPokemon(pokemon);
        giveLevel(evolutionPokemon, pokemon.level-1);

        return evolutionPokemon;
    }
}

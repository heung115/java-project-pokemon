package Pokemon;

import Player.Encyclopedia;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	
	private String pokemonName;
	private int pokemonNumber;
	private int maxHp;
	private int currentHp;
	private int belong; // 0-player, 1-wild, 2-AI
	private String type; // 0-water, 1-fire, 2-grass -> 물, 불, 풀
	private int damage;
	private boolean unlock;
	private boolean evolution;
	private int evolutionLevel;
	private int evolutionNo;
	
	/* For LevelPokemon */
	int level;
    int currentExp;
    int maxExp;



	private List<List<String>> encyclopedia = Encyclopedia.encyclopedia;

	public Pokemon(){

	}

	//create pokemon : decided pokemonNumber 
	public Pokemon(int num){
		//System.out.println("인덱스 지정 : "); 
		insertInfo(num);
	};

	//create pokemon : decided type
	public Pokemon(String type){
		System.out.println("타입 지정 : "); 
		String str = "";
		ArrayList<Integer> indexList = new ArrayList<>();
		int i;

		/* 원하는 type의 포켓몬을 선별하여 저장 */
		for(i=0; i < encyclopedia.size() ; i++){
			str = encyclopedia.get(i).get(3);
			//System.out.printf(i+": "+str+", "+type+"\n");
			if(str.equals(type)){
				indexList.add(Integer.parseInt(encyclopedia.get(i).get(0)));
			}	
			
		}
		if(indexList.isEmpty()){System.out.println("타입 선택 에러"); System.exit(-1);}
		
		/* 원하는 type의 포켓몬 중 random한 1개체 선택 */
		int num = makeRandom(indexList.size(), false);		
		insertInfo(num);
		
	};
	
	//To catch pokemon
	//호출 시 belong 초기화 필요
    public boolean calculateCatchRate(Pokemon pokemon, String ball){
        
		double ballEffect = 1;
        double randNum = Math.random();
        double catchRate;
		
		switch(ball){
			case "몬스터볼": ballEffect = 1; break;
			case "슈퍼볼": ballEffect = 1.25; break;
			case "하이퍼볼": ballEffect = 1.5; break;
			case "마스터볼": ballEffect = 255; break;
		}

		catchRate = ((3*maxHp-2*currentHp)*255 / (3*maxHp)) * ballEffect;

        if(randNum * 255 <= catchRate) return true;
        else return false;
        
    }

	public void insertInfo(int num){
		this.unlock = Boolean.parseBoolean(encyclopedia.get(num).get(1));
		this.pokemonName = encyclopedia.get(num).get(2);
		this.type = encyclopedia.get(num).get(3);
		this.maxHp = currentHp = Integer.parseInt(encyclopedia.get(num).get(4));
		this.damage = Integer.parseInt(encyclopedia.get(num).get(5));
		this.evolution = Boolean.parseBoolean(encyclopedia.get(num).get(6));
		this.evolutionLevel = Integer.parseInt(encyclopedia.get(num).get(7));
		this.evolutionNo = Integer.parseInt(encyclopedia.get(num).get(8));
	}

	//create random integer : (0 or 1 ~ size-1)
	public static int makeRandom(int size, boolean notZero){
		//System.out.println("랜덤 생성 : "); 
		Random random = new Random();
		int a = random.nextInt(size);

		/*0을 사용할 수 없는 경우*/
		while(a==0&&notZero)random.nextInt(size);
		
		return a;
	}

	public void increaseStat(){
		this.maxHp += 10;
		this.currentHp += 10;
		this.damage += 2;
	}
	
	public void showAllStat() {
		System.out.println(pokemonName);
		System.out.println("max hp : " + maxHp);
		System.out.println("current hp : " + currentHp);
		System.out.println("type : " + type);
		System.out.println("damage : " + damage+"\n");

	}

	public int getPokemonNumber() {
		return this.pokemonNumber;
	}

	public String getName() {
		return this.pokemonName;
	}

	public String getType() {
		return this.type;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getCurrentHp() {
		return this.currentHp;
	}

	// 전투 이후 남은 HP를 리턴
	public int setHp(int damage) {
		currentHp -= damage;// damage는 전투 영역에서 타입별로 setDamage();,어디선가 currentHp=maxHp 초기화 필요

		if(currentHp < 0) currentHp = 0;
		else if (currentHp > maxHp) currentHp = maxHp; //물리치료
		
		return this.currentHp;
	}

	public boolean getEvolution(){
		return this.evolution;
	}

	public int getEvolutionLevel(){
		return this.evolutionLevel;
	}

	public Pokemon evolutionPokemon(Pokemon pokemon){

        Pokemon evolutionPokemon = new Pokemon(pokemon.evolutionNo);
        evolutionPokemon.unlock = true;
        evolutionPokemon.currentExp = pokemon.currentExp;
        evolutionPokemon.maxExp = pokemon.maxExp;

        return evolutionPokemon;
    }
	/* To debug */
	public static void main(String[] args) {

		Pokemon poke[] = new Pokemon[2];
		poke[0] = new Pokemon("1");
		poke[1] = new Pokemon(makeRandom(Encyclopedia.encyclopedia.size(),true));
		poke[0].showAllStat();
		poke[1].showAllStat();
	}
}

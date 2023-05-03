package Pokemon;

import java.io.BufferedReader;
import Player.Encyclopedia.encyclopedia;
import java.util.Random;


public class Pokemon {
	private String pokemonName;
	private int pokemonNumber;
	private int maxHp;
	private int currentHp;
	private int belong; // 0-player, 1-wild, 2-AI
	private int type; // 0-water, 1-fire, 2-grass
	private int damage;
	private boolean evolution;
	private int evolutionLevel;
	private int evolutionNo;

	//creat pokemon : decided pokemonNumber 
	public void makePokemon(int num){
		pokemonName = encyclopedia.get(num).get(0);
		type = encyclopedia.get(num).get(1);
		maxHp = currentHp = encyclopedia.get(num).get(2);
		damage = encyclopedia.get(num).get(3);
	};

	//creat poketmon : decided type
	public void makePokemon(String type){
		String str = "";

		for(int i=0; i < encyclopedia.size() ; i++){
			str = encyclopedia.get(i).get(4);
			if(str.equals(type)){
				break;
			}	
		}

		pokemonName = encyclopedia.get(--i).get(1);
		maxHp = currentHp = encyclopedia.get(i).get(2);
		damage = encyclopedia.get(i).get(3);
		type = encyclopedia.get(i).get(4);

	};

	//creat wild pokemon
	public void makeWildPokemon(){
		Random random = new Random();
		int a = random.nextInt(encyclopedia.size())+1;
		makePokemon(a);
	}
	
	
	public void showAllStat() {
		System.out.println(pokemonName);
		System.out.println("max hp : " + maxHp);
		System.out.println("current hp : " + currentHp);
		System.out.println("type : " + type);
		System.out.println("damage" + damage);

	}

	public int getPokemonNumber() {
		return pokemonNumber;
	}

	public String getName() {
		return pokemonName;
	}

	int getMaxHp() {
		return this.maxHp;
	}

	// 전투 이후 남은 HP를 리턴
	int setHp(int damage) {
		currentHp -= damage;// damage는 전투 영역에서 타입별로 setDamage();,어디선가 currentHp=maxHp 초기화 필요
		return this.currentHp;
	}

	/*To debug*/
	public static void main(String[] args) {
	
		Pokemon poke[] = new Pokemon[2];
		poke[0] = new Pokemon();
		poke[1] = new Pokemon();
		//poke[0].getPokeInfo();
		//poke[1].makeWildPokemon();
	
	  }
}

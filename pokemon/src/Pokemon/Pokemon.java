package Pokemon;

import Player.Encyclopedia;
import Util.Ui;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Pokemon implements Serializable {
	private String pokemonName;
	private int pokemonNumber;
	private int maxHp;
	private int currentHp;
	//private int belong; // 0-player, 1-wild, 2-AI
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

	public Pokemon() {

	}

	// create pokemon : decided pokemonNumber
	public Pokemon(int num) {
		// System.out.println("인덱스 지정 : ");
		insertInfo(num);
	};

	// create pokemon : decided type
	public Pokemon(String type) {
		System.out.println("타입 지정 : ");
		String str = "";
		ArrayList<Integer> indexList = new ArrayList<>();
		int i;

		/* 원하는 type의 포켓몬을 선별하여 저장 */
		for (i = 0; i < encyclopedia.size(); i++) {
			str = encyclopedia.get(i).get(3);
			// System.out.printf(i+": "+str+", "+type+"\n");
			if (str.equals(type)) {
				indexList.add(Integer.parseInt(encyclopedia.get(i).get(0)));
			}

		}
		if (indexList.isEmpty()) {
			System.out.println("타입 선택 에러");
			System.exit(-1);
		}

		/* 원하는 type의 포켓몬 중 random한 1개체 선택 */
		int num = makeRandom(indexList.size(), false);
		insertInfo(num);

	};

	public void insertInfo(int num) {
		this.pokemonNumber = Integer.parseInt(encyclopedia.get(num).get(0));
		this.unlock = Boolean.parseBoolean(encyclopedia.get(num).get(1));
		this.pokemonName = encyclopedia.get(num).get(2);
		this.type = encyclopedia.get(num).get(3);
		this.maxHp = currentHp = Integer.parseInt(encyclopedia.get(num).get(4));
		this.damage = Integer.parseInt(encyclopedia.get(num).get(5));
		this.evolution = Boolean.parseBoolean(encyclopedia.get(num).get(6));
		this.evolutionLevel = Integer.parseInt(encyclopedia.get(num).get(7));
		this.evolutionNo = Integer.parseInt(encyclopedia.get(num).get(8))-1;
		LevelPokemon.setLevel(this);
	}

	// create random integer : (0 or 1 ~ size-1)
	public static int makeRandom(int size, boolean notZero) {
		// System.out.println("랜덤 생성 : ");
		Random random = new Random();
		int a = random.nextInt(size);

		/* 0을 사용할 수 없는 경우 */
		while (a == 0 && notZero)
			random.nextInt(size);

		return a;
	}

	public void increaseStat() {
		this.maxHp += 10;
		this.currentHp += 10;
		this.damage += 2;
	}

	public void showAllStat() {
		System.out.println(pokemonName);
		System.out.println("레벨 : " + level+" ("+ currentExp+" / "+maxExp+")");

		System.out.println("체력 : " + currentHp + "/" + maxHp);
		System.out.println("타입 : " + type);
		System.out.println("공격력 : " + damage + "\n");
		
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

		if (currentHp < 0)
			currentHp = 0;
		else if (currentHp > maxHp)
			currentHp = maxHp; // 물리치료

		return this.currentHp;
	}

	public boolean getEvolution() {
		return this.evolution;
	}

	public int getEvolutionLevel() {
		return this.evolutionLevel;
	}

	public void evolutionPokemon(Pokemon pokemon) {
		Pokemon evolutionPokemon = new Pokemon(pokemon.evolutionNo);

		Ui.tools.giveDelay(1000);
		System.out.println("\n오잉..? "+pokemon.pokemonName+"의 모습이..?\n");
		Ui.tools.giveDelay(1000);
		System.out.println(evolutionPokemon.pokemonName+"으로 진화하였다.\n");
		Ui.tools.giveDelay(700);

		this.unlock = true;
		this.pokemonName = evolutionPokemon.pokemonName;
		this.damage = evolutionPokemon.damage;
		this.type = evolutionPokemon.type;
		this.evolution = evolutionPokemon.evolution;
		this.evolutionLevel = evolutionPokemon.evolutionLevel;
		this.evolutionNo = evolutionPokemon.evolutionNo;
		this.maxHp = this.currentHp = evolutionPokemon.maxHp;
		evolutionPokemon.level = this.level;
		LevelPokemon.setLevel(pokemon);
		LevelPokemon.giveLevel(this, evolutionPokemon.level-1);
		
	}

	/* To debug */
	public static void main(String[] args) {

		Pokemon poke[] = new Pokemon[2];
		poke[1] = new Pokemon(1);
		poke[1].showAllStat();
		LevelPokemon levelPokemon = new LevelPokemon();
		for(int i=0;i<29;i++){
			System.out.println(i);
			levelPokemon.giveLevel(poke[1], 1);
			
		}
		poke[1].showAllStat();
	}
	
}

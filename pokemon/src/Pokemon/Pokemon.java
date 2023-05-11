package Pokemon;

import Player.Encyclopedia;
import java.util.Random;
import java.util.List;

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

	private List<List<String>> encyclopedia = Encyclopedia.encyclopedia;

	// create pokemon : decided pokemonNumber
	public void makePokemon(int num) {
		pokemonName = encyclopedia.get(num).get(2);
		type = Integer.parseInt(encyclopedia.get(num).get(3));
		maxHp = currentHp = Integer.parseInt(encyclopedia.get(num).get(4));
		damage = Integer.parseInt(encyclopedia.get(num).get(5));
	};

	// create pokemon : decided type
	public void makePokemon(String type) {
		String str = "";
		int i;
		for (i = 0; i < encyclopedia.size(); i++) {
			str = encyclopedia.get(i).get(4);
			if (str.equals(type)) {
				break;
			}
		}

		this.pokemonName = encyclopedia.get(--i).get(2);
		this.maxHp = this.currentHp = Integer.parseInt(encyclopedia.get(i).get(4));
		this.damage = Integer.parseInt(encyclopedia.get(i).get(5));
		this.type = Integer.parseInt(encyclopedia.get(i).get(3));

	};

	// create wild pokemon
	public void makeWildPokemon() {
		Random random = new Random();
		int a = random.nextInt(encyclopedia.size());
		makePokemon(a);
	}

	public void showAllStat() {
		System.out.println(pokemonName);
		System.out.println("max hp : " + maxHp);
		System.out.println("current hp : " + currentHp);
		System.out.println("type : " + type);
		System.out.println("damage : " + damage);

	}

	public int getPokemonNumber() {
		return pokemonNumber;
	}

	public String getName() {
		return pokemonName;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getCurrentHpHp() {
		return this.currentHp;
	}

	// 전투 이후 남은 HP를 리턴
	public int setHp(int damage) {
		currentHp -= damage;// damage는 전투 영역에서 타입별로 setDamage();,어디선가 currentHp=maxHp 초기화 필요
		return this.currentHp;
	}

	/* To debug */
	public static void main(String[] args) {

		Pokemon poke[] = new Pokemon[2];
		poke[0] = new Pokemon();
		poke[1] = new Pokemon();
		// poke[0].getPokeInfo();
		poke[1].makeWildPokemon();
		poke[1].showAllStat();
	}
}

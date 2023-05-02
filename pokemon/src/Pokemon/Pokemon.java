package Pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //Input,Output 예외처리 
import java.util.StringTokenizer;
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

	// read 1 each line
	public void getPokeInfo() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("pokemon\\src\\Pokemon\\pokemonList.txt"));
		br.readLine();	//skip 1 line (index name)
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//reading
		pokemonNumber =Integer.parseInt(st.nextToken());
		pokemonName = st.nextToken();
		type = Integer.parseInt(st.nextToken());
		maxHp = Integer.parseInt(st.nextToken());
		damage = Integer.parseInt(st.nextToken());
		evolution = Boolean.valueOf(st.nextToken());
		evolutionLevel = Integer.parseInt(st.nextToken());
		evolutionNo = Integer.parseInt(st.nextToken());
		
		//print infomation of pokemon
		System.out.println(pokemonNumber + " " + pokemonName + " " + type + " " + maxHp + " " + damage + " " + evolution + " " + evolutionLevel + " " + evolutionNo);

		br.close();
	}

	//creat wild pokemon
	public void makeWildPokemon() throws IOException {
		Random random = new Random();
		int a = random.nextInt(3)+1;
		System.out.println(a);
		String pokeInfo="";

		BufferedReader br = new BufferedReader(new FileReader("pokemon\\src\\Pokemon\\pokemonList.txt"));
		StringTokenizer st;
		br.readLine(); // skip line 1 : index name

		for(int i = 0; i!=a; i++){
			pokeInfo = br.readLine();
		}
		
		st = new StringTokenizer(pokeInfo);
		pokemonNumber =Integer.parseInt(st.nextToken());
		pokemonName = st.nextToken();
		type = Integer.parseInt(st.nextToken());
		maxHp = currentHp = Integer.parseInt(st.nextToken());
		damage = Integer.parseInt(st.nextToken());
		belong = 1;

		br.close();

		/* To debug */
		System.out.println(pokemonNumber + " " + pokemonName + " " + type + " " + maxHp + " " + damage + " ") ;

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

	private void startStatSetting() {

	}

	/*To debug*/
	public static void main(String[] args) throws IOException {
	
		Pokemon poke[] = new Pokemon[2];
		poke[0] = new Pokemon();
		poke[1] = new Pokemon();
		poke[0].getPokeInfo();
		poke[1].makeWildPokemon();
	
	  }
}

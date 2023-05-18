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
	private int type; // 0-water, 1-fire, 2-grass
	private int damage;
	private boolean evolution;
	private int evolutionLevel;
	private int evolutionNo;
	private List<List<String>> encyclopedia = Encyclopedia.encyclopedia;

	public Pokemon(){

	}

	//creat pokemon : decided pokemonNumber 
	public Pokemon(int num){
		//System.out.println("인덱스 지정 : "); 
		this.pokemonName = encyclopedia.get(num).get(2);
		this.type = Integer.parseInt(encyclopedia.get(num).get(3));
		this.maxHp = currentHp = Integer.parseInt(encyclopedia.get(num).get(4));
		this.damage = Integer.parseInt(encyclopedia.get(num).get(5));
	};

	//creat poketmon : decided type
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
		this.pokemonName = encyclopedia.get(indexList.get(num)).get(2);
		this.maxHp = this.currentHp = Integer.parseInt(encyclopedia.get(indexList.get(num)).get(4));
		this.damage = Integer.parseInt(encyclopedia.get(indexList.get(num)).get(5));
		this.type = Integer.parseInt(encyclopedia.get(indexList.get(num)).get(3));

	};

	//creat random integer : (0 or 1 ~ size-1)
	public static int makeRandom(int size, boolean notZero){
		//System.out.println("랜덤 생성 : "); 
		Random random = new Random();
		int a = random.nextInt(size);

		/*0을 사용할 수 없는 경우*/
		while(a==0&&notZero)random.nextInt(size);
		
		return a;
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

	public int getType() {
		return this.type;
	}

	public int getDamege() {
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

	/* To debug */
	public static void main(String[] args) {

		Pokemon poke[] = new Pokemon[2];
		poke[0] = new Pokemon("1");
		poke[1] = new Pokemon(makeRandom(Encyclopedia.encyclopedia.size(),true));
		poke[0].showAllStat();
		poke[1].showAllStat();
	}
}

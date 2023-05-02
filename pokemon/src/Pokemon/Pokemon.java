package Pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //Input,Output 예외처리 
import java.util.StringTokenizer;

public class Pokemon {
	private String pokemonName;
	private int pokemonNumber;
	private int maxHp;
	private int currentHp;
	private int belong; // 0은 플레이어, 1은 야생, 2는 AI
	private int type; // 0은 물, 1은 불, 2는 풀
	private int damage;

	// 포켓몬 정보를 한 줄 읽어오고, 공백 단위로 구분해서 담기
	public void getPokeInfo() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pokemonList.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pokemonName = st.nextToken();
		type = Integer.parseInt(st.nextToken());
		maxHp = Integer.parseInt(st.nextToken());
		damage = Integer.parseInt(st.nextToken());

		System.out.println(pokemonName + " " + type + " " + maxHp + " " + damage);
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

	@Override
	public String toString() {
		return "Pokemon [pokemonName=" + pokemonName + ", maxHp=" + maxHp + ", currentHp=" + currentHp + ", belong="
				+ belong + ", type=" + type + ", damage=" + damage + "]";
	}
}

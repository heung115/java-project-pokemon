import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Poketmon {
	String name;
	int hp;
	int level;
	int exp;
	int belong; //0은 플레이어, 1은 야생, 2는 AI
	char type;
	int attack;
	
	public void getPokeInfo() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\choi_\\Desktop\\java-project-pokemon\\poketmonList.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		name = st.nextToken();
		type = st.nextToken().charAt(0);
		hp = Integer.parseInt(st.nextToken());
		attack = Integer.parseInt(st.nextToken());
		
		System.out.println(name+" "+type+" "+hp+" "+attack);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Poketmon po = new Poketmon();
		po.getPokeInfo();

	}
	
	

}

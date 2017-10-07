import java.util.LinkedHashMap;
import java.util.Map;

public class TrieNode {
	Map<Character,TrieNode> map=new LinkedHashMap<>();
	boolean endOfWord;
}

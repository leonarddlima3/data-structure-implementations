
public class TrieImpl {
	public static TrieNode root = null;
	public static int index=0;
	public boolean flag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieImpl t = new TrieImpl();
		root = t.createEmptyTrieNode();
		t.insertWord("abc");
		t.insertWord("def");
		t.insertWord("abcd");
		System.out.println(t.checkWholeWordPresence("abc"));
		System.out.println(t.checkWholeWordPresence("ab"));
		System.out.println(t.checkPrefixPresence("abc"));
		System.out.println(t.checkPrefixPresence("ab"));
		System.out.println(t.checkWholeWordPresence("def"));
		System.out.println(t.checkWholeWordPresence("de"));
		System.out.println(t.checkPrefixPresence("def"));
		System.out.println(t.checkPrefixPresence("de"));
		t.deleteWord("abc");
		System.out.println(t.checkWholeWordPresence("abcd"));
		System.out.println(t.checkWholeWordPresence("def"));
		System.out.println(t.checkPrefixPresence("ab"));
		System.out.println(t.checkPrefixPresence("de"));
	}

	void insertWord(String word){
		if(word.length()>0){
			index=0;
			TrieNode temp=root;
			
			while(temp.map.containsKey(word.charAt(index))){
				temp=temp.map.get(word.charAt(index));
				index++;
			}
			while(index<=word.length()-1){
				temp.map.put(word.charAt(index), createEmptyTrieNode());
				temp.endOfWord=false;
				temp=temp.map.get(word.charAt(index));
				index++;
			}
			
		}
	}
	
	void deleteWord(String word){
		if(word.length()>0){
			index=-1;
			delete(root,word);
			
		}
	}
	
	void delete(TrieNode root,String word){
		index++;
		if(index>word.length()-1){
			index--;
			return;
		}
		
		
		delete(root.map.get(word.charAt(index)), word);
		
		if(index==word.length()-1){
			if(root.map.get(word.charAt(index)).map.size()==0){
				root.map.remove(word.charAt(index));
				index--;
			}else{
				root.map.get(word.charAt(index)).endOfWord=false;
				flag=true;
				index--;
				return;
			}
		}else{
			if(!flag){
				if(root.map.get(word.charAt(index)).map.size()==0){
					root.map.remove(word.charAt(index));
					index--;
				}else{
					index--;
					return;
				}
			}
			
		}
		
	}
	
	boolean checkWholeWordPresence(String word){
		if(word.length()>0){
			index=0;
			TrieNode temp=root;
			while(index<=word.length()-1){
				if(!temp.map.containsKey(word.charAt(index))){
					return false;
				}
				temp=temp.map.get(word.charAt(index));
				index++;
			}
			if(temp.endOfWord==false){
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	boolean checkPrefixPresence(String word){
		if(word.length()>0){
			index=0;
			TrieNode temp=root;
			while(index<=word.length()-1){
				if(!temp.map.containsKey(word.charAt(index))){
					return false;
				}
				temp=temp.map.get(word.charAt(index));
				index++;
			}
			
			
			return true;
		}
		
		return false;
	}

	TrieNode createEmptyTrieNode() {
		TrieNode node = new TrieNode();
		node.endOfWord = true;
		return node;
	}

}

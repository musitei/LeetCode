package TreeIterator;
public class TreeIterator {
	public Tree buildTree(String preIterator, String midIterator){
		if (preIterator.length() != midIterator.length()){
			return null;
		}
		
		if (preIterator.length() == 1){
			return new Tree(preIterator);
		}
		
		String root = preIterator.substring(0, 1);
 
		Tree tree = new Tree(root);
		
		int rootIdx = midIterator.indexOf(root);
		String newPreIterator;
		String newMidIterator;
		
		if (rootIdx != 0){//Left tree exists
			newPreIterator = preIterator.substring(1, rootIdx + 1);
			newMidIterator = midIterator.substring(0, rootIdx);
			tree.left = this.buildTree(newPreIterator, newMidIterator);
		}
		
		if (rootIdx != midIterator.length()-1){//right tree exists
			newPreIterator = preIterator.substring(rootIdx + 1);
			newMidIterator = midIterator.substring(rootIdx + 1);
			tree.right = this.buildTree(newPreIterator, newMidIterator);
		}
		
		return tree;
	}
	
	public String printPostorder(Tree tree){
		StringBuffer buf = new StringBuffer();
		if (tree.left != null){
			buf.append(printPostorder(tree.left));	
		}
		if (tree.right != null){
			buf.append(printPostorder(tree.right));	
		}
		
		buf.append(tree.data);
		
		return buf.toString();
	}
	
	public static void main(String[] args){
		String pre = "ABDCEF";
		String mid = "DBAECF";
		
		TreeIterator obj = new TreeIterator();
		System.out.println(obj.printPostorder(obj.buildTree(pre, mid)));
		//Output >>>> DBEFCA
	}
}
 
class Tree{
	String data;
	Tree left;
	Tree right;
	
	public Tree(String data){
		this.data = data;
	}
}
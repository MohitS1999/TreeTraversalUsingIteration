import java.util.*;
//For Tree
class Node{
	int data;
	Node lchild;
	Node rchild;
	public Node(int data){
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
}
//for Queue
class Node1{
	Node data;
	Node1 next;
}
//For Stack
class Node2{
	Node data;
	Node2 next;
}
public class TreeTraversalusingIteration{
	public static void main(String[] agrs){
		Tree t=new Tree();
		t.create();
			System.out.println("COUNT OF NODES:-  "+t.count(t.root()));
		System.out.println("\n\n\n\nInOrder Display");
		t.inOrderDisplay(t.root());
		System.out.println("\n\n\n\nPreorder Display");
		t.preOrderDisplay(t.root());
		System.out.println("\n\n\n\nlevelOrderTraversal");
		t.levelOrderTraversal(t.root());
	
		System.out.println("Who have Two Child OF NODES:-  "+t.twoChild(t.root()));
		System.out.println("Sum OF all the elements:-  "+t.sum(t.root()));
		System.out.println("Leaf Node:-  "+t.leafNode(t.root()));
		System.out.println("FUNC:-  "+t.fun(t.root()));
		
		
	}
}
class Tree{
	Scanner sc=new Scanner(System.in);
	Node root;
	Node p;
	//For creating the Node in tree
	public void create(){
		System.out.println("Enter the Root data");
		root=new Node(sc.nextInt());
		Queue q=new Queue();
		q.enqueue(root);
		int x;
		while(!q.isEmpty()){
			p=q.dequeue();
			System.out.println("Enter the Left Child of "+p.data);
			x=sc.nextInt();
			if(x!=-1){
				Node t=new Node(x);
				p.lchild=t;
				q.enqueue(t);
			}
			System.out.println("Enter the Right Child of "+p.data);
			x=sc.nextInt();
			if(x!=-1){
				Node t=new Node(x);
				p.rchild=t;
				q.enqueue(t);
			}
		}
	}
	//return the address of root node
	public Node root(){
		return root;
	}
	//Pre Order Display
	public void preOrderDisplay(Node n){
		Stack s=new Stack();
		while((n!=null)||!s.isEmpty()){
			if(n!=null){
				System.out.println(n.data);
				s.push(n);
				n=n.lchild;
			}else{
				n=s.pop();
				n=n.rchild;
			}
		}
	}
	//Inorder Display
	public void inOrderDisplay(Node n){
		Stack s=new Stack();
		while((n!=null)||(!s.isEmpty())){
			if(n!=null){
				s.push(n);
				n=n.lchild;
			}else{
				n=s.pop();
				System.out.println(n.data);
				n=n.rchild;
			}
		}
	}
	//Level Order Display
	public void levelOrderTraversal(Node n){
		Queue q=new Queue();
		System.out.println(n.data);
		q.enqueue(n);
		while(!q.isEmpty()){
			n=q.dequeue();
			if(n.lchild!=null){
				System.out.println(n.lchild.data);
				q.enqueue(n.lchild);
			}
			if(n.rchild!=null){
				System.out.println(n.rchild.data);
				q.enqueue(n.rchild);
			}
		}
	}
		// public void preOrderDisplay(Node n){
		// Stack s=new Stack();
		// while((n!=null)||(!s.isEmpty())){
			// if(n!=null){
				// s.push(n);
				// n=n.lchild;
			// }else{
				// n=s.pop();
				
				// n=n.rchild;
				
			// }
		// }
	// }
	public int count(Node n){
		int x;
		int y;
		if (n!=null){
			x=count(n.lchild);
			y=count(n.rchild);
			return x+y+1;
		}return 0;
	}
	public int twoChild(Node n){
		int x;
		int y;
		if(n!=null){
			x=twoChild(n.lchild);
			y=twoChild(n.rchild);
			if ((n.lchild!=null)&&n.rchild!=null)
				return x+y+1;
			else
				return x+y;
		}
		return 0;
	}
	public int sum(Node n){
		int x;
		int y;
		if(n!=null){
			x=sum(n.lchild);
			y=sum(n.rchild);
			return x+y+n.data;
		}return 0;
	}
	//
	public int leafNode(Node n){
		int x;
		int y;
		if (n!=null){
			x=leafNode(n.lchild);
			y=leafNode(n.lchild);
			if((n.lchild==null)&&(n.rchild==null))
				return x+y+1;
			else
				return x+y;
		}return 0;
	}
	//Height of tree
	public int fun(Node n){
		int x;
		int y;
		if (n!=null){
			x=fun(n.lchild);
			y=fun(n.lchild);
			if(x>y)
				return x+1;
			else
				return y+1;
		}return 0;
	}
	
}
class Queue{
	Node1 front;
	Node1 rear;
	public void enqueue(Node data){
		Node1 node1=new Node1();
		if (node1==null){
			System.out.println("Queue is Full");
		}else{
			node1.data=data;
			node1.next=null;
			if (front==null){
				front=node1;
				rear=node1;
			}else{
				rear.next=node1;
				rear=node1;
			}
		}
	}
	public Node dequeue(){
		Node x=null;
		if(front==null){
			System.out.println("Queue is Empty");
		}else{
			Node1 t=front;
			x=t.data;
			front=front.next;
			t=null;
		}return x;
	}
	public boolean isEmpty(){
		if (front==null)
			return true;
		return false;
	}
}
class Stack{
	Node2 top;
	public void push(Node data){
		Node2 node=new Node2();
		if (node==null){
			System.out.println("OverFlow Condtion");
		}else{
			node.data=data;
			node.next=top;
			top=node;
		}
	}
	public Node pop(){
		Node x=null;
		if(top==null)
			System.out.println("UnderFlow Condtion");
		else{
			Node2 t=top;
			top=top.next;
			x=t.data;
			t=null;
		}return x;
	}
	public boolean isEmpty(){
		if (top==null)
			return true;
		return false;
	}
}

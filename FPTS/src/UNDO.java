import java.util.Stack;

public class UNDO{
	
	Stack<State> UndoStack = new Stack<State>();
	
	public UNDO (){}
	
	public void push (State state){
		UndoStack.push(state);
	}
	
	public void undoState(){
		//Modify to use current user
		this.UndoStack.pop().undoState(null);
	}
	
	
}
import java.util.Stack;

public class UNDO{
	
	Stack<State> UndoStack = new Stack<State>();
	
	
	public UNDO (){}
	
	public void push (State state){
		UndoStack.push(state);
	}
	
	public void undoState(){
		//Modify to use current user
		if (this.UndoStack.peek() != null){
			this.UndoStack.pop().undoState(UserSystem.getActiveUser());
		}
	}
	
	
}
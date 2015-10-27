import java.util.Stack;

public class UNDO{
	
	Stack<State> UndoStack = new Stack<State>();
	Stack<State> RedoStack = new Stack<State>();
	
	
	public UNDO (){}
	
	public void pushToUndo (State state){
		UndoStack.push(state);
	}
	
	public void pushToRedo (State state){
		RedoStack.push(state);
	}
	
	public void undoState(){
		if (!this.UndoStack.empty()){
			State tempState = this.UndoStack.pop();
			tempState.undoState(UserSystem.getActiveUser());
			this.pushToRedo(tempState);
		}
	}
	
	public void redoState(){
		if(!this.RedoStack.empty()){
			State tempState = this.RedoStack.pop();
			tempState.undoState(UserSystem.getActiveUser());
			this.pushToUndo(tempState);
		}
	}
	
	
}
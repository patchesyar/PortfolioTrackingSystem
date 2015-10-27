public class State{
	
	Portfolio portfolio;
	User user;
	
	/*
	 * If we want to keep track of other things just pass them as arguments
	 */
	
	public State (Portfolio portfolio, User user){
		this.portfolio = portfolio;
		this.user = user;
	}
	
	public void portfolioUndo( Portfolio target){
		
		target.setAssociatedID(this.portfolio.getOwnerID());
		target.sethList(this.portfolio.gethList());
		target.setLog(this.portfolio.getLog());
		target.setTotalValue(this.portfolio.getTotalValue());
		
	}
	
	public void  undoState(Portfolio target){
		portfolioUndo(target);
	}
}
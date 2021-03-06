public class State{
	
	Portfolio portfolio;
	User user;
	
	/*
	 * If we want to keep track of other things just pass them as arguments
	 */
	
	public State (User user){
		this.portfolio = user.getPortfolios();
		this.user = user;
	}
	
	public void portfolioUndo( Portfolio target){
		
		target.setAssociatedID(this.portfolio.getOwnerID());
		target.sethList(this.portfolio.gethList());
		target.setLog(this.portfolio.getLog());
		target.setTotalValue(this.portfolio.getTotalValue());
		
	}
	
	public void  undoState(User target){
		portfolioUndo(target.getPortfolios());
	}
}
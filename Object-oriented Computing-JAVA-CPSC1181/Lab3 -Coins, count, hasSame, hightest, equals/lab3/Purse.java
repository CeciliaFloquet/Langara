import java.util.ArrayList;

/**
* A purse holds a collection of coins.CPSC 1181 Lab III from  Programming Exercise P7.5  Big Java, 4th Edition, Cay Horstmann
* @author modified heavily by Gladys Monagan and Hengameh Hamavand
* @version January 25, 2015
*/
public class Purse
{
   

    /**
    * Constructs an empty purse.
    */
	public Purse(){
      
		listOfCoins= new ArrayList<Coin>();
		
    }
   
   

	/**
	* Adds a coin to the purse regardless of whether the <code>coin</code> was in the 
	* purse  already or not
	* @param coin the coin to add 
	*/
	public void addCoin( Coin b ){
		listOfCoins.add(b);
		
	}
   

   
	/**
	* Removes a coin from the purse that is the same (denomination) as <code>coin</code>
	* i.e. it removes a coin from the pruse that is  <code>equal</code> to <code>coin</code>.
	* <p>
	* precondition: <code>equals</code> has been define for <code>coin</code>
	* @param coin a coin that matches the one that should be removed from purse
	* @return true if the matching coin was removed from the purse, false otherwise
	*/
   
	public boolean removeCoin(Coin a){
		
			return listOfCoins.remove(a);
			
		
	}
   
   

	/**
	* Gives a text representation of the purse.
	* @return a string in the format "Purse[coin1,coin2,...]"
	*/
	public String toString()
	{

		return "Purse" + listOfCoins.toString();      

	}
   
	/**
	* Counts the number of occurrences of <code>coin</code> in this purse.
	* <p>
	* IMPLEMENTATION detail for the lab: 
	* in order for two coins to be considered equal, their value and their name
	* must match  but there is a method <code>equals</code> defined inside
	* of the <code>Coin</code> class already
	* @param coin the item to match against
	* @return count the number of times the coin is in purse
	*/
	public int countCoin(int match){
		int count=0;
		for(Coin a : listOfCoins){
			if(a.getValue() == match){
				count++;
			}
		}
		return count;

	}
   
   

	/**
	* Determines if a purse has the same coins as the <code>otherPurse</code>,
	* (regardless of order and possible duplicates).
	* <p>
	* IMPLEMENTATION detail for the lab: you must use the method <code>this.occurrences</code>
	* when implementing <code>hasSameCoins</code>
	* @param otherPurse the other purse with coins
	* @return true if this and the otherPurse have the same coins, false otherwise
	*/
	public boolean hasSameCoins(Purse b){
		if (b == null){
				return false;
			}
		if(listOfCoins.size() != b.getListOfCoins().size()){
			return false;
		}
		else{
			if(listOfCoins.containsAll(b.getListOfCoins())){
				return true;
			}
			else{
				return false;
			}
		}
		
	}
	
	public ArrayList<Coin> getListOfCoins(){
		return listOfCoins;
	}
	/**
	* Gives the highest monetary value of any coin in the purse.
	* @return the highest coin value of any coin in the purse and 0 if the purse is empty.
	*/ 
	public Coin highestValue(){
		
		Coin largest = listOfCoins.get(0);
		if(listOfCoins.size() == 0)
			
			return largest;
		
		for(int i=0; i< listOfCoins.size(); i++){
			Coin a= listOfCoins.get(i);
			if (a.getValue() > largest.getValue())
				largest= a;
		} 
		return largest;    

	}


	private ArrayList<Coin> listOfCoins;
}

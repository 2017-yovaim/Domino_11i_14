package edu.school.problems;

public class DominoPlayer 
{
	private String nickname;
	//private DominoTile[] tiles;
	private Hand<DominoTile> tiles;
	private int tilesInHands;
	private DominoTable table;
	private PlayerEventListener playerListener;
	
	public DominoPlayer(String nicknameValue, Hand<DominoTile> tilesValue, int tilesInHandsValue,
			DominoTable tableValue)
	{
		this.setNickname(nicknameValue);
		this.tiles = tilesValue;
		this.tilesInHands = tilesInHandsValue;
		this.table = tableValue;
	}

	/*public DominoPlayer(String nicknameValue, DominoTile[] tilesValue, 
			int tilesInHandsValue, DominoTable tableValue) 
	{
		if (nicknameValue != null && !nicknameValue.isEmpty()) 
		{
			this.nickname = nicknameValue;
		}

		this.tiles = tilesValue;
		this.tilesInHands = tilesInHandsValue;
		this.table = tableValue;
	}
	*/

	public String getNickname() 
	{
		return this.nickname;
	}
	
	public Hand <DominoTile> getTiles()
	{
		return this.tiles;
	}

	/*public DominoTile[] getTiles() 
	{
		return this.tiles;
	}
	*/

	public int getTilesInHands() 
	{
		return this.tilesInHands;
	}

	public DominoTable getTable() 
	{
		return this.table;
	}

	public void setNickname(String nicknameValue) 
	{
		if (nicknameValue != null && !nicknameValue.isEmpty()) 
		{
			this.nickname = nicknameValue;
		}
	}
	
	public int getTileIndex(DominoTile t)
	{
		return this.tiles.getIndex(t);
	}
	
	public void addTileLeft(DominoTile t)
	{
		int index = this.getTileIndex(t);
		if(index == -1)
		{
			throw new IllegalArgumentException("You don't have this tile in your hand.");
		}
		boolean wasAdded = this.table.addLeft(t);
		if(wasAdded == true)
		{
			this.tilesInHands--;
			this.tiles.remove(t);
		}
	}
	
	public void addTileRight(DominoTile t)
	{
		int index = this.getTileIndex(t);
		if(index == -1)
		{
			throw new IllegalArgumentException("You don't have this tile in your hand.");
		}
		boolean wasAdded = this.table.addRight(t);
		if(wasAdded == true)
		{
			this.tilesInHands--;
			this.tiles.remove(t);
		}
	}
	
	public void addPlayerEventListener(PlayerEventListener playerListener)
	{
		this.playerListener = playerListener;
	}

	/*private int getTileIndex(DominoTile t) 
	{
		for (int i = 0; i < this.tiles.length; i++) 
		{
			if (this.tiles[i].equals(t))
				return i;
		}

		return -1;
	}
	

	public void addTileAtLeft(DominoTile t) 
	{

		int i = this.getTileIndex(t);
		if (i == -1) 
		{
			JOptionPane.showMessageDialog(null, "You do not have the tile in your deck.", "Error",
					JOptionPane.PLAIN_MESSAGE);
			return;
		} 
		else 
		{
			boolean wasAdded = this.table.addLeft(t);
			if (wasAdded == true) 
			{
				this.tilesInHands--;
				for (int j = i; j < this.tiles.length - 1; j++) 
				{
					this.tiles[j] = this.tiles[j + 1];
				}
			}
		}
	}

	public void addTileAtRight(DominoTile t) 
	{
		int i = this.getTileIndex(t);
		if(i == -1)
		{
			JOptionPane.showMessageDialog(null, "You do not have the tile in your deck.", "Error",
					JOptionPane.PLAIN_MESSAGE);
			return;
		}
		else
		{
			boolean wasAdded = this.table.addRight(t);
			if(wasAdded == true) 
			{
				this.tilesInHands--;
				for(int j = i; j < this.tilesInHands - 1; j++)
				{
					this.tiles[j] = this.tiles[j + 1];
				}
			}
		}
	}
	*/
}
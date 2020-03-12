package com.forestsoftware.kands.DB;

public class FavouriteDataModel {

	private int id;
	private String word;
	private String partOfSpeech;
	private int songId;

	public FavouriteDataModel() {
		super();
	}

	public FavouriteDataModel(String word, String pos, int si) {
		super();
		//this.id = id;
		this.word = word;
		this.songId = si;
		this.setPartOfSpeech(pos);
	}
	public FavouriteDataModel(String word, String pos)
	{
		super();
		//this.id = id;
		this.word = word;
		this.setPartOfSpeech(pos);
	}
	public FavouriteDataModel( String pos)
	{
		super();
		//this.id = id;
		this.setPartOfSpeech(pos);
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return this.word;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getSongId() {
		return songId;
	}

	public void setSongId(int sid) {
		this.songId = sid;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavouriteDataModel other = (FavouriteDataModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FavouriteDataModel [ ID="+ id + ", FavouriteDataModel=" + word + ", part of Speech="
				+ partOfSpeech + " ]";
	}*/
	
	@Override
	public String toString() {
		return "FavouriteDataModel [ FavouriteDataModel=" + word + ", part of Speech="	+ partOfSpeech + " ]";
	}
}
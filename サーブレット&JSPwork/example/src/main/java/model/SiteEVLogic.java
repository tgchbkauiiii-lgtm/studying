package model;

public class SiteEVLogic {
	public void like(SiteEV s) {
		int count =s.getLike();
		s.setLike(count + 1);
	}
	public void dislike(SiteEV s) {
		int count = s.getDislike();
		s.setDislike(count + 1);
	}
}

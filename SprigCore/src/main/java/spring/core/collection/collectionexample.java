package spring.core.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class collectionexample {

	private Set<String> set;
	private List<String>list;
	private Map<Integer, String>map;
	public collectionexample() {
		super();
	}
	public collectionexample(Set<String> set, List<String> list, Map<Integer, String> map) {
		super();
		this.set = set;
		this.list = list;
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "collectionexample [set=" + set + ", list=" + list + ", map=" + map + "]";
	}
	
	
	
}

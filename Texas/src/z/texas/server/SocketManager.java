package z.texas.server;

import java.util.ArrayList;

public class SocketManager {
	private ArrayList<Task> tasks;

	public SocketManager() {
		tasks = new ArrayList<Task>();
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public void closeAll() {
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).setStop(true);
		}
	}

	public boolean allReady() {
		if(tasks.size()<1)
			return false;
		for (int i = 0; i < tasks.size(); i++) {
			if(!tasks.get(i).getTexasBean().getState().equals("ready")){
				return false;
			}
		}
		return true;
	}

	public void allStart() {
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).gameStart();
		}
	}
}